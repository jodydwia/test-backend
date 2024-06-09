package com.springboot.backend.service.impl;

import com.springboot.backend.model.Detail;
import com.springboot.backend.model.Header;
import com.springboot.backend.payload.HeaderRequest;
import com.springboot.backend.service.DetailService;
import com.springboot.backend.service.HeaderService;
import com.springboot.backend.service.TrxService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

@Service
public class TrxServiceImpl implements TrxService {

    private final HeaderService headerService;

    private final DetailService detailService;

    public TrxServiceImpl(HeaderService headerService, DetailService detailService) {
        this.headerService = headerService;
        this.detailService = detailService;
    }

    @Override
    public String addTrx(HeaderRequest request) {

        LocalDate tanggalAwal = request.getTanggalAwal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate tanggalAkhir = request.getTanggalAkhir().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long months = ChronoUnit.MONTHS.between(
                tanggalAwal, tanggalAkhir
        )+1;


        Header header = new Header();
        header.setTanggalAwal(request.getTanggalAwal());
        header.setTanggalAkhir(request.getTanggalAkhir());
        header.setNominal(request.getNominal());

        Header save = headerService.addHeader(request);


        LocalDate tanggalAwalDetail = tanggalAwal;
        double nominal = 0;
        double totalRandomNominal = 0;
        // create Random object
        Random random = new Random();
        double min=80, max=100;
        double randomNumber = random.nextDouble(max - min + 1) + min;

        for (int i = 1; i <= months; i++) {

            Detail detail = new Detail();

            detail.setTanggalAwal(Date.from(tanggalAwalDetail.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            if (i != months) {
                Date lastDate = Date.from(getLastdate(tanggalAwalDetail).atStartOfDay(ZoneId.systemDefault()).toInstant());
                detail.setTanggalAkhir(lastDate);
            } else {
                detail.setTanggalAkhir(Date.from(tanggalAkhir.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }

            if(i != months) {
                nominal = randomNumber / 1000 * (months-1) * save.getNominal().doubleValue();
                totalRandomNominal += nominal;
            } else {
                nominal = save.getNominal().doubleValue() - totalRandomNominal;
            }

            detail.setNominal(new BigDecimal(nominal).setScale(2, BigDecimal.ROUND_HALF_EVEN));
            detail.setHeaderId(save.getId());
            Detail saveDetail = detailService.addDetail(detail);

            if (i != months) {
                tanggalAwalDetail = saveDetail.getTanggalAkhir().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(1);
            }
        }

        return "success";
    }

    public LocalDate getLastdate(LocalDate date) {
        return date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
    }

}
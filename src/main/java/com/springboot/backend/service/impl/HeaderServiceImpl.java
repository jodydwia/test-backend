package com.springboot.backend.service.impl;

import com.springboot.backend.model.Header;
import com.springboot.backend.payload.HeaderRequest;
import com.springboot.backend.repository.HeaderRepository;
import com.springboot.backend.service.HeaderService;
import org.springframework.stereotype.Service;

@Service
public class HeaderServiceImpl implements HeaderService {

    private final HeaderRepository headerRepository;

    public HeaderServiceImpl(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    @Override
    public Header addHeader(HeaderRequest request) {

        Header header = new Header();
        header.setTanggalAwal(request.getTanggalAwal());
        header.setTanggalAkhir(request.getTanggalAkhir());
        header.setNominal(request.getNominal());

        return headerRepository.save(header);
    }

}
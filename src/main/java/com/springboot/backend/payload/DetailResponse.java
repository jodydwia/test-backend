package com.springboot.backend.payload;

import com.springboot.backend.model.Detail;
import com.springboot.backend.model.Header;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class DetailResponse {

    @NotNull
    private UUID id;

    @NotNull
    private Date tanggalAwal;

    @NotNull
    private Date tanggalAkhir;

    @NotNull
    private BigDecimal nominal;

    @NotNull
    private UUID headerId;

    public DetailResponse(Detail detail) {
        this.id = detail.getId();
        this.tanggalAwal = detail.getTanggalAwal();
        this.tanggalAkhir = detail.getTanggalAkhir();
        this.nominal = detail.getNominal();
        this.headerId = detail.getHeaderId();
    }
}

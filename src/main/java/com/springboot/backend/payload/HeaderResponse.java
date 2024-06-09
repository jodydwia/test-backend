package com.springboot.backend.payload;

import com.springboot.backend.model.Header;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class HeaderResponse {

    @NotNull
    private UUID id;

    @NotNull
    private Date tanggalAwal;

    @NotNull
    private Date tanggalAkhir;

    @NotNull
    private BigDecimal nominal;

    public HeaderResponse(Header header) {
        this.id = header.getId();
        this.tanggalAwal = header.getTanggalAwal();
        this.tanggalAkhir = header.getTanggalAkhir();
        this.nominal = header.getNominal();
    }
}

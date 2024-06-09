package com.springboot.backend.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class HeaderRequest {

    @NotNull
    private Date tanggalAwal;

    @NotNull
    private Date tanggalAkhir;

    @NotNull
    private BigDecimal nominal;

}

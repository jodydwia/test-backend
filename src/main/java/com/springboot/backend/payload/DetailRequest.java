package com.springboot.backend.payload;

import com.springboot.backend.model.Detail;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class DetailRequest {

    @NotNull
    private Date tanggalAwal;

    @NotNull
    private Date tanggalAkhir;

    @NotNull
    private BigDecimal nominal;

    @NotNull
    private UUID headerId;

}

package com.springboot.backend.controller;

import com.springboot.backend.payload.ApiResponse;
import com.springboot.backend.payload.HeaderRequest;
import com.springboot.backend.payload.response.ResponseHandler;
import com.springboot.backend.service.TrxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/transaction")
public class TrxController {

    private final TrxService trxService;

    public TrxController(TrxService trxService) {
        this.trxService = trxService;
    }

    @PostMapping
    public ResponseEntity<Object> addHeader(@Valid @RequestBody HeaderRequest request) {

        ApiResponse response = trxService.addTrx(request);

        return ResponseHandler.responseBuilder(HttpStatus.CREATED, response);
    }


}

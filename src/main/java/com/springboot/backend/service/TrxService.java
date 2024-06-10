package com.springboot.backend.service;

import com.springboot.backend.payload.ApiResponse;
import com.springboot.backend.payload.HeaderRequest;

public interface TrxService {

    ApiResponse addTrx(HeaderRequest request);

}

package com.springboot.backend.service;

import com.springboot.backend.model.Header;
import com.springboot.backend.payload.HeaderRequest;
import com.springboot.backend.payload.HeaderResponse;


public interface HeaderService {

    Header addHeader(HeaderRequest request);

}

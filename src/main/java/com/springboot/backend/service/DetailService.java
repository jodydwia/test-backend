package com.springboot.backend.service;

import com.springboot.backend.model.Detail;
import com.springboot.backend.payload.DetailRequest;
import com.springboot.backend.payload.DetailResponse;

public interface DetailService {

    Detail addDetail(Detail detail);

}

package com.springboot.backend.service;

import com.springboot.backend.model.Detail;

import java.util.List;

public interface DetailService {

    Detail addDetail(Detail detail);

    String addDetails(List<Detail> details);

}

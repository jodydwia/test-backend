package com.springboot.backend.service.impl;

import com.springboot.backend.model.Detail;
import com.springboot.backend.repository.DetailRepository;
import com.springboot.backend.service.DetailService;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    private final DetailRepository detailRepository;

    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public Detail addDetail(Detail detail) {
        return detailRepository.save(detail);
    }

}
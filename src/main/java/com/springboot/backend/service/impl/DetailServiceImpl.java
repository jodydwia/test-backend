package com.springboot.backend.service.impl;

import com.springboot.backend.exception.BadRequestException;
import com.springboot.backend.model.Detail;
import com.springboot.backend.payload.ApiResponse;
import com.springboot.backend.repository.DetailRepository;
import com.springboot.backend.service.DetailService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public String addDetails(List<Detail> details) {

        try {
            detailRepository.saveAll(details);
        } catch (Error error) {
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, error.getMessage());
            throw new BadRequestException(apiResponse);
        }

        return "success";
    }
}
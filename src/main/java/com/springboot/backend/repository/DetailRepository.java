package com.springboot.backend.repository;

import com.springboot.backend.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetailRepository extends JpaRepository<Detail, UUID> {
}

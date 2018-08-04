package com.repository;

import com.model.Fund;
import org.springframework.data.repository.CrudRepository;

public interface FundRepository extends CrudRepository<Fund, String> {
}

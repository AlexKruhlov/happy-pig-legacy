package com.api.fund.controller;

import com.feature.fund.model.Fund;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FundController {

    Fund findById(@PathVariable String id);

    List<Fund> findAll();
}

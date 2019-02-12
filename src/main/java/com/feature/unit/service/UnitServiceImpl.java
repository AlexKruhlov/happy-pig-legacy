package com.feature.unit.service;

import com.api.unit.repository.UnitRepository;
import com.api.unit.service.UnitService;
import com.feature.unit.dto.UnitDto;
import com.feature.unit.model.Unit;
import com.feature.unit.transformer.UnitTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;
    private final UnitTransformer unitTransformer;

    @Override
    public List<UnitDto> findAll() {
        return unitRepository.findAll().stream()
                .map(unitTransformer::toDto)
                .collect(toList());
    }

    @Override
    public UnitDto saveOrUpdate(UnitDto unitDto) {
        Unit savedOrUpdatedUnit = unitRepository.save(unitTransformer.fromDto(unitDto));
        return unitTransformer.toDto(savedOrUpdatedUnit);
    }

    @Override
    public void deleteById(String unitId) {
        unitRepository.deleteById(unitId);
    }
}

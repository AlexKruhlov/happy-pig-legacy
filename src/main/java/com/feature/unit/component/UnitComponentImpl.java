package com.feature.unit.component;

import com.api.unit.component.UnitComponent;
import com.api.unit.service.UnitService;
import com.feature.unit.dto.UnitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unit")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UnitComponentImpl implements UnitComponent {
    private final UnitService unitService;

    @Override
    @GetMapping("/all")
    public List<UnitDto> findAll() {
        return unitService.findAll();
    }

    @Override
    @PostMapping("/save")
    public UnitDto saveOrUpdate(@RequestBody UnitDto unitDto) {
        return unitService.saveOrUpdate(unitDto);
    }

    @Override
    @PostMapping("/delete/{unitId}")
    public void deleteById(@PathVariable String unitId) {
        unitService.deleteById(unitId);
    }
}

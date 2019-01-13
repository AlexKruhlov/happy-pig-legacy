package com.feature.transfer.component;

import com.api.transfer.component.TransferComponent;
import com.api.transfer.service.TransferService;
import com.feature.transfer.dto.TransferWithFundsDto;
import com.feature.transfer.model.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implements API for UI to work with {@link Transfer} objects
 */
@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TransferComponentImpl implements TransferComponent {

    private final TransferService transferService;

    @Override
    @GetMapping("/all")
    public List<TransferWithFundsDto> findAll() {
        return transferService.findAll();
    }

    @Override
    @PostMapping("/create")
    public TransferWithFundsDto create(@RequestBody TransferWithFundsDto transferWithFundsDto) {
        return transferService.save(transferWithFundsDto);
    }
}

package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.ExecutiveDto;
import com.springboot.helpdesk.mapper.ExecutiveMapper;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.repository.ExecutiveRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExecutiveService {

    private final ExecutiveRepository executiveRepository;

    public Executive insertExecutive(@Valid ExecutiveDto executiveDTO) {
        Executive executive = ExecutiveMapper.mapDtoToEntity(executiveDTO);
        return executiveRepository.save(executive);
    }
}

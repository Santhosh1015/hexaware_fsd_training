package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.request.ExecutiveDto;
import com.springboot.helpdesk.model.Executive;
import org.springframework.stereotype.Component;

@Component
public class ExecutiveMapper {


    public static Executive mapDtoToEntity(ExecutiveDto executiveDTO) {
        Executive executive = new Executive();
        executive.setName(executiveDTO.name());
        executive.setContact(executiveDTO.contact());
        executive.setEmail(executiveDTO.email());

        return executive;
    }
}

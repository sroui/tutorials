package com.soufianeroui.tutorials.spring.observation.order.dto.assembler;

import com.soufianeroui.tutorials.spring.observation.order.dto.OrderDto;
import com.soufianeroui.tutorials.spring.observation.order.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderDtoAssembler {
    OrderDto assemble(Order entity);

    Order assemble(OrderDto dto);
}

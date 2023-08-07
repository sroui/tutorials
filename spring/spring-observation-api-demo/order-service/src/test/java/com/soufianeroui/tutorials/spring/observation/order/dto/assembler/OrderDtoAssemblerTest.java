package com.soufianeroui.tutorials.spring.observation.order.dto.assembler;

import com.soufianeroui.tutorials.spring.observation.order.dto.OrderDto;
import com.soufianeroui.tutorials.spring.observation.order.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link OrderDtoAssembler}
 *
 * @author soufiane roui
 */
class OrderDtoAssemblerTest {
    private OrderDtoAssembler orderDtoAssembler = new OrderDtoAssemblerImpl();
    private OrderDto orderDto;
    private Order order;

    @BeforeEach
    void setup() {
        order = new Order();
        order.setId(777L);
        order.setName("Bike");

        orderDto = new OrderDto();
        orderDto.setName("Chocolate");
        orderDto.setId(555L);
    }

    @Test
    void assemble_givenProductDto_thenReturnPopulatedProductModel() {
        Order actualOrderModel = orderDtoAssembler.assemble(orderDto);

        assertThat(actualOrderModel).isNotNull();
        assertThat(actualOrderModel.getId()).isEqualTo(555L);
        assertThat(actualOrderModel.getName()).isEqualTo("Chocolate");
    }

    @Test
    void assemble_givenProductModel_thenReturnPopulatedDto() {
        OrderDto actualOrderDto = orderDtoAssembler.assemble(order);

        assertThat(actualOrderDto).isNotNull();
        assertThat(actualOrderDto.getId()).isEqualTo(777L);
        assertThat(actualOrderDto.getName()).isEqualTo("Bike");
    }
}
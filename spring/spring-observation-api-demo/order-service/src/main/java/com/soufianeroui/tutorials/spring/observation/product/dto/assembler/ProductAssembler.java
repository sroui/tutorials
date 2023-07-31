package com.soufianeroui.tutorials.spring.observation.product.dto.assembler;

import com.soufianeroui.tutorials.spring.observation.product.dto.ProductDto;
import com.soufianeroui.tutorials.spring.observation.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProductAssembler {
    public abstract ProductDto assemble(Product product);

    public abstract Product assemble(ProductDto productDto);
}

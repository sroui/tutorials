package com.soufianeroui.tutorials.spring.observation.product.dto.assembler;

import com.soufianeroui.tutorials.spring.observation.product.dto.ProductDto;
import com.soufianeroui.tutorials.spring.observation.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link ProductAssembler}
 *
 * @author soufiane roui
 */
class ProductAssemblerTest {
    private ProductAssembler productAssembler = new ProductAssemblerImpl();
    private ProductDto productDto;
    private Product product;

    @BeforeEach
    void setup() {
        product = new Product();
        product.setId(777L);
        product.setName("Bike");

        productDto = new ProductDto();
        productDto.setName("Chocolate");
        productDto.setId(555L);
    }

    @Test
    void assemble_givenProductDto_thenReturnPopulatedProductModel() {
        Product actualProductModel = productAssembler.assemble(productDto);

        assertThat(actualProductModel).isNotNull();
        assertThat(actualProductModel.getId()).isEqualTo(555L);
        assertThat(actualProductModel.getName()).isEqualTo("Chocolate");
    }

    @Test
    void assemble_givenProductModel_thenReturnPopulatedDto() {
        ProductDto actualProductDto = productAssembler.assemble(product);

        assertThat(actualProductDto).isNotNull();
        assertThat(actualProductDto.getId()).isEqualTo(777L);
        assertThat(actualProductDto.getName()).isEqualTo("Bike");
    }
}
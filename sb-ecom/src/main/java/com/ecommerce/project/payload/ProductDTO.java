
package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private String productImage;
    private String productDescription;
    private Integer quantity;
    private Double price;
    private Double discount;
    private double specialProductPrice;
}

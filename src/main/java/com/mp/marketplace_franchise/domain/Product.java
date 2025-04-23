package com.mp.marketplace_franchise.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {

    @Id
    private String id;
    private String name;
    private int stock;
    private String idBranchOffice;
}

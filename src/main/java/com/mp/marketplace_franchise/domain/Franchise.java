package com.mp.marketplace_franchise.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "franchises")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Franchise {
    @Id
    private String id;
    private String name;
}

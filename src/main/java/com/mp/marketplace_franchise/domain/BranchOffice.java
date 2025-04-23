package com.mp.marketplace_franchise.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "branch_offices")
public class BranchOffice {
    @Id
    private String id;
    private String name;
    private String idFranchise;
}

package com.mp.marketplace_franchise.Dto;

import com.mp.marketplace_franchise.domain.BranchOffice;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductDetailRsDto {

    private String id;
    private String name;
    private int stock;
    private BranchOffice branchOffice;
}

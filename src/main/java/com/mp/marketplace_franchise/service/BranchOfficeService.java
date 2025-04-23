package com.mp.marketplace_franchise.service;

import com.mp.marketplace_franchise.Dto.BranchOfficeRqDto;
import com.mp.marketplace_franchise.Dto.ProductDetailRsDto;
import com.mp.marketplace_franchise.Utilities.Util;
import com.mp.marketplace_franchise.domain.BranchOffice;
import com.mp.marketplace_franchise.repository.BranchOfficeRepository;
import com.mp.marketplace_franchise.repository.FranchiseRepository;
import com.mp.marketplace_franchise.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class BranchOfficeService {

    private final BranchOfficeRepository branchOfficeRepository;

    private final FranchiseRepository franchiseRepository;

    private final ProductRepository productRepository;


    public Flux<BranchOffice> findAll() {
        return branchOfficeRepository.findAll();
    }

    public Mono<BranchOffice> findOneByName(String name) {
        return branchOfficeRepository.findByName(name);
    }

    public Mono<BranchOffice> saveBranchOffice(String franchiseId, BranchOfficeRqDto branchOfficeRq) {
        return franchiseRepository.findById(franchiseId)
                .flatMap(franchiseFound -> branchOfficeRepository.insert(
                            BranchOffice.builder()
                                    .name(branchOfficeRq.getName())
                                    .idFranchise(franchiseId)
                                    .build()
                ));
    }

    public Mono<BranchOffice> updateBranchOffice(String id, BranchOfficeRqDto branchOfficeRq) {
        return branchOfficeRepository.findById(id)
                .flatMap(brandOfficeFound -> {
                    brandOfficeFound.setName(Util.isNullOrEmpty(branchOfficeRq.getName(), brandOfficeFound.getName()));
                    return branchOfficeRepository.save(brandOfficeFound);
                });
    }

    public Flux<ProductDetailRsDto> getTopProductByBranchOffice(String franchiseId) {
        return branchOfficeRepository.findAllByIdFranchise(franchiseId)
                .flatMap(this::getTopProduct);
    }

    private Mono<ProductDetailRsDto> getTopProduct(BranchOffice branchOffice) {
        return productRepository.findAllByIdBranchOffice(branchOffice.getId())
                .reduce((product1, product2) -> product1.getStock() >= product2.getStock() ? product1 : product2)
                .map(topProduct -> ProductDetailRsDto.builder()
                        .name(topProduct.getName())
                        .stock(topProduct.getStock())
                        .id(topProduct.getId())
                        .branchOffice(branchOffice)
                        .build()
                );
    }
}

package com.mp.marketplace_franchise.service;

import com.mp.marketplace_franchise.Dto.ProductRqDto;
import com.mp.marketplace_franchise.Utilities.Util;
import com.mp.marketplace_franchise.domain.Product;
import com.mp.marketplace_franchise.repository.BranchOfficeRepository;
import com.mp.marketplace_franchise.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final BranchOfficeRepository branchOfficeRepository;


    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findOneByName(String name) {
        return productRepository.findByName(name);
    }

    public Mono<Product> saveProduct(String branchOfficeId, ProductRqDto productRq) {
        return branchOfficeRepository.findById(branchOfficeId)
                .flatMap(branchOfficeFound -> productRepository.insert(
                        Product.builder()
                                .name(productRq.getName())
                                .stock(productRq.getStock())
                                .idBranchOffice(branchOfficeId)
                                .build()
                ));
    }

    public Mono<Product> updateProduct(String id, ProductRqDto productRq) {
        return productRepository.findById(id)
                .flatMap(productFound -> {
                    productFound.setName(Util.isNullOrEmpty(productRq.getName(), productFound.getName()));
                    productFound.setStock(productRq.getStock());
                    return productRepository.save(productFound);
                });
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}

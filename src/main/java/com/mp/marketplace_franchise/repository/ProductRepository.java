package com.mp.marketplace_franchise.repository;

import com.mp.marketplace_franchise.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Mono<Product> findByName(String name);
    Flux<Product> findAllByIdBranchOffice(String idBranchOffice);
}

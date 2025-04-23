package com.mp.marketplace_franchise.repository;

import com.mp.marketplace_franchise.domain.Franchise;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface FranchiseRepository extends ReactiveMongoRepository<Franchise, String> {

    Mono<Franchise> findByName(String name);
}

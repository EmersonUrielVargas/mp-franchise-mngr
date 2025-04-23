package com.mp.marketplace_franchise.repository;

import com.mp.marketplace_franchise.domain.BranchOffice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchOfficeRepository extends ReactiveMongoRepository<BranchOffice, String> {

    Flux<BranchOffice> findAllByIdFranchise(String idFranchise);

    Mono<BranchOffice> findByName(String name);

}

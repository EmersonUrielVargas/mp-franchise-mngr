package com.mp.marketplace_franchise.service;

import com.mp.marketplace_franchise.Dto.FranchiseRqDto;
import com.mp.marketplace_franchise.Utilities.Util;
import com.mp.marketplace_franchise.domain.Franchise;
import com.mp.marketplace_franchise.repository.FranchiseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public Flux<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    public Mono<Franchise> findOneByName(String name) {
        return franchiseRepository.findByName(name);
    }

    public Mono<Franchise> saveFranchise(FranchiseRqDto franchise) {
        return franchiseRepository.insert(
                Franchise.builder()
                        .name(franchise.getName())
                        .build());
    }

    public Mono<Franchise> updateFranchise(String id, FranchiseRqDto franchise) {
        return franchiseRepository.findById(id)
                .flatMap(franchiseFound -> {
                    franchiseFound.setName(Util.isNullOrEmpty(franchise.getName(), franchiseFound.getName()));
                    return franchiseRepository.save(franchiseFound);
                });
    }

}

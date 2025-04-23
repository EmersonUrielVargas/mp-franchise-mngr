package com.mp.marketplace_franchise.controller;

import com.mp.marketplace_franchise.Dto.FranchiseRqDto;
import com.mp.marketplace_franchise.domain.Franchise;
import com.mp.marketplace_franchise.service.FranchiseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/franchise")
public class FranchiseController {

    private final FranchiseService franchiseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Franchise> getFranchises(){
        return franchiseService.findAll();
    }

    @GetMapping("/{nameFranchise}")
    public Mono<ResponseEntity<Franchise>> getFranchise(@PathVariable String nameFranchise){
        return franchiseService.findOneByName(nameFranchise)
                .map(franchise -> new ResponseEntity<>(franchise, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Mono<ResponseEntity<Franchise>> addFranchise(@RequestBody FranchiseRqDto franchise){
        return franchiseService.saveFranchise(franchise)
                .map(newFranchise -> new ResponseEntity<>(newFranchise, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PatchMapping("/{id}")
    public Mono<ResponseEntity<Franchise>> patchFranchise(@PathVariable String id, @RequestBody FranchiseRqDto franchise) {
        return franchiseService.updateFranchise(id, franchise)
                .map(newFranchise -> new ResponseEntity<>(newFranchise, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

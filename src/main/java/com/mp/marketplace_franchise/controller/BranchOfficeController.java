package com.mp.marketplace_franchise.controller;

import com.mp.marketplace_franchise.Dto.BranchOfficeRqDto;
import com.mp.marketplace_franchise.Dto.ProductDetailRsDto;
import com.mp.marketplace_franchise.domain.BranchOffice;
import com.mp.marketplace_franchise.service.BranchOfficeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/branch-office")
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    @GetMapping("")
    public Flux<BranchOffice> getBranchOffices() {
        return branchOfficeService.findAll();
    }

    @GetMapping("/{name}")
    public Mono<ResponseEntity<BranchOffice>> getBranchOffice(@PathVariable String name) {
        return branchOfficeService.findOneByName(name)
                .map(branchOffice -> new ResponseEntity<>(branchOffice, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{idFranchise}")
    public Mono<ResponseEntity<BranchOffice>> addBranchOffice(@PathVariable String idFranchise, @RequestBody BranchOfficeRqDto branchOfficeRq){
        return branchOfficeService.saveBranchOffice(idFranchise, branchOfficeRq )
                .map(newBranchOffice -> new ResponseEntity<>(newBranchOffice, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PatchMapping("/{id}")
    public Mono<ResponseEntity<BranchOffice>> patchBranchOffice(@PathVariable String id, @RequestBody BranchOfficeRqDto branchOfficeRq) {
        return branchOfficeService.updateBranchOffice(id, branchOfficeRq)
                .map(newBranchOffice -> new ResponseEntity<>(newBranchOffice, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/top-products-by-branch-offices/{idFranchise}")
    public Flux<ProductDetailRsDto> getTopProductByBranchOffice(@PathVariable String idFranchise) {
        return branchOfficeService.getTopProductByBranchOffice(idFranchise);
    }

}

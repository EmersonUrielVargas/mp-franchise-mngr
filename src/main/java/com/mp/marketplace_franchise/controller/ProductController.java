package com.mp.marketplace_franchise.controller;

import com.mp.marketplace_franchise.Dto.ProductRqDto;
import com.mp.marketplace_franchise.domain.Product;
import com.mp.marketplace_franchise.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public Flux<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{name}")
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable String name) {
        return productService.findOneByName(name)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{idBranchOffice}")
    public Mono<ResponseEntity<Product>> addProduct(@PathVariable String idBranchOffice, @RequestBody ProductRqDto productRq){
        return productService.saveProduct(idBranchOffice,productRq)
                .map(newProduct -> new ResponseEntity<>(newProduct, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PatchMapping("/{id}")
    public Mono<ResponseEntity<Product>> patchFranchise(@PathVariable String id, @RequestBody ProductRqDto productRq) {
        return productService.updateProduct(id, productRq)
                .map(newFranchise -> new ResponseEntity<>(newFranchise, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}

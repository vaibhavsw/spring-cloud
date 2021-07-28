package com.ghost.sku.controller;

import com.ghost.sku.model.Sku;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @GetMapping
    public Sku getSku(){
        return new Sku(10);
    }
}

package com.company.springExam.controller;

import com.company.springExam.model.Product;
import com.company.springExam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/{code}")
    public ResponseEntity getProduct(@PathVariable("code") String code) {
        try {
            Product product = menuService.getProduct(code);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

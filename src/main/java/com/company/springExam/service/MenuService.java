package com.company.springExam.service;

import com.company.springExam.entity.Menu;
import com.company.springExam.model.Factory;
import com.company.springExam.model.Product;
import com.company.springExam.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService implements MenuInterface {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Product getProduct(String name) {
        Menu menu = Menu.builder().code(name).build();
        Product product = Factory.getProduct(name);
        if (product != null) {
            menuRepository.save(menu);
            return product;
        }
        throw new RuntimeException("NotFoundProduct");
    }
}

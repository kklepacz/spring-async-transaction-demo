package com.example.asynctransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @Autowired
    private SomeTransactionalService someTransactionalService;

    @GetMapping("/test")
    public void test() {
        someTransactionalService.doInTransaction();
    }
}

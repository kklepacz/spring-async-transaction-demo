package com.example.asynctransactiondemo;

import com.example.asynctransactiondemo.storage.SomeEntity;
import com.example.asynctransactiondemo.storage.SomeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
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

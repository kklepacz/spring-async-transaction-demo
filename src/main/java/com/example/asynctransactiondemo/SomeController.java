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

    private static final Logger LOG = LoggerFactory.getLogger(SomeController.class);

    @Autowired
    private SomeRepository someRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/test")
    @Transactional
    public void test() {
        SomeEntity saved = someRepository.save(new SomeEntity());
        SomeEntitySaved event = new SomeEntitySaved(saved.id);
        LOG.info("publishing an event {}", event);
        eventPublisher.publishEvent(event);
    }
}

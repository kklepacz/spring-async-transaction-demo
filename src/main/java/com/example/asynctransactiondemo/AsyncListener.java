package com.example.asynctransactiondemo;

import com.example.asynctransactiondemo.storage.SomeEntity;
import com.example.asynctransactiondemo.storage.SomeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class AsyncListener {

  private static final Logger LOG = LoggerFactory.getLogger(AsyncListener.class);

  @Autowired
  private SomeRepository someRepository;

  @Async
  @TransactionalEventListener
  @Transactional
  public void handle(SomeEntitySaved someEntitySaved) {
    LOG.info("Saved entity with id: {}", someEntitySaved.id);
    LOG.info("Saving one more within same transaction");
    someRepository.save(new SomeEntity());
    LOG.info("Current state of database: ");
    someRepository.findAll().forEach(e -> LOG.info("{}", e));
  }


}

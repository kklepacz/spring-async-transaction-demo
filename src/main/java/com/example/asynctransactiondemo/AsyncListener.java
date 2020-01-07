package com.example.asynctransactiondemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class AsyncListener {

  private static final Logger LOG = LoggerFactory.getLogger(AsyncListener.class);

  @Async
  @TransactionalEventListener
  @Transactional
  public void handle(SomeEntitySaved someEntitySaved) {
    LOG.info("Transaction in async listener? {}", TransactionSynchronizationManager.isActualTransactionActive());
  }


}

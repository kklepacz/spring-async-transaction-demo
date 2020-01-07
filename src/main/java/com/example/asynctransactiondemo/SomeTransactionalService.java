package com.example.asynctransactiondemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.transaction.Transactional;

@Service
public class SomeTransactionalService {

  private static final Logger LOG = LoggerFactory.getLogger(SomeTransactionalService.class);

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Transactional
  public void doInTransaction() {
    LOG.info("Transaction in service? {}", TransactionSynchronizationManager.isActualTransactionActive());
    LOG.info("Publishing an event");
    eventPublisher.publishEvent(new SomeEntitySaved());
  }
}

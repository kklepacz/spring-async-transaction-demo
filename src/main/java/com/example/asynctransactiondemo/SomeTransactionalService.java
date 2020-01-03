package com.example.asynctransactiondemo;

import com.example.asynctransactiondemo.storage.SomeEntity;
import com.example.asynctransactiondemo.storage.SomeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SomeTransactionalService {

  private static final Logger LOG = LoggerFactory.getLogger(SomeTransactionalService.class);

  @Autowired
  private SomeRepository someRepository;

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Transactional
  public void doInTransaction() {
    SomeEntity saved = someRepository.save(new SomeEntity());
    SomeEntitySaved event = new SomeEntitySaved(saved.id);
    LOG.info("publishing an event {}", event);
    eventPublisher.publishEvent(event);
  }
}

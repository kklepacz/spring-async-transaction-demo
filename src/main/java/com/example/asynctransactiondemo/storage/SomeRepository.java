package com.example.asynctransactiondemo.storage;

import org.springframework.data.repository.CrudRepository;

public interface SomeRepository extends CrudRepository<SomeEntity, String> {
}

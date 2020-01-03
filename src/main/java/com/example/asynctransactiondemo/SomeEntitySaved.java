package com.example.asynctransactiondemo;

public class SomeEntitySaved {

  public final long id;

  public SomeEntitySaved(long id) {
    this.id = id;
  }

  @Override public String toString() {
    return "SomeEntitySaved{" +
        "id=" + id +
        '}';
  }
}

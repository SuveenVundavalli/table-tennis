package com.clx.apps.tt.db.model;

public enum Status {
  DONE("DONE"),
  PENDING("PENDING"),
  CANCELLED("CANCELLED");

  private String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}

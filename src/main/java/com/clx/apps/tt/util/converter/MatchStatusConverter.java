package com.clx.apps.tt.util.converter;

import com.clx.apps.tt.db.model.Status;

import javax.persistence.AttributeConverter;

public class MatchStatusConverter implements AttributeConverter<Status, String> {
  @Override
  public String convertToDatabaseColumn(Status attribute) {
    return attribute.toString();
  }

  @Override
  public Status convertToEntityAttribute(String dbData) {
    return Status.valueOf(dbData);
  }
}

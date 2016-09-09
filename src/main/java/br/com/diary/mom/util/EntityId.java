package br.com.diary.mom.util;

import java.util.UUID;

public class EntityId {

  public static String generated() {
    return UUID.randomUUID().toString();
  }
  

}

package br.com.diary.mom.abstracts;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;


public abstract class AbstractEntity {
  @Id
  protected String id;
  
  @Version
  protected int version;
  
  public AbstractEntity() {
  }
  
  public String getId() {
    return id;
  }

  public int getVersion() {
    return version;
  }
}

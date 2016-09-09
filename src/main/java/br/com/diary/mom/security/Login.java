package br.com.diary.mom.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
  
  private String username;
  private String senha;

  @JsonCreator
  public Login(
      @JsonProperty("username") String username,
      @JsonProperty("password") String senha) {
    this.username = username;
    this.senha = senha;
  }
  
  public String getSenha() {
    return senha;
  }
  
  public String getUsername() {
    return username;
  }

}

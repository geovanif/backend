package br.com.diary.mom.usuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarUsuario {

  private String nome;
  private String sobrenome;
  private String email;
  private String senha;

  @JsonCreator
  public CriarUsuario(
      @JsonProperty("nome") String nome, 
      @JsonProperty("sobrenome") String sobrenome, 
      @JsonProperty("email") String email, 
      @JsonProperty("senha") String senha) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.senha = senha;
  }

  public String getNome() {
    return nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }

}

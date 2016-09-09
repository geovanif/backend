package br.com.diary.mom.usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.diary.mom.abstracts.AbstractEntity;

@Document
public class Usuario extends AbstractEntity {

  private String nome;
  private String sobrenome;
  private String email;
  
  @JsonIgnore
  private String senha;
  private List<Messagem> messages;

  public Usuario(CriarUsuario criarUsuario) {
    this();
    this.nome = criarUsuario.getNome();
    this.sobrenome = criarUsuario.getSobrenome();
    this.email = criarUsuario.getEmail();
    this.senha = criarUsuario.getSenha();
  }

  public Usuario() {
    this.messages = new ArrayList<>();
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
  
  public List<Messagem> getMessages() {
    return Collections.unmodifiableList(messages);
  }

  @Override
  public String toString() {
    return String.format("Usuario[id=%s,nome=%s,sobrenome=%s,email=%s,senha=%s,version=%s]", id, nome, sobrenome, email,
        senha, version);
  }

  public void postarMensage(PostarMensagem postMessage) {
    this.messages.add(postMessage.getMessage());
  }

}

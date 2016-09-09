package br.com.diary.mom.usuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostarMensagem {

  private String usuarioId;
  private Messagem message;

  @JsonCreator
  public PostarMensagem(@JsonProperty("id") String id, @JsonProperty("mensagem") Messagem message) {
    this.usuarioId = id;
    this.message = message;
  }

  public String getUsuarioId() {
    return usuarioId;
  }

  public Messagem getMessage() {
    return message;
  }

}

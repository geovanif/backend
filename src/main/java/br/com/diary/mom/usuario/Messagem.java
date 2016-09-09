package br.com.diary.mom.usuario;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Messagem {

  private String conteudo;
  private Date dataAcontecimento;
  private TipoMessage tipo;
  private Date dataGeracao;

  @JsonCreator
  public Messagem(
      @JsonProperty("conteudo") String conteudo,
      @JsonProperty("dataAcontecimento") Date dataAcontecimento,
      @JsonProperty("tipo") TipoMessage tipo) {
    this.dataGeracao = new Date();
    this.conteudo = conteudo;
    this.dataAcontecimento = dataAcontecimento;
    this.tipo = tipo;
  }
  
  public Messagem() {
  }

  public enum TipoMessage {
    ANOTAÇÃO("Anotação"), CONSULTA_MÉDICA("Consulta médica"), EVENTOS_ESPECIAIS(
        "Eventos especiais"), REMÉDIOS_MINISTRADOS("Remédios ministrados"), ROBO("Robô");

    private String descricao;

    private TipoMessage(String descricao) {
      this.descricao = descricao;
    }

    public String getDescricao() {
      return descricao;
    }
  }

  public String getConteudo() {
    return conteudo;
  }

  public Date getDataAcontecimento() {
    return dataAcontecimento;
  }

  public TipoMessage getTipo() {
    return tipo;
  }
  
  public Date getDataGeracao() {
    return dataGeracao;
  }

}

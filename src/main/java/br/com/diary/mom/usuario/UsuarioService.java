package br.com.diary.mom.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  private UsuarioRepository repository;

  public Usuario create(CriarUsuario criarUsuario) {
    return this.repository.save(new Usuario(criarUsuario));
  }
  
  @Autowired
  public void setRepository(UsuarioRepository repository) {
    this.repository = repository;
  }

  public List<Usuario> getUsuario() {
    return this.repository.findAll();
  }

  public Usuario findByEmailAndSenha(String email, String senha) {
    return this.repository.findByEmailAndSenha(email,senha);
  }

  public Usuario postarMensagem(PostarMensagem postMessage) {
    Usuario usuario = this.repository.findOne(postMessage.getUsuarioId());
    usuario.postarMensage(postMessage);
    return this.repository.save(usuario);
  }

  public Usuario findById(String id) {
    return this.repository.findOne(id);
  }

}

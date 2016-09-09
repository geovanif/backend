package br.com.diary.mom.usuario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

  Usuario findByEmailAndSenha(String email, String senha);

  Usuario findByEmail(String username);

}

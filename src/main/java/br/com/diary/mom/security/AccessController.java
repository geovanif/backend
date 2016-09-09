package br.com.diary.mom.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.diary.mom.usuario.Messagem;
import br.com.diary.mom.usuario.Messagem.TipoMessage;
import br.com.diary.mom.usuario.PostarMensagem;
import br.com.diary.mom.usuario.Usuario;
import br.com.diary.mom.usuario.UsuarioService;

@RestController
@RequestMapping("/login")
@CrossOrigin(maxAge=3600)
public class AccessController {
  
  @Autowired
  private UsuarioService usuarioService;
  
  
  @RequestMapping(method=RequestMethod.POST)
  @ResponseBody
  public Usuario getAccess(@RequestBody Login login) throws Exception{
    Usuario usuario = this.usuarioService.findByEmailAndSenha(login.getUsername(), login.getSenha());
    if(usuario == null)
      throw new Exception("Usuario não encontrado.");
    if(usuario.getMessages().isEmpty()){
      return usuarioService.postarMensagem(new PostarMensagem(usuario.getId(), new Messagem("Olá mamãe "+  usuario.getNome() + " como você está? =)", new Date(), TipoMessage.ROBO)));
    }
    return usuario;
  }

}

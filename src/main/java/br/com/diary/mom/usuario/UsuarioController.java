package br.com.diary.mom.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  private UsuarioService usuarioService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public Usuario create(@RequestBody CriarUsuario criarUsuario) {
    return this.usuarioService.create(criarUsuario);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  @ResponseBody
  public Usuario get(@PathVariable String id) {
    return this.usuarioService.findById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Usuario> get() {
    return this.usuarioService.getUsuario();
  }

  @RequestMapping(method = RequestMethod.PUT)
  @ResponseBody
  public Usuario edit(@RequestBody PostarMensagem postarMensagem) {
    return this.usuarioService.postarMensagem(postarMensagem);
  }

  @Autowired
  public void setUsuarioService(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

}

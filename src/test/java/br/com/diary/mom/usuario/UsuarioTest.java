package br.com.diary.mom.usuario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.diary.mom.usuario.Messagem.TipoMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

  @Autowired
	private UsuarioController usuarioController;
  
  @Autowired
  private UsuarioService usuarioService;
  
  @Mock
  private UsuarioRepository usuarioRepositoryMock;
  
  @Before
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    this.usuarioService.setRepository(usuarioRepositoryMock);
  }

  @Test
	public void criarUsuario() {
	  String nome = "MARIA";
    String sobrenome = "JOAQUINA";
    String email = "maria.joaquina@gmail.com";
    String senha = "12345";
    CriarUsuario criarUsuario = new CriarUsuario(nome, sobrenome, email, senha);
    this.usuarioController.create(criarUsuario);
    ArgumentCaptor<Usuario> argUsuario = ArgumentCaptor.forClass(Usuario.class);
    verify(this.usuarioRepositoryMock).save(argUsuario.capture());
    
    Usuario usuarioSalvo = argUsuario.getValue();
    assertThat(usuarioSalvo.getNome()).isEqualTo("MARIA");
    assertThat(usuarioSalvo.getSobrenome()).isEqualTo("JOAQUINA");
    assertThat(usuarioSalvo.getSenha()).isEqualTo("12345");
    assertThat(usuarioSalvo.getEmail()).isEqualTo("maria.joaquina@gmail.com");
	}
  
  @Test
  public void postMessage(){
    String id = "1";
    Date dataAcontecimento = new Date();
    Messagem message = new Messagem("NOVO CONTEUDO", dataAcontecimento, TipoMessage.ANOTAÇÃO);
    PostarMensagem postar = new PostarMensagem(id, message);
    Usuario usuarioSpy = spy(new Usuario());
    when(usuarioRepositoryMock.findOne(id)).thenReturn(usuarioSpy);
    this.usuarioController.edit(postar);
    assertThat(usuarioSpy.getMessages()).hasSize(1);
    assertThat(usuarioSpy.getMessages().get(0).getConteudo()).isEqualTo("NOVO CONTEUDO");
    assertThat(usuarioSpy.getMessages().get(0).getDataAcontecimento()).isEqualTo(dataAcontecimento);
    assertThat(usuarioSpy.getMessages().get(0).getTipo()).isEqualTo(TipoMessage.ANOTAÇÃO);
    
  }

}

import org.example.dto.input.UsuarioDTOInput;
import org.example.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    public void testInsercaoUsuario() {
        UsuarioService usuarioService = new UsuarioService();
        UsuarioDTOInput usuarioDTOInput = new UsuarioDTOInput("Andre Ferrarez", "senha123");

        usuarioService.adicionarUsuario(usuarioDTOInput);

        assertEquals(1, usuarioService.listarUsuarios().size());

        System.out.println("Lista de Usuários após o teste: " + usuarioService.listarUsuarios().size());
    }
}
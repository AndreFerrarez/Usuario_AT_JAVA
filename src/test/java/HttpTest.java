import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.UsuarioController;
import org.example.service.UsuarioService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spark.Spark.port;

public class HttpTest {

    @BeforeAll
    public static void setup() {
        // Inicialize o Spark e configure os endpoints aqui
        port(4567); // Ajuste a porta conforme necessário
        new UsuarioController(new UsuarioService(), new ObjectMapper()).respostasRequisicoes();
    }

    @Test
    public void testListagemUsuarios() throws IOException {
        URL url = new URL("http://localhost:4567/usuarios");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Fazendo uma requisição GET
        connection.setRequestMethod("GET");

        // Validando o código de resposta
        assertEquals(200, connection.getResponseCode());
    }
}
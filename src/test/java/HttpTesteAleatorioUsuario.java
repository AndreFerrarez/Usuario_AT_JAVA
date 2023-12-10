import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpTesteAleatorioUsuario {
    @Test
    public void testInsercaoUsuarioRandomico() throws IOException {
        URL randomUserUrl = new URL("https://randomuser.me/api/");
        HttpURLConnection randomUserConnection = (HttpURLConnection) randomUserUrl.openConnection();
        randomUserConnection.setRequestMethod("GET");

        assertEquals(200, randomUserConnection.getResponseCode());

        URL usuarioApiUrl = new URL("http://localhost:4567/usuarios");
        HttpURLConnection minhaApiConnection = (HttpURLConnection) usuarioApiUrl.openConnection();
        minhaApiConnection.setRequestMethod("POST");


        assertEquals(201, minhaApiConnection.getResponseCode());
    }
}
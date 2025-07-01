import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class VerificarConexao {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                System.out.println("Conectado à internet!");
            } else {
                System.out.println("Sem conexão. Código: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}

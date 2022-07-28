import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão via HTTP e buscar os melhores 250 filmes de um Ranking

        // String url = "https://imdb-api.com/en/API/Top250Movies/k_wn3l5gxc";
        // URI endereco = URI.create(url);
        // ou...
        URI endereco = URI.create("https://imdb-api.com/en/API/Top250Movies/k_wn3l5gxc");

        // HttpClient client = HttpClient.newHttpClient();
        // ou...
        var client = HttpClient.newHttpClient();

        // HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        // ou...
        var request = HttpRequest.newBuilder(endereco).GET().build();

        // HttpResponse<String> response = client.send(request,
        // BodyHandlers.ofString());
        // ou ...
        var response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extrair informações relevantes para o projeto (título, poster, classificação
        // e nota)

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir e manipular os dados

        StickersGen sticker = new StickersGen();

        for (int i = 0; i < 10; i++) {
            Map<String, String> filme = listaDeFilmes.get(i);

            String titulo = filme.get("title");

            // String urlImagem = filme.get("image");
            String urlImagem = filme.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

            InputStream inputStream = new URL(urlImagem).openStream();

            sticker.criarImagem(inputStream, titulo);

            System.out.println("Título: " + titulo);
            System.out.println("Nota: " + filme.get("imDbRating") + "\n");
        }
    }
}

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        final Map<String, String> COR = new HashMap<>(
                Map.of("red", "\u001B[31m",
                        "green", "\u001B[32m",
                        "yellow", "\u001B[33m",
                        "blue", "\u001B[34m",
                        "magenta", "\u001B[35m",
                        "cyan", "\u001B[36m",
                        "reset", "\u001B[0m"));

        // Conteudo Nasa.

        // String url =
        // "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        // ExtratorDeConteudos extrator = new ExtratorDeConteudoNasa();

        // conteudo IMDb.

        String url = "https://imdb-api.com/en/API/Top250Movies/k_wn3l5gxc";
        ExtratorDeConteudos extrator = new ExtratorDeConteudoIMDb();

        // conteudo Magic The Gathering.

        // String url = "https://api.magicthegathering.io/v1/cards";
        // ExtratorDeConteudos extrator = new ExtratorDeConteudoMTG();

        // conteudo Linguagens de Programação.
        // String url = "http://localhost:8080/linguagens";
        // ExtratorDeConteudos extrator = new ExtratorDeConteudoLinguagens();

        var clienteHttp = new ClienteHttp();
        String json = clienteHttp.buscaDados(url);

        // Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var sticker = new StickersGen();

        for (Conteudo conteudo : conteudos) {

            // Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            int imDbRating = (int) Math.floor(Double.parseDouble(conteudo.getNota()));

            String nomeDoArquivo = "../../saida/" + conteudo.getTitulo() + ".png";
            String frase = conteudo.getTitulo();
            sticker.criarImagem(inputStream, nomeDoArquivo, frase);

            System.out.println("\nTítulo: \u001b[4m" + conteudo.getTitulo() + COR.get("reset"));
            System.out.println(COR.get("cyan") + conteudo.getUrlImagem() + COR.get("reset"));
            System.out.println("Nota: " + COR.get("yellow") + " ".repeat(imDbRating) + " " + conteudo.getNota() +
                    COR.get("reset"));
        }
    }
}

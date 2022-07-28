import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Conteudo Nasa.
        // String url =
        // "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        // ExtratorDeConteudos extrator = new ExtratorDeConteudoNasa();

        // conteudo IMDb.
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_wn3l5gxc";
        // ExtratorDeConteudos extrator = new ExtratorDeConteudoIMDb();

        // conteudo Magic The Gathering.
        // String url = "https://api.magicthegathering.io/v1/cards";
        // ExtratorDeConteudos extrator = new ExtratorDeConteudoMTG();

        // conteudo Linguagens de Programação.
        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudos extrator = new ExtratorDeConteudoLinguagens();

        var clienteHttp = new ClienteHttp();
        String json = clienteHttp.buscaDados(url);

        // Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var sticker = new StickersGen();

        for (Conteudo conteudo : conteudos) {

            // Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeDoArquivo = "../../saida/" + conteudo.getTitulo() + ".png";
            String frase = conteudo.getTitulo();
            sticker.criarImagem(inputStream, nomeDoArquivo, frase);

            System.out.println("Título: " + conteudo.getTitulo());
            System.out.println();
            // System.out.println("Nota: " + conteudo.get("imDbRating") + "\n");
        }
    }
}

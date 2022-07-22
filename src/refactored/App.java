import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão via HTTP e buscar os melhores 250 filmes de um Ranking

        // String url = "";
        // Conteudo Nasa.
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        // conteudo IMDb.
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_wn3l5gxc";
        // conteudo Magic The Gathering.
        // String url = "https://api.magicthegathering.io/v1/cards";

        var clienteHttp = new ClienteHttp();
        String json = clienteHttp.buscaDados(url);

        // Exibir e manipular os dados
        ExtratorDeConteudos extrator = new ExtratorDeConteudoNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var sticker = new StickersGen();

        for (int i = 2; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeDoArquivo = "../../saida/" + conteudo.getTitulo() + ".png";
            sticker.criarImagem(inputStream, nomeDoArquivo);

            System.out.println("Título: " + conteudo.getTitulo());
            System.out.println();
            // System.out.println("Nota: " + conteudo.get("imDbRating") + "\n");
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ExtratorDeConteudoIMDb
 */
public class ExtratorDeConteudoIMDb implements ExtratorDeConteudos {

    public List<Conteudo> extraiConteudos(String json) {
        // Extrair informações relevantes para o projeto (título, poster, classificação
        // e nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular (preencher) a lista de conteudos
        for (Map<String, String> atributo : listaDeAtributos) {

            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ExtratorDeConteudoNasa
 */
public class ExtratorDeConteudoNasa implements ExtratorDeConteudos {

    public List<Conteudo> extraiConteudos(String json) {

        // Extrair informações relevantes para o projeto (título, poster, classificação
        // e nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular (preencher) a lista de conteudos
        for (Map<String, String> atributo : listaDeAtributos) {

            String titulo = atributo.get("title");
            String urlImagem = atributo.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }

}

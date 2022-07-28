import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ExtratorDeConteudoMTG
 */
public class ExtratorDeConteudoMTG implements ExtratorDeConteudos {

    public List<Conteudo> extraiConteudos(String json) {

        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        String nome;
        String urlImagem;

        // popular (preencher) a lista de conteudos
        for (Map<String, String> atributo : listaDeAtributos) {

            System.out.println(atributo.get("name"));
            if (atributo.get("language") == "Portuguese (Brazil)") {
                nome = atributo.get("name");
                urlImagem = atributo.get("imageUrl");

                conteudos.add(new Conteudo(nome, urlImagem));
            }
        }

        return conteudos;
    }

}

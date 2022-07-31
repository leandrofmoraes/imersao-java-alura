/**
 * Conteudo
 */
public class Conteudo {

    private final String titulo;
    private final String urlImagem;
    private final String imDbNota;

    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.imDbNota = "0";
    }

    public Conteudo(String titulo, String urlImagem, String nota) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.imDbNota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getNota() {
        return imDbNota;
    }

}

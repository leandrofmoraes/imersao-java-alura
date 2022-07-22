
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.FileInputStream;
import java.io.InputStream;
// import java.net.URL;

import javax.imageio.ImageIO;

/**
 * StickersGen
 */
public class StickersGen {

    public void criarImagem(InputStream inputStream, String nomeDoArquivo) throws Exception {

        // leitura de imagem

        // InputStream inputStream = new FileInputStream(new
        // File("../entrada/poster-maior.jpg"));

        // String urlDeImagem =
        // "https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3.jpg";
        // InputStream inputStream = new URL(urlDeImagem).openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem com transparência e com novo tamanho (em memória)

        int largura = imagemOriginal.getWidth();

        // int height = imagemOriginal.getHeight();
        int novaAltura = imagemOriginal.getHeight() + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copia a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // escrever uma frase na nova imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        graphics.drawString("IMDB: 8,6", 100, novaAltura - 100);

        // salvar a nova imagem em arquivo
        // ImageIO.write(novaImagem, "png", new File("../../saida/" + nomeDoArquivo +
        // "_poster.png"));
        ImageIO.write(novaImagem, "png", new File(nomeDoArquivo));
    }

    // Teste
    /*
     * public static void main(String[] args) throws Exception {
     * var geraSticker = new StickersGen();
     * geraSticker.criarImagem();
     * }
     */
}

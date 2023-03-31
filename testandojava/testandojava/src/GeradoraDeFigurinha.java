import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {
    
    public void cria() {
        try{
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/imagem.jpg"));

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();

        graphics.drawImage(imagemOriginal, 0, 0, null);

        

        
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
        }catch(Exception exception){
            System.out.println(exception);
        }
        

        
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinha();
        geradora.cria();
    }
}

package exercicio.o1;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author owzi
 */
public class Quarto {

    /* 
        Swing e File
    ●
        JFileChooser 
    */

    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        int retorno = fc.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            System.out.println("O arquivo: " + arquivo.getAbsolutePath() + " tem o tamanho de " + arquivo.length() + " bytes!");
        } else {
            System.out.println("Operação Cancelada");
        }
    }

}

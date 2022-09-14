import javax.swing.*;

/**
 * Clase contenedora del metodo main, instancia el objeto Frame donde se desarrolla la aplicación
 */
public class ProcesadorDeTexto {
    public static void main(String[]args){
        Frame procesador= new Frame();
    }
}

/**
 * Clase que hereda de JFrame y contiene el marco de la ventana, sus carcateristicas
 * y añade a ella al panel principal
 */
class Frame extends JFrame {
    public Frame() {
        setTitle("WordMachine");
        setBounds(100,50,1000,580);
        add(new PanelPrincipal());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}









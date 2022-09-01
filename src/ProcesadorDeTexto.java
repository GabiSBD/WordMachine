import javax.swing.*;

public class ProcesadorDeTexto {
    public static void main(String[]args){
        Frame procesador= new Frame();
    }
}
class Frame extends JFrame {
    public Frame() {
        setTitle("WordMachine");
        setBounds(100,50,1000,580);
        add(new PanelPrincipal());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}









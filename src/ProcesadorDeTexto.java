import javax.swing.*;

import java.awt.*;



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
class PanelPrincipal extends JPanel {
    public PanelPrincipal() {
        setLayout(new BorderLayout());


        add(panelMenu, BorderLayout.NORTH);




        add(panelTexto, BorderLayout.CENTER);




        add(panelDeslizante,BorderLayout.WEST);





    }


    private PanelMenu panelMenu= PanelMenu.getInstance();
    private PanelTexto panelTexto= PanelTexto.getInstance();

    private PanelDeslizante panelDeslizante = PanelDeslizante.getInstance();
    }








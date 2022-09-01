import javax.swing.*;
import java.awt.*;

public class PanelTexto extends JPanel {
    private PanelTexto(){
        hoja= new JTextPane();
        hoja.setPreferredSize(new Dimension(950,450));


        JScrollPane scroll= new JScrollPane(hoja);

        add(scroll);
    }

    public static PanelTexto getInstance(){
       return panelTexto==null? panelTexto = new PanelTexto():panelTexto;
    }


    public JTextPane getHoja() { return hoja; }

    private JTextPane hoja;
    private static PanelTexto panelTexto ;
}

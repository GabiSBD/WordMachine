import javax.swing.*;
import java.awt.*;

/**
 * Clase que hereda de JPanel, se encarga de la construcion del subpanel donde se alberga el area de escritura de texto.
 * se implenmenta un patron Singleton, para asegurar que solo haya una misma instancia de este panel y sus atributos, como
 * ocurre en la clase MenuDeslizante que es necesario pasarle el JTextPane "hoja", para las acciones de guardar y cargar,
 * asegurandose que es el mismo que esta en el panelPrincipal y manteniendo la encapsulacion.
 * @see MenuDeslizante setFileListener()
 */
public class PanelTexto extends JPanel {
    private PanelTexto(){
        hoja= new JTextPane();
        hoja.setPreferredSize(new Dimension(950,450));


        JScrollPane scroll= new JScrollPane(hoja);

        add(scroll);
    }
    /**
     * Funcion necesaria para el patron Singleton, instancia el objeto panelTexto de esta misma clase o devuelve
     * la instancia creada anteriormente.
     * @return PanelTexto
     */
    public static PanelTexto getInstance(){
       return panelTexto==null? panelTexto = new PanelTexto():panelTexto;
    }

    /**
     * metodo getter de el atributo hoja.
     * @return JTextPane
     */
    public JTextPane getHoja() { return hoja; }

    private JTextPane hoja;
    private static PanelTexto panelTexto ;
}

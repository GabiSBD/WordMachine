import javax.swing.*;
import java.awt.*;

/**
 * Esta clase que hereda de JPanel, se encarga de albergar y dar un emplazamiento correcto a los demas subpaneles y
 * los alberga para su posterior añadido desde la clase Frame de una manera limpia y permite añadir o quitar paneles
 * sin necesidad de modificar ninguna otra clase. en definitiva su funcion es gestionar los paneles que se añaden al
 * Frame y sus dispsicion.
 */
class PanelPrincipal extends JPanel {
    public PanelPrincipal() {
        setLayout(new BorderLayout());

        add(panelMenu, BorderLayout.NORTH);

        add(panelTexto, BorderLayout.CENTER);

        add(menuDeslizante,BorderLayout.WEST);


    }

    /**
     * instancias de los subpaneles mediante el patron Singleton
     */

    private PanelMenu panelMenu= PanelMenu.getInstance();
    private PanelTexto panelTexto= PanelTexto.getInstance();
    private MenuDeslizante menuDeslizante = MenuDeslizante.getInstance();
}


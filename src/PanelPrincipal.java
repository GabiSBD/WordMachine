import javax.swing.*;
import java.awt.*;


class PanelPrincipal extends JPanel {
    public PanelPrincipal() {
        setLayout(new BorderLayout());

        add(panelMenu, BorderLayout.NORTH);

        add(panelTexto, BorderLayout.CENTER);

        add(menuDeslizante,BorderLayout.WEST);


    }


    private PanelMenu panelMenu= PanelMenu.getInstance();
    private PanelTexto panelTexto= PanelTexto.getInstance();
    private MenuDeslizante menuDeslizante = MenuDeslizante.getInstance();
}


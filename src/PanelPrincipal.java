import javax.swing.*;
import java.awt.*;


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


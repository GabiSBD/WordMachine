import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Clase que hereda de JPanel, se encarga de construir el menu superior de la aplicacion, implementa el patron Singleton
 */
public class PanelMenu extends JPanel {
    private PanelMenu(){

        barraMenu= new JMenuBar();

        fuente= new JMenu("Fuente");
        barraMenu.add(fuente);

        estilo= new JMenu("Estilo");
        barraMenu.add(estilo);

        tamagno= new JMenu("Tamaño");
        barraMenu.add(tamagno);

        arial= new JMenuItem("Arial");
        fuente.add(arial);

        cambria= new JMenuItem("Cambria");
        fuente.add(cambria);

        verdana= new JMenuItem("Verdana");
        fuente.add(verdana);

        negrita= new JMenuItem("Bold",new ImageIcon("B.png"));
        estilo.add(negrita);

        cursiva= new JMenuItem("Italic", new ImageIcon("I.png"));
        estilo.add(cursiva);

        subrayado= new JMenuItem("Underline", new ImageIcon("U.png"));
        estilo.add(subrayado);

        ButtonGroup tamagnogrupo=new ButtonGroup();

        tamagno_12= new JRadioButton("12");
        tamagnogrupo.add(tamagno_12);
        tamagno.add(tamagno_12);

        tamagno_16= new JRadioButton("16");
        tamagnogrupo.add(tamagno_16);
        tamagno.add(tamagno_16);

        tamagno_18= new JRadioButton("18");
        tamagnogrupo.add(tamagno_18);
        tamagno.add(tamagno_18);

        tamagno_20= new JRadioButton("20");
        tamagnogrupo.add(tamagno_20);
        tamagno.add(tamagno_20);

        add(barraMenu);

        /*
        usamos el metodo setAccelerator para añadidir unos accesos rapido desde el teclado a los botones de estilo
         */
        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_DOWN_MASK));
        subrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_DOWN_MASK));

        this.setListener();
    }

    /**
     * Funcion necesaria para el patron Singleton, instancia el objeto PanelMenu de esta misma clase o devuelve
     * la instancia creada anteriormente.
     * @return PanelMenu
     */
    public static PanelMenu getInstance(){return panelMenu==null?panelMenu = new PanelMenu():panelMenu;}

    /**
     * Procedimiento que se encarga de añadir los actionLstener a los oyentes y asi gestionar los eventos.
     */
    private  void setListener() {
        AbstractButton[]items= {arial, cambria, verdana, cursiva, negrita, subrayado, tamagno_12, tamagno_16,
                tamagno_18, tamagno_20};

        for (AbstractButton item : items) {
            switch (item.getText()){
                case "Arial":
                case "Cambria":
                case "Verdana":
                    item.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaFuente",item.getText()));
                    break;
                case "Italic":
                    item.addActionListener(new StyledEditorKit.ItalicAction());
                    break;
                case "Bold":
                    item.addActionListener(new StyledEditorKit.BoldAction());
                    break;
                case "Underline":
                    item.addActionListener(new StyledEditorKit.UnderlineAction());
                    break;
                default:
                    item.addActionListener(new StyledEditorKit.FontSizeAction("size",Integer.parseInt(item.getText())));
            }

        }

    }
    private JMenuBar barraMenu;
    private JMenu fuente, estilo, tamagno;
    private JMenuItem arial,cambria , verdana, negrita, cursiva,subrayado;
    private JRadioButton tamagno_12, tamagno_16, tamagno_18, tamagno_20;
    private static PanelMenu panelMenu;

}

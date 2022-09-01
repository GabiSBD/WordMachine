import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PanelMenu extends JPanel {
    private PanelMenu(){

        barraMenu= new JMenuBar();

        fuente= new JMenu("Fuente"); barraMenu.add(fuente);
        estilo= new JMenu("Estilo"); barraMenu.add(estilo);
        tamagno= new JMenu("Tamaño"); barraMenu.add(tamagno);

        arial= new JMenuItem("Arial"); fuente.add(arial);
        cambria= new JMenuItem("Cambria"); fuente.add(cambria);
        verdana= new JMenuItem("Verdana"); fuente.add(verdana);

        negrita= new JMenuItem("Bold",new ImageIcon("B.png")); estilo.add(negrita);
        cursiva= new JMenuItem("Italic", new ImageIcon("I.png")); estilo.add(cursiva);
        subrayado= new JMenuItem("Underline", new ImageIcon("U.png")); estilo.add(subrayado);

        ButtonGroup tamagnogrupo=new ButtonGroup();

        tamagno_12= new JRadioButton("12"); tamagnogrupo.add(tamagno_12); tamagno.add(tamagno_12);
        tamagno_16= new JRadioButton("16"); tamagnogrupo.add(tamagno_16); tamagno.add(tamagno_16);
        tamagno_18= new JRadioButton("18"); tamagnogrupo.add(tamagno_18); tamagno.add(tamagno_18);
        tamagno_20= new JRadioButton("20"); tamagnogrupo.add(tamagno_20); tamagno.add(tamagno_20);

        add(barraMenu);

        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_DOWN_MASK));
        subrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_DOWN_MASK));

        setListener();
    }

    public static PanelMenu getInstance(){return panelMenu==null?panelMenu = new PanelMenu():panelMenu;}


    private  void setListener() {
        AbstractButton[]items= {arial, cambria, verdana, cursiva, negrita, subrayado, tamagno_12, tamagno_16,
                tamagno_18, tamagno_20};

        for (AbstractButton item : items) {
            if(item.getText().equalsIgnoreCase("arial")||item.getText().equalsIgnoreCase("cambria")
                    ||item.getText().equalsIgnoreCase("verdana")) {

                item.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaFuente",item.getText()));

            }

            else if(item.getText().equalsIgnoreCase("italic"))
                item.addActionListener(new StyledEditorKit.ItalicAction());

            else if(item.getText().equalsIgnoreCase("bold"))
                item.addActionListener(new StyledEditorKit.BoldAction());

            else if(item.getText().equalsIgnoreCase("underline"))
                item.addActionListener(new StyledEditorKit.UnderlineAction());

            else  item.addActionListener(new StyledEditorKit.FontSizeAction("size",Integer.parseInt(item.getText())));
        }



    }
    private JMenuBar barraMenu;
    private JMenu fuente, estilo, tamagno;
    private JMenuItem arial,cambria , verdana, negrita, cursiva,subrayado;
    private JRadioButton tamagno_12, tamagno_16, tamagno_18, tamagno_20;
    private static PanelMenu panelMenu;
}

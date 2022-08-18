import javax.swing.*;

import javax.swing.text.StyledEditorKit;
import java.awt.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


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
        //-----------------Creamos la barra de herramientas--------------
        panelMenu= new JPanel();
        barraMenu= new JMenuBar();

        fuente= new JMenu("Fuente"); barraMenu.add(fuente);
        estilo= new JMenu("Estilo"); barraMenu.add(estilo);
        tamagno= new JMenu("Tamaño"); barraMenu.add(tamagno);

        arial= new JMenuItem("Arial"); fuente.add(arial);
        cambria= new JMenuItem("Cambria"); fuente.add(cambria);
        verdana= new JMenuItem("Verdana"); fuente.add(verdana);

        negrita= new JMenuItem("Negrita"); estilo.add(negrita);
        cursiva= new JMenuItem("Cursiva"); estilo.add(cursiva);
        subrayado= new JMenuItem("Subrayado"); estilo.add(subrayado);

        ButtonGroup tamagnogrupo=new ButtonGroup();

        tamagno_12= new JRadioButton("12"); tamagnogrupo.add(tamagno_12); tamagno.add(tamagno_12);
        tamagno_16= new JRadioButton("16"); tamagnogrupo.add(tamagno_16); tamagno.add(tamagno_16);
        tamagno_18= new JRadioButton("18"); tamagnogrupo.add(tamagno_18); tamagno.add(tamagno_18);
        tamagno_20= new JRadioButton("20"); tamagnogrupo.add(tamagno_20); tamagno.add(tamagno_20);

        panelMenu.add(barraMenu);
        add(panelMenu, BorderLayout.NORTH);

        //------------------------contruimos el cuadro de texto--------------------

        JPanel panelTexto= new JPanel();

        hoja= new JTextPane();
        hoja.setPreferredSize(new Dimension(950,450));


        JScrollPane scroll= new JScrollPane(hoja);

        panelTexto.add(scroll);
        add(panelTexto, BorderLayout.CENTER);

        //----------------------------contruimos el JPopupMenu---------------------------------
        menuDeslizante=new JToolBar(JToolBar.VERTICAL);

        n= new JButton(new ImageIcon("B.png")); menuDeslizante.add(n);
        k= new JButton(new ImageIcon("I.png")); menuDeslizante.add(k);
        s= new JButton(new ImageIcon("U.png")); menuDeslizante.add(s);

        menuDeslizante.addSeparator();

        red=new JButton(new ImageIcon("red.png")); menuDeslizante.add(red);
        green=new JButton(new ImageIcon("green.png")); menuDeslizante.add(green);
        blue=new JButton(new ImageIcon("blue.png")); menuDeslizante.add(blue);

        menuDeslizante.addSeparator();

        alinLeft=new JButton(new ImageIcon("Izq.png"));menuDeslizante.add(alinLeft);
        alinCenter=new JButton(new ImageIcon("Center.png"));menuDeslizante.add(alinCenter);
        alinRight=new JButton(new ImageIcon("Drch.png"));menuDeslizante.add(alinRight);

        add(menuDeslizante,BorderLayout.WEST);
        //--------------------------ponemos los items del menu suoerior a la escucha---------------------
        setListener();

        //----------------ponemos atajos de teclado para los actionlisteners de los item-----------------
        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_DOWN_MASK));
        subrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_DOWN_MASK));


    }

    private  void setListener(){
        JMenuItem[]items= {arial,cambria,verdana,cursiva,negrita,subrayado};

        for (JMenuItem item : items) {
            if(item.getText().equalsIgnoreCase("arial")||item.getText().equalsIgnoreCase("cambria")
                    ||item.getText().equalsIgnoreCase("verdana")) {

                item.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaFuente",item.getText()));

            }

           else if(item.getText().equalsIgnoreCase("cursiva")) item.addActionListener(new StyledEditorKit.ItalicAction());
           else if(item.getText().equalsIgnoreCase("negrita")) item.addActionListener(new StyledEditorKit.BoldAction());
           else if(item.getText().equalsIgnoreCase("subrayado")) item.addActionListener(new StyledEditorKit.UnderlineAction());
           else item.addActionListener(new StyledEditorKit.FontSizeAction("size",Integer.parseInt(item.getText())));

        }
        JRadioButton[] items2= {tamagno_12,tamagno_16,tamagno_18,tamagno_20};
        for (JRadioButton item : items2){
             item.addActionListener(new StyledEditorKit.FontSizeAction("size",Integer.parseInt(item.getText())));
        }
    }

    private JPanel panelMenu;
    private JMenuBar barraMenu;
    private JMenu fuente, estilo, tamagno;
    private JMenuItem arial,cambria , verdana, negrita, cursiva,subrayado;
    private JRadioButton tamagno_12, tamagno_16, tamagno_18, tamagno_20;
    private JToolBar menuDeslizante;
    private JButton n,k,s,red,green,blue,alinLeft,alinCenter,alinRight;
    private JTextPane hoja;

}
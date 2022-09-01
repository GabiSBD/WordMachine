import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PanelDeslizante extends JPanel{
    private PanelDeslizante() {
        menuDeslizante = new JToolBar(JToolBar.VERTICAL);

        b = new JButton("b", new ImageIcon("B.png"));
        menuDeslizante.add(b);
        i = new JButton("i", new ImageIcon("I.png"));
        menuDeslizante.add(i);
        u = new JButton("u", new ImageIcon("U.png"));
        menuDeslizante.add(u);

        menuDeslizante.addSeparator();

        red = new JButton("red", new ImageIcon("red.png"));
        menuDeslizante.add(red);
        green = new JButton("green", new ImageIcon("green.png"));
        menuDeslizante.add(green);
        blue = new JButton("blue", new ImageIcon("blue.png"));
        menuDeslizante.add(blue);

        menuDeslizante.addSeparator();

        alinLeft = new JButton("alinleft", new ImageIcon("Izq.png"));
        menuDeslizante.add(alinLeft);
        alinCenter = new JButton("alincenter", new ImageIcon("Center.png"));
        menuDeslizante.add(alinCenter);
        alinRight = new JButton("alinright", new ImageIcon("Drch.png"));
        menuDeslizante.add(alinRight);

        menuDeslizante.addSeparator();

        save = new JButton("save", new ImageIcon("save.png"));
        menuDeslizante.add(save);
        load = new JButton("load", new ImageIcon("load.png"));
        menuDeslizante.add(load);

        add(menuDeslizante);
    }

    public static PanelDeslizante getInstance(){
        return panelDeslizante==null? panelDeslizante = new PanelDeslizante():panelDeslizante;
    }

    private void setListener() {
        AbstractButton[] items = {b, i, u, red, green, blue, alinLeft, alinCenter, alinRight};


        for (AbstractButton item : items) {

            if (item.getText().equalsIgnoreCase("i"))
                item.addActionListener(new StyledEditorKit.ItalicAction());

            else if (item.getText().equalsIgnoreCase("b"))
                item.addActionListener(new StyledEditorKit.BoldAction());

            else if (item.getText().equalsIgnoreCase("u"))
                item.addActionListener(new StyledEditorKit.UnderlineAction());

            else if (item.getText().equalsIgnoreCase("red"))
                item.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));
            else if (item.getText().equalsIgnoreCase("green"))
                item.addActionListener(new StyledEditorKit.ForegroundAction("verde", Color.GREEN));
            else if (item.getText().equalsIgnoreCase("blue"))
                item.addActionListener(new StyledEditorKit.ForegroundAction("blue", Color.BLUE));
            else if (item.getText().equalsIgnoreCase("red"))
                item.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));

            else if (item.getText().equalsIgnoreCase("alinleft"))
                item.addActionListener(new StyledEditorKit.AlignmentAction("izq", 0));
            else if (item.getText().equalsIgnoreCase("alincenter"))
                item.addActionListener(new StyledEditorKit.AlignmentAction("izq", 4));
            else if (item.getText().equalsIgnoreCase("alinright"))
                item.addActionListener(new StyledEditorKit.AlignmentAction("drch", 2));

            setFileListener();

            //--------------------borro los text de los botones para que no se reflejen en la interfaz,les puse text porque me ahorro codigo en el setlistener------------------
            JButton[]quitText={b, i, u, red, green, blue , alinLeft, alinCenter, alinRight, save, load};
            for(JButton boton:quitText) boton.setText("");
        }

    }
    public void setFileListener(){
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    file= new PrintStream(JOptionPane.showInputDialog("Introduce nombre y extension del archivo:" +
                            "\n(.txt,.doc,etc)"));
                }catch(java.io.FileNotFoundException exception){
                    System.out.println(exception.getMessage());
                }
                file.println(panelTexto.getHoja().getText());
                file.close();
            }
            PrintStream file;
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    file= new FileInputStream(JOptionPane.showInputDialog("Introduce nombre y extension del archivo:" +
                            "\n(.txt,.doc,etc)"));
                    buffer=file.readAllBytes();
                    String text= new String(buffer, java.nio.charset.StandardCharsets.UTF_8);
                    panelTexto.getHoja().setText(text);

                }catch(FileNotFoundException exception){
                    System.out.println(exception.getMessage());
                }catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            byte[]buffer=new byte [0];
            InputStream file;
        });

    }
    private PanelTexto panelTexto = PanelTexto.getInstance();
    private JToolBar menuDeslizante;
    private JButton b, i, u, red, green, blue, alinLeft, alinCenter, alinRight, save, load;

    private static PanelDeslizante panelDeslizante;
}
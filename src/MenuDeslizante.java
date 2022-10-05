import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Clase que hereda de JToolbar, esta clase es algo diferente a las demas ya que no es un panel al uso si no un menu que
 * podremos mover por la pantalla o del PC o por el Frame de la aplicación, contiene las acciones de estilo,
 * alineacion de texto, clor de la fuente, y guardado del texto en un fichero y carga de ficheros de texto.
 * Por defecto se guardan y cargan dentro de la carpeta src del proyecto, ya que es una prueba, pero cuando te piden el
 * nombre y extension del fichero al guardar o cargar deberia funcionar si ponemos la ruta deseada para el fichero.
 */
public class MenuDeslizante extends JToolBar{
    /**
     * metodo constructor que usaremos con el metodo getInstance()
     * @param cons: se lo otroga el metodo getInstance() automaticamente. corresponderia a la disposicion del JToolBar
     */
    private MenuDeslizante(int cons) {
        super(cons);


        b = new JButton("b", new ImageIcon("B.png"));
        add(b);

        i = new JButton("i", new ImageIcon("I.png"));
        add(i);

        u = new JButton("u", new ImageIcon("U.png"));
        add(u);

        addSeparator();

        red = new JButton("red", new ImageIcon("red.png"));
        add(red);

        green = new JButton("green", new ImageIcon("green.png"));
        add(green);

        blue = new JButton("blue", new ImageIcon("blue.png"));
        add(blue);

        addSeparator();

        alinLeft = new JButton("alinleft", new ImageIcon("Izq.png"));
        add(alinLeft);

        alinCenter = new JButton("alincenter", new ImageIcon("Center.png"));
        add(alinCenter);

        alinRight = new JButton("alinright", new ImageIcon("Drch.png"));
        add(alinRight);

        addSeparator();

        save = new JButton("save", new ImageIcon("save.png"));
        add(save);

        load = new JButton("load", new ImageIcon("load.png"));
        add(load);


        this.setListener();
    }

    /**
     * Funcion necesaria para el patron Singleton, instancia el objeto menuDeslizante de esta misma clase o devuelve
     * la instancia creada anteriormente.
     * @return MenuDeslizante
     */
    public static MenuDeslizante getInstance(){
        return menuDeslizante==null? menuDeslizante = new MenuDeslizante(JToolBar.VERTICAL):menuDeslizante;
    }

    /**
     * Procedimiento que se encarga de añadir los actionLstener a los oyentes y asi gestionar los eventos, ademas contine
     * encapsulado el procedimiento setFileListener().
     * @see MenuDeslizante setFileListener()
     */
    private void setListener() {
        AbstractButton[] items = {b, i, u, red, green, blue, alinLeft, alinCenter, alinRight};


        for (AbstractButton item : items) {

            switch (item.getText()){
                case "i":
                    item.addActionListener(new StyledEditorKit.ItalicAction());
                    break;
                case "b":
                    item.addActionListener(new StyledEditorKit.BoldAction());
                    break;
                case "u":
                    item.addActionListener(new StyledEditorKit.UnderlineAction());
                    break;
                case "red":
                    item.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));
                    break;
                case "green":
                    item.addActionListener(new StyledEditorKit.ForegroundAction("verde", Color.GREEN));
                    break;
                case "blue":
                    item.addActionListener(new StyledEditorKit.ForegroundAction("blue", Color.BLUE));
                    break;
                case "alinleft":
                    item.addActionListener(new StyledEditorKit.AlignmentAction("izq", 0));
                    break;
                case "alincenter":
                    item.addActionListener(new StyledEditorKit.AlignmentAction("izq", 4));
                    break;
                case "alinright":
                    item.addActionListener(new StyledEditorKit.AlignmentAction("drch", 2));
                    break;

            }

        }

        setFileListener();

        /*borro los text de los botones para que no se reflejen en la interfaz grafica,les puse text porque me convenia
        * paradesarrollar el codigo de este metodo*/

        JButton[]quitText={b, i, u, red, green, blue , alinLeft, alinCenter, alinRight, save, load};
        for(JButton boton:quitText) boton.setText("");

    }

    /**
     * Procedimiento que coloca las acciones de guardar y cargar archivos a los oyentes(botones save y load).se encuentra
     * anidado dentro de setListener() de esta clase.
     * @see MenuDeslizante setListener()
     */
    private void setFileListener(){
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
    private static MenuDeslizante menuDeslizante;
    private JButton b, i, u, red, green, blue, alinLeft, alinCenter, alinRight, save, load;

}
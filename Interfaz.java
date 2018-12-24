import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class Interfaz{
    private JFrame marco;
    private Menu menu;
    private JButton encriptar, desencriptar;
    private Checkbox cesar, vigenere;
    private CheckboxGroup acciones;
    private JPanel panelTextos, panelAcciones, panelBotones;
    private JScrollPane scrollMensaje, scrollMensajeModificado;
    private JTextArea mensaje, mensajeModificado;
    
    public Interfaz(Controlador elControlador, String[][] elMenu){
        //creacion de objetos
        menu = new Menu(elControlador, elMenu);
        marco = new JFrame("Encriptador");
        acciones = new CheckboxGroup();
        cesar = new Checkbox("Cesar", acciones, true);
        vigenere = new Checkbox("Vigenere", acciones, false);
        encriptar = new JButton("Encriptar");
        desencriptar = new JButton("Desencriptar");
        panelTextos = new JPanel();
        panelAcciones = new JPanel();
        panelBotones = new JPanel();
        mensaje = new JTextArea(10, 15);
        mensajeModificado = new JTextArea(10, 15);
        scrollMensaje = new JScrollPane(mensaje);
        scrollMensajeModificado = new JScrollPane(mensajeModificado);
        //configuracion de objetos
        marco.setLocationRelativeTo(null);
        mensaje.setLineWrap(true);
        mensajeModificado.setLineWrap(true);
        marco.setLayout(new BorderLayout());
        encriptar.setActionCommand("Encriptar");
        desencriptar.setActionCommand("Desencriptar");
        //agregacion de objetos
        panelTextos.add(scrollMensaje);
        panelTextos.add(new JLabel("==>"));
        panelTextos.add(scrollMensajeModificado);
        panelAcciones.add(new JLabel("Eliga el metodo"));
        panelAcciones.add(cesar);
        panelAcciones.add(vigenere);
        panelBotones.add(encriptar);
        panelBotones.add(desencriptar);
        marco.add(panelTextos, BorderLayout.CENTER);
        marco.add(panelAcciones, BorderLayout.NORTH);
        marco.add(panelBotones, BorderLayout.SOUTH);
        marco.setJMenuBar(menu);
        marco.pack();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        marco.setVisible(true);
    }
    
    public void setEscuchadorBotones(Criptografo elCriptografo){
        encriptar.addActionListener(elCriptografo);
        desencriptar.addActionListener(elCriptografo);
    }
    
    public void limpiar(){
        mensaje.setText("");
        mensajeModificado.setText("");
    }
    
    public String getMensaje(){
        return mensaje.getText();
    }
    
    public void setMensajeModificado(String elMensaje){
        mensajeModificado.setText(elMensaje);
    }
    
    public boolean getEstadoCesar(){
        return cesar.getState();
    }
}
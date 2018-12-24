import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class Controlador implements ActionListener{
    private String[][] menu = {{"Archivo", "Limpiar", "Salir"}, {"Edicion", "Configurar Cesar", "Configurar Vigenere", "Valores por defecto"}, {"Ayuda", "Metodos", "Como usar", "Acerca de"}};
    private Criptografo criptografo;
    private Mensajes mensajes;
    private Interfaz interfaz;
    
    public Controlador(){
        mensajes = new Mensajes();
        interfaz = new Interfaz(this, menu);
        criptografo = new Criptografo(mensajes, interfaz);
        interfaz.setEscuchadorBotones(criptografo);
    }
    
    public static void main(String[] arg){
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
    
    public void iniciar(){
        interfaz.mostrar();
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equals("Limpiar")){
            interfaz.limpiar();
        }else{
            if(evento.getActionCommand().equals("Salir")){
                System.exit(0);
            }else{
                if(evento.getActionCommand().equals("Configurar Cesar")){
                    criptografo.configurarCesar();
                }else{
                    if(evento.getActionCommand().equals("Configurar Vigenere")){
                        criptografo.configurarVigenere();
                    }else{
                        if(evento.getActionCommand().equals("Como usar")){
                            String manual = "Para encriptar/desencriptar un mensaje:\n\n"
                                            + "1. Escoger un metodo de encriptado/desencriptado.\n"
                                            + "2. Escribir un mensaje en el campo de la izquierda.\n"
                                            + "3. Procesar con los botones Encriptar o Desencriptar.\n"
                                            + "4. Borrado automatico de los campos: Archivo>Limpiar.\n"
                                            + "5. Configuracion Cesar: Edicion>Configurar Cesar.\n"
                                            + "6. Configuracion Vigenere: Edicion>Configurar Vigenere.\n"
                                            + "7. Configurar por defecto: Edicion>Valores por defecto.\n"
                                            + "8. Para copiar/pegar el contenido, usar Ctrl+C/Ctrl+V.\n\n"
                                            + "*Para mas detalles de los metodos: Ayuda>Metodos.";
                            mensajes.decirHilera(manual, "Como usar");
                        }else{
                            if(evento.getActionCommand().equals("Valores por defecto")){
                                criptografo.setDefault();
                            }else{
                                if(evento.getActionCommand().equals("Acerca de")){
                                    mensajes.decirHilera("Encriptador v1.0\npor Fabio Flores\nefabiofm@hotmail.com", "Acerca de");
                                }else{
                                    if(evento.getActionCommand().equals("Metodos")){
                                        String explicacion = "Encriptacion mediante Cesar:\n\n"
                                                        + "    Reemplaza cada letra del mensaje por otra ubicada cierto numero de lugares\n"
                                                        + "    adelante en la tabla de codigo ASCII (3 por defecto) e inserta cierto numero \n" 
                                                        + "    de caracteres basura (1 por defecto) entre cada letra del mensaje original.\n\n"
                                                        + "Encriptacion mediante Vigenere:\n\n"
                                                        + "    Se utiliza una clave ('Nemesis' por defecto) que se suma letra por letra\n" 
                                                        + "    al mensaje. Para conocer como configurar los metodos: Ayuda>Como usar.\n";
                                        mensajes.decirHilera(explicacion, "Metodos");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
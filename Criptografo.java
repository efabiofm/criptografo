import java.util.Random;
import java.awt.event.*;
import java.awt.Checkbox;
class Criptografo implements ActionListener{
    private Mensajes mensajes;
    private Interfaz interfaz;
    private String clave;
    private Random random;
    private int desplazamientos;
    private int fantasmas;
    
    public Criptografo(Mensajes losMensajes, Interfaz laInterfaz){
        interfaz = laInterfaz;
        random = new Random();
        mensajes = losMensajes;
        clave = "Nemesis";
        desplazamientos = 3;
        fantasmas = 1;
    }
    
    public void actionPerformed(ActionEvent e){
        boolean metodo = interfaz.getEstadoCesar();
        String msj = interfaz.getMensaje();
        if(msj.equals("")){
            mensajes.decirHilera("Escriba primero un mensaje", "No hay mensaje");
        }else{
            if(e.getActionCommand().equals("Encriptar")){
                if(metodo){
                    interfaz.setMensajeModificado(this.encriptarCesar(msj));
                }else{
                    interfaz.setMensajeModificado(this.encriptarVigenere(msj));
                }
            }else{
                if(e.getActionCommand().equals("Desencriptar")){
                    if(metodo){
                        interfaz.setMensajeModificado(this.desencriptarCesar(msj));
                    }else{
                        interfaz.setMensajeModificado(this.desencriptarVigenere(msj));
                    }
                }
            }
        }
    }
    
    public void configurarCesar(){
        desplazamientos = mensajes.pedirEnteroEnRango("¿Numero de lugares a desplazar?\nConfiguracion actual: "+desplazamientos+ "\nNota: 1 minimo, 4 maximo", "Configuracion Cesar", 1, 4);
        fantasmas = mensajes.pedirEnteroEnRango("¿Numero de caracteres basura?\nConfiguracion actual: "+fantasmas+ "\nNota: 1 minimo, 3 maximo", "Configuracion Cesar", 1, 3);
    }
    
    public void configurarVigenere(){
        clave = mensajes.pedirHilera("Escriba una clave\nClave actual: "+clave, "Configuracion Vigenere");
        while(clave.equals("")){
            clave = mensajes.pedirHilera("Debe escribir una clave", "Configuracion Vigenere");
        }
    }
    
    public String encriptarCesar(String msj){
        int numeroAleatorio;
        char letra;
        char fantasma;
        String msjEncriptado = "";
        
        for(int i=0; i < msj.length(); i++){
            letra = msj.charAt(i);
            letra = (char)(letra+desplazamientos);
            msjEncriptado = msjEncriptado+letra;
            
            for(int j=0; j < fantasmas; j++){
                numeroAleatorio = random.nextInt(100)+1;
                fantasma = (char)(numeroAleatorio);
                msjEncriptado = msjEncriptado+fantasma;
            }
        }
        return msjEncriptado;
    }
    
    public String encriptarVigenere(String msj){
        char letraMsj;
        char letraClave;
        char letraModificada;
        String msjEncriptado = "";
        
        for(int i = 0, j = 0; i < msj.length(); i++, j++){
            letraMsj = msj.charAt(i);
            if(j == clave.length()){
                j = 0;
            }
            letraClave = clave.charAt(j);
            letraModificada = (char)(letraMsj+letraClave);
            msjEncriptado = msjEncriptado+letraModificada;
        }
        return msjEncriptado;
    }
    
    public String desencriptarCesar(String msj){
        int numeroAleatorio;
        char letra;
        char fantasma;
        String msjDesencriptado = "";
        
        for(int i = 0; i < msj.length(); i=i+fantasmas+1){
            letra = msj.charAt(i);
            letra = (char)(letra-desplazamientos);
            msjDesencriptado = msjDesencriptado+letra;
        }
        return msjDesencriptado;
    }
    
    public String desencriptarVigenere(String msj){
        char letraMsj;
        char letraClave;
        char letraModificada;
        String msjEncriptado = "";
        
        for(int i = 0, j = 0; i < msj.length(); i++, j++){
            letraMsj = msj.charAt(i);
            if(j == clave.length()){
                j = 0;
            }
            letraClave = clave.charAt(j);
            letraModificada = (char)(letraMsj-letraClave);
            msjEncriptado = msjEncriptado+letraModificada;
        }
        return msjEncriptado;
    }
    
    public void setDefault(){
        clave = "Nemesis";
        desplazamientos = 3;
        fantasmas = 1;
        mensajes.decirHilera("Se han reestablecido los valores por defecto", "Valores por defecto");
    }
}
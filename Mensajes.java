import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * Describe a una interfaz que permite:
 * - la entrada y salida de hileras de caracteres
 * - la entrada de enteros verificando entradas v�lidas
 * - la entrada de enteros positivos verificando entradas v�lidas
 * - la entrada de enteros en un rango verificando entradas v�lidas
 * - la selecci�n de "s�" o "no" a una pregunta
 * - la selecci�n de una opci�n de las mostradas en botones
 * - la selecci�n de una opci�n de una lista
 * Las ventanas tienen t�tulos.
 * @author Lara+Murillo
 * @version 4.0 (3 setiembre 2009)
 */
class Mensajes extends JOptionPane{
      private final String MENSAJE_ERROR_NUMERICO = "Debe digitar un n�mero entero.";
      private final String MENSAJE_ERROR_POSITIVO = "Debe digitar un n�mero entero positivo.";
      private final String MENSAJE_ERROR_EN_RANGO = "Debe digitar un n�mero entero entre los siguientes valores: ";
      private final String MENSAJE_OTRO_INTENTO = "Vuelva a intentarlo.";
      private final String TITULO_ERROR = "Error";
  
    /**
     * No realiza ninguna inicializaci�n
     */
    public Mensajes(){}

    /**
     * Despliega en una ventana una hilera de caracteres
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     */
    public void decirHilera(String hileraMensaje, String hileraTitulo){
        this.showMessageDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE);
    }
    
    /**
     * Solicita al usuario una hilera de caracteres
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     * @return Devuelve un objeto de tipo String con el texto digitado por el usuario
     */
    public String pedirHilera(String hileraMensaje, String hileraTitulo){
        String resultado;
        resultado = this.showInputDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE);
        return resultado;
    }
    
    /**
     * Solicita al usuario un n�mero entero
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     * @return Devuelve el n�mero entero digitado por el usuario
     */
    public int pedirEntero(String hileraMensaje, String hileraTitulo) {
        String mensajeError = MENSAJE_ERROR_NUMERICO + "\n" + MENSAJE_OTRO_INTENTO;
        String hilera;
        int resultado = 0;
        boolean respuestaCorrecta = false;

        while (!respuestaCorrecta) {
            hilera = this.showInputDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE);
            try {
                resultado = Integer.parseInt(hilera);
                respuestaCorrecta = true;
            } catch (Exception error) {
                respuestaCorrecta = false;
                this.decirHilera(mensajeError, TITULO_ERROR);
            }
        }
        
        return resultado;
    }
    
    /**
     * Solicita al usuario un n�mero entero positivo o cero
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     * @return Devuelve el n�mero entero digitado por el usuario
     */
    public int pedirEnteroPositivo(String hileraMensaje, String hileraTitulo) {
        String mensajeError = MENSAJE_ERROR_POSITIVO + "\n" + MENSAJE_OTRO_INTENTO;
        String hilera;
        int resultado = 0;
        boolean respuestaCorrecta = false;

        while (!respuestaCorrecta) {
            hilera = this.showInputDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE);
            try {
                resultado = Integer.parseInt(hilera);
                respuestaCorrecta = (resultado >= 0);
            } catch (Exception error) {
                respuestaCorrecta = false;
            }
            if (!respuestaCorrecta) {
                this.decirHilera(mensajeError, TITULO_ERROR);
            }
        }
        
        return resultado;
    }
    
    /**
     * Solicita al usuario un n�mero entero en un rango dado
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     * @param valorMinimo valor m�nimo que puede ingresar el usuario
     * @param valorMaximo valor m�ximo que puede ingresar el usuario
     * @return Devuelve el n�mero entero digitado por el usuario
     */
    public int pedirEnteroEnRango(String hileraMensaje, String hileraTitulo, int valorMinimo, int valorMaximo) {
        String mensajeError = MENSAJE_ERROR_EN_RANGO + valorMinimo + " y " + valorMaximo + ".\n" + MENSAJE_OTRO_INTENTO;
        String hilera;
        int resultado = 0;
        boolean respuestaCorrecta = false;

        while (!respuestaCorrecta) {
            hilera = this.showInputDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE);
            try {
                resultado = Integer.parseInt(hilera);
                respuestaCorrecta = ((resultado >= valorMinimo) && (resultado <= valorMaximo));
            } catch (Exception error) {
                respuestaCorrecta = false;
            }
            if (!respuestaCorrecta) {
                this.decirHilera(mensajeError, TITULO_ERROR);
            }
        }
        
        return resultado;
    }
    
    /**
     * Solicita al usuario una respuesta de "s�" o "no"
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     * @return 0 si el usuario escoge "s�" y 1 si escoge "no"
     */
    public int pedirSiNo(String hileraMensaje, String hileraTitulo) {
        int resultado;
        resultado = this.showConfirmDialog(null, hileraMensaje, hileraTitulo, YES_NO_OPTION);
        return resultado;
    }
    
   /**
     * Solicita al usuario escoger una opci�n de las mostradas en botones
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     * @param listaHilerasOpciones Lista de hileras de texto con las opciones
     * @param hileraInicial Nombre de la opci�n que por defecto aparece seleccionada
     * @return un entero entre 0 y el n�mero de opciones menos 1
     */
    public int pedirOpcionBotones(String hileraMensaje, String hileraTitulo, String[] listaHilerasOpciones, String hileraInicial) {
        int resultado;
        resultado = this.showOptionDialog(null, hileraMensaje, hileraTitulo, DEFAULT_OPTION, PLAIN_MESSAGE,new ImageIcon(),listaHilerasOpciones, hileraInicial);
        return resultado;
    }    

    /**
     * Solicita al usuario escoger una opci�n de una lista dada
     * @param hileraMensaje Texto que se desplegar� en la ventana
     * @param hileraTitulo T�tulo de la ventana
     * @param listaHilerasOpciones Lista de hileras de texto con las opciones
     * @param hileraInicial Nombre de la opci�n que por defecto aparece seleccionada
     * @return La hilera correspondiente a la opci�n escogida
     */
    public String pedirOpcionLista(String hileraMensaje, String hileraTitulo, String[] listaHilerasOpciones, String hileraInicial) {
        String resultado;
        Object objeto = this.showInputDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE, new ImageIcon(), listaHilerasOpciones, hileraInicial);
        resultado = (String) objeto;
        return resultado;
    }    
}

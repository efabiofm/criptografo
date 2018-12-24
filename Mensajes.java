import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * Describe a una interfaz que permite:
 * - la entrada y salida de hileras de caracteres
 * - la entrada de enteros verificando entradas válidas
 * - la entrada de enteros positivos verificando entradas válidas
 * - la entrada de enteros en un rango verificando entradas válidas
 * - la selección de "sí" o "no" a una pregunta
 * - la selección de una opción de las mostradas en botones
 * - la selección de una opción de una lista
 * Las ventanas tienen títulos.
 * @author Lara+Murillo
 * @version 4.0 (3 setiembre 2009)
 */
class Mensajes extends JOptionPane{
      private final String MENSAJE_ERROR_NUMERICO = "Debe digitar un número entero.";
      private final String MENSAJE_ERROR_POSITIVO = "Debe digitar un número entero positivo.";
      private final String MENSAJE_ERROR_EN_RANGO = "Debe digitar un número entero entre los siguientes valores: ";
      private final String MENSAJE_OTRO_INTENTO = "Vuelva a intentarlo.";
      private final String TITULO_ERROR = "Error";
  
    /**
     * No realiza ninguna inicialización
     */
    public Mensajes(){}

    /**
     * Despliega en una ventana una hilera de caracteres
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     */
    public void decirHilera(String hileraMensaje, String hileraTitulo){
        this.showMessageDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE);
    }
    
    /**
     * Solicita al usuario una hilera de caracteres
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     * @return Devuelve un objeto de tipo String con el texto digitado por el usuario
     */
    public String pedirHilera(String hileraMensaje, String hileraTitulo){
        String resultado;
        resultado = this.showInputDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE);
        return resultado;
    }
    
    /**
     * Solicita al usuario un número entero
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     * @return Devuelve el número entero digitado por el usuario
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
     * Solicita al usuario un número entero positivo o cero
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     * @return Devuelve el número entero digitado por el usuario
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
     * Solicita al usuario un número entero en un rango dado
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     * @param valorMinimo valor mínimo que puede ingresar el usuario
     * @param valorMaximo valor máximo que puede ingresar el usuario
     * @return Devuelve el número entero digitado por el usuario
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
     * Solicita al usuario una respuesta de "sí" o "no"
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     * @return 0 si el usuario escoge "sí" y 1 si escoge "no"
     */
    public int pedirSiNo(String hileraMensaje, String hileraTitulo) {
        int resultado;
        resultado = this.showConfirmDialog(null, hileraMensaje, hileraTitulo, YES_NO_OPTION);
        return resultado;
    }
    
   /**
     * Solicita al usuario escoger una opción de las mostradas en botones
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     * @param listaHilerasOpciones Lista de hileras de texto con las opciones
     * @param hileraInicial Nombre de la opción que por defecto aparece seleccionada
     * @return un entero entre 0 y el número de opciones menos 1
     */
    public int pedirOpcionBotones(String hileraMensaje, String hileraTitulo, String[] listaHilerasOpciones, String hileraInicial) {
        int resultado;
        resultado = this.showOptionDialog(null, hileraMensaje, hileraTitulo, DEFAULT_OPTION, PLAIN_MESSAGE,new ImageIcon(),listaHilerasOpciones, hileraInicial);
        return resultado;
    }    

    /**
     * Solicita al usuario escoger una opción de una lista dada
     * @param hileraMensaje Texto que se desplegará en la ventana
     * @param hileraTitulo Título de la ventana
     * @param listaHilerasOpciones Lista de hileras de texto con las opciones
     * @param hileraInicial Nombre de la opción que por defecto aparece seleccionada
     * @return La hilera correspondiente a la opción escogida
     */
    public String pedirOpcionLista(String hileraMensaje, String hileraTitulo, String[] listaHilerasOpciones, String hileraInicial) {
        String resultado;
        Object objeto = this.showInputDialog(null, hileraMensaje, hileraTitulo, PLAIN_MESSAGE, new ImageIcon(), listaHilerasOpciones, hileraInicial);
        resultado = (String) objeto;
        return resultado;
    }    
}

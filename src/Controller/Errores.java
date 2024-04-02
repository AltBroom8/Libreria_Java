package Controller;

public class Errores extends Exception {


    public static final int TITULO_VACIO = 1;
    public static final int AUTOR_VACIO = 2;
    public static final int GENERO_VACIO = 3;

    public static final int PRECIO_VACIO = 4;
    public static final int ANIO_VACIO = 5;
    public Errores(int number) {
        super(getErrorMessage(number));
    }

    public static String getErrorMessage(int errorCode) {
        String errorMessage = "Error: ";
        switch (errorCode) {
            case TITULO_VACIO:  errorMessage += "El titulo esta vacío";
            break;
            case AUTOR_VACIO: errorMessage += "Introduzca el autor";
            break;
            case GENERO_VACIO: errorMessage += "Introduzca el genero";
            break;
            case PRECIO_VACIO: errorMessage += "Introduzca el precio";
            break;
            case ANIO_VACIO: errorMessage+= "Introduzca el año";
            break;
            default:
                errorMessage += "DESCONOCIDO";
        }
        return errorMessage;
    }
}

package Model;

import java.util.Date;

public class Venta {
    int id;

    int libroID;
    int usuarioID;
    Date fechaVenta;
    String tipo_transaccion;

    public Venta(int id, Date fechaVenta,  int libroID, int usuarioID,String tipo_transaccion) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.libroID = libroID;
        this.usuarioID = usuarioID;
        this.tipo_transaccion=tipo_transaccion;
    }
}

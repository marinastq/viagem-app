package br.com.marinas.reserva;


public class Reserva {
    private long id;
    private long idCliente;

    private Reserva(long id, long idCliente) {
        this.id = id;
        this.idCliente = idCliente;
    }

    private Reserva(long idCliente) {
        this.idCliente = idCliente;
    }

    public static Reserva of(long id, long idCliente) {
        return new Reserva(id, idCliente);
    }

    public static Reserva of(long idCliente) {
        return new Reserva(idCliente);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

   
}

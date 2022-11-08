package edu.eci.arep.arepmicroservicios.model;


public class Tweet {
    private String mensaje;
    private String fecha;

    private String username;

    public Tweet(String mensaje, String fecha, String username) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.username = username;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

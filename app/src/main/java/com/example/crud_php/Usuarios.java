package com.example.crud_php;

public class Usuarios {
    //String id,nombre,correo,direccion;
    String IdEvento,Nombre_Evento,Lugar,Fecha,Hora,IdAdmin;

    public Usuarios() {
    }

    public Usuarios(String IdEvento, String Nombre_Evento, String Lugar, String Fecha,String Hora,String IdAdmin) {
        this.IdEvento = IdEvento;
        this.Nombre_Evento = Nombre_Evento;
        this.Lugar = Lugar;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.IdAdmin = IdAdmin;
    }

    public String getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(String IdEvento) {
        this.IdEvento = IdEvento;
    }

    public String getNombre_Evento() {
        return Nombre_Evento;
    }

    public void setNombre_Evento(String Nombre_Evento) {
        this.Nombre_Evento = Nombre_Evento;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {this.Fecha = Fecha;}

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {this.Hora = Hora;}

    public String getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(String IdAdmin) {this.IdAdmin = IdAdmin;}
}

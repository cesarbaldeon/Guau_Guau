package pe.edu.cibertec.guauguau.data.entities;

import com.google.gson.annotations.SerializedName;

public class Mascotas {

    @SerializedName("id_mascota")
    private int id_mascota;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("especie")
    private String especie;
    @SerializedName("raza")
    private String raza;
    @SerializedName("caracter")
    private String caracter;
    @SerializedName("fecha_nac")
    private String fecha_nac;
    @SerializedName("usuarios")
    private Usuario objUsuarios;


    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public Usuario getObjUsuarios() {
        return objUsuarios;
    }

    public void setObjUsuarios(Usuario objUsuarios) {
        this.objUsuarios = objUsuarios;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
}

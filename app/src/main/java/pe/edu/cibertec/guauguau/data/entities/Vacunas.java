package pe.edu.cibertec.guauguau.data.entities;

import com.google.gson.annotations.SerializedName;

public class Vacunas {

    private String id_vacuna;
    private String nom_vacuna;
    private String fecha_vacuna;
    @SerializedName("mascotas")
    private Mascotas objMascota;

    private String detalle_vacuna;

    public Vacunas() {
        objMascota= new Mascotas();
    }

    public String getId_vacuna() {
        return id_vacuna;
    }

    public void setId_vacuna(String id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

    public String getNom_vacuna() {
        return nom_vacuna;
    }

    public void setNom_vacuna(String nom_vacuna) {
        this.nom_vacuna = nom_vacuna;
    }

    public String getFecha_vacuna() {
        return fecha_vacuna;
    }

    public void setFecha_vacuna(String fecha_vacuna) {
        this.fecha_vacuna = fecha_vacuna;
    }

    public Mascotas getObjMascota() {
        return objMascota;
    }

    public void setObjMascota(Mascotas objMascota) {
        this.objMascota = objMascota;
    }

    public String getDetalle_vacuna() {
        return detalle_vacuna;
    }

    public void setDetalle_vacuna(String detalle_vacuna) {
        this.detalle_vacuna = detalle_vacuna;
    }
}

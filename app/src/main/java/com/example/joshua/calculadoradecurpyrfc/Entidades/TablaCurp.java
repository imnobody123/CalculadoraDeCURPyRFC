package com.example.joshua.calculadoradecurpyrfc.Entidades;

public class TablaCurp {

    private Integer idNombre;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String FechaNacimiento;
    private String Sexo;
    private String Entidad;
    private String Curp;
    private String Rfc;

    public TablaCurp(Integer idNombre, String nombre, String apellido1, String apellido2, String fechaNacimiento, String sexo, String entidad, String curp, String rfc) {
        this.idNombre = idNombre;
        Nombre = nombre;
        Apellido1 = apellido1;
        Apellido2 = apellido2;
        FechaNacimiento = fechaNacimiento;
        Sexo = sexo;
        Entidad = entidad;
        Curp = curp;
        Rfc = rfc;
    }

    public TablaCurp(){

    }

    public Integer getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(Integer idNombre) {
        this.idNombre = idNombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getEntidad() {
        return Entidad;
    }

    public void setEntidad(String entidad) {
        Entidad = entidad;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String curp) {
        Curp = curp;
    }

    public String getRfc() {
        return Rfc;
    }

    public void setRfc(String rfc) {
        Rfc = rfc;
    }
}

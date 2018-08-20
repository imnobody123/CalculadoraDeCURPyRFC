package com.example.joshua.calculadoradecurpyrfc;

import android.content.Context;

public class clsFuncionesDeMenu {

    public String guardarCURP(Context ctx, String Nombre, String apellidop, String apellidom, String fechan, String sexo, String entidad, String Curp, String Rfc){
        String Mensaje = "";
        ConsultasSQLite consulta = new ConsultasSQLite();
        extraerDatosBD extraccionDatos = new extraerDatosBD();
        extraccionDatos.inicializarVaraiubles(ctx);
        extraccionDatos.consultarInformacionCurp();

        int j = extraccionDatos.listaTablaCurp.size();
            if(j == 0){
                consulta.InsertarCURP(ctx, Nombre, apellidop, apellidom, fechan, sexo, entidad, Curp, Rfc);
                Mensaje = "Datos Guardados Correctamente";
            }else{
                for (int i = 0; i < j; i++) {
                    String curpObtenido = extraccionDatos.listaTablaCurp.get(i).getCurp();
                    if (Curp.equals(curpObtenido)) {
                        consulta.actualizarCurp(ctx, Nombre, apellidop, apellidom, fechan, sexo, entidad, Curp, Rfc);
                        Mensaje = "Datos Actualizados Correctamente";
                    }else if(i == j-1){
                        consulta.InsertarCURP(ctx, Nombre, apellidop, apellidom, fechan, sexo, entidad, Curp, Rfc);
                        Mensaje = "Datos Guardados Correctamente";
                    }
                }
            }
            return Mensaje;
    }
}

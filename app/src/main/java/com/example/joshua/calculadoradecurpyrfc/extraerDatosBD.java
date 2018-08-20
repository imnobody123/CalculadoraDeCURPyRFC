package com.example.joshua.calculadoradecurpyrfc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.joshua.calculadoradecurpyrfc.Entidades.TablaCurp;

import java.util.ArrayList;

public class extraerDatosBD {

    clsConexionBDCurp conexion;
    ArrayList<String> listaInfo;
    ArrayList<TablaCurp> listaTablaCurp;

    public void inicializarVaraiubles(Context context){
        conexion = new clsConexionBDCurp(context, "BD__CALCULADORA_CURP_RFC");
    }

    public void consultarInformacionCurp(){
        SQLiteDatabase bd = conexion.getReadableDatabase();
        TablaCurp tablaCurp = null;
        listaTablaCurp = new ArrayList<TablaCurp>();

        Cursor cursor = bd.rawQuery("SELECT * FROM curp", null);
        while(cursor.moveToNext()){
            tablaCurp = new TablaCurp();
            tablaCurp.setIdNombre(cursor.getInt(0));
            tablaCurp.setNombre(cursor.getString(1));
            tablaCurp.setApellido1(cursor.getString(2));
            tablaCurp.setApellido2(cursor.getString(3));
            tablaCurp.setFechaNacimiento(cursor.getString(4));
            tablaCurp.setSexo(cursor.getString(5));
            tablaCurp.setEntidad(cursor.getString(6));
            tablaCurp.setCurp(cursor.getString(7));
            tablaCurp.setRfc(cursor.getString(8));

            listaTablaCurp.add(tablaCurp);
        }
        obtenerLIstaCurp();
    }

    public void obtenerLIstaCurp(){
        listaInfo = new ArrayList<String>();
        for(int i = 0; i < listaTablaCurp.size(); i++){
            listaInfo.add(listaTablaCurp.get(i).getIdNombre() + "\t\t"
                    + listaTablaCurp.get(i).getNombre() + " "
                    + listaTablaCurp.get(i).getApellido1() + " "
                    + listaTablaCurp.get(i).getApellido2() + "\n"
                    + "\t\t" + listaTablaCurp.get(i).getFechaNacimiento() + "\n"
                    + "\t\t" + listaTablaCurp.get(i).getSexo() + "\n"
                    + "\t\t" + listaTablaCurp.get(i).getEntidad() + "\n"
                    + "\t\t" + listaTablaCurp.get(i).getCurp() + "\n"
                    + "\t\t" + listaTablaCurp.get(i).getRfc());
        }
    }
}

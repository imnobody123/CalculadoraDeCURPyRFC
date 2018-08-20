package com.example.joshua.calculadoradecurpyrfc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ConsultasSQLite {

    public void InsertarCURP(Context context, String nombre, String apellidop, String apellidom, String fechan, String sexo, String entidad, String curp, String rfc){
        clsConexionBDCurp conexion = new clsConexionBDCurp(context, "BD__CALCULADORA_CURP_RFC");
        SQLiteDatabase BD = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("ApellidoP", apellidop);
        valores.put("ApellidoM", apellidom);
        valores.put("FechaN", fechan);
        valores.put("Sexo", sexo);
        valores.put("Entidad", entidad);
        valores.put("CURP", curp);
        valores.put("RFC", rfc);
        BD.insert("curp", null, valores);
        BD.close();
    }

    public void eliminarCurp(Context context, String []parametros){
        clsConexionBDCurp conexion = new clsConexionBDCurp(context, "BD__CALCULADORA_CURP_RFC");
        SQLiteDatabase BD = conexion.getWritableDatabase();

        SQLiteDatabase bd = conexion.getWritableDatabase();
        bd.delete("curp", "id_Nombre = ?", parametros);
        Toast.makeText(context, "Dato eliminado correctamente", Toast.LENGTH_LONG).show();
        bd.close();
    }

    public void actualizarCurp(Context context, String nombre, String apellidop, String apellidom, String fechan, String sexo, String entidad, String curp, String rfc){
        clsConexionBDCurp conexion = new clsConexionBDCurp(context, "BD__CALCULADORA_CURP_RFC");
        SQLiteDatabase BD = conexion.getWritableDatabase();

        String[] curp2 = {curp};
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("ApellidoP", apellidop);
        valores.put("ApellidoM", apellidom);
        valores.put("FechaN", fechan);
        valores.put("Sexo", sexo);
        valores.put("Entidad", entidad);
        valores.put("CURP", curp);
        valores.put("RFC", rfc);
        BD.update("curp", valores, "Curp = ?", curp2);
        BD.close();
    }
}

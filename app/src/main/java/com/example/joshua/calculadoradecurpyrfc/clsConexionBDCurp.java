package com.example.joshua.calculadoradecurpyrfc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class clsConexionBDCurp extends SQLiteOpenHelper {

    public clsConexionBDCurp(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE curp (id_Nombre INTEGER PRIMARY KEY, Nombre TEXT NOT NULL, ApellidoP TEXT NOT NULL,ApellidoM TEXT NOT NULL,FechaN TEXT NOT NULL,Sexo TEXT NOT NULL,Entidad TEXT NOT NULL,CURP TEXT NOT NULL, RFC TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS curp");
        onCreate(db);
    }
}

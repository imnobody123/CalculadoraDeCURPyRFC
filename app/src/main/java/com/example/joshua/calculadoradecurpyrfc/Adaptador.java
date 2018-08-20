package com.example.joshua.calculadoradecurpyrfc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adaptador extends BaseAdapter
{
    private static LayoutInflater layoutInflater = null;

    Context context;
    String datos[][];

    public Adaptador(Context context, String[][] datos)
    {
        this.context = context;
        this.datos = datos;
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        final View vista = layoutInflater.inflate(R.layout.listview_custom_item, null);
        TextView Nombre = (TextView) vista.findViewById(R.id.textoNombre);
        TextView Fecha = (TextView) vista.findViewById(R.id.textoFecha);
        TextView Sexo = (TextView) vista.findViewById(R.id.textoSexo);
        TextView Estado = (TextView) vista.findViewById(R.id.textoEstado);
        TextView Curp = (TextView) vista.findViewById(R.id.textoCurp);
        TextView Rfc = (TextView) vista.findViewById(R.id.textoRfc);
        Nombre.setText(datos[i][1] + " " + datos[i][2] + " " + datos[i][3]);
        Fecha.setText(datos[i][4]);
        Sexo.setText(datos[i][5]);
        Estado.setText(datos[i][6]);
        Curp.setText(datos[i][7]);
        Rfc.setText(datos[i][8]);

        return vista;
    }

    @Override
    public int getCount()
    {
        return datos.length;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }
}

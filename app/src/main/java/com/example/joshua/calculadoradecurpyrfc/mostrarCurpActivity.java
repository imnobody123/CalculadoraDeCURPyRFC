package com.example.joshua.calculadoradecurpyrfc;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


public class mostrarCurpActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener, AdapterView.OnItemClickListener {

    ListView list;
    extraerDatosBD extraccionDatos;
    String []valorIdNombre = new String[1];
    int posicionDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_curp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extraccionDatos = new extraerDatosBD();
        extraccionDatos.inicializarVaraiubles(this);
        extraccionDatos.consultarInformacionCurp();

        list = (ListView) findViewById(R.id.listView);

        String[][] matriz = new String[extraccionDatos.listaTablaCurp.size()][9];
        for (int x = 0; x < extraccionDatos.listaTablaCurp.size(); x++)
        {
            matriz[x][0] = String.valueOf(extraccionDatos.listaTablaCurp.get(x).getIdNombre());
            matriz[x][1] = extraccionDatos.listaTablaCurp.get(x).getNombre();
            matriz[x][2] = extraccionDatos.listaTablaCurp.get(x).getApellido1();
            matriz[x][3] = extraccionDatos.listaTablaCurp.get(x).getApellido2();
            matriz[x][4] = extraccionDatos.listaTablaCurp.get(x).getFechaNacimiento();
            matriz[x][5] = extraccionDatos.listaTablaCurp.get(x).getSexo();
            matriz[x][6] = extraccionDatos.listaTablaCurp.get(x).getEntidad();
            matriz[x][7] = extraccionDatos.listaTablaCurp.get(x).getCurp();
            matriz[x][8] = extraccionDatos.listaTablaCurp.get(x).getRfc();
        }
        for (int x = 0; x < extraccionDatos.listaTablaCurp.size(); x++)
        {
            for (int y = 0; y < 9; y++)
            {
                Log.d(mostrarCurpActivity.class.getName(), matriz[x][y]);
            }
        }
        list.setAdapter(new Adaptador(this, matriz));
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        posicionDatos = position;
        valorIdNombre[0] = String.valueOf(extraccionDatos.listaTablaCurp.get(position).getIdNombre());
        showPopup(view);
    }



    // En este método se genera un menu ShowPopup
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(getApplicationContext(), v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_emergente_activity_mostrar_curp);
        popup.show();
    }

    /* En este método se identifica la opción presionada
       para posteriormente ejecutar su respectiva acción
     */
    String Tag = mostrarCurpActivity.class.getName();
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mostrar:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Nombre", extraccionDatos.listaTablaCurp.get(posicionDatos).getNombre());
                intent.putExtra("ApeP", extraccionDatos.listaTablaCurp.get(posicionDatos).getApellido1());
                intent.putExtra("ApeM", extraccionDatos.listaTablaCurp.get(posicionDatos).getApellido2());
                intent.putExtra("FechaN", extraccionDatos.listaTablaCurp.get(posicionDatos).getFechaNacimiento());
                intent.putExtra("Sexo", extraccionDatos.listaTablaCurp.get(posicionDatos).getSexo());
                intent.putExtra("Entidad", extraccionDatos.listaTablaCurp.get(posicionDatos).getEntidad());
                intent.putExtra("Curp", extraccionDatos.listaTablaCurp.get(posicionDatos).getCurp());
                intent.putExtra("Rfc", extraccionDatos.listaTablaCurp.get(posicionDatos).getRfc());
                startActivity(intent);
                finish();
                break;
            case R.id.copiar_curp:
                ClipData clipCurp = ClipData.newPlainText("text", extraccionDatos.listaTablaCurp.get(posicionDatos).getCurp());
                ClipboardManager clipboardCurp = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                clipboardCurp.setPrimaryClip(clipCurp);
                Toast.makeText(getApplicationContext(), "Texto copiado al portapapeles", Toast.LENGTH_LONG).show();
                break;
            case R.id.copiar_rfc:
                ClipData cliprfc = ClipData.newPlainText("text", extraccionDatos.listaTablaCurp.get(posicionDatos).getRfc());
                ClipboardManager clipboardrfc = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                clipboardrfc.setPrimaryClip(cliprfc);
                Toast.makeText(getApplicationContext(), "Texto copiado al portapapeles", Toast.LENGTH_LONG).show();
                break;
            case R.id.eliminar:
                ConsultasSQLite consulta = new ConsultasSQLite();
                consulta.eliminarCurp(this, valorIdNombre);
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

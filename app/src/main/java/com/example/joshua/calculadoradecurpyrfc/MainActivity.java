package com.example.joshua.calculadoradecurpyrfc;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    RadioButton radioMasculino, radioFemenino;
    EditText txtNombres, txtApellidoP, txtApellidoM, txtFechaN;
    Button btnCalcular;
    TextView textCurp, textRfc;
    Spinner SpinEntidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        radioMasculino = (RadioButton) findViewById(R.id.radioBtnMasculino);
        radioFemenino = (RadioButton) findViewById(R.id.radioBtnFemenino);
        txtNombres = (EditText) findViewById(R.id.txtNombre);
        txtApellidoP = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoM = (EditText) findViewById(R.id.txtApellidoMaterno);
        txtFechaN = (EditText) findViewById(R.id.txtFechaNacimiento);
        btnCalcular = (Button) findViewById(R.id.btnCalcula);
        textCurp = (TextView) findViewById(R.id.textViewCURP);
        textRfc = (TextView) findViewById(R.id.textRFC);

        btnCalcular.setOnClickListener(this);
        txtFechaN.setOnClickListener(this);

        SpinEntidades = (Spinner) findViewById(R.id.spinnerEntidades);
        String[] entidad = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chihuahua",
                "Chiapas", "Ciudad de México", "Coahuila", "Colima", "Durango", "Guanajuato",
                "Guerrero", "Hidalgo", "Jalisco", "Estado de México",
                "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla",
                "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora",
                "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
        SpinEntidades.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidad));

        if (getIntent().getStringExtra("Nombre") != null)
        {
            txtNombres.setText("" + getIntent().getStringExtra("Nombre"));
            txtApellidoP.setText("" + getIntent().getStringExtra("ApeP"));
            txtApellidoM.setText("" + getIntent().getStringExtra("ApeM"));
            txtFechaN.setText("" + getIntent().getStringExtra("FechaN"));
            if (getIntent().getStringExtra("Sexo").equals("Masculino"))
            {
                radioMasculino.setChecked(true);
            }
            else if (getIntent().getStringExtra("Sexo").equals("Femenino"))
            {
                radioFemenino.setChecked(true);
            }
            int j = 0;
            for (int i = 0; i <= 32; i++)
            {
                if (SpinEntidades.getItemAtPosition(i).equals(getIntent().getStringExtra("Entidad")))
                {
                    j = i;
                    i = 32;
                }
            }
            SpinEntidades.setSelection(j);
            textCurp.setText("CURP: " + getIntent().getStringExtra("Curp"));
            textRfc.setText("RFC: " + getIntent().getStringExtra("Rfc"));
        }
    }

    @Override
    public void onClick(View v) {
        int dia, mes, ano;
        final Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        ano = c.get(Calendar.YEAR);
        if(v == txtFechaN)
        {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
            {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                {
                    String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
                    txtFechaN.setText(fecha);
                }
            }, dia, mes, ano);
            datePickerDialog.show();
        }

        if(v == btnCalcular)
        {
            try
            {
                textCurp.setText("CURP: " + CURP().toUpperCase());
                textRfc.setText("RFC: " + RFC().toUpperCase());
            }
            catch(Exception error)
            {
                Toast.makeText(this, "¡Error no se pueden calcular los datos verifique los campos!", Toast.LENGTH_LONG).show();
            }
        }
    }

    // En este método se arma el String Curp
    public String CURP(){
        //Aquí se crea la instancia de la clase que contine los algoritmos
        CalcularCurp_y_Rfc objCalcula = new CalcularCurp_y_Rfc();
        //Aquí se mandan los parametros a la clase calcularCurp para procesar los Strings
        String letrasApellidoP = objCalcula.letrasApellidoP(txtApellidoP.getText().toString());
        String letrasApellidoM = objCalcula.letrasApellidoM(txtApellidoM.getText().toString());
        String letrasNombre = objCalcula.letrasNombre(txtNombres.getText().toString());
        String digitosFechaN = objCalcula.digitosFechaN(txtFechaN.getText().toString());
        String letraSexo = objCalcula.letraSexo(String.valueOf(radioMasculino.isChecked()));
        String letrasEntidad = objCalcula.letrasEntidad(SpinEntidades.getSelectedItem().toString());
        String consonantesApeP = objCalcula.consonantesApeP(txtApellidoP.getText().toString());
        String consonantesApeM = objCalcula.consonantesApeM(txtApellidoM.getText().toString());
        String consonantesNombre = objCalcula.consonantesNombre(txtNombres.getText().toString());
        String CurpSinHomoclave = letrasApellidoP + letrasApellidoM + letrasNombre + digitosFechaN + letraSexo + letrasEntidad + consonantesApeP + consonantesApeM + consonantesNombre;
        String Homoclave = objCalcula.HomoClave(txtFechaN.getText().toString(), CurpSinHomoclave);
        String CurpConHomoclave = letrasApellidoP + letrasApellidoM + letrasNombre + digitosFechaN + letraSexo + letrasEntidad + consonantesApeP + consonantesApeM + consonantesNombre + Homoclave;
        return CurpConHomoclave;
    }

    public String RFC(){
        //Aquí se crea la instancia de la clase que contine los algoritmos
        CalcularCurp_y_Rfc objCalcula = new CalcularCurp_y_Rfc();
        //Aquí se mandan los parametros a la clase calcularCurp para procesar los Strings
        String letrasApellidoP = objCalcula.letrasApellidoP(txtApellidoP.getText().toString());
        String letrasApellidoM = objCalcula.letrasApellidoM(txtApellidoM.getText().toString());
        String letrasNombre = objCalcula.letrasNombre(txtNombres.getText().toString());
        String digitosFechaN = objCalcula.digitosFechaN(txtFechaN.getText().toString());
        String claveHomonimia = objCalcula.ClaveHomonimiaRFC((txtApellidoP.getText().toString() +" " + txtApellidoM.getText().toString()+" "+txtNombres.getText().toString()).toUpperCase());
        String RFCSinHomoclave = letrasApellidoP + letrasApellidoM + letrasNombre + digitosFechaN + claveHomonimia;
        String DigitoVerificador = objCalcula.digitoVerificador(RFCSinHomoclave);
        String RFCConHomoclave = letrasApellidoP + letrasApellidoM + letrasNombre + digitosFechaN + claveHomonimia + DigitoVerificador;
        return RFCConHomoclave;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // En este método se genera un menu ShowPopup
    public void showPopupCURP(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_emergente);
        popup.show();
    }

    public void showPopupRFC(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_emergente_2);
        popup.show();
    }

    /* En este método se identifica la opción presionada
       para posteriormente ejecutar su respectiva acción
     */
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.guardar_CURP:
                try
                {
                    clsFuncionesDeMenu funcion = new clsFuncionesDeMenu();
                    String Nombre = txtNombres.getText().toString();
                    String ApellidoPaterno = txtApellidoP.getText().toString();
                    String ApellidoMaterno = txtApellidoM.getText().toString();
                    String FechaNac = txtFechaN.getText().toString();
                    String Sexo = "";
                    if (radioFemenino.isChecked() == true)
                    {
                        Sexo = "Femenino";
                    }
                    else if (radioMasculino.isChecked() == true)
                    {
                        Sexo = "Masculino";
                    }
                    String Entidad = SpinEntidades.getSelectedItem().toString();
                    String Curp = CURP().toUpperCase();
                    String Rfc = RFC().toUpperCase();
                    String Mensaje = funcion.guardarCURP(this, Nombre, ApellidoPaterno, ApellidoMaterno, FechaNac, Sexo, Entidad, Curp, Rfc);
                    Toast.makeText(this, Mensaje, Toast.LENGTH_LONG).show();
                }
                catch(Exception error)
                {
                    Toast.makeText(this, "¡Error los datos no se pueden guardar!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.copiar_CURP:
                try
                {
                    ClipData clipCurp = ClipData.newPlainText("text", CURP().toUpperCase());
                    ClipboardManager clipboardCurp = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                    clipboardCurp.setPrimaryClip(clipCurp);
                    Toast.makeText(getApplicationContext(), "Texto copiado al portapapeles", Toast.LENGTH_LONG).show();
                }
                catch(Exception error)
                {
                    Toast.makeText(this, "¡Error no hay textto para copiar!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.copiar_RFC:
                try
                {
                    ClipData clipRfc = ClipData.newPlainText("text", RFC().toUpperCase());
                    ClipboardManager clipboardRfc = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                    clipboardRfc.setPrimaryClip(clipRfc);
                    Toast.makeText(getApplicationContext(), "Texto copiado al portapapeles", Toast.LENGTH_LONG).show();
                }
                catch(Exception error)
                {
                    Toast.makeText(this, "¡Error no hay textto para copiar!", Toast.LENGTH_LONG).show();
                }
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.salir) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.curp_guardado) {
            Intent intent = new Intent(MainActivity.this, mostrarCurpActivity.class);
            startActivity(intent);
        }  else if (id == R.id.pag_curp) {
            Intent intent = new Intent(MainActivity.this, ActivityPagConsultaCurp.class);
            startActivity(intent);
        } else if (id == R.id.pag_rfc) {
            Intent intent = new Intent(MainActivity.this, ActivityConsultaRfc.class);
            startActivity(intent);
        } else if (id == R.id.pag_cbtis){
            Intent intent = new Intent(MainActivity.this, Activity_PagCbtis.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

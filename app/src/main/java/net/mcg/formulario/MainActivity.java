package net.mcg.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre, telefono, email, descripcion;
    DatePicker fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        fecha = (DatePicker) findViewById(R.id.fecha);
        telefono = (EditText) findViewById(R.id.telefono);
        email = (EditText) findViewById(R.id.email);
        descripcion = (EditText) findViewById(R.id.descripcion);

        Button siguiente = (Button) findViewById(R.id.btn_sig);

        Bundle parametros= getIntent().getExtras();

        nombre.setText( parametros.getString("nombre_ingresado"));
        //fecha.updateDate( parametros.getInt("dia_ingresado"), parametros.getInt("mes_ingresado"), parametros.getInt("anio_ingresado") );
        telefono.setText( parametros.getString("tel_ingresado"));
        email.setText( parametros.getString("email_ingresado"));
        descripcion.setText( parametros.getString("descripcion_ingresado"));


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Detalle.class);

                intent.putExtra("nombreCompleto", nombre.getText().toString());
                intent.putExtra("fecha",  fecha.getDayOfMonth() + "-" + (fecha.getMonth()+1) + "-" + fecha.getYear());
                intent.putExtra( "tel", telefono.getText().toString());
                intent.putExtra( "email", email.getText().toString());
                intent.putExtra( "descripcion", descripcion.getText().toString());

                startActivity(intent);
            }
        });

    }
}
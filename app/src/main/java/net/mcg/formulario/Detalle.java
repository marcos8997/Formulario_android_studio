package net.mcg.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Bundle parametros= getIntent().getExtras();
        TextView nombre, fecha, tel, email, desc;
        Button btnEditar;

        nombre = (TextView) findViewById(R.id.confirmar_nombre);
        fecha = (TextView) findViewById(R.id.confirmar_fecha);
        tel = (TextView) findViewById(R.id.confirmar_tel);
        email = (TextView) findViewById(R.id.confirmar_email);
        desc = (TextView) findViewById(R.id.confirmar_desc);
        btnEditar = (Button) findViewById(R.id.btn_editar);

        nombre.setText( parametros.getString("nombreCompleto"));
        fecha.setText( "Fecha Nacimiento: "+ parametros.getString("fecha"));
        tel.setText("Tel: " + parametros.getString("tel"));
        email.setText( "Email: " + parametros.getString("email"));
        desc.setText( "Descripción: "+ parametros.getString("descripcion"));

        btnEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Detalle.this, MainActivity.class);

                intent.putExtra("nombre_ingresado", nombre.getText().toString());
                intent.putExtra( "tel_ingresado", tel.getText().toString());
                intent.putExtra( "email_ingresado", email.getText().toString());
                intent.putExtra( "descripcion_ingresado", desc.getText().toString());

                startActivity(intent);
            }
        });
    }
}
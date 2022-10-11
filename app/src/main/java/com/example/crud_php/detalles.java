package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class detalles extends AppCompatActivity {

    TextView tvid,tvname,tvLugar,tvFecha,tvHora,tvIdAdmin;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvLugar = findViewById(R.id.txtLugar);
        tvFecha = findViewById(R.id.txtFecha);
        tvHora = findViewById(R.id.txtHora);
        tvIdAdmin = findViewById(R.id.txtIdAdmin);



        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: " + MainActivity.employeeArrayList.get(position).getIdEvento());
        tvname.setText("Nombre Evento: " + MainActivity.employeeArrayList.get(position).getNombre_Evento());
        tvLugar.setText("Lugar: " + MainActivity.employeeArrayList.get(position).getLugar());
        tvFecha.setText("Fecha: " + MainActivity.employeeArrayList.get(position).getFecha());
        tvHora.setText("Hora: " + MainActivity.employeeArrayList.get(position).getHora());
        tvIdAdmin.setText("Id Admin: " + MainActivity.employeeArrayList.get(position).getIdAdmin());


    }
}
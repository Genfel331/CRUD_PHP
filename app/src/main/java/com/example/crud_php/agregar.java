package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class agregar extends AppCompatActivity {

    EditText txtIdEvento,txtNombre_Evento,txtLugar,txtFecha,txtHora,txtIdAdmin;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtIdEvento = findViewById(R.id.IdEvento);
        txtNombre_Evento = findViewById(R.id.Nombre_Evento);
        txtLugar = findViewById(R.id.Lugar);
        txtFecha = findViewById(R.id.Fecha);
        txtHora = findViewById(R.id.Hora);
        txtIdAdmin=findViewById(R.id.IdAdmin);

        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String IdEvento = txtIdEvento.getText().toString().trim();
        final String Nombre_Evento = txtNombre_Evento.getText().toString().trim();
        final String Lugar = txtLugar.getText().toString().trim();
        final String Fecha = txtFecha.getText().toString().trim();
        final String Hora = txtHora.getText().toString().trim();
        final String IdAdmin = txtIdAdmin.getText().toString().trim();


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(IdEvento.isEmpty()){
            Toast.makeText(this, "ingrese la id del evento", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Nombre_Evento.isEmpty()){
            Toast.makeText(this, "ingrese nombre del evento", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Lugar.isEmpty()){
            Toast.makeText(this, "ingrese direccion del lugar", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Fecha.isEmpty()){
            Toast.makeText(this, "ingrese fecha del evento", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Hora.isEmpty()){
            Toast.makeText(this, "ingrese hora del evento", Toast.LENGTH_SHORT).show();
            return;
        }
        if(IdAdmin.isEmpty()){
            Toast.makeText(this, "ingrese su id de admin", Toast.LENGTH_SHORT).show();
            return;
        }



        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://ticketonline.shop/Android/insertar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("datas insertados")){
                                Toast.makeText(agregar.this, "datas insertados", Toast.LENGTH_SHORT).show();



                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(agregar.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("IdEvento",IdEvento);
                    params.put("Nombre_Evento",Nombre_Evento);
                    params.put("Lugar",Lugar);
                    params.put("Fecha",Fecha);
                    params.put("Hora",Hora);
                    params.put("IdAdmin",IdAdmin);




                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(agregar.this);
            requestQueue.add(request);



        }




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
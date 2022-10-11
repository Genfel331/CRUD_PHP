package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class editar extends AppCompatActivity {

    EditText edIdEvento, edNombre_Evento, edLugar, edFecha,edHora,edIdAdmin;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edIdEvento = findViewById(R.id.ttIdEvento);
        edNombre_Evento = findViewById(R.id.ttNombre_Evento);
        edLugar = findViewById(R.id.ttLugar);
        edFecha = findViewById(R.id.ttFecha);
        edHora = findViewById(R.id.ttHora);
        edIdAdmin = findViewById(R.id.ttIdAdmin);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edIdEvento.setText(MainActivity.employeeArrayList.get(position).getIdEvento());
        edNombre_Evento.setText(MainActivity.employeeArrayList.get(position).getNombre_Evento());
        edLugar.setText(MainActivity.employeeArrayList.get(position).getLugar());
        edFecha.setText(MainActivity.employeeArrayList.get(position).getFecha());
        edHora.setText(MainActivity.employeeArrayList.get(position).getHora());
        edIdAdmin.setText(MainActivity.employeeArrayList.get(position).getIdAdmin());






    }

    public void actualizar(View view) {
        final String evento = edIdEvento.getText().toString().trim();
        final String nombre = edNombre_Evento.getText().toString().trim();
        final String lugar = edLugar.getText().toString().trim();
        final String fecha = edFecha.getText().toString().trim();
        final String hora = edHora.getText().toString().trim();
        final String idAdmin = edIdAdmin.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Actualizando....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://ticketonline.shop/Android/actualizar.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(editar.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("IdEvento",evento);
                params.put("Nombre_Evento",nombre);
                params.put("Lugar",lugar);
                params.put("Fecha",fecha);
                params.put("Hora",hora);
                params.put("IdAdmin",idAdmin);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(editar.this);
        requestQueue.add(request);





    }
}
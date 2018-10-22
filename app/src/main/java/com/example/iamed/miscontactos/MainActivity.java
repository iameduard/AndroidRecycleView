package com.example.iamed.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        contactos=new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.imagen01,"Eduardo Jimenez","04122027031","ejimenmail@gmail.com"));
        contactos.add(new Contacto(R.drawable.imagen02,"yorley uribe","04242036806","yorleyuribe@gmail.com"));
        contactos.add(new Contacto(R.drawable.imagen03,"Salvaita Jimenez","5553322","salvita@gmail.com"));
        contactos.add(new Contacto(R.drawable.imagen04,"Derian Bonilla","11110101","derian@gmail.com"));


        inicializarAdaptador();

        /*
        ArrayList<String> nombreContacto = new ArrayList<>();

        for (Contacto contacto:contactos) {
            nombreContacto.add(contacto.getNombre());
        }
        */

        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });
        */

    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }
}

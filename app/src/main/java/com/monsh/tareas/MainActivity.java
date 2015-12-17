package com.monsh.tareas;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText item;
    private ListView dynamicListView;
    private ArrayList <String> list;
    private ArrayAdapter<String>adapter;
    private FloatingActionButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = (EditText) findViewById(R.id.itemEditText);
        add = (FloatingActionButton)findViewById(R.id.add_item);
        dynamicListView = (ListView) findViewById(R.id.itemListView);

        //Inicializamos la lista y el item
        list = new ArrayList<String>();
        list.add("Curso de Android");

        //Inicializar el arrayAdapter
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list);

        //Seteo el adaptador a la lista
        dynamicListView.setAdapter(adapter);

        //Añadir el item de la lista con el click del fab :)

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String todoItem = item.getText().toString();

                if (todoItem.length()>0){

                    //Añade el valor al editTex de la lista
                    list.add(todoItem);

                    //Aplicamos los cambios al adaptador para refrescar la vista
                    adapter.notifyDataSetChanged();

                    //Limpiamos el EditText para le nuevo item
                    item.setText("");
                }
                //Borrar el item cuando hay un longclick
                dynamicListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        //Remover los items de la lista
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        return true;
                    }
                });







            }
        });
    }
}

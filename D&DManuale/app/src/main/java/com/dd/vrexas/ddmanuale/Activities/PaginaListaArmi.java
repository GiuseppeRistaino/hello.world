package com.dd.vrexas.ddmanuale.Activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.dd.vrexas.ddmanuale.Adapters.AdapterPaginaArmi;
import com.dd.vrexas.ddmanuale.DbHelper.DBManagerD_D;
import com.dd.vrexas.ddmanuale.DbHelper.ExternalDbOpenHelper;
import com.dd.vrexas.ddmanuale.R;

import java.util.ArrayList;

/**
 * Created by Vrexas on 04/02/2016.
 */
public class PaginaListaArmi extends Activity {

    private ListView listViewArmi;
    private EditText editTextFiltraArmi;
    private SQLiteDatabase database;
    private ExternalDbOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_lista_armi);

        listViewArmi = (ListView) findViewById(R.id.listView_Armi);
        editTextFiltraArmi = (EditText) findViewById(R.id.editText_filtraArmi);

        dbHelper = new ExternalDbOpenHelper(this, DBManagerD_D.DB_NAME);
        database = dbHelper.openDataBase();

        Cursor c = database.query(DBManagerD_D.TABLE_NAME_ARMI, DBManagerD_D.COLUMNS_ARMA,
                null, null, null, null
                , DBManagerD_D.COLUMNS_ARMA[0]);
        c.moveToFirst();

        ArrayList<String> listaNomeArmi = new ArrayList<String>();
        do {
            listaNomeArmi.add(c.getString(0));
        }
        while(c.moveToNext());


        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.layout_elemento_lista_armi, R.id.textView_layout_pagina_armi_nome,values);*/

        final AdapterPaginaArmi adapterPaginaArmi = new AdapterPaginaArmi(this, R.layout.layout_elemento_lista_armi, listaNomeArmi);

        listViewArmi.setAdapter(adapterPaginaArmi);

        listViewArmi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openPageArmi = new Intent(PaginaListaArmi.this, PaginaArma.class);
                String extra = (String)parent.getItemAtPosition(position);
                openPageArmi.putExtra("arma", extra);
                startActivity(openPageArmi);
            }
        });

        listViewArmi.setTextFilterEnabled(true);
        editTextFiltraArmi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapterPaginaArmi.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}

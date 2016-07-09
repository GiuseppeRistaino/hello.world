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

import com.dd.vrexas.ddmanuale.Adapters.AdapterPaginaAbility;
import com.dd.vrexas.ddmanuale.DbHelper.DBManagerD_D;
import com.dd.vrexas.ddmanuale.DbHelper.ExternalDbOpenHelper;
import com.dd.vrexas.ddmanuale.R;

import java.util.ArrayList;

/**
 * Created by Vrexas on 15/02/2016.
 */
public class PaginaListaAbility extends Activity {

    private ListView listViewAbility;
    public EditText editTextFiltraAbility;
    private SQLiteDatabase database;
    private ExternalDbOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_lista_ability);

        listViewAbility = (ListView) findViewById(R.id.listView_Ability);
        editTextFiltraAbility = (EditText) findViewById(R.id.editText_filtraAbility);

        dbHelper = new ExternalDbOpenHelper(this, DBManagerD_D.DB_NAME);
        database = dbHelper.openDataBase();

        Cursor c = database.query(DBManagerD_D.TABLE_NAME_ABILITY, DBManagerD_D.COLUMNS_ABILITY,
                null, null, null, null
                , DBManagerD_D.COLUMNS_ABILITY[0]);
        c.moveToFirst();

        ArrayList<String> listaNomeAbility = new ArrayList<String>();
        do {
            listaNomeAbility.add(c.getString(0));
        }
        while(c.moveToNext());

        final AdapterPaginaAbility adapterPaginaAbility = new AdapterPaginaAbility(this, R.layout.layout_elemento_lista_ability, listaNomeAbility);

        listViewAbility.setAdapter(adapterPaginaAbility);

        listViewAbility.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openPageAbility = new Intent(PaginaListaAbility.this, PaginaAbility.class);
                String extra = (String)parent.getItemAtPosition(position);
                openPageAbility.putExtra("ability", extra);
                startActivity(openPageAbility);
            }
        });

        listViewAbility.setTextFilterEnabled(true);
        editTextFiltraAbility.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapterPaginaAbility.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }




}

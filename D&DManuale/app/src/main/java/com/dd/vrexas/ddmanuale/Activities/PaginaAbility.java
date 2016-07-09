package com.dd.vrexas.ddmanuale.Activities;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.dd.vrexas.ddmanuale.DbHelper.DBManagerD_D;
import com.dd.vrexas.ddmanuale.DbHelper.ExternalDbOpenHelper;
import com.dd.vrexas.ddmanuale.R;

/**
 * Created by Vrexas on 15/02/2016.
 */
public class PaginaAbility extends Activity {

    TextView textView_nome, textView_descrizione, textView_prova, textView_azione, textView_ritentare,
            textView_speciale, textView_sinergia, textView_restrizioni, textView_senza_addestramento;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_ability);

        textView_nome = (TextView) findViewById(R.id.textView_nome_ability);
        textView_descrizione = (TextView) findViewById(R.id.textView_descrizione_ability);
        textView_prova = (TextView) findViewById(R.id.textView_prova_ability);
        textView_azione = (TextView) findViewById(R.id.textView_azione_ability);
        textView_ritentare = (TextView) findViewById(R.id.textView_ritentare_ability);
        textView_speciale = (TextView) findViewById(R.id.textView_speciale_ability);
        textView_sinergia = (TextView) findViewById(R.id.textView_sinergia_ability);
        textView_restrizioni = (TextView) findViewById(R.id.textView_restrizioni_ability);
        textView_senza_addestramento = (TextView) findViewById(R.id.textView_senza_addestramento_ability);

        ExternalDbOpenHelper dbHelper = new ExternalDbOpenHelper(this, DBManagerD_D.DB_NAME);
        database = dbHelper.openDataBase();

        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            String nome_ability = extras.getString("ability");

            String selection = DBManagerD_D.COLUMNS_ABILITY[0] + " = ?";
            String[] selectionArgs = {nome_ability};
            Cursor c = database.query(DBManagerD_D.TABLE_NAME_ABILITY, DBManagerD_D.COLUMNS_ABILITY,
                    selection, selectionArgs, null, null
                    , null);
            c.moveToFirst();

            textView_nome.setText(nome_ability);
            textView_descrizione.setText("Descrizione: " + c.getString(1));
            textView_prova.setText("Prova: " + c.getString(2));
            textView_azione.setText("Azione: " + c.getString(3));
            textView_ritentare.setText("Ritentare: " + c.getString(4));
            textView_speciale.setText("Speciale: " + c.getString(5));
            textView_sinergia.setText("Sinergia: " + c.getString(6));
            textView_restrizioni.setText("Restrizioni: " + c.getString(7));
            textView_senza_addestramento.setText("Senza Addestramento: " + c.getString(7));

        }

    }

}

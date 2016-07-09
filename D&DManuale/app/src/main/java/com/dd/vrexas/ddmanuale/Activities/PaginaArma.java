package com.dd.vrexas.ddmanuale.Activities;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dd.vrexas.ddmanuale.DbHelper.DBManagerD_D;
import com.dd.vrexas.ddmanuale.DbHelper.ExternalDbOpenHelper;
import com.dd.vrexas.ddmanuale.R;

/**
 * Created by Vrexas on 04/02/2016.
 */
public class PaginaArma extends Activity {


    TextView textView_nome, textView_tipo, textView_costo, textView_danniPiccola, textView_danniMedia,
        textView_critico, textView_gittata, textView_peso;
    ImageView imageView_imageArma;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_arma);

        textView_nome = (TextView) findViewById(R.id.textView_nome_arma);
        textView_tipo = (TextView) findViewById(R.id.textView_tipo_arma);
        textView_costo = (TextView) findViewById(R.id.textView_costo_arma);
        textView_danniPiccola = (TextView) findViewById(R.id.textView_danni_piccola_arma);
        textView_danniMedia = (TextView) findViewById(R.id.textView_danni_media_arma);
        textView_critico = (TextView) findViewById(R.id.textView_critico_arma);
        textView_gittata = (TextView) findViewById(R.id.textView_gittata_arma);
        textView_peso = (TextView) findViewById(R.id.textView_peso_arma);

        imageView_imageArma = (ImageView) findViewById(R.id.imageView_image_arma);

        ExternalDbOpenHelper dbHelper = new ExternalDbOpenHelper(this, DBManagerD_D.DB_NAME);
        database = dbHelper.openDataBase();



        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            String nome_arma = extras.getString("arma");

            String selection = DBManagerD_D.COLUMNS_ARMA[0] + " = ?";
            String[] selectionArgs = {nome_arma};
            Cursor c = database.query(DBManagerD_D.TABLE_NAME_ARMI, DBManagerD_D.COLUMNS_ARMA,
                    selection, selectionArgs, null, null
                    , null);
            c.moveToFirst();

            textView_nome.setText(nome_arma);
            textView_tipo.setText("Tipo: " +c.getString(1));
            textView_costo.setText("Costo: " + c.getString(2));
            textView_danniPiccola.setText("Danni taglia piccola: " + c.getString(3));
            textView_danniMedia.setText("Danni taglia media: " + c.getString(4));
            textView_critico.setText("Critico: " + c.getString(5));
            textView_gittata.setText("Gittata: " + c.getString(6));
            textView_peso.setText("Peso: " + c.getString(7));

            String nome_file_img = nome_arma.toLowerCase();
            nome_file_img = nome_file_img.replace("(", "");
            nome_file_img = nome_file_img.replace(")", "");
            nome_file_img = nome_file_img.replace(" ", "_");
            nome_file_img = nome_file_img.replace("'", "_");
            nome_file_img = nome_file_img.replace("-","0");
            int id = getResources().getIdentifier(this.getPackageName()+":drawable/" + nome_file_img, null, null);
            imageView_imageArma.setImageResource(id);
        }

    }

}

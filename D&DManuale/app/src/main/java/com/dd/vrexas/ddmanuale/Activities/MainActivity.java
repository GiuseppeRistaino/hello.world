package com.dd.vrexas.ddmanuale.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dd.vrexas.ddmanuale.DbHelper.ExternalDbOpenHelper;
import com.dd.vrexas.ddmanuale.R;

public class MainActivity extends AppCompatActivity {

    public Button buttonArmi;
    public Button buttonMostri;
    public Button buttonIncantesimi;
    public Button buttonAbility;

    ExternalDbOpenHelper dbHelper;

    public final static String DB_NAME = "Dungeons&Dragons";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonArmi = (Button) findViewById(R.id.button_armi);
        buttonMostri = (Button) findViewById(R.id.button_mostri);
        buttonIncantesimi = (Button) findViewById(R.id.button_incantesimi);
        buttonAbility = (Button) findViewById(R.id.button_ability);

        dbHelper = new ExternalDbOpenHelper(this, DB_NAME);

        buttonArmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openPageListArmi = new Intent(MainActivity.this,PaginaListaArmi.class);
                startActivity(openPageListArmi);
            }
        });

        buttonAbility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openPageListAbility = new Intent(MainActivity.this,PaginaListaAbility.class);
                startActivity(openPageListAbility);
            }
        });

    }

}

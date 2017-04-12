package com.example.sudo.zadaca3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static android.R.attr.description;
import static android.R.attr.name;

public class AddTask extends Activity implements View.OnClickListener {

    EditText etNaslov, etOpis;
    Spinner spTezina;
    Button bDodaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setUP();
    }

    private void setUP() {
        this.etNaslov = (EditText) findViewById(R.id.etNaslov);
        this.etOpis = (EditText) findViewById(R.id.etOpis);
        this.spTezina = (Spinner) findViewById(R.id.spTezina);
        this.bDodaj = (Button) findViewById(R.id.bDodaj);
        this.bDodaj.setOnClickListener(this);


        Spinner spinner = (Spinner) findViewById(R.id.spTezina);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tezine, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        String Naslov = String.valueOf(etNaslov.getText());
        String Opis = String.valueOf(etOpis.getText());
        String Prioritet = String.valueOf(spTezina.getId());



    }
}


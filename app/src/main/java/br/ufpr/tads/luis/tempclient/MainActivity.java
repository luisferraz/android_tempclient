package br.ufpr.tads.luis.tempclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converteTemp(View view) {
        EditText entrada = (EditText) findViewById(R.id.editTextEntrada);
        TextView saida = (TextView) findViewById(R.id.textViewSaida);
        Double temp = Double.parseDouble(entrada.getText().toString());
        RequestTask task = new RequestTask (saida);
        task.execute(temp);
    }
}
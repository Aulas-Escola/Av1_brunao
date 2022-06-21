package com.test.av1p_brunao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textViewResultado = findViewById(R.id.textViewResultado);
    }
    public void calcularPreco(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if (camposValidados){
            this.calcularMelhorPreco(precoAlcool, precoGasolina);
        }
        else{
            textViewResultado.setText("Preencha os campos primeiro!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        }
        else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoAlcool/precoGasolina;
        if (resultado > 0.7){
            textViewResultado.setText("Melhor Utilizar a Gasolina!");
        }else{
            textViewResultado.setText("Melhor Utilizar o Alcool!");
        }
    }
}

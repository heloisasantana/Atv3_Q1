package com.seuusuario.appcombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:Heloísa Santana da Silva
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextGasolina, editTextEtanol;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os componentes da interface
        editTextGasolina = findViewById(R.id.editTextGasolina);
        editTextEtanol = findViewById(R.id.editTextEtanol);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurando o evento de clique no botão "Calcular"
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMelhorCombustivel();
            }
        });
    }

    private void calcularMelhorCombustivel() {
        try {
            // Obtendo os valores dos EditTexts
            double precoGasolina = Double.parseDouble(editTextGasolina.getText().toString());
            double precoEtanol = Double.parseDouble(editTextEtanol.getText().toString());

            // Calculando a relação entre etanol e gasolina
            double relacao = precoEtanol / precoGasolina;

            // Verificando qual combustível é mais vantajoso
            if (relacao <= 0.7) {
                textViewResultado.setText("Abasteça com Etanol");
            } else {
                textViewResultado.setText("Abasteça com Gasolina");
            }
        } catch (NumberFormatException e) {
            textViewResultado.setText("Por favor, insira valores válidos.");
        }
    }
}

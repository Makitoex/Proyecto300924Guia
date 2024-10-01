package com.example.proyecto300924;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText id_ingresanumero;
    private Button id_btverificar;
    private TextView id_txvisualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        id_ingresanumero = findViewById(R.id.id_ingresanumero);
        id_btverificar = findViewById(R.id.id_btverificar);
        id_txvisualizar = findViewById(R.id.id_txvisualizar1);

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Button click listener
        id_btverificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id_ingresanumero.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa un número", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Parse number and check if it's even or odd
                int numero = Integer.parseInt(id_ingresanumero.getText().toString());

                if (numero % 2 == 0) {
                    id_txvisualizar.setText("El número es par.");
                } else {
                    id_txvisualizar.setText("El número es impar.");
                }

                // Display numbers from 1 to 10
                StringBuilder numeros = new StringBuilder("Números del 1 al 10: ");
                for (int i = 1; i <= 10; i++) {
                    numeros.append(i).append(" ");
                }
                id_txvisualizar.append("\n" + numeros.toString());
            }
        });

        // Set up button for fragment replacement
        Button boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, new OtroFragment())
                        .commit();
            }
        });
    }
}

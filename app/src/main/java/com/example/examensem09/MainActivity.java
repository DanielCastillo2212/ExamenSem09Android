package com.example.examensem09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean esJugador1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvPtj1 = findViewById(R.id.tvPtj1);
        TextView tvPtj2 = findViewById(R.id.tvPtj2);
        TextView tvGanador = findViewById(R.id.tvGanador);

        Button btnJugador = findViewById(R.id.btnJugador);
        Button btnReset = findViewById(R.id.btnReset);

        btnJugador.setOnClickListener(view -> {
            if (esJugador1) {
                btnJugador.setText("Jugador 2");
                int randomNumber1 = (int) (Math.random() * 10) + 1;
                tvPtj1.setText(String.valueOf(randomNumber1));
            } else {
                int randomNumber2 = (int) (Math.random() * 10) + 1;
                tvPtj2.setText(String.valueOf(randomNumber2));

                int ptj1 = Integer.parseInt(tvPtj1.getText().toString());
                int ptj2 = Integer.parseInt(tvPtj2.getText().toString());

                if (ptj1 > ptj2) {
                    tvGanador.setText("Ganador Jugador 1");
                } else if (ptj1 < ptj2) {
                    tvGanador.setText("Ganador Jugador 2");
                } else {
                    tvGanador.setText("Empate");
                }

                btnJugador.setEnabled(false);
            }


            // Cambiar el estado del jugador
            esJugador1 = !esJugador1;
        });

        btnReset.setOnClickListener(view -> {
            btnJugador.setText("Jugador 1");
            tvPtj1.setText("");
            tvPtj2.setText("");
            tvGanador.setText("");
            btnJugador.setEnabled(true);
        });

    }
}
package com.erikriosetiawan.cubecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BolaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextJariJari;
    Button buttonCalculate;
    TextView textViewLuasResult;
    TextView textViewVolumeResult;

    private static final String STATE_RESULT_LUAS_PERMUKAAN = "state_result_luas_permukaan";
    private static final String STATE_RESULT_VOLUME = "state_result_volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);

        getSupportActionBar().setTitle("Luas Permukaan & Volume Bola");

        editTextJariJari = findViewById(R.id.edit_text_jari_jari);

        buttonCalculate = findViewById(R.id.button_calculate);
        buttonCalculate.setOnClickListener(this);

        textViewLuasResult = findViewById(R.id.text_view_luas_result);
        textViewVolumeResult = findViewById(R.id.text_view_volume_result);

        if (savedInstanceState != null) {
            String luasResult = savedInstanceState.getString(STATE_RESULT_LUAS_PERMUKAAN);
            String volumeResult = savedInstanceState.getString(STATE_RESULT_VOLUME);

            textViewLuasResult.setText(luasResult);
            textViewVolumeResult.setText(volumeResult);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String inputJariJari = editTextJariJari.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputJariJari)) {
                isEmptyFields = true;
                editTextJariJari.setError("Field ini tidak boleh kosong");
            }

            Double jariJari = toDouble(inputJariJari);

            if (jariJari == null) {
                isInvalidDouble = true;
                editTextJariJari.setError("Field ini harus berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                Bola hitungBola = new Bola();
                hitungBola.setJariJari(jariJari);

                Double luas = hitungBola.luas(hitungBola.getJariJari());
                Double volume = hitungBola.volume(hitungBola.getJariJari());

                textViewLuasResult.setText(String.valueOf(luas));
                textViewVolumeResult.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(STATE_RESULT_LUAS_PERMUKAAN, textViewLuasResult.getText().toString());
        outState.putString(STATE_RESULT_VOLUME, textViewVolumeResult.getText().toString());
    }
}

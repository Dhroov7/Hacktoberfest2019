package com.erikriosetiawan.cubecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TabungActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextJariJari, editTextTinggi;
    Button buttonCalculate;
    TextView textViewLuasResult, textViewVolumeResult;

    private static final String STATE_RESULT_LUAS_PERMUKAAN = "state_result_luas_permukaan";
    private static final String STATE_RESULT_VOLUME = "state_result_volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);

        getSupportActionBar().setTitle("Luas Permukaan & Volume Tabung");

        editTextJariJari = findViewById(R.id.edit_text_jari_jari);
        editTextTinggi = findViewById(R.id.edit_text_tinggi);

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
            String inputTinggi = editTextTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputJariJari)) {
                isEmptyFields = true;
                editTextJariJari.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true;
                editTextTinggi.setError("Field ini tidak boleh kosong");
            }

            Double jariJari = toDouble(inputJariJari);
            Double tinggi = toDouble(inputTinggi);

            if (jariJari == null) {
                isInvalidDouble = true;
                editTextJariJari.setError("Field ini harus berupa nomor yang valid");
            }

            if (tinggi == null) {
                isInvalidDouble = true;
                editTextTinggi.setError("Field ini harus berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                Tabung hitungTabung = new Tabung();

                hitungTabung.setJariJari(jariJari);
                hitungTabung.setHeight(jariJari);

                Double luas = hitungTabung.luas(hitungTabung.getJariJari(), hitungTabung.getHeight());
                Double volume =hitungTabung.volume(hitungTabung.getJariJari(), hitungTabung.getHeight());

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

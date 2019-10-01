package com.erikriosetiawan.cubecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KerucutActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextJarijari, editTextPanjangSisi, editTextTinggi;
    Button buttonCalculate;
    TextView textViewLuasResult, textViewVolumeResult;

    private static final String STATE_RESULT_LUAS_PERMUKAAN = "state_result_luas_permukaan";
    private static final String STATE_RESULT_VOLUME = "state_result_volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerucut);

        getSupportActionBar().setTitle("Luas Permukaan & Volume Kerucut");

        editTextJarijari = findViewById(R.id.edit_text_jari_jari);
        editTextPanjangSisi = findViewById(R.id.edit_text_panjang_sisi);
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

            String inputJariJari = editTextJarijari.getText().toString().trim();
            String inputPanjangSisi = editTextPanjangSisi.getText().toString().trim();
            String inputTinggi = editTextTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputJariJari)) {
                isEmptyFields = true;
                editTextJarijari.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputPanjangSisi)) {
                isEmptyFields = true;
                editTextPanjangSisi.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true;
                editTextTinggi.setError("Field ini tidak boleh kosong");
            }

            Double jariJari = toDouble(inputJariJari);
            Double panjangSisi = toDouble(inputPanjangSisi);
            Double tinggi = toDouble(inputTinggi);

            if (jariJari == null) {
                isInvalidDouble = true;
                editTextJarijari.setError("Field ini harus berupa nomor yang valid");
            }

            if (panjangSisi == null) {
                isInvalidDouble = true;
                editTextPanjangSisi.setError("Field ini harus berupa nomor yang valid");
            }

            if (tinggi == null) {
                isInvalidDouble = true;
                editTextTinggi.setError("Field ini harus berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                Kerucut hitungKerucut = new Kerucut();
                hitungKerucut.setJariJari(jariJari);
                hitungKerucut.setSisi(panjangSisi);
                hitungKerucut.setHeight(tinggi);

                Double luas = hitungKerucut.luas(hitungKerucut.getJariJari(), hitungKerucut.getSisi());
                Double volume = hitungKerucut.volume(hitungKerucut.getJariJari(), hitungKerucut.getHeight());

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

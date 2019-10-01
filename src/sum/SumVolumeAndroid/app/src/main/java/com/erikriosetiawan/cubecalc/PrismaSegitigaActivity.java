package com.erikriosetiawan.cubecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrismaSegitigaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextKelilingSegitiga, editTextTinggi, editTextLuasSegitiga, editTextLuasAlas;
    Button buttonCalculate;
    TextView textViewLuasResult, textViewVolumeResult;

    private static final String STATE_RESULT_LUAS_PERMUKAAN = "state_result_luas_permukaan";
    private static final String STATE_RESULT_VOLUME = "state_result_volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prisma_segitiga);

        getSupportActionBar().setTitle("Luas Permukaan & Volume Prisma Segitiga");

        editTextKelilingSegitiga = findViewById(R.id.edit_text_keliling_segitiga);
        editTextTinggi = findViewById(R.id.edit_text_tinggi);
        editTextLuasSegitiga = findViewById(R.id.edit_text_luas_segitiga);
        editTextLuasAlas = findViewById(R.id.edit_text_luas_alas);

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
            String inputKelililngSegitiga = editTextKelilingSegitiga.getText().toString().trim();
            String inputTinggi = editTextTinggi.getText().toString().trim();
            String inputLuasSegitiga = editTextLuasSegitiga.getText().toString().trim();
            String inputLuasAlas = editTextLuasAlas.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputKelililngSegitiga)) {
                isEmptyFields = true;
                editTextKelilingSegitiga.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true;
                editTextTinggi.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputLuasSegitiga)) {
                isEmptyFields = true;
                editTextLuasSegitiga.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputLuasAlas)) {
                isEmptyFields = true;
                editTextLuasAlas.setError("Field ini tidak boleh kosong");
            }

            Double kelilingSegitiga = toDouble(inputKelililngSegitiga);
            Double tinggi = toDouble(inputTinggi);
            Double luasSegitiga = toDouble(inputLuasSegitiga);
            Double luasAlas = toDouble(inputLuasAlas);

            if (kelilingSegitiga == null) {
                isInvalidDouble = true;
                editTextKelilingSegitiga.setError("Field ini harus berupa nomor yang valid");
            }

            if (tinggi == null) {
                isInvalidDouble = true;
                editTextTinggi.setError("Field ini harus berupa nomor yang valid");
            }

            if (luasSegitiga == null) {
                isInvalidDouble = true;
                editTextLuasAlas.setError("Field ini harus berupa nomor yang valid");
            }

            if (luasAlas == null) {
                isInvalidDouble = true;
                editTextLuasAlas.setError("Field ini harus berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                PrismaSegitiga hitungPrismaSegitiga = new PrismaSegitiga();

                hitungPrismaSegitiga.setKelilingSegitiga(kelilingSegitiga);
                hitungPrismaSegitiga.setHeight(tinggi);
                hitungPrismaSegitiga.setLuasSegitiga(luasSegitiga);
                hitungPrismaSegitiga.setLuasAlas(luasAlas);

                Double luas = hitungPrismaSegitiga.luas(hitungPrismaSegitiga.getKelilingSegitiga(), hitungPrismaSegitiga.getHeight(), hitungPrismaSegitiga.getLuasSegitiga());
                Double volume = hitungPrismaSegitiga.volume(hitungPrismaSegitiga.getLuasAlas(), hitungPrismaSegitiga.getHeight());

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

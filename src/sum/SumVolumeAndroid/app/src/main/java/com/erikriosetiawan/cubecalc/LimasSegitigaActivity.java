package com.erikriosetiawan.cubecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LimasSegitigaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextLuasSisiSatu, editTextLuasSisiDua, editTextLuasSisiTiga, editTextLuasAlas, editTextTinggi;
    Button buttonCalculate;
    TextView textViewLuasResult, textViewVolumeResult;

    private static final String STATE_RESULT_LUAS_PERMUKAAN = "state_result_luas_permukaan";
    private static final String STATE_RESULT_VOLUME = "state_result_volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limas_segitiga);

        getSupportActionBar().setTitle("Luas Permukaan & Volume Limas Segitiga");

        editTextLuasSisiSatu = findViewById(R.id.edit_text_luas_sisi_satu);
        editTextLuasSisiDua = findViewById(R.id.edit_text_luas_sisi_dua);
        editTextLuasSisiTiga = findViewById(R.id.edit_text_luas_sisi_tiga);
        editTextLuasAlas = findViewById(R.id.edit_text_luas_alas);
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
            String inputLuasSisiSatu = editTextLuasSisiSatu.getText().toString().trim();
            String inputLuasSisiDua = editTextLuasSisiDua.getText().toString().trim();
            String inputLuasSisiTiga = editTextLuasSisiTiga.getText().toString().trim();
            String inputLuasAlas = editTextLuasAlas.getText().toString().trim();
            String inputTinggi = editTextTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLuasSisiSatu)) {
                isEmptyFields = true;
                editTextLuasSisiSatu.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputLuasSisiDua)) {
                isEmptyFields = true;
                editTextLuasSisiDua.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputLuasSisiTiga)) {
                isEmptyFields = true;
                editTextLuasSisiTiga.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputLuasAlas)) {
                isEmptyFields = true;
                editTextLuasAlas.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true;
                editTextTinggi.setError("Field ini tidak boleh kosong");
            }

            Double luasSisiSatu = toDouble(inputLuasSisiSatu);
            Double luasSisiDua = toDouble(inputLuasSisiDua);
            Double luasSisiTiga = toDouble(inputLuasSisiTiga);
            Double luasAlas = toDouble(inputLuasAlas);
            Double tinggi = toDouble(inputTinggi);

            if (luasSisiSatu == null) {
                isInvalidDouble = true;
                editTextLuasSisiSatu.setError("Field ini harus berupa nomor yang valid");
            }

            if (luasSisiDua == null) {
                isInvalidDouble = true;
                editTextLuasSisiDua.setError("Field ini harus berupa nomor yang valid");
            }

            if (luasSisiTiga == null) {
                isInvalidDouble = true;
                editTextLuasSisiTiga.setError("Field ini harus berupa nomor yang valid");
            }

            if (luasAlas == null) {
                isInvalidDouble = true;
                editTextLuasAlas.setError("Field ini harus berupa nomor yang valid");
            }

            if (tinggi == null) {
                isInvalidDouble = true;
                editTextTinggi.setError("Field ini harus berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                LimasSegitiga hitungLimasSegitiga = new LimasSegitiga();

                hitungLimasSegitiga.setLuasSisiSatu(luasSisiSatu);
                hitungLimasSegitiga.setLuasSisiDua(luasSisiDua);
                hitungLimasSegitiga.setLuasSisiTiga(luasSisiTiga);
                hitungLimasSegitiga.setLuasAlas(luasAlas);
                hitungLimasSegitiga.setHeight(tinggi);

                Double luas = hitungLimasSegitiga.luas(hitungLimasSegitiga.getLuasSisiSatu(), hitungLimasSegitiga.getLuasSisiDua(), hitungLimasSegitiga.getLuasSisiTiga(), hitungLimasSegitiga.getLuasAlas());
                Double volume = hitungLimasSegitiga.volume(hitungLimasSegitiga.getLuasAlas(), hitungLimasSegitiga.getHeight());

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

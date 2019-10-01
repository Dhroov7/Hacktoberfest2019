package com.erikriosetiawan.cubecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LimasSegiEmpatActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextLuasSisiSatu, editTextLuasSisiDua, editTextLuasSisiTiga, editTextLuasSisiEmpat, editTextLuasAlas, editTextTinggi;
    Button buttonCalculate;
    TextView textViewLuas, textViewVolume;

    private static final String STATE_RESULT_LUAS_PERMUKAAN = "state_result_luas_permukaan";
    private static final String STATE_RESULT_VOLUME = "state_result_volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limas_segi_empat);

        getSupportActionBar().setTitle("Luas Permukaan & Volume Limas Segiempat");

        editTextLuasSisiSatu = findViewById(R.id.edit_text_luas_sisi_satu);
        editTextLuasSisiDua = findViewById(R.id.edit_text_luas_sisi_dua);
        editTextLuasSisiTiga = findViewById(R.id.edit_text_luas_sisi_tiga);
        editTextLuasSisiEmpat = findViewById(R.id.edit_text_luas_sisi_empat);
        editTextLuasAlas = findViewById(R.id.edit_text_luas_alas);
        editTextTinggi = findViewById(R.id.edit_text_tinggi);

        buttonCalculate = findViewById(R.id.button_calculate);
        buttonCalculate.setOnClickListener(this);

        textViewLuas = findViewById(R.id.text_view_luas_result);
        textViewVolume = findViewById(R.id.text_view_volume_result);

        if (savedInstanceState != null) {
            String resultLuas = savedInstanceState.getString(STATE_RESULT_LUAS_PERMUKAAN);
            String resultVolume = savedInstanceState.getString(STATE_RESULT_VOLUME);

            textViewLuas.setText(resultLuas);
            textViewVolume.setText(resultVolume);
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_calculate) {

            String inputLuasSisiSatu = editTextLuasSisiSatu.getText().toString().trim();
            String inputLuasSisiDua = editTextLuasSisiDua.getText().toString().trim();
            String inputLuasSisiTiga = editTextLuasSisiTiga.getText().toString().trim();
            String inputLuasSisiEmpat = editTextLuasSisiEmpat.getText().toString().trim();
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

            if (TextUtils.isEmpty(inputLuasSisiEmpat)) {
                isEmptyFields = true;
                editTextLuasSisiEmpat.setError("Field ini tidak boleh kosong");
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
            Double luasSisiEmpat = toDouble(inputLuasSisiEmpat);
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

            if (luasSisiEmpat == null) {
                isInvalidDouble = true;
                editTextLuasSisiEmpat.setError("Field ini harus berupa nomor yang valid");
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
                LimasSegiEmpat hitungLimasSegiEmpat = new LimasSegiEmpat();
                hitungLimasSegiEmpat.setLuasSisiSatu(luasSisiSatu);
                hitungLimasSegiEmpat.setLuasSisiDua(luasSisiDua);
                hitungLimasSegiEmpat.setLuasSisiTiga(luasSisiTiga);
                hitungLimasSegiEmpat.setLuasSisiEmpat(luasSisiEmpat);
                hitungLimasSegiEmpat.setLuasAlas(luasAlas);
                hitungLimasSegiEmpat.setHeight(tinggi);

                Double luas = hitungLimasSegiEmpat.luas(hitungLimasSegiEmpat.getLuasSisiSatu(), hitungLimasSegiEmpat.getLuasSisiDua(), hitungLimasSegiEmpat.getLuasSisiTiga(), hitungLimasSegiEmpat.getLuasSisiEmpat(), hitungLimasSegiEmpat.getLuasAlas());
                Double volume = hitungLimasSegiEmpat.volume(hitungLimasSegiEmpat.getLuasAlas(), hitungLimasSegiEmpat.getHeight());

                textViewLuas.setText(String.valueOf(luas));
                textViewVolume.setText(String.valueOf(volume));
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

        outState.putString(STATE_RESULT_LUAS_PERMUKAAN, textViewLuas.getText().toString());
        outState.putString(STATE_RESULT_VOLUME, textViewVolume.getText().toString());
    }
}

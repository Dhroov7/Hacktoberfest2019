package com.erikriosetiawan.cubecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KubusActivity extends AppCompatActivity implements View.OnClickListener {


    EditText editTextPanjangRusuk;
    Button buttonCalculate;
    TextView textViewLuasResult, textViewVolumeResult;

    private static final String STATE_RESULT_LUAS_PERMUKAAN = "state_result_luas_permukaan";
    private static final String STATE_RESULT_VOLUME = "state_result_volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);

        getSupportActionBar().setTitle("Luas Permukaan & Volume Kubus");

        editTextPanjangRusuk = findViewById(R.id.edit_text_panjang_rusuk_kubus);

        buttonCalculate = findViewById(R.id.button_calculate);
        buttonCalculate.setOnClickListener(this);

        textViewLuasResult = findViewById(R.id.text_view_luas_result);
        textViewVolumeResult = findViewById(R.id.text_view_volume_result);

        if (savedInstanceState != null) {
            String resultLuas = savedInstanceState.getString(STATE_RESULT_LUAS_PERMUKAAN);
            String resultVolume = savedInstanceState.getString(STATE_RESULT_VOLUME);

            textViewLuasResult.setText(resultLuas);
            textViewVolumeResult.setText(resultVolume);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String inputRusuk = editTextPanjangRusuk.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputRusuk)) {
                isEmptyFields = true;
                editTextPanjangRusuk.setError("Field ini tidak boleh kosong");
            }

            Double rusuk = toDouble(inputRusuk);

            if (rusuk == null) {
                isInvalidDouble = true;
                editTextPanjangRusuk.setError("Field ini harus berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                Kubus hitungKubus = new Kubus();
                hitungKubus.setRusuk(rusuk);
                double luasPermukaan = hitungKubus.luas(hitungKubus.getRusuk());
                double volume = hitungKubus.volume(hitungKubus.getRusuk());

                textViewLuasResult.setText(String.valueOf(luasPermukaan));
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

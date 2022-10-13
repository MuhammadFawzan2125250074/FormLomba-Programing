package com.if31.formlombaprograming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etNoWhatsapp, etAlamat, etPassword, etPin;
    private RadioGroup rgJenisKelamin;
    private RadioButton rbJenisKelamin;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNoWhatsapp = findViewById(R.id.et_no_wa);
        etAlamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);
        rgJenisKelamin = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = etNama.getText().toString();
                String nowhatsapp = etNoWhatsapp.getText().toString();
                String alamat = etAlamat.getText().toString();
                String password = etPassword.getText().toString();
                String pin = etPin.getText().toString();

                int jeniskelamin = rgJenisKelamin.getCheckedRadioButtonId();
                rbJenisKelamin = findViewById(jeniskelamin);

                String jenisKelamin = rbJenisKelamin.getText().toString();

                if (nama.trim().equals("")){
                    etNama.setError("Nama tidak boleh kosong!!!");
                }
                else if (nowhatsapp.trim().equals("")){
                    etNoWhatsapp.setError("No Whatsapp tidak boleh kosong!!!");
                }
                else if (alamat.trim().equals("")){
                    etAlamat.setError("Alamat tidak boleh kosong!!!");
                }
                else if (password.trim().equals("")){
                    etPassword.setError("Password tidak boleh kosong!!!");
                }
                else if (pin.trim().equals("")){
                    etPin.setError("Pin tidak boleh kosong!!!");
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("varNama", nama);
                    intent.putExtra("varNoWhatsapp", nowhatsapp);
                    intent.putExtra("varAlamat", alamat);
                    intent.putExtra("varJenisKelamin", jenisKelamin);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etNoWhatsapp.setText("");
        etAlamat.setText("");
        etPassword.setText("");
        etPin.setText("");
    }
}
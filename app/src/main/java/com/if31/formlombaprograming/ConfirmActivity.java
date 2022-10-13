package com.if31.formlombaprograming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
   TextView tvNama, tvJk, tvNoWhatsapp, tvAlamat, tvTanggal;
   Button btnTanggal, btnKonfirmasi;

   String nama, jk, nowhatsapp, alamat, choosenDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJk = findViewById(R.id.tv_jk);
        tvNoWhatsapp = findViewById(R.id.tv_nowa);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);

        btnTanggal= findViewById(R.id.btntanggal);
        btnKonfirmasi = findViewById(R.id.btnkonfirmasi);

        //ambil Intent yang dikirim oleh MainActivity
        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        jk = terima.getStringExtra("varJenisKelamin");
        nowhatsapp = terima.getStringExtra("varNoWhatsapp");
        alamat = terima.getStringExtra("varAlamat");
        //set variabel
        tvNama.setText(nama);
        tvJk.setText(jk);
        tvNoWhatsapp.setText(nowhatsapp);
        tvAlamat.setText(alamat);

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalender = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth)
                    {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String tanggal = Integer.toString(dayOfMonth);
                        choosenDate = tanggal +"/"+ bulan +"/"+tahun;
                        tvTanggal.setText(choosenDate);
                    }
                }, newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH),
                        newCalender.get(Calendar.DAY_OF_MONTH));
                //tampilkan datePickerDialog
                datePickerDialog.show();
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data anda sudah benar ?");

                //button postif
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ConfirmActivity.this,
                                "Terima kasih, pendaftaran anda telah berhasil"
                                , Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //button negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this,
                                "pendaftaran anda tidak berhasil"
                                , Toast.LENGTH_SHORT).show();
                    }
                });
                //tampilkan dialog
                dialog.show();
            }
        });

    }
}
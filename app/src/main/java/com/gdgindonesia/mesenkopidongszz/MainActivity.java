package com.gdgindonesia.mesenkopidongszz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private static final int HARGA = 15000;
	private static final int HARGA_TOPPING_COKLAT = 2000;
	private static final int HARGA_TOPPING_AGER = 6500;

	TextView textJumlah;

	/* Baru */
	EditText inputNama;
	CheckBox cekBoxCoklat;
	CheckBox cekBoxAger;

	int jumlah = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inputNama = (EditText) findViewById(R.id.input_nama);
		cekBoxCoklat = (CheckBox) findViewById(R.id.cekbox_coklat);
		cekBoxAger = (CheckBox) findViewById(R.id.cekbox_ager);
		textJumlah = (TextView) findViewById(R.id.text_jumlah);

		updateJumlah();
	}

	public void kurang(View view) {
		if (jumlah > 0)
			jumlah -= 1;
		updateJumlah();
	}

	public void tambah(View view) {
		jumlah += 1;
		updateJumlah();
	}

	public void hitung(View view) {

		String name = inputNama.getText().toString();
		if (TextUtils.isEmpty(name)) {
			inputNama.setError("Nama tidak boleh kosong");
			return;
		}

		boolean apakahPakeCoklat = cekBoxCoklat.isChecked();
		boolean apakahPakeAger = cekBoxAger.isChecked();

		int total = (jumlah * HARGA);
		if (apakahPakeCoklat)
			total += HARGA_TOPPING_COKLAT;
		if (apakahPakeAger)
			total += HARGA_TOPPING_AGER;

		String totalHarga = "Rp." + total;

		final String rincian = "Nama: " + name
			+ "\nTambah topping coklat: " + apakahPakeCoklat
			+ "\nTambah topping ager: " + apakahPakeAger
			+ "\nTotal Harga: " + totalHarga
			+ "\nThank you!";

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Konfirmasi!");
		builder.setMessage("Apakah anda yakin ingin memesan ini?");
		builder.setNegativeButton("Bentar bentar ...", null);
		builder.setPositiveButton("Yakin bro!", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				/* Untuk ke activity hasil */
				Intent intent = new Intent(MainActivity.this, HasilActivity.class);
				intent.putExtra("data", rincian);
				startActivity(intent);
			}
		});
		builder.create().show();
	}


	private void updateJumlah() {
		textJumlah.setText(String.valueOf(jumlah));
	}
}

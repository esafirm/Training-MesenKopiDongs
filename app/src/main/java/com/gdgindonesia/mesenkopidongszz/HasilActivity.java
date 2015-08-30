package com.gdgindonesia.mesenkopidongszz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by esa on 30/08/15, with awesomeness
 */
public class HasilActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hasil);

		Intent intent = getIntent();
		String data = intent.getStringExtra("data");

		TextView textHasil = (TextView) findViewById(R.id.text_hasil);
		textHasil.setText(data);
	}
}

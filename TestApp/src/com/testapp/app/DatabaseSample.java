package com.testapp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DatabaseSample extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		View button1Click = findViewById(R.id.button1);
		button1Click.setOnClickListener(this);
		View button2Click = findViewById(R.id.button2);
		button2Click.setOnClickListener(this);        

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){

		case R.id.button1:
			Intent i = new Intent(this, AddTypeList.class);  
			startActivity(i);
			break;

		}
	}
}
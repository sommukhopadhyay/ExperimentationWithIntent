package com.somitsolutions.training.android.experimentationwithintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivitylayout);
		
		Intent returnIntent = getIntent();
		
		String firstStringData = returnIntent.getStringExtra("Key0");
		int secondIntData = returnIntent.getIntExtra("Key1", 0);
		//returnIntent.putExtra("Key2", "This is the return result from the called Intent");
		//setResult(RESULT_OK, returnIntent);
		Toast.makeText(getApplicationContext(), "First Data:" + firstStringData + "Second Data:"+ Integer.toString(secondIntData), Toast.LENGTH_LONG).show();
		//finish();
	}
}

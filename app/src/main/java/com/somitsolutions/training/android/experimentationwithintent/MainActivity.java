package com.somitsolutions.training.android.experimentationwithintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.*;

public class MainActivity extends Activity implements View.OnClickListener{
	Button mButtonCallTheSecondActivity;
	public static final int mRequestCode = 100;
	public static final String intentAction = "com.somitsolutions.training.android.experimentationwithintent.testaction";
	//public static final String intentCategory = "com.somitsolutions.training.android.experimentationwithintent.testcategory";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mButtonCallTheSecondActivity = (Button)findViewById(R.id.button1);
		mButtonCallTheSecondActivity.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.equals(mButtonCallTheSecondActivity)){
			
			//Explicit Intent calling Asynchronously
			//Passing the data to the called Intent through the function putExtra
			//these data will be received by the called intent through the 
			//function getExtra
			Intent i = new Intent(getApplicationContext(),SecondActivity.class);
			i.putExtra("Key0", "This is the first String Data...");
			//i.putExtra("Key1", 10);
			startActivity(i);
			
			//Implicit  Intent calling
			//Here we need to set the Action and DataType. In the Intent-filter part of the
			//manifest file of the called Activity, we need to set Action Type, Category as Default
			//and the Mime-Type. Here as we have sent plain text, we have set the Data Type
			//as text/plain
			/*Intent i = new Intent();
			i.setAction("com.somitsolutions.training.android.experimentationwithintent.TEST");
			i.setType("text/plain");
			i.putExtra("Key0", "This is the first String Data...");
			i.putExtra("Key1", 10);
			startActivity(i);*/
			
			//Explicit Intent Calling Synchronously
			/*Intent i = new Intent(getApplicationContext(),SecondActivity.class);
			i.putExtra("Key0", "This is the first String Data...");
			i.putExtra("Key1", 10);
			startActivityForResult(i, mRequestCode);*/
			
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == mRequestCode){
			
			if (resultCode == RESULT_OK){
				String returnValue = data.getStringExtra("Key2");
				Toast.makeText(getApplicationContext(), returnValue, Toast.LENGTH_SHORT).show();
			}
			
		}
	}
	
}

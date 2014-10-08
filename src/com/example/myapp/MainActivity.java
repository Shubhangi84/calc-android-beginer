package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	

	  public EditText angka1, angka2;
	  public TextView total;
	  public String num1, num2;
	  public Double hasil;
	  public Spinner spinner;
	  public Button btnsubmit;
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		spinner = (Spinner) findViewById(R.id.dropdownmenu);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.hitung, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		angka1 = (EditText) findViewById(R.id.angka1);
		angka2 = (EditText) findViewById(R.id.angka2);
		total = (TextView) findViewById(R.id.total);
		btnsubmit = (Button) findViewById(R.id.submit);
		
		btnsubmit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				
				String aksi = String.valueOf(spinner.getSelectedItem());
				num1 = angka1.getText().toString();
				num2 = angka2.getText().toString();
				
				double na1 = num1.length() > 0 ? Double.valueOf(num1) : 0;
	            double na2 = num2.length() > 0 ? Double.valueOf(num2) : 0;

				if (aksi.equals("tambah")) {
					
					hasil = na1 + na2;
					
				} else if(aksi.equals("kurang")) {

					hasil = na1 - na2;
					
				} else if(aksi.equals("bagi")) {

					hasil = na1 / na2;
					
				} else {

					hasil = na1 * na2;

				}
				
				total.setText("Hasilnya " + Double.toString(hasil));

				
				/*Toast.makeText(MainActivity.this, 
						"OnItemSelectedListener : " + aksi,
						Toast.LENGTH_SHORT).show();*/
		    	
		    }
		});
		
		
	}

}

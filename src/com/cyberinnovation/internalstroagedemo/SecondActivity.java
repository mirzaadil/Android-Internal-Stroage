package com.cyberinnovation.internalstroagedemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity implements OnClickListener {

	String TAG = "MIRZA";
	private EditText edittext_namee = null;
	private EditText editext_passwordd = null;
	private Button button_load = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		edittext_namee = (EditText) findViewById(R.id.edittext_name_second);
		editext_passwordd = (EditText) findViewById(R.id.edittext_passwrod_second);

		button_load = (Button) findViewById(R.id.button_load);
		button_load.setOnClickListener(this);
		edittext_namee.getText().toString();
		editext_passwordd.getText().toString();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.button_load:

			try {
				FileInputStream fileInputStream = openFileInput(ConstantApp.FILE_NAME);
				int read = -1;
				try {
					StringBuffer buffer = new StringBuffer();
					while ((read = fileInputStream.read()) != -1) {

						buffer.append((char) read);

					}
					Log.d(TAG, "File Data get ::" + buffer.toString());
					String user_info = buffer.toString();
					String a[] = user_info.split(" ");

					edittext_namee.setText(a[0]);
					editext_passwordd.setText(a[1]);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		// case R.id.button_secondActivity:
		// startActivity(new Intent(this, MainActivity.class));
		default:
			break;
		}
	}
}

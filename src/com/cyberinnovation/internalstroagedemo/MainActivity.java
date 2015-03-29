package com.cyberinnovation.internalstroagedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	String TAG = "MIRZA";
	private EditText exittext_name = null;
	private EditText edittext_password = null;
	private Button button_save = null;
	private Button button_move = null;
	String User_name;
	String user_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		exittext_name = (EditText) findViewById(R.id.edittext_name);
		edittext_password = (EditText) findViewById(R.id.edittext_passwrod);

		button_save = (Button) findViewById(R.id.button_saveData);
		button_move = (Button) findViewById(R.id.button_second_Activity);
		button_save.setOnClickListener(this);
		button_move.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_saveData:

			saveDate();
			break;
		case R.id.button_second_Activity:
			Intent intent = new Intent(this, SecondActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	private void saveDate() {

		Log.d(TAG, "On save Method");
		User_name = exittext_name.getText().toString();
		user_password = edittext_password.getText().toString();

		User_name = User_name + " ";

		File file = null;
		FileOutputStream fileOutputStream = null;
		try {
			file = getFilesDir();
			fileOutputStream = openFileOutput(ConstantApp.FILE_NAME,
					Context.MODE_PRIVATE);
			try {
				fileOutputStream.write(User_name.getBytes());
				fileOutputStream.write(user_password.getBytes());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Toast.makeText(getApplicationContext(),
				"File Save Successfully" + file.toString(), Toast.LENGTH_LONG)
				.show();
	}
}

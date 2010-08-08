package org.moo.android.filebrowser;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CreateFolderDialog extends Dialog {

	
public CreateFolderDialog(Context context) {
		super(context);
	}

	public interface ReadyListener{
		public void ready(String dirname);
	}
	
	protected ReadyListener readyListener;
	
	public CreateFolderDialog(Context context, ReadyListener readyListener)
	{
		super(context);
		this.readyListener = readyListener; 
	}

	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setTitle(R.string.folder_add);
		setContentView(R.layout.create_folder);
		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, android.R.drawable.ic_menu_add);
		Button create = (Button) findViewById(R.id.create_button);
		
		create.setOnClickListener(new OKListener());
	}

	private class OKListener implements android.view.View.OnClickListener {
		@Override
		public void onClick(View v) {
			EditText input = (EditText) findViewById(R.id.new_folder_name);
			readyListener.ready(input.getText().toString());
			CreateFolderDialog.this.dismiss();
		}
	}
	
}

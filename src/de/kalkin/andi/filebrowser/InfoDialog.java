/**
 *  Show information about file or directory
 */
package de.kalkin.andi.filebrowser;

import java.io.File;
import java.io.FilePermission;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

/**
 * @author kalkin
 * 
 */
public class InfoDialog extends Dialog {

	private File file;

	public InfoDialog(Context context, File infoFile) {
		super(context);
		file = infoFile;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setTitle(R.string.info);
		setContentView(R.layout.info_dialog);
		((TextView) findViewById(R.id.nameValue)).setText(file.getName());
		((TextView) findViewById(R.id.sizeValue)).setText("" + file.length());
		String date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date(file.lastModified()));
		((TextView) findViewById(R.id.changedValue)).setText(date);
		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				android.R.drawable.ic_menu_info_details);
	}

}

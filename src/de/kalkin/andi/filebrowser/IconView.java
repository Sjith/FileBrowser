package de.kalkin.andi.filebrowser;

/*
 * Copyright (c) 2009, Moo Productions
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice, this list of 
 *   conditions and the following disclaimer.
 * 
 * - Redistributions in binary form must reproduce the above copyright notice, this list 
 *   of conditions and the following disclaimer in the documentation and/or other materials 
 *   provided with the distribution.
 * 
 * - Neither the name of the Moo Productions nor the names of its contributors may be used 
 *   to endorse or promote products derived from this software without specific prior written 
 *   permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS 
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY 
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IconView extends LinearLayout
{
	protected ImageView mIcon;
	protected TextView mFileName;

	public IconView(Context context, int iconResId, String fileName)
	{
		super(context);
		
		this.setOrientation(VERTICAL);
		this.setPadding(3, 3, 3, 3);
		this.setGravity(Gravity.CENTER_HORIZONTAL);
		
		mIcon = new ImageView(context);
		mIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);
		mIcon.setImageResource(iconResId);
		addView(mIcon, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		
		mFileName = new TextView(context);
		mFileName.setSingleLine();
		mFileName.setEllipsize(TextUtils.TruncateAt.END);
		mFileName.setText(fileName);
		addView(mFileName, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	}
	
	public void select()
	{
		mFileName.setEllipsize(TextUtils.TruncateAt.MARQUEE);
	}
	
	public void deselect()
	{
		mFileName.setEllipsize(TextUtils.TruncateAt.END);
	}
	
	public void setIconResId(int resId)
	{
		mIcon.setImageResource(resId);
	}

	public void setFileName(String fileName)
	{
		mFileName.setText(fileName);
	}

	public String getFileName()
	{
		return mFileName.getText().toString();
	}
}

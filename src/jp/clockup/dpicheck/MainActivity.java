package jp.clockup.dpicheck;

import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	public MainActivity()
	{
		Log.d("appstate", "construct");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 表示TextView
		TextView text1 = (TextView)findViewById(R.id.textView1);
		TextView text2 = (TextView)findViewById(R.id.textView2);
		TextView text3 = (TextView)findViewById(R.id.textView3);
		TextView text4 = (TextView)findViewById(R.id.textView4);
		
		// モデル名
		
		// DPI
		DisplayMetrics metrics = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		String dpi = "";
		if (metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH) {
			dpi = "xdpi";
		}
		else if (metrics.densityDpi == DisplayMetrics.DENSITY_HIGH) {
			dpi = "hdpi";
		}
		else if (metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM) {
			dpi = "mdpi";
		}
		else if (metrics.densityDpi == DisplayMetrics.DENSITY_LOW) {
			dpi = "ldpi";
		}
		else{
			dpi = "unknown";
		}
		text1.setText("DPI: " + dpi);
		
		// 解像度
		String pixels = "";
		pixels = String.format("%d x %d", metrics.widthPixels, metrics.heightPixels);
		text2.setText("PIXELS: " + pixels);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

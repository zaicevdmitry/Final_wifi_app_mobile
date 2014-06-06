package by.zaicev.app.utils.wifi;

import java.util.Timer;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import by.salin.app.R;

public class MainActivity extends Activity
{
	private WifiManager wifi;
	private ScanTask scanner;
	private ScanResultReceiver receiver;
	private Timer timer;
	private static ViewHolder holder;
	static MainActivity ma;
	public static ViewHolder getHolder()
	{
		return holder;
	}
/*
	public void i(String info)
	{
		holder.i(info);
	}
*/
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.e("tag", getMacAddress(this));
		setContentView(R.layout.activity_main);
		holder = new ViewHolder(this);
		//i("started");
		ma = this;
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		timer = new Timer();
		scanner = new ScanTask(this);

		//i("begin registr receiver");
		receiver = new ScanResultReceiver();
		IntentFilter receiverRegisterIntent = new IntentFilter();
		receiverRegisterIntent.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
		registerReceiver(receiver, receiverRegisterIntent);
		//i(" ");

        if(wifi.isWifiEnabled())
        {
        	holder.setChangesText(""+ wifi.getConnectionInfo().getNetworkId());
        	wifi.startScan();
        }
        else
        {        
        	wifi.setWifiEnabled(true);
    		timer.scheduleAtFixedRate(scanner, 0, 500);
        }
        

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Get self mac address
	 * 
	 * @param context
	 * @return
	 */
	private String getMacAddress(Context context)
	{
		WifiManager wimanager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		String macAddress = wimanager.getConnectionInfo().getMacAddress();
		if(macAddress == null)
		{
			macAddress = "Device don't have mac address or wi-fi is disabled";
		}
		return macAddress;
	}
	
	class ViewHolder
	{
		//TextView status;
		//TextView coords;
		TextView changes;

		ViewHolder(Activity activity)
		{
			super();
			//status = (TextView) activity.findViewById(R.id.status_title);
			//coords = (TextView) activity.findViewById(R.id.status_coord);
			changes = (TextView) activity.findViewById(R.id.status_changes);
		}
		/*
		public void setStatusText(String text)
		{
			status.setText(text);
		}

		public void setCoordsText(String text)
		{
			coords.setText(text);
		}
*/
		public void setChangesText(String text)
		{
			changes.setText(text);
		}
/*
		public void i(String info)
		{
			setStatusText(info);
		}*/
	}
	
}

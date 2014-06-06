package by.zaicev.app.utils.wifi;

import java.util.List;

import by.zaicev.app.WIFIApplication;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;


public class ScanResultReceiver extends BroadcastReceiver{
	
	private List<ScanResult> scans;
	private Thread checkScunResultThread;
	private WeightedScanFactory wsFactory;
	
	
	
	
	public ScanResultReceiver() {
		super();
		wsFactory = new WeightedScanFactory(WIFIApplication.getApplication().getApplicationContext());
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		wifi.startScan();
		
		scans = wifi.getScanResults();
		if(scans != null)
		{
			if((checkScunResultThread==null || !checkScunResultThread.isAlive()))
			{
				//Average location
				ScanCounter sc = new ScanCounter(this, scans, wsFactory);
				checkScunResultThread = new Thread(sc);
				checkScunResultThread.setName("Scan Counter");
				checkScunResultThread.start();
			}
		}
	}



}

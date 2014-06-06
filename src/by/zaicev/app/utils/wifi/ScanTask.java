/*
 * ECE 480 Spring 2011
 * Team 2 Design Project
 * Matt Gottshall
 * Jake D'Onofrio
 * Gordie Stein
 * Andrew Kling
 */
package by.zaicev.app.utils.wifi;

import java.util.TimerTask;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;

/**The task to be performed by the timer.  Start the first scan.*/
public class ScanTask extends TimerTask{
    Context context;
    
    Handler handler = new Handler();
    
    boolean started = false;
    
    int count  = 0;

    public ScanTask(Context context) {
        this.context = context;
    }

    //This timer will initialize the scanning.
    public void run() 
    {
        handler.post(new Runnable() 
        {
            public void run() 
            {
            	WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        		if(wifi != null)
        		{
        			if(!started)
        			{
        				wifi.startScan();
        				started = true;
        			}
        		}
            }
        });
    }
}
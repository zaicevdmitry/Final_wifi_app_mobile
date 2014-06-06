/**
 * 
 */
package by.zaicev.app;

import android.app.Application;


public class WIFIApplication extends Application
{
	private static WIFIApplication mApplication;

	@Override
	public void onCreate()
	{
		super.onCreate();
		mApplication = this;
	}

	public static WIFIApplication getApplication()
	{
		return mApplication;
	}

}

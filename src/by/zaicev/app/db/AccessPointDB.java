/*
 * ECE 480 Spring 2011
 * Team 2 Design Project
 * Matt Gottshall
 * Jake D'Onofrio
 * Gordie Stein
 * Andrew Kling
 */
package by.zaicev.app.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This is an object to hold the list of dowloaded APs and their location
 * 
 */
// A database that will map an ssid to an xyz location
public class AccessPointDB
{
	private HashMap<String, LinkedList<Float>> accessPoints;

	// private static final int x=0;
	// private static final int y=1;
	// private static final int z=2;
	//
	// private iDocent miD;
	public AccessPointDB()
	{
		accessPoints = new HashMap<String, LinkedList<Float>>();
		initDBSpots();
	}

	/**
	 * Obtain the location of an access point given the mac address
	 * 
	 * {@link GetLocation}.
	 * 
	 * @param mac
	 *            - the MAC address of the desired access point
	 * @return List<Float> - the access point's location stored in a list (x y
	 *         z)
	 * 
	 */
	public List<Float> GetLocation(String mac)
	{
		return accessPoints.get(mac.toLowerCase());
	}

	/**
	 * Start scanning APs. Checks if there is a live connection with the server
	 * then downloads the list of APs.
	 * 
	 * @return boolean - true if the list was downloaded
	 */
	public boolean initDBSpots()
	{

		/*LinkedList<Float> l1 = new LinkedList<Float>();
		float[] f = { Float.valueOf(100f), Float.valueOf(-100f), Float.valueOf(100f) };
		l1.add(f[0]);
		l1.add(f[1]);
		l1.add(f[2]);
		//accessPoints.put("98:fc:11:8e:46:f0", l1); // intex 1
		accessPoints.put("00:22:93:c4:40:24", l1);*/ // sata
		LinkedList<Float> lAP1 = new LinkedList<Float>();
		float[] fAP1 = { Float.valueOf(100f), Float.valueOf(100f), Float.valueOf(0f) };
		lAP1.add(fAP1[0]);
		lAP1.add(fAP1[1]);
		lAP1.add(fAP1[2]);
		accessPoints.put("60:a1:0a:f2:0c:b6", lAP1); // test1
		//accessPoints.put("20:54:76:8d:34:8c", lAP1); // Wifi
		//accessPoints.put("10:d5:42:84:c6:b4", lAP1); // Wifi

		/*LinkedList<Float> l3 = new LinkedList<Float>();
		float[] f3 = { Float.valueOf(50f), Float.valueOf(50f), Float.valueOf(-20f) };
		l3.add(f3[0]);
		l3.add(f3[1]);
		l3.add(f3[2]);
		//accessPoints.put("00:23:69:19:71:e6", l3); // intex 2
		accessPoints.put("00:26:ed:a3:fb:c6", l3); // ZTE-76
*/
		LinkedList<Float> l4 = new LinkedList<Float>();
		float[] f4 = { Float.valueOf(100f), Float.valueOf(-100f), Float.valueOf(0f) };
		l4.add(f4[0]);
		l4.add(f4[1]);
		l4.add(f4[2]);
		
		accessPoints.put("78:1d:ba:27:7b:0b", l4); // Tamogoch2
		//accessPoints.put("38:e7:d8:d8:a6:f9", l4); // HTC Desir
		
		
		
		LinkedList<Float> l2 = new LinkedList<Float>();
		float[] f2 = { Float.valueOf(-100f), Float.valueOf(100f), Float.valueOf(0f) };
		l2.add(f2[0]);
		l2.add(f2[1]);
		l2.add(f2[2]);
		//accessPoints.put("38:e7:d8:d8:a6:f9", l2); // Desir
		//accessPoints.put("02:1a:11:fb:55:da", l2); // Nexus S
		//accessPoints.put("38:e7:d8:d8:a6:f9", l2); // HTC Desir
		accessPoints.put("02:1a:11:f2:d9:75", l4); //HTC ONE
		
		LinkedList<Float> lAP3 = new LinkedList<Float>();
		float[] fAP3 = { Float.valueOf(-100f), Float.valueOf(-100f), Float.valueOf(0f) };
		lAP3.add(fAP3[0]);
		lAP3.add(fAP3[1]);
		lAP3.add(fAP3[2]);
		accessPoints.put("78:1d:ba:27:7b:03", lAP3); //Tamogoch
		//accessPoints.put("02:1a:11:f7:a7:bd", lAP3);//HTC ONE
		
		return true;
	}

}

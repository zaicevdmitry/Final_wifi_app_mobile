package by.zaicev.app.utils.wifi;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import by.zaicev.app.utils.wifi.ScanCounter.Phone;

import com.google.gson.Gson;

public class SendData implements Runnable{
	
	private Phone x,y,id;
	
	public SendData(Phone phone)	{
		this.x=phone;
		
	}
	
	@Override
	public void run() {
		
		Gson gson = new Gson();
        String jsonData = gson.toJson(x);

        HttpClient httpClient = new DefaultHttpClient();

        try {
            HttpPost request = new HttpPost("http://192.168.0.185:8081/service/api/sendData");
            StringEntity params =new StringEntity(jsonData);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
        }catch(Exception e){}

	}

}

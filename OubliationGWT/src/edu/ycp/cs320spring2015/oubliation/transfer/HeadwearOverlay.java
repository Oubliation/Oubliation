package edu.ycp.cs320spring2015.oubliation.transfer;

import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;

public class HeadwearOverlay extends EquipmentOverlay<Headwear> {
	protected HeadwearOverlay() {}
	
	static public void getAllData(String filename, final DataCallback<Headwear[]> callback) {
		String url = URL.encode(GWT.getModuleBaseURL() + filename);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					Window.alert("Couldn't retrieve JSON");
				}
				
				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						JsArray<HeadwearOverlay> jsonArray = JsonUtils.<JsArray<HeadwearOverlay>>safeEval(response.getText());
						LinkedList<Headwear> dataList = new LinkedList<Headwear>();
						for (int count=0; count<jsonArray.length(); count+=1) {
							dataList.add(jsonArray.get(count).getData());
						}
						Headwear[] dataArray = dataList.toArray(new Headwear[dataList.size()]);
						callback.recieve(dataArray);
					} else {
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e) {
		  Window.alert("Couldn't retrieve JSON");
		}
	}
	
	public Headwear getData() {
		return new Headwear(getNameTag(), getPrice(), getJobSet(), getAr());
	}
}

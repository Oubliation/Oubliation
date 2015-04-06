package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.StatusCodeException;

public class EntityResourceMap<O extends EntityOverlay> implements Map<String, O> {
	private HashMap<String, O> resourceMap = new HashMap<String, O>();
	final private int totalFiles;
	private int fileCount = 0;
	
	protected EntityResourceMap(String[] filepaths, final AsyncCallback<EntityResourceMap<O>> callback) {
		final EntityResourceMap<O> that = this;
		totalFiles = filepaths.length;
		try {
			for (String filepath : filepaths) {
				String url = URL.encode(filepath);
				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
				builder.sendRequest(null, new RequestCallback() {
					public void onError(Request request, Throwable exception) {
						callback.onFailure(exception);
					}
					
					public void onResponseReceived(Request request, Response response) {
						if (200 == response.getStatusCode()) {
							JsArray<O> jsonArray = JsonUtils.<JsArray<O>>safeEval(response.getText());
	
							for (int count=0; count<jsonArray.length(); count+=1) {
								O overlay = jsonArray.get(count);
								resourceMap.put(overlay.getName(), overlay);
							}
							fileCount += 1;
							if (fileCount == totalFiles) {
								callback.onSuccess(that);
							}
						} else {
							callback.onFailure(new StatusCodeException(response.getStatusCode(), response.getStatusText()));
						}
					}
				});
			}
		} catch (RequestException exception) {
			callback.onFailure(exception);
		}
	}

	public void clear() {
		resourceMap.clear();
	}

	public boolean containsKey(Object key) {
		return resourceMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return resourceMap.containsValue(value);
	}

	public Set<java.util.Map.Entry<String, O>> entrySet() {
		return resourceMap.entrySet();
	}

	public boolean equals(Object o) {
		return resourceMap.equals(o);
	}

	public O get(Object key) {
		return resourceMap.get(key);
	}

	public int hashCode() {
		return resourceMap.hashCode();
	}

	public boolean isEmpty() {
		return resourceMap.isEmpty();
	}

	public Set<String> keySet() {
		return resourceMap.keySet();
	}

	public O put(String key, O value) {
		return resourceMap.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends O> m) {
		resourceMap.putAll(m);
	}

	public O remove(Object key) {
		return resourceMap.remove(key);
	}

	public int size() {
		return resourceMap.size();
	}

	public String toString() {
		return resourceMap.toString();
	}

	public Collection<O> values() {
		return resourceMap.values();
	}
}

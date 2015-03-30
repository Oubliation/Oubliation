package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dev.util.collect.HashMap;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.StatusCodeException;

import edu.ycp.cs320spring2015.oubliation.shared.Entity;

class EntityResourceMap<E extends Entity, O extends EntityOverlay<E>> implements Map<String, E> {
	private HashMap<String, E> resourceMap = new HashMap<String, E>();
	final int totalFiles;
	int fileCount = 0;
	
	EntityResourceMap(String[] filenames, final AsyncCallback<EntityResourceMap<E, O>> callback) {
		final EntityResourceMap<E, O> that = this;
		totalFiles = filenames.length;
		try {
			for (String filename : filenames) {
				String url = URL.encode(GWT.getModuleBaseURL() + filename);
				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
				builder.sendRequest(null, new RequestCallback() {
					public void onError(Request request, Throwable exception) {
						callback.onFailure(exception);
					}
					
					public void onResponseReceived(Request request, Response response) {
						if (200 == response.getStatusCode()) {
							JsArray<O> jsonArray = JsonUtils.<JsArray<O>>safeEval(response.getText());
	
							for (int count=0; count<jsonArray.length(); count+=1) {
								E entity = jsonArray.get(count).getData();
								resourceMap.put(entity.getName(), entity);
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

	public E compute(String key,
			BiFunction<? super String, ? super E, ? extends E> remappingFunction) {
		return resourceMap.compute(key, remappingFunction);
	}

	public E computeIfAbsent(String key,
			Function<? super String, ? extends E> mappingFunction) {
		return resourceMap.computeIfAbsent(key, mappingFunction);
	}

	public E computeIfPresent(String key,
			BiFunction<? super String, ? super E, ? extends E> remappingFunction) {
		return resourceMap.computeIfPresent(key, remappingFunction);
	}

	public boolean containsKey(Object key) {
		return resourceMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return resourceMap.containsValue(value);
	}

	public Set<java.util.Map.Entry<String, E>> entrySet() {
		return resourceMap.entrySet();
	}

	public boolean equals(Object o) {
		return resourceMap.equals(o);
	}

	public void forEach(BiConsumer<? super String, ? super E> action) {
		resourceMap.forEach(action);
	}

	public E get(Object key) {
		return resourceMap.get(key);
	}

	public E getOrDefault(Object key, E defaultValue) {
		return resourceMap.getOrDefault(key, defaultValue);
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

	public E merge(String key, E value,
			BiFunction<? super E, ? super E, ? extends E> remappingFunction) {
		return resourceMap.merge(key, value, remappingFunction);
	}

	public E put(String key, E value) {
		return resourceMap.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends E> m) {
		resourceMap.putAll(m);
	}

	public E putIfAbsent(String key, E value) {
		return resourceMap.putIfAbsent(key, value);
	}

	public boolean remove(Object key, Object value) {
		return resourceMap.remove(key, value);
	}

	public E remove(Object key) {
		return resourceMap.remove(key);
	}

	public boolean replace(String key, E oldValue, E newValue) {
		return resourceMap.replace(key, oldValue, newValue);
	}

	public E replace(String key, E value) {
		return resourceMap.replace(key, value);
	}

	public void replaceAll(
			BiFunction<? super String, ? super E, ? extends E> function) {
		resourceMap.replaceAll(function);
	}

	public int size() {
		return resourceMap.size();
	}

	public String toString() {
		return resourceMap.toString();
	}

	public Collection<E> values() {
		return resourceMap.values();
	}
}

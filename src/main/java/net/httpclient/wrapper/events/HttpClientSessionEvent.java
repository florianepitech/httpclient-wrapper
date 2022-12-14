package net.httpclient.wrapper.events;

import net.httpclient.wrapper.session.HttpClientSession;

import java.util.ArrayList;
import java.util.List;

/**
 * This static class manage the HttpClientSession events.
 */
public class HttpClientSessionEvent {

    private static final ArrayList<HttpClientSessionListener> httpClientSessionBasics = new ArrayList<>();

    /*
     $      Add and remove listeners
     */

    /**
     * Add a listener to the list of listeners.
     * @param listener The listener to add.
     */
    public static void addHttpClientSessionListener(HttpClientSessionListener listener) {
        synchronized (httpClientSessionBasics) {
            httpClientSessionBasics.add(listener);
        }
    }

    /**
     * Remove a listener from the list of listeners.
     * @param listener The listener to remove.
     */
    public static void removeHttpClientSessionListener(HttpClientSessionListener listener) {
        synchronized (httpClientSessionBasics) {
            httpClientSessionBasics.remove(listener);
        }
    }

    /*
     $      Trigger events
     */

    /**
     * Trigger the event onHttpClientCookiesUpdated in all listeners.
     * @param httpClientSession The HttpClientSession who has updated his cookies.
     */
    public static void triggerHttpClientCookiesUpdated(HttpClientSession httpClientSession) {
        synchronized (httpClientSessionBasics) {
            httpClientSessionBasics.forEach(listener -> listener.onHttpClientCookiesUpdated(httpClientSession));
        }
    }


    /*
     $      Getters
     */

    /**
     * This method return a list copy of the listeners.
     * @return A list copy of the listeners.
     */
    public static List<HttpClientSessionListener> getHttpClientSessionListeners() {
        synchronized (httpClientSessionBasics) {
            return new ArrayList<>(httpClientSessionBasics);
        }
    }

}

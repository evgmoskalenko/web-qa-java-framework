package com.testframework.apps.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Response {

    private String url;

    public Response() {
    }

    public Response(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponseCode(String urlValue) throws IOException {
        URL url = new URL(urlValue);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return String.valueOf(http.getResponseCode());
    }

}

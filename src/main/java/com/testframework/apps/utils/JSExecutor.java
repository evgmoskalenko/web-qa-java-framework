package com.testframework.apps.utils;

import com.codeborne.selenide.Selenide;

import java.util.Objects;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.fail;

public class JSExecutor {

    public JSExecutor(){
        if(!Objects.equals(baseUrl, "http://localhost:8080")) {
            Selenide.executeJavaScript("$(document).ready()");
        } else {
            fail("Because base url is equals 'http://localhost:8080'");
        }
    }

    public void POSTWithParams(final String requestUrl, final String param){
        Selenide.executeJavaScript(String.format("$.post('%s%s', %s).done()", baseUrl, requestUrl, param));
        sleep(300);
    }

    public void GETWithParam(final String requestUrl, final String param){
        Selenide.executeJavaScript(String.format("$.get('%s', %s).done()", requestUrl, param));
        sleep(300);
    }

    /**
     * Make GET request to baseUrl
     * @param request
     * request with params
     */
    public void GETRequest(final String request){
        Selenide.executeJavaScript(String.format("$.get('%s%s').done()", baseUrl, request));
    }

}

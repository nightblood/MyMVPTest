package com.zlf.mytest.http;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Response;

/**
 * Created by zlf on 2017/1/9.
 */
public class RequestIntercept implements okhttp3.Interceptor {

    private GlobalHttpHandler mHandler;

    @Inject
    public RequestIntercept(GlobalHttpHandler httpHandler) {
        mHandler = httpHandler;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // TODO
        return null;
    }



}

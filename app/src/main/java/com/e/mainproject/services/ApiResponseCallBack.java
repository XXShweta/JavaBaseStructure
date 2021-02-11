package com.e.mainproject.services;

public interface ApiResponseCallBack<S> {
    void onSuccess(S value);
    void onError(String error, int code);

}

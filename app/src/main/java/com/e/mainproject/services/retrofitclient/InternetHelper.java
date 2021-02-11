package com.e.mainproject.services.retrofitclient;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import javax.inject.Inject;

public class InternetHelper {

    Context context;

    @Inject
    public InternetHelper(Context context){
        this.context = context;
    }

    public Boolean isInternetConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE) ;

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            Network network = connectivityManager.getActiveNetwork();
            if(network == null){
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
                return true;
            if(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
                return true;
            return false;
        }else {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo.isConnected();
        }
    }
}

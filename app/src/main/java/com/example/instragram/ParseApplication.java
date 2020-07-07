package com.example.instragram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Copied and pasted from instructions:
        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("chianna-insta") // should correspond to APP_ID env variable
                .clientKey("jsdkhafkadfkjahdfcdasd")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://chianna-insta.herokuapp.com/parse").build()); // wants to make sure it's https
    }
}

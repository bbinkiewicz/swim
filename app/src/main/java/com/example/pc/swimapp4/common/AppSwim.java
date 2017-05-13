package com.example.pc.swimapp4.common;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;



public class AppSwim extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        Realm.deleteRealm(config);


    }
}

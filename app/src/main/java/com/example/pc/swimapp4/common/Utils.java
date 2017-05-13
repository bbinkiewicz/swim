package com.example.pc.swimapp4.common;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by PC on 2017-05-11.
 */

public class Utils {

    public static void addToDatabase(RealmObject o){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(o);
        realm.commitTransaction();
        realm.close();

    }
}

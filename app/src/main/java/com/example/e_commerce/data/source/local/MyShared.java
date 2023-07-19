package com.example.e_commerce.data.source.local;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;

public class MyShared {
    private static SharedPreferences sharedPreferences = null;

    public static void   init(Context context){
        if (sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("usersData" , Context.MODE_PRIVATE);
        }
    }


 /*   public static SharedPreferences getShared(Context context){
        if (sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("usersData" , Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }*/
    public static void saveString(SharedKeys key , String value){
        sharedPreferences.edit().putString(key.name() , value).apply();


    }
    public static String getString(SharedKeys key){
        return sharedPreferences.getString(key.name() , "");
    }

}

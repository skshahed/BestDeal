package com.example.forever.bestdeal.DatabaseSource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.forever.bestdeal.DatabaseHelper.AdvertiseDataabaseHelper;

/**
 * Created by Ashif Rahman on 5/24/2017.
 */

public class AdvertiseDatabaseSource {
    private AdvertiseDataabaseHelper advertiseDataabaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public AdvertiseDatabaseSource(Context context) {
        advertiseDataabaseHelper = new AdvertiseDataabaseHelper(context);

    }

    public void open()
    {
        sqLiteDatabase = advertiseDataabaseHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteDatabase.close();

    }


}

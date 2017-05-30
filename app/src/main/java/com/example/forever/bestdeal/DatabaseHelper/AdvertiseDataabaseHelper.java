package com.example.forever.bestdeal.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashif Rahman on 5/24/2017.
 */

public class AdvertiseDataabaseHelper  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ADVERTISE_GET_SENT";
    public static final int DATABASE_VERSION = 1;


    //start public user table
        public static final String ADV_PUBLIC_USER_INFO = "adv_public_user_info";

        public static final String P_USER_ID = "user_id";
        public static final String USER_FULL_NAME = "full_name";
        public static final String USER_EMAIL = "user_email";
        public static final String USER_PASSWORD = "password";
        public static final String USER_CONTACT_NO = "user_contact_no";
        public static final String USER_ADDRESS = "address";
        public static final String CREATE_SYSTEM_PUBLIC_USER_TABLE = "create table " +ADV_PUBLIC_USER_INFO+"("+
                P_USER_ID+" integer primary key, "+
                USER_FULL_NAME+" text, "+
                USER_EMAIL+" text, "+
                USER_PASSWORD+" text, "+
                USER_CONTACT_NO+" text, "+
                USER_ADDRESS+" text);";
    //end public user table


    //start category main table
        public static final String ADV_CAT_MAIN = "adv_cat_main";

        public static final String CAT_MAIN_ID = "cat_main_id";
        public static final String CAT_MAIN_NAME = "cat_main_name";
        public static final String CREATE_CAT_MAIN_TABLE = "create table " +ADV_CAT_MAIN+"("+
                CAT_MAIN_ID+" integer primary key, "+
                CAT_MAIN_NAME+" text);";
    //end category main table


        //start category child table
            public static final String ADV_CAT_CHILD = "adv_cat_child"; //Relational table

            public static final String CAT_CHILD_ID = "cat_child_id";
            public static final String CAT_CHILD_MAIN_ID = "cat_child_main_id"; //Relation with main category
            public static final String CAT_CHILD_NAME = "cat_child_name";
            public static final String CREATE_CAT_CHILD_TABLE = "create table " +ADV_CAT_CHILD+"("+
                    CAT_CHILD_ID+" integer primary key, "+
                    CAT_CHILD_MAIN_ID+" text, "+
                    CAT_CHILD_NAME+" text);";
        //end category child table


    //start advertise info table
        public static final String ADV_ADVERTISE_INFO       = "advertise_info"; //advertise table name

        public static final String ADVERTISE_ID         = "advertise_id";
        public static final String PUBLIC_USER_ID       = "public_user_id";
        public static final String ADVERTISE_MAIN_CAT   = "advertise_main_cat";
        public static final String ADVERTISE_CHILD_CAT  = "advertise_child_cat";
        public static final String ADVERTISE_DATE_TIME  = "advertise_date_time";
        public static final String ADVERTISE_TITLE      = "advertise_title";
        public static final String ADVERTISE_DETAILS    = "advertise_details";
        public static final String ADVERTISE_PRICE      = "advertise_price";
        public static final String CREATE_ADVERTISE_INFO_TABLE = "create  table " +ADV_ADVERTISE_INFO+"("+
                ADVERTISE_ID+" integer primary key, "+
                PUBLIC_USER_ID+" text, "+
                ADVERTISE_MAIN_CAT+" text, "+
                ADVERTISE_CHILD_CAT+" text, "+
                ADVERTISE_DATE_TIME+" text, "+
                ADVERTISE_TITLE+" text, "+
                ADVERTISE_DETAILS+" text, "+
                ADVERTISE_PRICE+" text);";
    //end advertise info table


        //start advertise info photo file
            public static final String ADV_PHOTO_FILE = "adv_photo_file"; //Relational table

            public static final String ADVERTISE_PHOTO_FILE_ID = "advertise_photo_file_id";
            public static final String PHOTO_FILE_ADVERTISE_ID = "advertise_id";   //Relation with main category
            public static final String PHOTO_FILE_PATH = "advertise_photo_file_path";
            public static final String CREATE_ADV_PHOTO_FILE_TABLE = "create table " +ADV_PHOTO_FILE+"("+
                    ADVERTISE_PHOTO_FILE_ID+" integer primary key, "+
                    PHOTO_FILE_ADVERTISE_ID+" text, "+
                    PHOTO_FILE_PATH+" text);";
        //end advertise info photo file

    public AdvertiseDataabaseHelper(Context context) {
        super(context, DATABASE_NAME,  null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SYSTEM_PUBLIC_USER_TABLE);
        db.execSQL(CREATE_CAT_MAIN_TABLE);
        db.execSQL(CREATE_CAT_CHILD_TABLE);
        db.execSQL(CREATE_ADVERTISE_INFO_TABLE);
        db.execSQL(CREATE_ADV_PHOTO_FILE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ADV_PUBLIC_USER_INFO);
        db.execSQL("drop table if exists "+ADV_CAT_MAIN);
        db.execSQL("drop table if exists "+ADV_CAT_CHILD);
        db.execSQL("drop table if exists "+ADV_PUBLIC_USER_INFO);
        db.execSQL("drop table if exists "+ADV_PHOTO_FILE);
        onCreate(db);

    }
    public void clearDatabase(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ADV_PUBLIC_USER_INFO,null,null);
        db.delete(ADV_CAT_MAIN,null,null);
        db.delete(ADV_CAT_CHILD,null,null);
        db.delete(ADV_PUBLIC_USER_INFO,null,null);
        db.delete(ADV_PHOTO_FILE,null,null);
        db.close();
    }
}


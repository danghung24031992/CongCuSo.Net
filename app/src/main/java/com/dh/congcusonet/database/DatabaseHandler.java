package com.dh.congcusonet.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DH on 6/26/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "congcuso";
    private static final String TABLE_CONTACTS = "xsmb";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + Constant.TAG_KETQUAID + " INTEGER PRIMARY KEY,"
                + Constant.TAG_GDB + " TEXT,"
                + Constant.TAG_GNHAT + " TEXT"
                + Constant.TAG_GHAI1 + " TEXT"
                + Constant.TAG_GHAI2 + " TEXT"
                + Constant.TAG_GBA1 + " TEXT"
                + Constant.TAG_GBA2 + " TEXT"
                + Constant.TAG_GBA3 + " TEXT"
                + Constant.TAG_GBA4 + " TEXT"
                + Constant.TAG_GBA5 + " TEXT"
                + Constant.TAG_GBA6 + " TEXT"
                + Constant.TAG_GBON1 + " TEXT"
                + Constant.TAG_GBON2 + " TEXT"
                + Constant.TAG_GBON3 + " TEXT"
                + Constant.TAG_GBON4 + " TEXT"
                + Constant.TAG_GNAM1 + " TEXT"
                + Constant.TAG_GNAM2 + " TEXT"
                + Constant.TAG_GNAM3 + " TEXT"
                + Constant.TAG_GNAM4 + " TEXT"
                + Constant.TAG_GNAM5 + " TEXT"
                + Constant.TAG_GNAM6 + " TEXT"
                + Constant.TAG_GSAU1 + " TEXT"
                + Constant.TAG_GSAU2 + " TEXT"
                + Constant.TAG_GSAU3 + " TEXT"
                + Constant.TAG_GBAY1 + " TEXT"
                + Constant.TAG_GBAY2 + " TEXT"
                + Constant.TAG_GBAY3 + " TEXT"
                + Constant.TAG_GBAY4 + " TEXT"
                + Constant.TAG_KQLOCUOI + " TEXT"
                + Constant.TAG_KQLODAU + " TEXT"
                + Constant.TAG_CHUOISO + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.dh.congcusonet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dh.congcusonet.XSBean;

import java.util.ArrayList;

/**
 * Created by DH on 6/26/2015.
 */
public class DatabaseHelper {

    private static final String DB_NAME = "congcuso.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "xsmb";
    private SQLiteDatabase database;
    private Context mContext;
    private OpenHelper helper;

    private XSBean xsBean;

    public DatabaseHelper(Context context) {
        this.mContext = context;
        helper = new OpenHelper(mContext);
        database = helper.getWritableDatabase();
    }

    public class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + Constant.TAG_KETQUAID + " INTEGER PRIMARY KEY,"
                    + Constant.TAG_GDB + " TEXT,"
                    + Constant.TAG_GNHAT + " TEXT,"
                    + Constant.TAG_GHAI1 + " TEXT,"
                    + Constant.TAG_GHAI2 + " TEXT,"
                    + Constant.TAG_GBA1 + " TEXT,"
                    + Constant.TAG_GBA2 + " TEXT,"
                    + Constant.TAG_GBA3 + " TEXT,"
                    + Constant.TAG_GBA4 + " TEXT,"
                    + Constant.TAG_GBA5 + " TEXT,"
                    + Constant.TAG_GBA6 + " TEXT,"
                    + Constant.TAG_GBON1 + " TEXT,"
                    + Constant.TAG_GBON2 + " TEXT,"
                    + Constant.TAG_GBON3 + " TEXT,"
                    + Constant.TAG_GBON4 + " TEXT,"
                    + Constant.TAG_GNAM1 + " TEXT,"
                    + Constant.TAG_GNAM2 + " TEXT,"
                    + Constant.TAG_GNAM3 + " TEXT,"
                    + Constant.TAG_GNAM4 + " TEXT,"
                    + Constant.TAG_GNAM5 + " TEXT,"
                    + Constant.TAG_GNAM6 + " TEXT,"
                    + Constant.TAG_GSAU1 + " TEXT,"
                    + Constant.TAG_GSAU2 + " TEXT,"
                    + Constant.TAG_GSAU3 + " TEXT,"
                    + Constant.TAG_GBAY1 + " TEXT,"
                    + Constant.TAG_GBAY2 + " TEXT,"
                    + Constant.TAG_GBAY3 + " TEXT,"
                    + Constant.TAG_GBAY4 + " TEXT,"
                    + Constant.TAG_KQLOCUOI + " TEXT,"
                    + Constant.TAG_DATECREATE + " TEXT"
                    + ")";
            db.execSQL(CREATE_CONTACTS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }

        @Override
        public synchronized void close() {
            super.close();
            database.close();
        }
    }
    public void insertData(XSBean xsBean) {
        ContentValues values = new ContentValues();
        values.put(Constant.TAG_GDB, xsBean.getGDB());
        values.put(Constant.TAG_GNHAT, xsBean.getGNHAT());
        values.put(Constant.TAG_GHAI1, xsBean.getGHAI1());
        values.put(Constant.TAG_GHAI2, xsBean.getGHAI2());
        values.put(Constant.TAG_GBA1, xsBean.getGBA1());
        values.put(Constant.TAG_GBA2, xsBean.getGBA2());
        values.put(Constant.TAG_GBA3, xsBean.getGBA3());
        values.put(Constant.TAG_GBA4, xsBean.getGBA4());
        values.put(Constant.TAG_GBA5, xsBean.getGBA5());
        values.put(Constant.TAG_GBA6, xsBean.getGBA6());
        values.put(Constant.TAG_GBON1, xsBean.getGBON1());
        values.put(Constant.TAG_GBON2, xsBean.getGBON2());
        values.put(Constant.TAG_GBON3, xsBean.getGBON3());
        values.put(Constant.TAG_GBON4, xsBean.getGBON4());
        values.put(Constant.TAG_GNAM1, xsBean.getGNAM1());
        values.put(Constant.TAG_GNAM2, xsBean.getGNAM2());
        values.put(Constant.TAG_GNAM3, xsBean.getGNAM3());
        values.put(Constant.TAG_GNAM4, xsBean.getGNAM4());
        values.put(Constant.TAG_GNAM5, xsBean.getGNAM5());
        values.put(Constant.TAG_GNAM6, xsBean.getGNAM6());
        values.put(Constant.TAG_GSAU1, xsBean.getGSAU1());
        values.put(Constant.TAG_GSAU2, xsBean.getGSAU2());
        values.put(Constant.TAG_GSAU3, xsBean.getGSAU3());
        values.put(Constant.TAG_GBAY1, xsBean.getGBAY1());
        values.put(Constant.TAG_GBAY2, xsBean.getGBAY2());
        values.put(Constant.TAG_GBAY3, xsBean.getGBAY3());
        values.put(Constant.TAG_GBAY4, xsBean.getGBAY4());
        values.put(Constant.TAG_KQLOCUOI, xsBean.getKQLOCUOI());
        values.put(Constant.TAG_DATECREATE, xsBean.getDATECREATE());
        database.insertOrThrow(TABLE_NAME, null, values);
    }

    public XSBean getData(String date) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + Constant.TAG_DATECREATE + " = '" +date+ "'";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                xsBean = new XSBean();

                xsBean.setKETQUAID(Integer.parseInt(cursor.getString(0)));
                xsBean.setGDB(cursor.getString(1));
                xsBean.setGNHAT(cursor.getString(2));
                xsBean.setGHAI1(cursor.getString(3));
                xsBean.setGHAI2(cursor.getString(4));
                xsBean.setGBA1(cursor.getString(5));
                xsBean.setGBA2(cursor.getString(6));
                xsBean.setGBA3(cursor.getString(7));
                xsBean.setGBA4(cursor.getString(8));
                xsBean.setGBA5(cursor.getString(9));
                xsBean.setGBA6(cursor.getString(10));
                xsBean.setGBON1(cursor.getString(11));
                xsBean.setGBON2(cursor.getString(12));
                xsBean.setGBON3(cursor.getString(13));
                xsBean.setGBON4(cursor.getString(14));
                xsBean.setGNAM1(cursor.getString(15));
                xsBean.setGNAM2(cursor.getString(16));
                xsBean.setGNAM3(cursor.getString(17));
                xsBean.setGNAM4(cursor.getString(18));
                xsBean.setGNAM5(cursor.getString(19));
                xsBean.setGNAM6(cursor.getString(20));
                xsBean.setGSAU1(cursor.getString(21));
                xsBean.setGSAU2(cursor.getString(22));
                xsBean.setGSAU3(cursor.getString(23));
                xsBean.setGBAY1(cursor.getString(24));
                xsBean.setGBAY2(cursor.getString(25));
                xsBean.setGBAY3(cursor.getString(26));
                xsBean.setGBAY4(cursor.getString(27));
                xsBean.setKQLOCUOI(cursor.getString(28));
                xsBean.setDATECREATE(cursor.getString(29));
            }
        }
        return xsBean;
    }

    public ArrayList<XSBean> getAllData() {
        ArrayList<XSBean> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME + " LIMIT 10";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    XSBean xsBean = new XSBean();
                    xsBean.setKETQUAID(Integer.parseInt(cursor.getString(0)));
                    xsBean.setGDB(cursor.getString(1));
                    xsBean.setGNHAT(cursor.getString(2));
                    xsBean.setGHAI1(cursor.getString(3));
                    xsBean.setGHAI2(cursor.getString(4));
                    xsBean.setGBA1(cursor.getString(5));
                    xsBean.setGBA2(cursor.getString(6));
                    xsBean.setGBA3(cursor.getString(7));
                    xsBean.setGBA4(cursor.getString(8));
                    xsBean.setGBA5(cursor.getString(9));
                    xsBean.setGBA6(cursor.getString(10));
                    xsBean.setGBON1(cursor.getString(11));
                    xsBean.setGBON2(cursor.getString(12));
                    xsBean.setGBON3(cursor.getString(13));
                    xsBean.setGBON4(cursor.getString(14));
                    xsBean.setGNAM1(cursor.getString(15));
                    xsBean.setGNAM2(cursor.getString(16));
                    xsBean.setGNAM3(cursor.getString(17));
                    xsBean.setGNAM4(cursor.getString(18));
                    xsBean.setGNAM5(cursor.getString(19));
                    xsBean.setGNAM6(cursor.getString(20));
                    xsBean.setGSAU1(cursor.getString(21));
                    xsBean.setGSAU2(cursor.getString(22));
                    xsBean.setGSAU3(cursor.getString(23));
                    xsBean.setGBAY1(cursor.getString(24));
                    xsBean.setGBAY2(cursor.getString(25));
                    xsBean.setGBAY3(cursor.getString(26));
                    xsBean.setGBAY4(cursor.getString(27));
                    xsBean.setKQLOCUOI(cursor.getString(28));
                    xsBean.setDATECREATE(cursor.getString(29));
                    list.add(xsBean);
                }while (cursor.moveToNext());
            }
        }
        return list;
    }

    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME ;
        Cursor cursor = database.rawQuery(countQuery, null);
        int count = cursor.getCount();
        return count;
    }

    public int updateData(XSBean xsBean) {
        ContentValues values = new ContentValues();
        values.put(Constant.TAG_GDB, xsBean.getGDB());
        values.put(Constant.TAG_GNHAT, xsBean.getGNHAT());
        values.put(Constant.TAG_GHAI1, xsBean.getGHAI1());
        values.put(Constant.TAG_GHAI2, xsBean.getGHAI2());
        values.put(Constant.TAG_GBA1, xsBean.getGBA1());
        values.put(Constant.TAG_GBA2, xsBean.getGBA2());
        values.put(Constant.TAG_GBA3, xsBean.getGBA3());
        values.put(Constant.TAG_GBA4, xsBean.getGBA4());
        values.put(Constant.TAG_GBA5, xsBean.getGBA5());
        values.put(Constant.TAG_GBA6, xsBean.getGBA6());
        values.put(Constant.TAG_GBON1, xsBean.getGBON1());
        values.put(Constant.TAG_GBON2, xsBean.getGBON2());
        values.put(Constant.TAG_GBON3, xsBean.getGBON3());
        values.put(Constant.TAG_GBON4, xsBean.getGBON4());
        values.put(Constant.TAG_GNAM1, xsBean.getGNAM1());
        values.put(Constant.TAG_GNAM2, xsBean.getGNAM2());
        values.put(Constant.TAG_GNAM3, xsBean.getGNAM3());
        values.put(Constant.TAG_GNAM4, xsBean.getGNAM4());
        values.put(Constant.TAG_GNAM5, xsBean.getGNAM5());
        values.put(Constant.TAG_GNAM6, xsBean.getGNAM6());
        values.put(Constant.TAG_GSAU1, xsBean.getGSAU1());
        values.put(Constant.TAG_GSAU2, xsBean.getGSAU2());
        values.put(Constant.TAG_GSAU3, xsBean.getGSAU3());
        values.put(Constant.TAG_GBAY1, xsBean.getGBAY1());
        values.put(Constant.TAG_GBAY2, xsBean.getGBAY2());
        values.put(Constant.TAG_GBAY3, xsBean.getGBAY3());
        values.put(Constant.TAG_GBAY4, xsBean.getGBAY4());
        values.put(Constant.TAG_KQLOCUOI, xsBean.getKQLOCUOI());
        values.put(Constant.TAG_DATECREATE, xsBean.getDATECREATE());
        return database.update(TABLE_NAME, values, Constant.TAG_KETQUAID + " = ?",
                new String[]{String.valueOf(xsBean.getKETQUAID())});
    }

    public void delete(XSBean xsBean) {
        database.delete(TABLE_NAME, Constant.TAG_KETQUAID + " = ?",
                new String[]{String.valueOf(xsBean.getKETQUAID())});
    }

}


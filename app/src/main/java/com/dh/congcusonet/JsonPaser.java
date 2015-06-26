package com.dh.congcusonet;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DH on 6/26/2015.
 */
public class JsonPaser {
    private Context mContext;

    public static final String TAG_KETQUAID = "KETQUAID";
    public static final String TAG_GDB = "GDB";
    public static final String TAG_GNHAT = "GNHAT";
    public static final String TAG_GHAI1 = "GHAI1";
    public static final String TAG_GHAI2 = "GHAI2";
    public static final String TAG_GBA1 = "GBA1";
    public static final String TAG_GBA2 = "GBA2";
    public static final String TAG_GBA3 = "GBA3";
    public static final String TAG_GBA4 = "GBA4";
    public static final String TAG_GBA5 = "GBA5";
    public static final String TAG_GBA6 = "GBA6";
    public static final String TAG_GBON1 = "GBON1";
    public static final String TAG_GBON2 = "GBON2";
    public static final String TAG_GBON3 = "GBON3";
    public static final String TAG_GBON4 = "GBON4";
    public static final String TAG_GNAM1 = "GNAM1";
    public static final String TAG_GNAM2 = "GNAM2";
    public static final String TAG_GNAM3 = "GNAM3";
    public static final String TAG_GNAM4 = "GNAM4";
    public static final String TAG_GNAM5 = "GNAM5";
    public static final String TAG_GNAM6 = "GNAM6";
    public static final String TAG_GSAU1 = "GSAU1";
    public static final String TAG_GSAU2 = "GSAU2";
    public static final String TAG_GSAU3 = "GSAU3";
    public static final String TAG_GBAY1 = "GBAY1";
    public static final String TAG_GBAY2 = "GBAY2";
    public static final String TAG_GBAY3 = "GBAY3";
    public static final String TAG_GBAY4 = "GBAY4";
    public static final String TAG_KQLOCUOI = "KQLOCUOI";
    public static final String TAG_KQLODAU = "KQLODAU";
    public static final String TAG_CHUOISO = "CHUOISO";

//    private static String url = "http://mediaplayer.cf/mediaservice.svc/json/singer/9ae1b119bb11524676e75582c2c23060";
//    private static String url = "http://congcuso.net/Service1.svc/json/getketqua/2015-06-22";
    private static String url = "http://api.androidhive.info/contacts/";

    public JsonPaser(Context mContext) {
        this.mContext = mContext;
    }

    public XSBean getData(String myUrl) {
        XSBean xsBean = new XSBean();
        //url = url + myUrl;
        ServiceHandler handler = new ServiceHandler();

        String jsonStr = handler.getJsonData(url);

        Log.d("LLLLLLLLLLLLLL",jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);

                xsBean.setKETQUAID(jsonObject.getInt(TAG_KETQUAID));
                xsBean.setGDB(jsonObject.getString(TAG_GDB));
                xsBean.setGNHAT(jsonObject.getString(TAG_GNHAT));
                xsBean.setGHAI1(jsonObject.getString(TAG_GHAI1));
                xsBean.setGHAI2(jsonObject.getString(TAG_GHAI2));
                xsBean.setGBA1(jsonObject.getString(TAG_GBA1));
                xsBean.setGBA2(jsonObject.getString(TAG_GBA2));
                xsBean.setGBA3(jsonObject.getString(TAG_GBA3));
                xsBean.setGBA4(jsonObject.getString(TAG_GBA4));
                xsBean.setGBA5(jsonObject.getString(TAG_GBA5));
                xsBean.setGBA6(jsonObject.getString(TAG_GBA6));
                xsBean.setGBON1(jsonObject.getString(TAG_GBON1));
                xsBean.setGBON2(jsonObject.getString(TAG_GBON2));
                xsBean.setGBON3(jsonObject.getString(TAG_GBON3));
                xsBean.setGBON4(jsonObject.getString(TAG_GBON4));
                xsBean.setGNAM1(jsonObject.getString(TAG_GNAM1));
                xsBean.setGNAM2(jsonObject.getString(TAG_GNAM2));
                xsBean.setGNAM3(jsonObject.getString(TAG_GNAM3));
                xsBean.setGNAM4(jsonObject.getString(TAG_GNAM4));
                xsBean.setGNAM5(jsonObject.getString(TAG_GNAM5));
                xsBean.setGNAM6(jsonObject.getString(TAG_GNAM6));
                xsBean.setGSAU1(jsonObject.getString(TAG_GSAU1));
                xsBean.setGSAU2(jsonObject.getString(TAG_GSAU2));
                xsBean.setGSAU3(jsonObject.getString(TAG_GSAU3));
                xsBean.setGBAY1(jsonObject.getString(TAG_GBAY1));
                xsBean.setGBAY2(jsonObject.getString(TAG_GBAY2));
                xsBean.setGBAY3(jsonObject.getString(TAG_GBAY3));
                xsBean.setGBAY4(jsonObject.getString(TAG_GBAY4));
                xsBean.setKQLODAU(jsonObject.getString(TAG_KQLODAU));
                xsBean.setKQLOCUOI(jsonObject.getString(TAG_KQLOCUOI));
                xsBean.setCHUOISO(jsonObject.getString(TAG_CHUOISO));

            } catch (JSONException ex) {

            }
        }
        return xsBean;
    }
}

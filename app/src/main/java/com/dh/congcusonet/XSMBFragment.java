package com.dh.congcusonet;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dh.congcusonet.database.Constant;
import com.dh.congcusonet.database.DatabaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class XSMBFragment extends Fragment {
    private XSBean xsBean;
    private DatabaseHelper helper;
    private ArrayList<XSBean> xsBeanArrayList;
    private static String TAG = XSMBFragment.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeJsonObjectRequest();

        helper = new DatabaseHelper(getActivity());
    }

    private void makeJsonObjectRequest() {
        String urlJsonObj = "http://congcuso.net/Service1.svc/json/getketqua/2015-06-22";
        // Post params to be sent to the server
        HashMap<String, String> params = new HashMap<>();
        params.put("token", "AbCdEfGh123456");

        JsonObjectRequest request = new JsonObjectRequest(urlJsonObj, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        handlerRespone(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("ERROR:", error.getMessage());
                    }
                }
        );
        AppController.getInstance().getRequestQueue().add(request);
    }

    private void handlerRespone(JSONObject response) {
        xsBean = new XSBean();
        try {
            xsBean.setGDB(response.getString(Constant.TAG_GDB));
            xsBean.setGNHAT(response.getString(Constant.TAG_GNHAT));
            xsBean.setGHAI1(response.getString(Constant.TAG_GHAI1));
            xsBean.setGHAI2(response.getString(Constant.TAG_GHAI2));
            xsBean.setGBA1(response.getString(Constant.TAG_GBA1));
            xsBean.setGBA2(response.getString(Constant.TAG_GBA2));
            xsBean.setGBA3(response.getString(Constant.TAG_GBA3));
            xsBean.setGBA4(response.getString(Constant.TAG_GBA4));
            xsBean.setGBA5(response.getString(Constant.TAG_GBA5));
            xsBean.setGBA6(response.getString(Constant.TAG_GBA6));
            xsBean.setGBON1(response.getString(Constant.TAG_GBON1));
            xsBean.setGBON2(response.getString(Constant.TAG_GBON2));
            xsBean.setGBON3(response.getString(Constant.TAG_GBON3));
            xsBean.setGBON4(response.getString(Constant.TAG_GBON4));
            xsBean.setGNAM1(response.getString(Constant.TAG_GNAM1));
            xsBean.setGNAM2(response.getString(Constant.TAG_GNAM2));
            xsBean.setGNAM3(response.getString(Constant.TAG_GNAM3));
            xsBean.setGNAM4(response.getString(Constant.TAG_GNAM4));
            xsBean.setGNAM5(response.getString(Constant.TAG_GNAM5));
            xsBean.setGNAM6(response.getString(Constant.TAG_GNAM6));
            xsBean.setGSAU1(response.getString(Constant.TAG_GSAU1));
            xsBean.setGSAU2(response.getString(Constant.TAG_GSAU2));
            xsBean.setGSAU3(response.getString(Constant.TAG_GSAU3));
            xsBean.setGBAY1(response.getString(Constant.TAG_GBAY1));
            xsBean.setGBAY2(response.getString(Constant.TAG_GBAY2));
            xsBean.setGBAY3(response.getString(Constant.TAG_GBAY3));
            xsBean.setGBAY4(response.getString(Constant.TAG_GBAY4));
            xsBean.setKQLOCUOI(response.getString(Constant.TAG_KQLOCUOI));
            xsBean.setDATECREATE(response.getString(Constant.TAG_DATECREATE));

            //helper.insertData(xsBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        xsBeanArrayList = new ArrayList<>();

        xsBeanArrayList = helper.getAllData();
        int count = 0;
        for (XSBean bean : xsBeanArrayList) {
            if(xsBean.getDATECREATE().equalsIgnoreCase(bean.getDATECREATE())){
            }
        }
        //helper.insertData(xsBean);

        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE",helper.getCount()+"");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");

//        Calendar c = Calendar.getInstance();
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

        Log.d("FFFFFFFFFFFFFFFFFFFFF", formattedDate);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_xsmb, container, false);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

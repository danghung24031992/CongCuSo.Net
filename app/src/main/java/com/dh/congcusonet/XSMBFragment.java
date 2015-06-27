package com.dh.congcusonet;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dh.congcusonet.database.Constant;
import com.dh.congcusonet.database.DatabaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class XSMBFragment extends Fragment {
    private XSBean xsBean;
    private DatabaseHelper helper;
    private ArrayList<XSBean> xsBeanArrayList;
    private static String TAG = XSMBFragment.class.getSimpleName();

    private TextView tvGDB;
    private TextView tvGNHAT;
    private TextView tvGNHI1;
    private TextView tvGNHI2;
    private TextView tvGBA1;
    private TextView tvGBA2;
    private TextView tvGBA3;
    private TextView tvGBA4;
    private TextView tvGBA5;
    private TextView tvGBA6;
    private TextView tvGBON1;
    private TextView tvGBON2;
    private TextView tvGBON3;
    private TextView tvGBON4;
    private TextView tvGNAM1;
    private TextView tvGNAM2;
    private TextView tvGNAM3;
    private TextView tvGNAM4;
    private TextView tvGNAM5;
    private TextView tvGNAM6;
    private TextView tvGSAU1;
    private TextView tvGSAU2;
    private TextView tvGSAU3;
    private TextView tvGBAY1;
    private TextView tvGBAY2;
    private TextView tvGBAY3;
    private TextView tvGBAY4;
    private TextView tvDATECREATE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeJsonObjectRequest();

        helper = new DatabaseHelper(getActivity());
        databaseTest();
    }

    private void databaseTest() {

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

        } catch (JSONException e) {
            e.printStackTrace();
        }

        boolean ck = false;
        for (XSBean bean : helper.getAllData()) {
            if (bean.getDATECREATE().equalsIgnoreCase(xsBean.getDATECREATE())){
                ck = true;
            }
        }
        if (ck == false){
            helper.insertData(xsBean);
        }

        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", helper.getCount() + "");
        Log.d("EEEEEEEEEEEEEEEE", xsBean.getKQLOCUOI());

//        Calendar c = Calendar.getInstance();
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String formattedTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        Log.d("DDDDDDDDDDDDDDDDDDDDD", formattedDate);
        Log.d("TTTTTTTTTTTTTTTTTTTTT", formattedTime);


        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
//        cal.set(1992,Calendar.MARCH,24);
        Log.d("AAAAAAAAAAAAAAAAAAAAAA", simpleDateFormat1.format(cal.getTime()));
        cal.add(Calendar.DATE, 1);
        Log.d("BBBBBBBBBBBBBBBBBBBBBB", simpleDateFormat1.format(cal.getTime()));
        cal.add(Calendar.DATE, -1);
        Log.d("CCCCCCCCCCCCCCCCCCCCCC", simpleDateFormat1.format(cal.getTime()));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_xsmb, container, false);
        tvGDB = (TextView) rootView.findViewById(R.id.tvGDB);
        tvGNHAT = (TextView) rootView.findViewById(R.id.tvGNHAT);
        tvGNHI1 = (TextView) rootView.findViewById(R.id.tvGNHI1);
        tvGNHI2 = (TextView) rootView.findViewById(R.id.tvGNHI2);
        tvGBA1 = (TextView) rootView.findViewById(R.id.tvGBA1);
        tvGBA2 = (TextView) rootView.findViewById(R.id.tvGBA2);
        tvGBA3 = (TextView) rootView.findViewById(R.id.tvGBA3);
        tvGBA4 = (TextView) rootView.findViewById(R.id.tvGBA4);
        tvGBA5 = (TextView) rootView.findViewById(R.id.tvGBA5);
        tvGBA6 = (TextView) rootView.findViewById(R.id.tvGBA6);
        tvGBON1 = (TextView) rootView.findViewById(R.id.tvGBON1);
        tvGBON2 = (TextView) rootView.findViewById(R.id.tvGBON2);
        tvGBON3 = (TextView) rootView.findViewById(R.id.tvGBON3);
        tvGBON4 = (TextView) rootView.findViewById(R.id.tvGBON4);
        tvGNAM1 = (TextView) rootView.findViewById(R.id.tvGNAM1);
        tvGNAM2 = (TextView) rootView.findViewById(R.id.tvGNAM2);
        tvGNAM3 = (TextView) rootView.findViewById(R.id.tvGNAM3);
        tvGNAM4 = (TextView) rootView.findViewById(R.id.tvGNAM4);
        tvGNAM5 = (TextView) rootView.findViewById(R.id.tvGNAM5);
        tvGNAM6 = (TextView) rootView.findViewById(R.id.tvGNAM6);
        tvGSAU1 = (TextView) rootView.findViewById(R.id.tvGSAU1);
        tvGSAU2 = (TextView) rootView.findViewById(R.id.tvGSAU2);
        tvGSAU3 = (TextView) rootView.findViewById(R.id.tvGSAU3);
        tvGBAY1 = (TextView) rootView.findViewById(R.id.tvGBAY1);
        tvGBAY2 = (TextView) rootView.findViewById(R.id.tvGBAY2);
        tvGBAY3 = (TextView) rootView.findViewById(R.id.tvGBAY3);
        tvGBAY4 = (TextView) rootView.findViewById(R.id.tvGBAY4);
        tvDATECREATE = (TextView) rootView.findViewById(R.id.tvDATECREATE);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        xsBean = new XSBean();
        xsBean = helper.getData("2015-06-22");
        tvGDB.setText(xsBean.getGDB());
        tvGNHAT.setText(xsBean.getGNHAT());
        tvGNHI1.setText(xsBean.getGHAI1());
        tvGNHI2.setText(xsBean.getGHAI2());
        tvGBA1.setText(xsBean.getGBA1());
        tvGBA2.setText(xsBean.getGBA2());
        tvGBA3.setText(xsBean.getGBA3());
        tvGBA4.setText(xsBean.getGBA4());
        tvGBA5.setText(xsBean.getGBA5());
        tvGBA6.setText(xsBean.getGBA6());
        tvGBON1.setText(xsBean.getGBON1());
        tvGBON2.setText(xsBean.getGBON2());
        tvGBON3.setText(xsBean.getGBON3());
        tvGBON4.setText(xsBean.getGBON4());
        tvGNAM1.setText(xsBean.getGNAM1());
        tvGNAM2.setText(xsBean.getGNAM2());
        tvGNAM3.setText(xsBean.getGNAM3());
        tvGNAM4.setText(xsBean.getGNAM4());
        tvGNAM5.setText(xsBean.getGNAM5());
        tvGNAM6.setText(xsBean.getGNAM6());
        tvGSAU1.setText(xsBean.getGSAU1());
        tvGSAU2.setText(xsBean.getGSAU2());
        tvGSAU3.setText(xsBean.getGSAU3());
        tvGBAY1.setText(xsBean.getGBAY1());
        tvGBAY2.setText(xsBean.getGBAY2());
        tvGBAY3.setText(xsBean.getGBAY3());
        tvGBAY4.setText(xsBean.getGBAY4());
        tvDATECREATE.setText("Ngày "+xsBean.getDATECREATE());
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

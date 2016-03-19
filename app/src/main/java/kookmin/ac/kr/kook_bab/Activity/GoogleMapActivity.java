package kookmin.ac.kr.kook_bab.Activity;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.*;

import kookmin.ac.kr.kook_bab.R;

public class GoogleMapActivity extends AppCompatActivity {


    //Database Setting
    SQLiteDatabase db;
    String dbName = "log.db";
    String tableName = "logListTable";
    int dbMode = Context.MODE_PRIVATE;

    //Object about Googlemap
    private GoogleMap map;
    static final LatLng SEOUL = new LatLng( 37.611141, 126.997289);

    //Other variable
    String whattype;
    String getPosition;
    String lon,lat;
    double mlon,mlat;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);


        //Google Map Open
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        map = mapFragment.getMap();
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 16));

        //database open
        db = openOrCreateDatabase(dbName, dbMode, null);


        //Intent setting
        whattype = getIntent().getExtras().getString("type");
        selectDataAll(whattype);

        getPosition = getIntent().getExtras().getString("p_id");
        selectData(getPosition);

    }

    //Search Data and show marker
    public void selectData(String what) {
        String sql = "select * from " + tableName + ";";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();

        while (!result.isAfterLast()) {
            String act = result.getString(0);
            String name = result.getString(1);
            if(act.equals(what)) {
                lon = result.getString(2);
                lat = result.getString(3);
                Log.d("lab_sqlite", "index= " + lon + " name=" + lat);

                mlon = Double.valueOf(lon);
                mlat = Double.valueOf(lat);
                Log.d("lab_sqlite", "d= " + mlon + " ae=" + mlat);

                final LatLng ThisLocation = new LatLng(mlon, mlat);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(ThisLocation, 16));
                Marker my = map.addMarker(new MarkerOptions().position(ThisLocation).title(name).icon(BitmapDescriptorFactory.fromResource(R.drawable.fork)));
                }
            result.moveToNext();
            }
        result.close();


    }

    //Select all data
    public void selectDataAll(String what) {
        String sql = "select distinct * from " + tableName + ";";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();

        while (!result.isAfterLast()) {
            String act = result.getString(4);
            String name = result.getString(1);

            if(act.equals(what)) {
                lon = result.getString(2);
                lat = result.getString(3);
                Log.d("lab_sqlite", "index= " + lon + " name=" + lat);

                mlon = Double.valueOf(lon);
                mlat = Double.valueOf(lat);
                Log.d("lab_sqlite", "d= " + mlon + " ae=" + mlat);

                final LatLng ThisLocation = new LatLng(mlon, mlat);
                Marker my = map.addMarker(new MarkerOptions().position(ThisLocation).title(name));

            }
            result.moveToNext();
        }
        result.close();
    }


}

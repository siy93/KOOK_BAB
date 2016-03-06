package kookmin.ac.kr.kook_bab;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 송인엽 on 2016-02-22.
 */
public class DeliverySchoolFragment extends Fragment {
    EditText editText;

    public DeliverySchoolFragment() {}


    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_delivery, container, false);

        final Intent SearchShow = new Intent(getActivity(),SearchShowActivity.class);
        editText = (EditText) rootView.findViewById(R.id.editText);
        final String what = editText.getText().toString();

        Button bt_search = (Button)rootView.findViewById(R.id.bt_search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchShow.putExtra("info",what);
                startActivity(SearchShow);
            }
        });

        return rootView;
    }

    /*
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        editText = (EditText) getActivity().findViewById(R.id.editText);
        db = getActivity().openOrCreateDatabase(dbName, dbMode, null);
        String what = editText.getText().toString();


        arrList = new ArrayList<String>();
        arr_id_list = new ArrayList<String>();
        arr_lon_list= new ArrayList<String>();
        arr_lat_list= new ArrayList<String>();
        baseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrList);
        ListView mList = (ListView) getActivity().findViewById(R.id.list_view);
        mList.setAdapter(baseAdapter);

        mList.setOnItemClickListener(this);

    }
    // 모든 Data 읽기
    public void selectAll() {
        String sql = "select * from " + tableName + ";";
        Cursor results = db.rawQuery(sql, null);
        results.moveToFirst();
        while (!results.isAfterLast()) {
            String id = results.getString(0);
            String name = results.getString(1);
            String lon = results.getString(2);
            String lat = results.getString(3);
            //Log.d("lab_sqlite", "index= " + id + " name=" + name);

            arr_id_list.add(id);
            arrList.add(name);
            arr_lon_list.add(lon);
            arr_lat_list.add(lat);
            results.moveToNext();
        }
        results.close();
    }
    */
}

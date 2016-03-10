package kookmin.ac.kr.kook_bab;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Created by 송인엽 on 2016-03-04.
 */
public class SearchShowActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener
{
    //Object about Database
    SQLiteDatabase db;
    String dbName = "log.db";
    String tableName = "logListTable";
    int dbMode = Context.MODE_PRIVATE;

    ArrayAdapter<String> baseAdapter;
    ArrayList<String> arrList = null;
    ArrayList<String> arr_id_list = null;
    ArrayList<String> arr_lon_list = null;
    ArrayList<String> arr_lat_list = null;
    ArrayList<String> arr_type_list = null;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_searchshow);

        //  Database 생성 및 열기
        db = openOrCreateDatabase(dbName,dbMode,null);

        arrList = new ArrayList<String>();
        arr_id_list = new ArrayList<String>();
        arr_lon_list= new ArrayList<String>();
        arr_lat_list= new ArrayList<String>();
        arr_type_list = new ArrayList<String>();
        baseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrList);
        ListView mList = (ListView) findViewById(R.id.list_view);
        mList.setAdapter(baseAdapter);

        mList.setOnItemLongClickListener(this);

        Intent intent = getIntent();
        String what = intent.getExtras().getString("info");
        select(what);

    }

    // 모든 Data 읽기
    public void select(String what) {
        String sql = "select * from " + tableName + " where (type = '" + what + "' OR name like '%" + what + "%' );";
        Cursor results = db.rawQuery(sql, null);
        results.moveToFirst();
        if(results.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "데이터가 없습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }


        while (!results.isAfterLast()) {
            String id = results.getString(0);
            String name = results.getString(1);
            String lon = results.getString(2);
            String lat = results.getString(3);
            String type = results.getString(4);
            //Log.d("lab_sqlite", "index= " + id + " name=" + name);

            arr_id_list.add(id);
            arrList.add(name);
            arr_lon_list.add(lon);
            arr_lat_list.add(lat);
            arr_type_list.add(type);
            results.moveToNext();

        }
        results.close();
    }

    //길게누를 때 이벤트 설정
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        final Integer selectedPos = i;
        AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());
        alertDlg.setTitle("질문");

        alertDlg.setPositiveButton( "정보확인", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String position = arr_id_list.get(selectedPos);
                dialog.dismiss();

                Intent intent = new Intent(SearchShowActivity.this, GoogleMapActivity.class);
                intent.putExtra("p_id", position);

                baseAdapter.notifyDataSetChanged();
            }
        });

        alertDlg.setNegativeButton( "위치확인", new DialogInterface.OnClickListener(){

            @Override
            public void onClick( DialogInterface dialog, int which ) {
                String position = arr_id_list.get(selectedPos);
                dialog.dismiss();


                Intent intent = new Intent(SearchShowActivity.this, GoogleMapActivity.class);
                intent.putExtra("p_id", position);

                startActivity(intent);
            }
        });

        alertDlg.setMessage("작업을 선택해주세요");
        alertDlg.show();
        return false;

    }

}

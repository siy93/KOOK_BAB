package kookmin.ac.kr.kook_bab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 송인엽 on 2016-02-20.
 */
public class OutSchoolFragment extends Fragment {

    public OutSchoolFragment() {}

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_outschool,container,false);

        Button bt_caffe = (Button)rootView.findViewById(R.id.bt_caffe);
        Button bt_china = (Button)rootView.findViewById(R.id.bt_china);
        Button bt_korea = (Button)rootView.findViewById(R.id.bt_korea);
        Button bt_usa = (Button)rootView.findViewById(R.id.bt_usa);
        Button bt_japan = (Button)rootView.findViewById(R.id.bt_japan);
        Button bt_sub = (Button)rootView.findViewById(R.id.bt_sub);
        Button bt_drink = (Button)rootView.findViewById(R.id.bt_drink);
        Button bt_meat = (Button)rootView.findViewById(R.id.bt_meat);
        Button bt_chicken = (Button)rootView.findViewById(R.id.bt_chicken);

        bt_caffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","카페");
                startActivity(map);
            }
        });
        bt_china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","중식");
                startActivity(map);
            }
        });
        bt_korea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","한식");
                startActivity(map);
            }
        });
        bt_usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","양식");
                startActivity(map);
            }
        });
        bt_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","치킨");
                startActivity(map);
            }
        });
        bt_japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(), GoogleMapActivity.class);
                map.putExtra("type","일식");
                startActivity(map);
            }
        });
        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","분식");
                startActivity(map);
            }
        });
        bt_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","술");
                startActivity(map);
            }
        });
        bt_meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                map.putExtra("type","고기");
                startActivity(map);
            }
        });
        return rootView;
    }
}
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


        Button button1 = (Button)rootView.findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(),GoogleMapActivity.class);
                startActivity(map);
            }
        });
        return rootView;
    }
}

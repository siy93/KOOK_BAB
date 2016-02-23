package kookmin.ac.kr.kook_bab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 송인엽 on 2016-02-23.
 */
public class OtherInfoFragment extends Fragment {

    public OtherInfoFragment() {}

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_other,container,false);

        Button bt_library = (Button)rootView.findViewById(R.id.bt_library);
        bt_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new  Intent(Intent.ACTION_VIEW, Uri.parse("http://210.123.38.73/index.asp"));
                startActivity(myIntent);
            }
        });

        return rootView;
    }
}

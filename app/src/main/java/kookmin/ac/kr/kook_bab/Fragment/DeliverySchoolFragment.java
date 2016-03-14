package kookmin.ac.kr.kook_bab.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import kookmin.ac.kr.kook_bab.Activity.SearchShowActivity;
import kookmin.ac.kr.kook_bab.R;


public class DeliverySchoolFragment extends Fragment {
    EditText editText;

    public DeliverySchoolFragment() {}


    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_delivery, container, false);

        final Intent SearchShow = new Intent(getActivity(),SearchShowActivity.class);
        editText = (EditText) rootView.findViewById(R.id.editText);


        Button bt_search = (Button)rootView.findViewById(R.id.bt_search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String what = editText.getText().toString();
                SearchShow.putExtra("info", what);
                startActivity(SearchShow);
            }
        });

        return rootView;
    }
}

package kookmin.ac.kr.kook_bab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by 송인엽 on 2016-02-22.
 */
public class DeliverySchoolFragment extends Fragment {

    public DeliverySchoolFragment( ) {
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_outschool,container,false);

        return rootView;
    }
}

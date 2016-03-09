package kookmin.ac.kr.kook_bab;


import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by 송인엽 on 2016-03-06.
 */
public class InSchoolFragment extends Fragment {


    private static String URL_PRIMARY = "http://m.kookmin.ac.kr/info/cafeteria.php";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inschool, container, false);

        WebView mWebView =(WebView) rootView.findViewById(R.id.webview);
        // 웹뷰에서 자바스크립트실행가능
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 구글홈페이지 지정
        mWebView.loadUrl(URL_PRIMARY);
        // WebViewClient 지정



        return rootView;

    }



}

package com.yeonnex.jetpackapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonnex.jetpackapp.ui.main.MainFragment

// 내비게이션 아키텍쳐
// NavController 클래스
//  내비게이션 스택을 사용해서 사용자의 앱 내부 목적지 경로를 추작하여 화면 이동


class MainActivity : AppCompatActivity() , SecondFragment.OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // 내비게이션이 구성되었으므로
        // main_fragment.xml 파일이 로딩되지 않도록 삭제
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
    }
    override fun onFragmentInteration(uri: Uri){

    }
}
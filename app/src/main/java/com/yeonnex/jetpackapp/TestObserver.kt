package com.yeonnex.jetpackapp

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

// 안드로이드 생명주기-인식 컴포넌트 사용하기
// LifecycleObserver 인터페이스를 구현하면 됨! (인터페이스는 여러개 상속 가능. 클래스는 단 하나만 가능)


class TestObserver : LifecycleObserver {
    private val TAG = "LifeCycleEvent"
    @OnLifecycleEvent(LifeCycle.Event.ON_RESUME)
    fun onResume(){
        Log.i(TAG, "onResume")
    }

    @OnLifecycleEvent(LifeCycle.Event.ON_PAUSE)
    fun onPause(){
        Log.i(TAG, "onPause")
    }

    @OnLifecycleEvent(LifeCycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i(TAG, "onCreate")
    }
    @OnLifecycleEvent(LifeCycle.Event.ON_START)
    fun onStart(){
        Log.i(TAG, "onStart")
    }
    @OnLifecycleEvent(LifeCycle.Event.ON_STOP)
    fun onStop(){
        Log.i(TAG, "onStop")
    }
    // ON_ANY 이벤트 핸들러 : 프래그먼트의 현재 상태와 관련된 이벤트를 추적

    @OnLifecycleEvent(LifeCycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event){ // 이벤트가 들어오면 어떤 이벤트인지 출력
        Log.i(TAG, owner.lifecycle.currentState.name)
    }
}
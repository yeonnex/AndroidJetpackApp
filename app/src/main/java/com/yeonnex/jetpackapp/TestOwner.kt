package com.yeonnex.jetpackapp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class TestOwner : LifecycleOwner {
    private val lifecycleRegistry: LifecycleRegistry
    init {
        lifecycleRegistry = LifecycleRegistry(this) // 지연 초기화같은 것!
    }

    // LifecycleRegistry 의 인스턴스를 반환하는 함수
    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    // 객체의 markState()함수 또는 handleLifecycleEvent() 함수를 사용해서
    // 생명주기 이벤트를 발생
    fun startOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }
    fun stopOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }
    // 개체지향으로 가면 갈수록 if 문이 없어진다.
    // 위와 같은 걸 이벤트 중심 프로그램이라 한다.
}
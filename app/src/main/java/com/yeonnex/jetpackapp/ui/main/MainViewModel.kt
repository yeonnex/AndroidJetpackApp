package com.yeonnex.jetpackapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// ViewModel 상태 저장
//	앱 상태 데이터 저장 및 복원
//	VewModel 상태 저장 라이브러리 사용
//		SaveStateHandle 객체 : 저장 및 복원에 필요한 데이터를 키와 값으로 저장
//		SavedStateViewModelFactory 객체 : ViewModel 서브 클래스의 인스턴스 생성에 필요한 인자 객체
//	상태 저장 및 복원
//		SaveStateHandle 인스턴스 함수
//			set(String key, val value) : 저장
//			get(String key) : 복원
//			getLiveData(String key) : LiveData 객체를 사용할 경우 복원
//			contains(String key) : 특정 key 값을 갖는지 나타내는 boolean 값 반환
//			remove(String key) : 값과 키를 삭제하고 삭제된 값을 반환
//			keys() : 저장된 산태에 포함된 모든 키의 문자열을 반환

const val RESULT_KEY = "Dollar Value"
const val RESULT_KEY2 = "Euro Value"

class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val usd_to_eu_rate = 0.74f
    var dollarText: MutableLiveData<String> = savedStateHandle.getLiveData(RESULT_KEY)
    var result: MutableLiveData<Float> =savedStateHandle.getLiveData(RESULT_KEY2)

    fun convertValue() {
        dollarText.let {
            if (!it.value.equals(""))
                result.value = it.value?.toFloat()?.times(usd_to_eu_rate)
            else
                result.value = 0f

            savedStateHandle.set(RESULT_KEY, it.value)
            savedStateHandle.set(RESULT_KEY2, result.value)
        }
    }
}

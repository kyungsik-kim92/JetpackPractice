package com.example.databindingpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map


class MainViewModel : ViewModel() {


    private val _point = MutableLiveData(0)

    val point : LiveData<Int> = _point


    val myPointType : LiveData<MyPointType> = _point.map{

        when {
            it> 80 -> {MyPointType.BIG}
            it> 50 -> {MyPointType.MIDDLE}
            it> 30 -> {MyPointType.SMALL}
            else -> {MyPointType.VERY_SMALL}
        }

    }

    fun pointPlus(){
        _point.value= _point.value?.plus(10)
    }

}

// 4가지 -> BIG / MIDDLE / SMALL / VERY_SMALL
// 몇가지 타입으로 고정해서 사용하고 싶을 때
enum class MyPointType {
    BIG,
    MIDDLE,
    SMALL,
    VERY_SMALL
}
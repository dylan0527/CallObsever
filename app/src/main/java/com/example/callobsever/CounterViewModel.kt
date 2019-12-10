package com.example.callobsever

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    //something that can change
    private val _counter = MutableLiveData<Int>()

    val getCounter:LiveData<Int>
        get()=_counter //getter ald is a return

    init{
        Log.d("ViewModel","ViewModel initialised")
        _counter.value=0
    }


    fun increment(){
        //recreate value
        _counter.value=_counter.value?.plus(1)
    }

    fun decrement(){
        _counter.value=_counter.value?.minus(1)
    }

    override fun onCleared() {
        Log.d("ViewModel","ViewModel cleared")
        super.onCleared()
    }
}
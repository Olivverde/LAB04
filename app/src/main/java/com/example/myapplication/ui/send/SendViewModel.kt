package com.example.myapplication.ui.send

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendViewModel : ViewModel() {

    val _text = MutableLiveData<String>()

    fun setMsgCommunicator(msg: String) {
        _text.setValue(msg)
    }
}


package com.example.myapplication.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutOfModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is me, I'm Oliver and i am currently studying computer science " +
                "at UVG, I'm an amateur artist. I practice ping pong in my free time and " +
                "I go on volunteering trips each time I can as well. I have 2 cats and " +
                "I'm suffering due to this class..."
    }
    val text: LiveData<String> = _text
}
package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Officially the Republic of Guatemala, is a country in Central America" +
                " bordered by Mexico to the north and west. Belize and the Caribbean to the " +
                "northeast, Honduras to the east, El Salvador to the southeast. With a estimated" +
                " population of 17.2 million."
    }
    val text: LiveData<String> = _text
}
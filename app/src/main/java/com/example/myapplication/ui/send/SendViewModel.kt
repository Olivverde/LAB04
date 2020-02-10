package com.example.myapplication.ui.send

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendViewModel : ViewModel() {

    val _text = MutableLiveData<String>()
    val _textPhrase = MutableLiveData<String>()
    val _textDescription = MutableLiveData<String>()

    fun setMsgCommunicator(msg: String) {
        if(msg.equals("city")){
            _text.setValue("Guatemala City")
            _textPhrase.setValue("The cradle of the eternal Spring")
            _textDescription.setValue("locally known as Guatemala or Guate, officially Nueva Guatemala de la Asunción (New Guatemala of the Assumption), is the capital and largest city of Guatemala, and the most populous urban area in Central America. It is estimated that its population is about 1 million. Guatemala City is also the capital of the Municipality of Guatemala and of the Guatemala Department. ")
        }else if (msg.equals("semuc")){
            _text.setValue("Semuc Champey")
            _textPhrase.setValue("Where the river hides under the stones")
            _textDescription.setValue("is a natural monument in the department of Alta Verapaz, Guatemala, near the Q'eqchi' Maya town of Lanquín. It consists of a natural 300 m limestone bridge, under which passes the Cahabón River. Atop the bridge is a series of stepped, turquoise pools, a popular swimming attraction. ")
        }else if (msg.equals("flores")){
            _text.setValue("Flores Island")
            _textPhrase.setValue("The most beautiful island in Peten")
            _textDescription.setValue("Flores is the capital of the Petén Department, Guatemala's landlocked, northernmost department. The population is 13,700 (2003). Flores is the seat of the municipality of Flores (population 22,600).")
        }
    }
}


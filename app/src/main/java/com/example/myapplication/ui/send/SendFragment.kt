package com.example.myapplication.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R

class SendFragment : Fragment() {

    private lateinit var sendViewModel: SendViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(SendViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_send, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = view.findViewById<View>(R.id.text_title) as TextView
        val phrase = view.findViewById<View>(R.id.text_phrase) as TextView
        val description = view.findViewById<View>(R.id.text_description) as TextView

        val model = ViewModelProviders.of(activity!!).get(SendViewModel::class.java)

        model._text.observe(this, object : Observer<Any>{
            override fun onChanged(t: Any?) {
                title.text = t!!.toString()
            }
        })
        model._textPhrase.observe(this, object : Observer<Any>{
            override fun onChanged(t: Any?) {
                phrase.text = t!!.toString()
            }
        })
        model._textDescription.observe(this, object : Observer<Any>{
            override fun onChanged(t: Any?) {
                description.text = t!!.toString()
            }
        })
    }
}
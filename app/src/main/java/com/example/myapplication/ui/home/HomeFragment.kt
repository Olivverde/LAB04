package com.example.myapplication.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import kotlinx.android.synthetic.main.nav_header_main.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val image: ImageView = root.findViewById(R.id.guatemala_pic)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
            image.setImageResource(R.drawable.guatemala)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val upperButton = view.findViewById<View>(R.id.imageButton) as ImageButton
        val editText = view.findViewById<View>(R.id.editText) as EditText
        val textView = view.findViewById<View>(R.id.text_home) as TextView
        var flag = 0

        upperButton.setOnClickListener{
            val txt:String = editText.text.toString()
            textView.setText(txt)
            editText.setVisibility(View.GONE)
            flag += 1
            if (flag > 1){
                flag = 0
                editText.setVisibility(View.VISIBLE)
                homeViewModel =
                    ViewModelProviders.of(this).get(HomeViewModel::class.java)
                homeViewModel.text.observe(this, Observer {
                    textView.text = it
                })
            }


        }
    }
}
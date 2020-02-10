package com.example.myapplication.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.R.id.fragment_container_view_tag
import com.example.myapplication.R.id.fragment_home
import com.example.myapplication.ui.send.SendFragment
import com.example.myapplication.ui.send.SendViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_send.*

class HomeFragment : Fragment() {

    companion object{
        lateinit var mctx:Context
    }
    private lateinit var homeViewModel: HomeViewModel
    private  lateinit var communicator: SendViewModel
    private lateinit var place: String

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
        val cityButton = view.findViewById<View>(R.id.cityButton) as Button
        val semucButton = view.findViewById<View>(R.id.semucButton) as Button
        val floresButton = view.findViewById<View>(R.id.floresButton) as Button
        val editText = view.findViewById<View>(R.id.editText) as EditText
        val textView = view.findViewById<View>(R.id.text_home) as TextView
        var flag = 0

        communicator =
            ViewModelProviders.of(activity!!).get(SendViewModel::class.java)

        upperButton.setOnClickListener{
            val txt:String = editText.text.toString()
            textView.setText(txt)
            editText.setVisibility(View.GONE)
            flag += 1
            if (flag > 1){
                flag = 0
                editText.setVisibility(View.VISIBLE)
                homeViewModel.text.observe(this, Observer {
                    textView.text = it
                })
            }
        }
        cityButton.setOnClickListener{
            communicator!!.setMsgCommunicator("city")
            val myFragment = SendFragment()
            val fT = fragmentManager!!.beginTransaction()
            fT.replace(R.id.fragment_home, myFragment)
            fT.addToBackStack(null)
            fT.commit()
        }
        semucButton.setOnClickListener {
            communicator!!.setMsgCommunicator("semuc")
            val myFragment = SendFragment()
            val fT = fragmentManager!!.beginTransaction()
            fT.replace(R.id.fragment_home, myFragment)
            fT.addToBackStack(null)
            fT.commit()
        }
        floresButton.setOnClickListener {
            communicator!!.setMsgCommunicator("flores")
            val myFragment = SendFragment()
            val fT = fragmentManager!!.beginTransaction()
            fT.replace(R.id.fragment_home, myFragment)
            fT.addToBackStack(null)
            fT.commit()
        }
    }
}
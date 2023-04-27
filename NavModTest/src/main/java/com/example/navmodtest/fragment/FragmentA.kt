package com.example.navmodtest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navmodtest.R


class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val btnB = view.findViewById<Button>(R.id.btn_b)
        val btnC = view.findViewById<Button>(R.id.btn_c)
        val btnD = view.findViewById<Button>(R.id.btn_d)

        btnB.setOnClickListener {
            findNavController().navigate(R.id.frag_b)
        }

        btnC.setOnClickListener {
            findNavController().navigate(R.id.frag_c)
        }

        btnD.setOnClickListener {
            findNavController().navigate(R.id.frag_d)
        }
        return view
    }
}
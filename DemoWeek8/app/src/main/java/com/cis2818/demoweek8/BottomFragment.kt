package com.cis2818.demoweek8

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cis2818.demoweek8.databinding.FragmentBottomBinding


class BottomFragment : Fragment() {
    private lateinit var binding: FragmentBottomBinding
    var listener:CalculatorListener?=null

    interface CalculatorListener{
        fun setDisplay()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is CalculatorListener){
            listener= context
        }else{
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener=null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            Model.typedValue.append("1")
            listener?.setDisplay()
        }
        binding.btn2.setOnClickListener {
            Model.typedValue.append("2")
            listener?.setDisplay()
        }
        binding.btn3.setOnClickListener {
            Model.typedValue.append("3")
            listener?.setDisplay()
        }
        binding.btn4.setOnClickListener {
            Model.typedValue.append("4")
            listener?.setDisplay()
        }
        binding.btn5.setOnClickListener {
            Model.typedValue.append("5")
            listener?.setDisplay()
        }
        binding.btn6.setOnClickListener {
            Model.typedValue.append("6")
            listener?.setDisplay()
        }
        binding.btn7.setOnClickListener {
            Model.typedValue.append("7")
            listener?.setDisplay()
        }
        binding.btn8.setOnClickListener {
            Model.typedValue.append("8")
            listener?.setDisplay()
        }
        binding.btn9.setOnClickListener {
            Model.typedValue.append("9")
            listener?.setDisplay()
        }
        binding.btnC.setOnClickListener {
            Model.typedValue.clear()
            listener?.setDisplay()
        }
    }

    fun onNum(view: View){
        val btnValue =view as Button
        when(btnValue.id){
            binding.btn1.id->Model.typedValue.append("1")
            binding.btn2.id->Model.typedValue.append("2")
            binding.btn3.id->Model.typedValue.append("3")
            binding.btn4.id->Model.typedValue.append("4")
            binding.btn5.id->Model.typedValue.append("5")
            binding.btn6.id->Model.typedValue.append("6")
            binding.btn7.id->Model.typedValue.append("7")
            binding.btn8.id->Model.typedValue.append("8")
            binding.btn9.id->Model.typedValue.append("9")
            binding.btnC.id->Model.typedValue.clear()
        }
        listener?.setDisplay()
    }
}
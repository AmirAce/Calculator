package demoweek8.cis2818.demoweek8

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.cis2818.demoweek8.databinding.FragmentBottomBinding
import kotlin.math.sqrt


class BottomFragment : Fragment() {
    private lateinit var binding: FragmentBottomBinding
    var listener: CalculatorListener? = null
    var plusnum = 0.0
    var timesnum = 0.0
    var dividenum = 0.0
    var radicalnum = 0.0
    var minusnum = 0.0
    var displaynum = 0.0
    var num1 = 0.0
    var num2 = 0.0
    var modulenum = 0
    interface CalculatorListener {
        fun setDisplay()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CalculatorListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener (this::onNum)
        binding.btn2.setOnClickListener (this::onNum)
        binding.btn3.setOnClickListener (this::onNum)
        binding.btn4.setOnClickListener (this::onNum)
        binding.btn5.setOnClickListener (this::onNum)
        binding.btn6.setOnClickListener (this::onNum)
        binding.btn7.setOnClickListener (this::onNum)
        binding.btn8.setOnClickListener (this::onNum)
        binding.btn9.setOnClickListener (this::onNum)
        binding.btn0.setOnClickListener (this::onNum)
        binding.btnC.setOnClickListener (this::onNum)
        binding.btnplus.setOnClickListener(this::onPlus)
        binding.btnEnter.setOnClickListener(this::onEnter)
        binding.btnminus.setOnClickListener (this::onMinus)
        binding.btntimes.setOnClickListener(this::onTimes)
        binding.btnradical.setOnClickListener(this::onRadical)
        binding.btndivide.setOnClickListener(this::onDivide)
        binding.btnmodulus.setOnClickListener(this::onModulus)
        binding.ce.setOnClickListener ( this::onCE )



    }


    fun onNum(view: View) {
        val btnValue = view as Button
        when (btnValue.id) {
            binding.btn1.id -> Model.typedValue.append("1")
            binding.btn2.id -> Model.typedValue.append("2")
            binding.btn3.id -> Model.typedValue.append("3")
            binding.btn4.id -> Model.typedValue.append("4")
            binding.btn5.id -> Model.typedValue.append("5")
            binding.btn6.id -> Model.typedValue.append("6")
            binding.btn7.id -> Model.typedValue.append("7")
            binding.btn8.id -> Model.typedValue.append("8")
            binding.btn9.id -> Model.typedValue.append("9")
            binding.btn0.id -> Model.typedValue.append("0")
            binding.btnC.id-> Model.typedValue.clear()
        }

//

        listener?.setDisplay()
    }

    fun onPlus(view: View){

//            sum = plusnum + Model.typedValue.toString().toInt()
                if( Model.typedValue.substring(1,Model.typedValue.length).contains("-")){
                    Toast.makeText(context, "please calculate expression first!", Toast.LENGTH_SHORT).show()
                }
        else {
                    plusnum += Model.typedValue.toString().toDouble()
                    Model.typedValue.clear()
                    listener?.setDisplay()
                }


    }
    fun onMinus(view: View){
        if(minusnum != 0.0 || !Model.typedValue.contains("-")){
            if(Model.typedValue.isNotEmpty()){
                minusnum = Model.typedValue.toString().toDouble() - minusnum
                Model.typedValue.clear()
            }
            else{

                Model.typedValue.append("-")
//                minusnum = Model.typedValue.toString().toDouble() - minusnum
//                Model.typedValue.clear()

            }


        }
        else{
            Model.typedValue.append("-")

        }
        listener?.setDisplay()
    }
    fun onDivide(view: View){
        if (dividenum!= 0.0 && dividenum != 1.0){
            dividenum /= Model.typedValue.toString().toDouble()
            Model.typedValue.clear()
            listener?.setDisplay()
        }
        else{
            dividenum = 1.0
            dividenum = Model.typedValue.toString().toDouble() / dividenum
            Model.typedValue.clear()

        }
    }
    fun onTimes(view: View){
        if(timesnum != 0.0){
            timesnum *= Model.typedValue.toString().toDouble()
        Model.typedValue.clear()

        }
        else{
            timesnum = 1.0
            timesnum *= Model.typedValue.toString().toDouble()
            Model.typedValue.clear()
        }
        listener?.setDisplay()

    }
    fun onModulus(view: View){
        Model.typedValue.append("%")
    }
    fun onCE(view: View) {
        if (Model.typedValue.isNotEmpty()) {
            Model.typedValue.deleteCharAt(Model.typedValue.length - 1)
            listener?.setDisplay()
        } else {
            Toast.makeText(context, "there is nothing to delete!", Toast.LENGTH_SHORT).show()
        }
    }
    fun onRadical(view: View){
        radicalnum = sqrt(Model.typedValue.toString().toDouble())
//        Model.typedValue.clear()
        Model.typedValue.clear()
        Model.typedValue.append(radicalnum)
        listener?.setDisplay()
    }

    fun onEnter(view: View){
        if(Model.typedValue.isEmpty()) {
            if(plusnum == 0.0){
                displaynum = plusnum
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                plusnum = 0.0
            }
            if(timesnum == 0.0){
                displaynum = timesnum
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                timesnum = 1.0
            }
            if (dividenum == 0.0){
                displaynum = dividenum
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                dividenum = 1.0
            }
            if (minusnum == 0.0){
                displaynum = minusnum
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                minusnum = 0.0
            }
//            if(radicalnum == 0.0){
//
//                Model.typedValue.append(radicalnum)
//
//                radicalnum = 0.0
//            }
            listener?.setDisplay()
        }
        else{
            if(plusnum!=0.0){

                num1 = Model.typedValue.toString().toDouble()
                Model.typedValue.clear()
                displaynum = plusnum + num1
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                plusnum = 0.0
                num1 = 0.0
                listener?.setDisplay()

            }
            if(timesnum!= 0.0 && timesnum != 1.0){
                num1 = Model.typedValue.toString().toDouble()
                Model.typedValue.clear()
                displaynum = timesnum * num1
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                timesnum = 1.0
                num1 = 0.0
                listener?.setDisplay()
            }
            if(dividenum!= 0.0 && dividenum != 1.0){
                num1 = Model.typedValue.toString().toDouble()
                Model.typedValue.clear()
                displaynum = dividenum / num1
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                dividenum = 1.0
                num1 = 0.0
                listener?.setDisplay()
            }
            if(minusnum!= 0.0){
                num1 = Model.typedValue.toString().toDouble()
                Model.typedValue.clear()
                displaynum = minusnum - num1
                Model.typedValue.append(displaynum)
                displaynum = 0.0
                minusnum = 0.0
                num1 = 0.0
                listener?.setDisplay()
            }


        }
        if(Model.typedValue.contains("%")){
            val moduleposition = Model.typedValue.indexOf("%")
            num1 = Model.typedValue.substring(0,moduleposition).toDouble()
            num2 = Model.typedValue.substring(moduleposition + 1,Model.typedValue.length).toDouble()
            modulenum = (num1 % num2).toInt()
            Model.typedValue.clear()
            Model.typedValue.append(modulenum)
            listener?.setDisplay()


        }
        if(Model.typedValue.substring(1,Model.typedValue.length).contains("-") && Model.typedValue.length > 3 ){
            val minusposition = Model.typedValue.indexOf("-",1)
            num1 = Model.typedValue.substring(1,minusposition).toDouble()
            num2 = Model.typedValue.substring(minusposition + 1,Model.typedValue.length).toDouble()
            minusnum = -(num1 + num2)
            Model.typedValue.clear()
            Model.typedValue.append(minusnum)
            listener?.setDisplay()


        }


//        if(radicalnum != 0.0){
////                num1 = Model.typedValue.toString().toDouble()
////
////                radicalnum = sqrt(num1)
//            Model.typedValue.append(radicalnum)
//            Model.typedValue.clear()
////                minusnum = 0.0
////                num1 = 0.0
//            radicalnum = 0.0
//            listener?.setDisplay()
//        }

    }

}


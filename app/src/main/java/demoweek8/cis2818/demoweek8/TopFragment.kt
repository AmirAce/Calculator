package demoweek8.cis2818.demoweek8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cis2818.demoweek8.databinding.FragmentTopBinding


class TopFragment : Fragment() {
    private lateinit var binding: FragmentTopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentTopBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeDisplay(){
        if(Model.typedValue.isNotEmpty()){
            binding.display.text= Model.typedValue
        }
        else{
            binding.display.text="0"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("INPUT",binding.display.text.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState!=null){
            binding.display.text = savedInstanceState.getString("INPUT")
        }
    }
}
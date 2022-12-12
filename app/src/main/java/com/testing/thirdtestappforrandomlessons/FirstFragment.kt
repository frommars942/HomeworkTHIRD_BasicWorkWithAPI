package com.testing.thirdtestappforrandomlessons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.testing.thirdtestappforrandomlessons.databinding.FragmentFirstBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ЕСЛИ ЛИСТ С ВТОРОГО ФРАГМЕНТА НЕ ПУСТОЙ = ЧИСТИМ / НАВЕРНО НЕ ПОНАДОБИТСЯ ТАК КАК НЕ СОЗДАЮТСЯ НОВЫЕ ИНСТАНСЫ?

        binding.button1.setOnClickListener {
            // second fragment
            Navigation.findNavController(binding.root).navigate(R.id.arrow_forward)
        }
    }
}
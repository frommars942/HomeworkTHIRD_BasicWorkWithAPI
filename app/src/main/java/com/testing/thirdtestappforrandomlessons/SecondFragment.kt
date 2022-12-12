package com.testing.thirdtestappforrandomlessons

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import com.testing.thirdtestappforrandomlessons.databinding.FragmentSecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    //тут наверно еше лист объявить???

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize block | url: REST API site
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val postService = retrofit.create(PostService::class.java)
        postService.getById((0..100).random()).enqueue(object: Callback<PostResponse> { // call random post number
            override fun onResponse(
                call: Call<PostResponse>,
                response: Response<PostResponse>
            ) {
                // publish response
                binding.textContainer.text = response.body().toString()
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                // shitting about response
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            }

        })

        // return button
        binding.button2.setOnClickListener {
            // Возвращаемся снова на первый
            Navigation.findNavController(binding.root).navigate(R.id.arrow_back)
        }
    }
}
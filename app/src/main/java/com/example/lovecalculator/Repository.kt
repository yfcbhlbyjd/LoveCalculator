package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getCalculate(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        var liveLoveModel = MutableLiveData<LoveModel>()
        App.api.calculateLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveModel.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }
        })
        return liveLoveModel
    }
}
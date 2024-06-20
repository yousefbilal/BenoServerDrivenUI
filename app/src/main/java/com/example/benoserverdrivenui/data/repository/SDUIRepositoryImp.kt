package com.example.benoserverdrivenui.data.repository

import android.util.Log
import com.example.benoserverdrivenui.data.remote.Api
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SDUIRepositoryImp (
    private val api: Api
): SDUIRepository {
    override fun getHomeScreen(onResult: (String?) -> Unit) {
        api.getHomeScreen().enqueue(object: Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                //handle error here
                Log.e("Error", t.message.toString())
                onResult(null)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                //your raw string response
                val stringResponse = response.body()?.string()
                onResult(stringResponse)
                Log.d("API RESPONSE", "onResponse: $stringResponse")
            }

        })
    }


}
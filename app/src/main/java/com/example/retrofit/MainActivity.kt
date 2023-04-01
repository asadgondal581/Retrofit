package com.example.retrofit


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofit.activities.GetActivity
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.postMethod.ApiInterface
import com.example.retrofit.postMethod.RequestModel
import com.example.retrofit.postMethod.ResponseModel
import com.example.retrofit.postMethod.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.getButton?.setOnClickListener {
            val intent = Intent(this, GetActivity::class.java)
            startActivity(intent)
        }
        binding?.postButton?.setOnClickListener {
            //DummyModel
            val response = ServiceBuilder.buildService(ApiInterface::class.java)
            val requestModel = RequestModel("asad123", "paswrd123")
            response.sendReq(requestModel).enqueue(
                object : Callback<ResponseModel> {
                    override fun onResponse(
                        call: Call<ResponseModel>,
                        response: Response<ResponseModel>
                    ) {
                        Log.d("TAG", "${response.body()?.message.toString()}")
                        Toast.makeText(
                            this@MainActivity,
                            response.message().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
                    }

                }
            )
        }
    }
}
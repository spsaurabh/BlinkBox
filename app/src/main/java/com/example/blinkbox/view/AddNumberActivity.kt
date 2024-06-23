package com.example.blinkbox.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.blinkbox.databinding.ActivityAddNumberBinding

class AddNumberActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    private fun initViews() {
        with(binding){
            tvStart.setOnClickListener {
                if(etAddNumber.text.isNotEmpty()){
                    verifyNumber()
                }else{
                    Toast.makeText(this@AddNumberActivity,"Enter Number",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun verifyNumber() {
        if(binding.etAddNumber.text.toString().toInt() in 4..10){
            val intent = Intent(this,BoxActivity::class.java)
            intent.putExtra("InputNumber",binding.etAddNumber.text.toString())
            startActivity(intent)

        }else{
            Toast.makeText(this,"Enter Number Between 4 to 10",Toast.LENGTH_SHORT).show()
        }
    }
}
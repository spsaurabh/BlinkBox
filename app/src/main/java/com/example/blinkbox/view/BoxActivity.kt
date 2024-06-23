package com.example.blinkbox.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blinkbox.adapter.BoxesAdapter
import com.example.blinkbox.databinding.ActivityBoxBinding
import com.example.blinkbox.model.BoxModel

class BoxActivity : AppCompatActivity() {
    private lateinit var binding:ActivityBoxBinding
    private lateinit var boxRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val getNumber = intent.getStringExtra("InputNumber")
        boxRecyclerView=binding.rvBoxes
        boxRecyclerView.layoutManager=GridLayoutManager(this,4)
        boxRecyclerView.setHasFixedSize(true)
        if (getNumber!=null) {
            val boxModel = BoxModel()
            val multiplyNumber = getNumber.toInt().times(getNumber.toInt())
            boxModel.totalBoxes=multiplyNumber
            boxModel.isSelected=false
            boxRecyclerView.adapter=BoxesAdapter(this,boxModel)
        }
    }
}
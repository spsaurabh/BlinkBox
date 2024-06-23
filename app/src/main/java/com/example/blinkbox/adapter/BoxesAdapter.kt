package com.example.blinkbox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.blinkbox.R
import com.example.blinkbox.databinding.BoxlayoutBinding
import com.example.blinkbox.model.BoxModel

class BoxesAdapter(val context: Context, val boxModel: BoxModel) :
    RecyclerView.Adapter<BoxesAdapter.BoxesViewHolder>(){
    private var selectedIndex: Int = -1 // Track clicked item position
    inner class BoxesViewHolder(var binding: BoxlayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.dot.visibility = if (position == selectedIndex) View.VISIBLE else View.INVISIBLE
            itemView.setOnClickListener {
                val animationIn = AnimationUtils.loadAnimation(context, R.anim.blick_in)
                val animationOut = AnimationUtils.loadAnimation(context, R.anim.blink_out)
                animationIn.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(p0: Animation?) {

                    }
                    override fun onAnimationEnd(p0: Animation?) {
                        itemView.startAnimation(animationOut)
                    }
                    override fun onAnimationRepeat(p0: Animation?) {

                    }
                })
                 itemView.startAnimation(animationIn)

                if (selectedIndex != adapterPosition) {
                    val previousPosition = selectedIndex
                    selectedIndex = adapterPosition
                    if (previousPosition >= 0) {
                        notifyItemChanged(previousPosition)
                    }
                    notifyItemChanged(selectedIndex)
                }
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxesViewHolder {
        val binding = BoxlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BoxesViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return boxModel.totalBoxes
    }
    override fun onBindViewHolder(holder: BoxesViewHolder, position: Int) {
        holder.binding.root.setOnClickListener {
//            val previousIndex = selectedIndex
//            selectedIndex = position
//            if (previousIndex != -1 && previousIndex != selectedIndex) {
//                boxModel.isSelected = false
//                notifyItemChanged(previousIndex)
//            }
//            boxModel.isSelected = true
//            notifyItemChanged(selectedIndex)
//            holder.binding.dot.visibility = if (boxModel.isSelected) View.VISIBLE else View.GONE
        }
        holder.bind(position)
    }
}
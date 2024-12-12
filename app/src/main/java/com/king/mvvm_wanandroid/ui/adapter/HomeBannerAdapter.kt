package com.king.mvvm_wanandroid.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.king.mvvm_wanandroid.R
import com.king.mvvm_wanandroid.bean.HomeBannerItem
import com.king.mvvm_wanandroid.databinding.ItemHomeBannerBinding

class HomeBannerAdapter : RecyclerView.Adapter<HomeBannerAdapter.HomeBannerViewHolder>() {

    private var mData = mutableListOf<HomeBannerItem>()

    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeBannerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
//        Glide.with(holder.itemView).load(mData[position].imagePath).into(binding.itemHomeIcon)
        holder.bindData(mData[position])
    }

    fun setData(mData: MutableList<HomeBannerItem>) {
        this.mData = mData
    }


//    class HomeBannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private var imageView: ImageView? = null
//
//        init {
//            imageView = itemView.findViewById(R.id.item_home_icon)
//        }
//
//    }

    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: HomeBannerItem) {
            binding.apply {
                this.homeModel = data
                Glide.with(itemView).load(data.imagePath).into(itemHomeIcon)
                executePendingBindings()
            }
        }
    }
}


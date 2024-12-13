package com.king.mvvm_wanandroid.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        holder.bindData(mData[position])

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(mData: MutableList<HomeBannerItem>) {
        this.mData = mData
        notifyDataSetChanged()
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
            }
        }
    }
}


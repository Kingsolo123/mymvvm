package com.king.mvvm_wanandroid.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.king.mvvm_wanandroid.bean.HomeListBean
import com.king.mvvm_wanandroid.databinding.ItemHomeListBinding

class HomeListAdapter :
    PagingDataAdapter<HomeListBean, HomeListAdapter.HomeListViewHolder>(HomeListComparator) {


    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bingData(it)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        return HomeListViewHolder(
            ItemHomeListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class HomeListViewHolder(private val bingDing: ItemHomeListBinding) :
        RecyclerView.ViewHolder(bingDing.root) {

        fun bingData(data: HomeListBean) {
            bingDing.apply {
                this.article = data
            }
        }
    }
}

object HomeListComparator : DiffUtil.ItemCallback<HomeListBean>() {
    override fun areItemsTheSame(oldItem: HomeListBean, newItem: HomeListBean): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeListBean, newItem: HomeListBean): Boolean {
        return oldItem == newItem
    }

}
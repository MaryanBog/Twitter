package com.myproj.retpofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myproj.retpofit.models.Twitter
import com.myproj.retpofit.models.TwitterImage
import com.myproj.retpofit.models.TwitterQuote
import com.myproj.retpofit.models.TwitterSimple

class TwitterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mDataList: MutableList<Twitter> = ArrayList()
    private var delegate: TwitterDelegate? = null

    fun attachDelegate(delegate: TwitterDelegate) {
        this.delegate = delegate
    }

    fun setData(data: List<Twitter>) {
        mDataList.clear()
        mDataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> ImageViewHolder(
                itemView = inflater.inflate(
                    R.layout.cell_twitter_text_image,
                    parent,
                    false
                ), delegate = delegate
            )
            2 -> QuoteViewHolder(
                itemView = inflater.inflate(
                    R.layout.cell_twitter_text_quote,
                    parent,
                    false
                ), delegate = delegate
            )
            else -> TextViewHolder(
                itemView = inflater.inflate(
                    R.layout.cell_twitter_text,
                    parent,
                    false
                ), delegate = delegate
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextViewHolder -> holder.bind(model = (mDataList[position] as TwitterSimple))
            is ImageViewHolder -> holder.bind(model = (mDataList[position] as TwitterImage))
            is QuoteViewHolder -> holder.bind(model = (mDataList[position] as TwitterQuote))
        }
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (mDataList[position]) {
            is TwitterSimple -> 0
            is TwitterImage -> 1
            is TwitterQuote -> 2
        }
    }
}
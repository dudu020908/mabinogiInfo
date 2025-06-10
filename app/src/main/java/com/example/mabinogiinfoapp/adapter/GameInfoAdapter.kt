package com.example.mabinogiinfoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mabinogiinfoapp.data.GameInfo
import com.example.mabinogiinfoapp.databinding.ItemGameInfoBinding

class GameInfoAdapter(
    private val onItemClick: (GameInfo) -> Unit,
    private val showDescription: Boolean = true
) : RecyclerView.Adapter<GameInfoAdapter.ViewHolder>() {

    private var displayedItems: List<GameInfo> = emptyList()

    fun updateList(newList: List<GameInfo>) {
        displayedItems = newList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemGameInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GameInfo) {
            binding.txtTitle.text = item.title

            if (showDescription) {
                binding.txtSubTitle.text = item.subtitle
                binding.txtSubTitle.visibility = View.VISIBLE

                binding.txtDescription.text = item.description
                binding.txtDescription.visibility = View.VISIBLE
            } else {
                binding.txtSubTitle.visibility = View.GONE
                binding.txtDescription.visibility = View.GONE
            }

            binding.imgIcon.setImageResource(item.iconResId)

            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGameInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = displayedItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(displayedItems[position])
    }
}

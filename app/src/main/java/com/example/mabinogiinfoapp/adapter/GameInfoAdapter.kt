package com.example.mabinogiinfoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mabinogiinfoapp.data.GameInfo
import com.example.mabinogiinfoapp.databinding.ItemGameInfoBinding

class GameInfoAdapter(
    private val items: List<GameInfo>,
    private val onItemClick: (GameInfo) -> Unit,
    private val showDescription: Boolean = true  // ← 설명 출력 여부 제어
) : RecyclerView.Adapter<GameInfoAdapter.ViewHolder>() {

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
                binding.txtDescription.visibility = View.GONE

                binding.txtSubTitle.visibility = View.GONE
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

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

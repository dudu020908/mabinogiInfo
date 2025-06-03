package com.example.mabinogiinfoapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mabinogiinfoapp.adapter.GameInfoAdapter
import com.example.mabinogiinfoapp.data.SampleData
import com.example.mabinogiinfoapp.databinding.ActivityRuneListBinding

class RuneListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRuneListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRuneListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra("category") ?: return

        binding.txtRuneTitle.text = "$category 장비 목록"

        val runes = SampleData.runeList.filter { it.category == category }

        val adapter = GameInfoAdapter(
            runes.map { it.toGameInfo() },
            onItemClick = { selected ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("area", "info")
                intent.putExtra("item", selected)
                startActivity(intent)
            },
            showDescription = false // ← 설명 안 보이게 설정
        )


        binding.recyclerRuneList.layoutManager = LinearLayoutManager(this)
        binding.recyclerRuneList.adapter = adapter
    }
}

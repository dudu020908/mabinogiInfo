package com.example.mabinogiinfoapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mabinogiinfoapp.R
import com.example.mabinogiinfoapp.adapter.GameInfoAdapter
import com.example.mabinogiinfoapp.data.GameInfo
import com.example.mabinogiinfoapp.data.SampleData
import com.example.mabinogiinfoapp.databinding.ActivityRuneListBinding

class RuneListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRuneListBinding
    private lateinit var adapter: GameInfoAdapter
    private lateinit var allItems: List<GameInfo>  // 전체 리스트 보존

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRuneListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val category = intent.getStringExtra("category") ?: return
        binding.txtRuneTitle.text = "$category 장비 목록"

        allItems = SampleData.runeList
            .filter { it.category == category }
            .map { it.toGameInfo() }

        adapter = GameInfoAdapter(
            onItemClick = { selected ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("area", "info")
                intent.putExtra("info", selected)
                startActivity(intent)
            },
            showDescription = false
        )

        binding.recyclerRuneList.layoutManager = LinearLayoutManager(this)
        binding.recyclerRuneList.adapter = adapter

        adapter.updateList(allItems)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.queryHint = "룬 이름 검색"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = true

            override fun onQueryTextChange(newText: String?): Boolean {
                filterRuneList(newText.orEmpty())
                return true
            }
        })

        return true
    }

    private fun filterRuneList(query: String) {
        val filteredList = allItems.filter {
            it.title.contains(query, ignoreCase = true)
        }
        adapter.updateList(filteredList)
    }
}

package com.example.mabinogiinfoapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mabinogiinfoapp.adapter.GameInfoAdapter
import com.example.mabinogiinfoapp.data.SampleData
import com.example.mabinogiinfoapp.databinding.ActivitySkillListBinding

class SkillListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkillListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jobGroup = intent.getStringExtra("jobGroup") ?: return

        val filteredSkills = SampleData.skillList.filter {
            it.jobGroup == jobGroup
        }

        binding.txtSkillTitle.text = "$jobGroup 스킬 목록"

        val adapter = GameInfoAdapter(filteredSkills.map { it.toGameInfo() }) { selected ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("info", selected)  // selected: GameInfo
            startActivity(intent)
        }

        binding.recyclerSkillList.layoutManager = LinearLayoutManager(this)
        binding.recyclerSkillList.adapter = adapter
    }
}

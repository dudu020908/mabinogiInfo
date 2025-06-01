package com.example.mabinogiinfoapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mabinogiinfoapp.databinding.ActivityJobCategoryBinding

class JobCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJobCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWarrior.setOnClickListener { openSkillList("전사") }
        binding.btnMage.setOnClickListener {
            val intent = Intent(this, SubJobActivity::class.java)
            intent.putExtra("jobGroup", "마법사")
            startActivity(intent)
        }
        binding.btnArcher.setOnClickListener { openSkillList("궁수") }
        binding.btnHealer.setOnClickListener { openSkillList("힐러") }
        binding.btnBard.setOnClickListener { openSkillList("음유시인") }
    }

    private fun openSkillList(jobGroup: String) {
        val intent = Intent(this, SkillListActivity::class.java)
        intent.putExtra("jobGroup", jobGroup)
        startActivity(intent)
    }
}

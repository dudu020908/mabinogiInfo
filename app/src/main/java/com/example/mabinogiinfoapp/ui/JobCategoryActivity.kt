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

        binding.btnWarrior.setOnClickListener { val intent = Intent(this, SubJobActivity::class.java)
            intent.putExtra("jobGroup", "전사")
            startActivity(intent) }
        binding.btnMage.setOnClickListener {
            val intent = Intent(this, SubJobActivity::class.java)
            intent.putExtra("jobGroup", "마법사")
            startActivity(intent)
        }
        binding.btnArcher.setOnClickListener {
            val intent = Intent(this, SubJobActivity::class.java)
            intent.putExtra("jobGroup", "궁수")
            startActivity(intent)
        }
        binding.btnHealer.setOnClickListener {             val intent = Intent(this, SubJobActivity::class.java)
            intent.putExtra("jobGroup", "힐러")
            startActivity(intent) }
        binding.btnBard.setOnClickListener {            val intent = Intent(this, SubJobActivity::class.java)
            intent.putExtra("jobGroup", "음유시인")
            startActivity(intent) }
        binding.btnThief.setOnClickListener {             val intent = Intent(this, SubJobActivity::class.java)
            intent.putExtra("jobGroup", "도적")
            startActivity(intent) }
    }

    private fun openSkillList(jobGroup: String) {
        val intent = Intent(this, SkillListActivity::class.java)
        intent.putExtra("jobGroup", jobGroup)
        startActivity(intent)
    }
}

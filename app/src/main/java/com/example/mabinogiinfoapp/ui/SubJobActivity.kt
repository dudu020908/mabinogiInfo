package com.example.mabinogiinfoapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mabinogiinfoapp.databinding.ActivitySubJobBinding

class SubJobActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubJobBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jobGroup = intent.getStringExtra("jobGroup") ?: "직업군 없음"
        binding.txtSubTitle.text = "$jobGroup 전직 선택"

        val subJobs = when (jobGroup) {
            "전사" -> listOf("검술사", "대검전사", "전사")
            "마법사" -> listOf("마법사", "빙결술사", "화염술사")
            "궁수" -> listOf("궁수", "석궁사수", "장궁병")
            "힐러" -> listOf("사제", "수도사", "힐러")
            "음유시인" -> listOf("댄서", "악사", "음유시인")
            else -> emptyList()
        }

        binding.chipGroup.removeAllViews()
        for (jobClass in subJobs) {
            val chip = com.google.android.material.chip.Chip(this).apply {
                text = jobClass
                isCheckable = false
                setOnClickListener {
                    openJobDetail(jobClass)
                }
            }
            binding.chipGroup.addView(chip)
        }
    }

    private fun openJobDetail(jobClass: String) {
        val intent = Intent(this, JobDetailActivity::class.java)
        intent.putExtra("jobClass", jobClass)
        startActivity(intent)
    }
}

package com.example.mabinogiinfoapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mabinogiinfoapp.databinding.ActivityEquipmentCategoryBinding

class EquipmentCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEquipmentCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEquipmentCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWeapon.setOnClickListener { openCategory("무기") }
        binding.btnArmor.setOnClickListener { openCategory("방어구") }
        binding.btnAccessory.setOnClickListener { openCategory("장신구") }
        binding.btnEmblem.setOnClickListener { openCategory("엠블럼") }
    }

    private fun openCategory(category: String) {
        val intent = Intent(this, RuneListActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
    }
}

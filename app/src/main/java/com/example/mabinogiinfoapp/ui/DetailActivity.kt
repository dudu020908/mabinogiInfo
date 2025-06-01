package com.example.mabinogiinfoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mabinogiinfoapp.data.GameInfo
import com.example.mabinogiinfoapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val info = intent.getSerializableExtra("info") as? GameInfo ?: return

        binding.txtTitle.text = info.title
        binding.txtDescription.text = info.description
        binding.imgIcon.setImageResource(info.iconResId)
    }
}

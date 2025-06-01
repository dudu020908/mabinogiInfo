package com.example.mabinogiinfoapp.ui

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mabinogiinfoapp.data.GameSkill
import com.example.mabinogiinfoapp.data.SampleData
import com.example.mabinogiinfoapp.databinding.ActivityJobDetailBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class JobDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJobDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val className = intent.getStringExtra("jobClass") ?: "직업 없음"
        binding.txtJobTitle.text = className

        // GameSkill에서 스킬 추출
        val filteredSkills = SampleData.skillList.filter {
            it.jobClass == className
        }
        populateSkillChips(binding.chipSkillGroup, filteredSkills)
        // GameRune에서 카테고리별 룬 추출
        val weaponRunes = SampleData.runeList.filter {
            it.category == "무기"
        }
        val armorRunes = SampleData.runeList.filter {
            it.category == "방어구"
        }
        val emblemRunes = SampleData.runeList.filter {
            it.category == "엠블럼"
        }

        // 스킬 출력
        val skillLabels = filteredSkills.map { "${it.title} ★★" } // 등급 가정
        populateChips(binding.chipSkillGroup, skillLabels)

        // 룬 출력
        populateChips(binding.chipWeaponGroup, weaponRunes.map { it.title })
        populateChips(binding.chipArmorGroup, armorRunes.map { it.title })
        populateChips(binding.chipEmblemGroup, emblemRunes.map { it.title })

        // 콤보 아이콘 – 스킬 순서 아이디로 나열
        val comboIconIds = filteredSkills.map { it.iconResId }
        comboIconIds.forEach {
            val icon = ImageView(this).apply {
                setImageResource(it)
                layoutParams = android.view.ViewGroup.LayoutParams(100, 100)
                setPadding(8, 8, 8, 8)
            }
            binding.linearCombo.addView(icon)
        }
    }

    private fun populateChips(chipGroup: ChipGroup, items: List<String>) {
        chipGroup.removeAllViews()
        for (text in items) {
            val chip = Chip(this).apply {
                this.text = text
                isClickable = false
                isCheckable = false
            }
            chipGroup.addView(chip)
        }
    }
    private fun populateSkillChips(chipGroup: ChipGroup, skills: List<GameSkill>) {
        chipGroup.removeAllViews()
        for (skill in skills) {
            val chip = Chip(this).apply {
                text = "${skill.title}"
                isClickable = true
                isCheckable = false
                setOnClickListener {
                    showSkillDialog(skill)
                }
            }
            chipGroup.addView(chip)
        }
    }
    private fun showSkillDialog(skill: GameSkill) {
        MaterialAlertDialogBuilder(this)
            .setTitle(skill.title)
            .setMessage(skill.description) // description 필드가 있어야 함
            .setPositiveButton("확인", null)
            .show()
    }
}

package com.example.mabinogiinfoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mabinogiinfoapp.data.GameRune
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

        // 스킬 출력
        val filteredSkills = SampleData.skillList.filter { it.jobClass == className }
        populateChips(binding.chipSkillGroup, filteredSkills)

        // 추천 룬 출력 (카테고리별)
        populateChips(binding.chipWeaponGroup, getRecommendedRunes(className, "무기"))
        populateChips(binding.chipArmorGroup, getRecommendedRunes(className, "방어구"))
        populateChips(binding.chipAccessoryGroup, getRecommendedRunes(className, "장신구"))

    }
    private val recommendedRuneTitlesByJob = mapOf(
        //전사
        "전사" to mapOf(
            "장신구" to listOf("참격","돌격","맹공"),
            "무기" to listOf("천 자루 검","결투+","무수한 담금질"),
            "방어구" to listOf("마나 격류", "바위거인","쇄빙"),
        ),
        "대검전사" to mapOf(
            "장신구" to listOf("회전","탄력","반격"),
            "무기" to listOf("천 자루 검","가시 덩굴","무수한 담금질"),
            "방어구" to listOf("마나 격류","쇄빙", "횃불","칼날 보루"),
        ),
        "검술사" to mapOf(
            "장신구" to listOf("관통","무희","맹렬"),
            "무기" to listOf("천 자루 검","결투+","무수한 담금질"),
            "방어구" to listOf("쇄빙", "횃불"),
        ),
        //궁수
        "궁수" to mapOf(
            "장신구" to listOf("치명적","매"),
            "무기" to listOf("천 자루 검","눈먼 분노","결투+"),
            "방어구" to listOf("마나 격류", "횃불","평원 방랑자"),
        ),
        "석궁사수" to mapOf(
            "장신구" to listOf("연쇄","감전","반전"),
            "무기" to listOf("천 자루 검","눈먼 분노","결투+"),
            "방어구" to listOf("쇄빙", "횃불","평원 방랑자"),
        ),
        "장궁병" to mapOf(
            "장신구" to listOf("초음파","집중","내상"),
            "무기" to listOf("천 자루 검","격노+","결투+"),
            "방어구" to listOf("초자연+", "마나 격류","바위 거인","고요한 바람"),
        ),
        //마법사
        "마법사" to mapOf(
            "장신구" to listOf("운석","증폭","산사태"),
            "무기" to listOf("천 자루 검","가시 덩굴","무수한 담금질"),
            "방어구" to listOf("마나 격류", "바위 거인","초자연+"),
        ),
        "빙결술사" to mapOf(
            "장신구" to listOf("북풍","빙검","오로라"),
            "무기" to listOf("천 자루 검","가시 덩굴","마법 탐구가"),
            "방어구" to listOf("쇄빙", "횃불","메마른 땅","응축된 마력"),
        ),
        "화염술사" to mapOf(
            "장신구" to listOf("분출","잿더미","불기둥","화력"),
            "무기" to listOf("천 자루 검","눈먼 분노","결투+"),
            "방어구" to listOf("쇄빙", "횃불","마나 격류","바위 거인"),
        ),
        //힐러
        "힐러" to mapOf(
            "장신구" to listOf("억압","서약","물결"),
            "무기" to listOf("천 자루 검","영혼 수확자"),
            "방어구" to listOf("마나 격류","바위 거인","깨달음", "안정","신성한 수양",),
        ),
        "사제" to mapOf(
            "장신구" to listOf("희생","수레바퀴","날개","빛줄기"),
            "무기" to listOf("천 자루 검","무수한 담금질"),
            "방어구" to listOf("바위 거인", "신성한 수양","안정"),
        ),
        "수도사" to mapOf(
            "장신구" to listOf("응보","업화","광휘","정화"),
            "무기" to listOf("천 자루 검","무수한 담금질","결투+"),
            "방어구" to listOf("마나 격류", "신성한 수양","바위 거인"),
        ),
        //음유시인
        "음유시인" to mapOf(
            "장신구" to listOf("화음","재치","급습"),
            "무기" to listOf("천 자루 검","경이+","가시 덩굴"),
            "방어구" to listOf("바위 거인", "비열한 일격","전율하는 악상"),
        ),
        "댄서" to mapOf(
            "장신구" to listOf("산뜻함","나비","다가옴"),
            "무기" to listOf("천 자루 검","격노+","격전+"),
            "방어구" to listOf("전율하는 악상", "마나 격류","바위 거인"),
        ),
        "악사" to mapOf(
            "장신구" to listOf("종장","박애","속주"),
            "무기" to listOf("천 자루 검","무수한 담금질","결투+"),
            "방어구" to listOf("마나 격류","바위 거인","횃불","쇄빙","전율하는 악상"),
        ),
        "도적" to mapOf(
            "장신구" to listOf("치밀함","땅거미","독무"),
            "무기" to listOf("천 자루 검","경이+"),
            "방어구" to listOf("바위 거인", "마나 격류","비열한 일격","비정한 승부사"),
        ),
        "격투가" to mapOf(
            "장신구" to listOf("격파","전진","열혈"),
            "무기" to listOf("천 자루 검","격노+","결투+","무수한 담금질"),
            "방어구" to listOf("마나 격류", "바위 거인","횃불","쇄빙"),
        ),
        "듀얼블레이드" to mapOf(
            "장신구" to listOf("질주","열상","속행"),
            "무기" to listOf("천 자루 검","눈먼 분노"),
            "방어구" to listOf("마나 격류", "바위 거인","평원 방랑자"),
        ),
    )
    /**
     * 추천 룬 title 기반으로 GameRune 리스트 반환
     */
    private fun getRecommendedRunes(className: String, category: String): List<GameRune> {
        val titleList = recommendedRuneTitlesByJob[className]?.get(category) ?: return emptyList()
        return SampleData.runeList.filter {
            it.category == category && it.title in titleList
        }
    }

    /**
     * GameRune or GameSkill 공용 칩 출력기
     */
    private fun <T> populateChips(chipGroup: ChipGroup, items: List<T>) {
        chipGroup.removeAllViews()
        for (item in items) {
            val chip = Chip(this).apply {
                when (item) {
                    is GameRune -> {
                        text = item.title
                        isClickable = true
                        isCheckable = false
                        setOnClickListener {
                            MaterialAlertDialogBuilder(this@JobDetailActivity)
                                .setTitle(item.title)
                                .setMessage(item.description)
                                .setPositiveButton("확인", null)
                                .show()
                        }
                    }
                    is GameSkill -> {
                        text = item.title
                        chipIcon = getDrawable(item.iconResId)
                        isChipIconVisible = true
                        isClickable = true
                        isCheckable = false
                        setOnClickListener {
                            MaterialAlertDialogBuilder(this@JobDetailActivity)
                                .setTitle(item.title)
                                .setIcon(getDrawable(item.iconResId))
                                .setMessage("${item.subtitle}\n${item.description}")
                                .setPositiveButton("확인", null)
                                .show()
                        }
                    }
                }
            }
            chipGroup.addView(chip)
        }
    }
}

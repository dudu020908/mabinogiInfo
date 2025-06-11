package com.example.mabinogiinfoapp.extention

import com.example.mabinogiinfoapp.data.GameInfo
import com.example.mabinogiinfoapp.data.GameRune
import com.example.mabinogiinfoapp.util.extractEffectKeywords
import com.example.mabinogiinfoapp.util.generateAbbreviation
import com.example.mabinogiinfoapp.util.generateSyllableAbbreviation

fun buildSearchKeys(rune: GameRune): List<String> {
    val keywords = mutableListOf<String>()

    // 음절 약자
    val syllable = generateSyllableAbbreviation(rune.title)
    keywords.add(syllable)

    // 초성 약자
    val initials = generateAbbreviation(rune.title)
    keywords.add(initials)

    // 설명 트리거 키워드
    val triggerWords = extractEffectKeywords(rune.description)
    keywords.addAll(triggerWords)

    return keywords
}
fun GameRune.toGameInfo(): GameInfo {
    return GameInfo(
        id = this.id,
        title = this.title,
        subtitle = this.subtitle,
        description = this.description,
        iconResId = this.iconResId,
        searchKeys = buildSearchKeys(this)

    )

}

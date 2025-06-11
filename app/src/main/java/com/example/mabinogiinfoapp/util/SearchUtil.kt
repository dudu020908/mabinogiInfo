package com.example.mabinogiinfoapp.util

fun generateAbbreviation(name: String): String {
    return name.filter { it in '가'..'힣' }
        .map { getInitialConsonant(it) }
        .joinToString("")
}

fun getInitialConsonant(char: Char): Char {
    val base = char.code - 0xAC00
    val chosungIndex = base / (21 * 28)
    val chosungTable = listOf(
        'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ','ㅅ',
        'ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'
    )
    return chosungTable.getOrNull(chosungIndex) ?: char
}
fun generateSyllableAbbreviation(name: String): String {
    return name.split(" ")
        .mapNotNull { it.firstOrNull()?.toString() }
        .joinToString("")
}
val triggerKeywords = listOf("화상", "빙결", "출혈", "신성", "정신", "중독","암흑")

fun extractEffectKeywords(description: String): List<String> {
    return triggerKeywords.filter { description.contains(it) }
}

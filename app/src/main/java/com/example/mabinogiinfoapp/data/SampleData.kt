package com.example.mabinogiinfoapp.data
import com.example.mabinogiinfoapp.R
object SampleData {
    val skillList = listOf(

        GameSkill(
            id = 1,
            jobGroup = "전사",
            jobClass = "전사",
            title = "연속 베기",
            description = "쉴 틈 없이 적을 몰아붙이는 신속한 베기 공격.\n" +
                    "타겟에게 빠르게 접근해 연속으로 검을 휘두른다.\n" +
                    "투지가 최고조에 이르면, 공격 횟수가 증가하고 스킬을 더 빠르게 사용한다.타켓 대미지\n" +
                    "n x 3 주변 대미지 : n x 3\n" +
                    "투지 최고조 시 타겟 대미지 : n x 6\n" +
                    "투지 최고조 시 주변 대미지 : n x 6\n" +
                    "투지 생성 : 5\n" +
                    "재사용 대기 시간 : 5초\n" +
                    "사거리 : 6m\n" +
                    "범위 : 2.5m",
            iconResId = R.drawable.w1
        ),
        GameSkill(
            id = 2,
            jobGroup = "전사",
            jobClass = "전사",
            title = "블레이드 스매시",
            description = "다수의 적을 일거에 제압하는 묵직한 베기 공격.\n" +
                    "폭발적인 힘을 검에 실어 전방에 힘껏 휘두른다.\n" +
                    "검의 반경에 있는 적들은 큰 충격으로 넘어진다.\n" +
                    "투지가 최고조에 이르면, 더 빠른 속도로 스킬을 사용해 전방위의 적들에게 피해를 준다.\n" +
                    "대미지 : n\n" +
                    "브레이크 대미지 : 1칸\n" +
                    "투지 생성 : 15\n" +
                    "캐스팅 시간 : 1.7초\n" +
                    "투지 최고조 시 캐스팅 시간 : 0.85초\n" +
                    "재사용 대기 시간 : 12초\n" +
                    "범위 : 4m\n",
            iconResId = R.drawable.w2
        ),
        GameSkill(
            id = 3,
            jobGroup = "전사",
            jobClass = "전사",
            title = "방패 치기",
            description = "적의 공세를 단번에 끊어내는 육중한 방패 타격.\n" +
                    "빈틈을 노려 타겟을 방패로 힘껏 치고 밀쳐낸다.\n" +
                    "스킬을 준비 중인 타겟은 큰 충격으로 기절한다.\n" +
                    "스킬 사용 후, 잠시 동안 가드 상태가 되어 일정 확률로 적의 공격을 방어한다.\n" +
                    "투지가 최고조에 이르면, 충격파를 일으켜 주변 적들에게 피해를 주고 잠시 동안 받는 모든 공격을 방어한다.\n" +
                    "대미지 : n\n" +
                    "투지 최고조 시 대미지 : n\n" +
                    "카운터 시 브레이크 대미지 : 1칸\n" +
                    "투지 생성 : 10\n" +
                    "가드 지속 시 : 10초\n" +
                    "가드 확률 : 50%\n" +
                    "투지 최고조 시 가드 확률 : 100%\n" +
                    "가드 시 받는 대미지 감소 : 25%\n" +
                    "가드 시 투지 생성 : 2\n" +
                    "재사용 대기 시간 : 10초\n" +
                    "최대 스택 수 : 2\n" +
                    "투지 최고조 시 범위 : 4m",
            iconResId = R.drawable.w3
        ),
        GameSkill(
            id = 5,
            jobGroup = "전사",
            jobClass = "전사",
            title = "아마란스 킥",
            description = "상대의 빈틈을 노리는 강력한 역습.\n" +
                    "공격 방어 후, 적의 허점을 포착해 거센 발차기를 날린다.\n" +
                    "전방의 적들에게 큰 피해를 주고 기절시킨다.\n" +
                    "카운터 어택 발동 시 1회 사용할 수 있다.\n" +
                    "스킬 사용 후, 잠시 동안 가드 상태가 되어 일정 확률로 적의 공격을 방어한다.\n" +
                    "대미지 : n\n" +
                    "브레이크 대미지 : 1칸\n" +
                    "추가 치명타 확률 : 100%\n" +
                    "가드 지속 시간 : 10초\n" +
                    "가드 확률 : 50%\n" +
                    "가드 시 받는 대미지 감소 : 25%\n" +
                    "가드 시 투지 생성 : 2\n" +
                    "범위 : 5m",
            iconResId = R.drawable.w1
        ),
        GameSkill(
            id = 6,
            jobGroup = "전사",
            jobClass = "전사",
            title = "찌르기",
            description = "순식간에 거리를 좁히는 거센 찌르기 공격.\n" +
                    "맹렬한 기세로 돌진하여 전방의 적들을 꿰뚫는다.\n" +
                    "브레이크된 적에게는 도약해 더 큰 피해를 준다.\n" +
                    "투지가 최고조에 이르면, 충격파를 일으켜 주변 적들에게 피해를 준다.\n" +
                    "대미지 :n\n" +
                    "투지 최고조 시 대미지 : n\n" +
                    "도약 공격 시 대미지 증가 : 50%\n" +
                    "투지 생성 : 10\n" +
                    "재사용 대기 시간 : 9초\n" +
                    "사거리 : 12m\n" +
                    "범위 : 4m\n" +
                    "투지 최고조 시 범위 : 8m",
            iconResId = R.drawable.w4
        ),
        GameSkill(
            id = 7,
            jobGroup = "전사",
            jobClass = "전사",
            title = "전장의 함성",
            description = "기세로 적을 압도하는 함성.\n" +
                    "큰 외침으로 주변의 적들을 도발해 자신을 공격하게 만들고, 아군의 사기를 끌어올린다.\n" +
                    "잠시동안 아군의 공격력과 방어력이 증가한다.\n" +
                    "투지가 대폭 증가한다.\n" +
                    "대미지 : n\n" +
                    "투지 생성 : 25\n" +
                    "도발 지속 시간 : 8초\n" +
                    "지속 시간 : 8초\n" +
                    "[시너지] 공격력 증가 : 10%\n" +
                    "[시너지] 방어력 증가 : 10%\n" +
                    "피격 시 추가 투지 생성 :3\n" +
                    "재사용 대기 시간 : 15초\n" +
                    "범위 : 6m",
            iconResId = R.drawable.w5
        ),
        GameSkill(
            id = 8,
            jobGroup = "전사",
            jobClass = "전사",
            title = "블레이드 임팩트",
            description = "폭발적인 힘으로 도약해 지면을 뒤흔드는 타격.\n" +
                    "착지 지점에 충격파를 일으켜 큰 피해와 함께 적들을 넘어뜨리며 충격파의 중심부에 가까운 적에게는 더 큰 피해를 준다.\n" +
                    "잠시 동안 최대 체력이 증가하고 받는 피해가 감소한다.\n" +
                    "또한 최고조에 이른 투지를 즉시 얻으며 스킬을 사용해도 투지가 소모되지 않는다.\n" +
                    "-『맹렬한 투지는 땅마저 흔들고 뒤집으리』\n" +
                    "대미지 : n\n" +
                    "중심부 추가 대미지 : n\n" +
                    "브레이크 대미지 : 3칸\n" +
                    "지속 시간 : 12초\n" +
                    "받는 대미지 감소 : 50%\n" +
                    "최대 체력 증가 : 20%\n" +
                    "궁극기 비용 : 200\n" +
                    "중심부 범위 : 5m\n" +
                    "범위 : 10m",
            iconResId = R.drawable.w6
        ),
        GameSkill(
            id = 9,
            jobGroup = "전사",
            jobClass = "전사",
            title = "카운터 어택",
            description = "적의 공격에 대응하고, 포착한 약점에 강타를 날리는 전투술.\n" +
                    "방패로 적의 공격을 방어하면 일정 확률로 아마란스 킥을 사용할 수 있다.\n" +
                    "\n" +
                    "발동 확률 50%\n" +
                    "아마란스 킥 사용가능 시간 5초",
            iconResId = R.drawable.ic_launcher_background
        ),
        GameSkill(
            id = 10,
            jobGroup = "전사",
            jobClass = "전사",
            title = "투지",
            description = "공방을 주고받을 때마다 솟아오르는 전사의 본능적인 전투 의지.\n" +
                    "적을 공격하거나 공격당할 때 투지를 획득한다.\n" +
                    "적에게 강타 및 추가타를 적중시키거나, 성공적으로 공격을 방어하면 더 많이 획득한다.\n" +
                    "투지가 가득 치면 다음 한 번의 공격이 대폭 강화되며, 강화 스킬 사용 시 체력을 회복한다.\n" +
                    "\n" +
                    "투지 최대치 50\n" +
                    "기본 공격 시 투지 생성 2\n" +
                    "강타 적중 시 투지 생성 1\n" +
                    "추가타 적중 시 투지 생성 2\n" +
                    "체력 회복 최대 체력의 4%",
            iconResId = R.drawable.ic_launcher_background
        ),
        GameSkill(
            id = 11,
            jobGroup = "전사",
            jobClass = "전사",
            title = "전투 숙련: 수호",
            description = "전방에서 아군을 보호하는 숙련된 전투 기법.\n" +
                    "모든 공격으로부터 받는 피해가 감소하고, 적에게 주는 무방비 피해가 증가한다.\n" +
                    "\n" +
                    "받는 대미지 감소 15%\n" +
                    "무방비 대미지 증가 3%",
            iconResId = R.drawable.ic_launcher_background
        ),
        GameSkill(
            id = 12,
            jobGroup = "전사",
            jobClass = "전사",
            title = "복수심",
            description = "적의 공격을 막을 때마다 솟구치는 전사의 뜨거운 마음가짐.\n" +
                    "방패로 적의 공격을 방어하면 잠시 동안 공격력이 증가한다.\n" +
                    "\n" +
                    "공격력 증가 5%\n" +
                    "지속 시간 10초\n" +
                    "최대 중첩 수 5",
            iconResId = R.drawable.ic_launcher_background
        ),
        GameSkill(
            id = 13,
            jobGroup = "전사",
            jobClass = "전사",
            title = "기회 포착",
            description = "한 번 잡은 승기를 놓치지 않는 맹렬한 전투 의지.\n" +
                    "브레이크 상태의 적을 공격하거나, 공격이 강타로 적중하면 잠시 동안 치명타 확률이 증가한다.\n" +
                    "\n" +
                    "치명타 확률 증가 10%\n" +
                    "지속 시간 10초",
            iconResId = R.drawable.ic_launcher_background
        ),
    )
    val runeList = listOf(
        GameRune(1, "장신구", "참격", "전사의 블레이드 스매시 스킬에 변화를 준다.\n" +
                "항상 주변 원형 범위의 적을 빠르게 공격하며, 추가로 지속 피해: 화상 상태로 만든다.", R.drawable.ic_launcher_background),

    GameRune(2, "장신구", "돌진", "전사의 방패 치기 스킬에 변화를 준다.\n" +
            "짧은 거리를 돌진해 적을 공격한다. 브레이크된 상태일 때도 사용할 수 있다.", R.drawable.ic_launcher_background),

    GameRune(3, "장신구", "포효", "전사의 전장의 함성 스킬에 변화를 준다.\n" +
            "투지가 최고조에 이르면, 주변의 모든 적을 넘어뜨리는 매우 강력한 충격파를 일으킨다.", R.drawable.ic_launcher_background),

    GameRune(4, "장신구", "패기", "전사의 전장의 함성 스킬에 변화를 준다.\n" +
            "함성 피해가 대폭 증가하고, 스킬 사용 시 투지 상승 효과가 사라진다.", R.drawable.ic_launcher_background),

    GameRune(5, "장신구", "맹공", "전사의 연속 베기 스킬에 변화를 준다.\n" +
            "가드 상태일 경우, 적에게 맹렬한 연속 공격을 가하고 잠시 동안 공격력을 증가시키는 제압 스킬로 변화한다.", R.drawable.ic_launcher_background),

    GameRune(6, "장신구", "돌격", "전사의 찌르기 스킬을 꿰뚫기로 교체한다.\n" +
            "온 힘을 검 끝에 모아, 타겟에게 위력적인 돌진 공격을 가한다.", R.drawable.ic_launcher_background),
    )
//커밋
}

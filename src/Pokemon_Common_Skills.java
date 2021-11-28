class Pokemon_Common_Skills
    // 포켓몬 객체가 공통적으로 가지고 있는 스킬들을 구현할 부모 클래스
{
    private int Tackle(int ATK)
            // 몸통 박치기
    {
        return ATK;
    }

    private int Scratch(int ATK)
            // 햘퀴기
    {
        return ATK;
    }

    private int Tail_Whip(int DEF)
            // 꼬리 흔들기
    {
        return DEF - 2;
    }

    private int Growl(int ATK)
            // 울음소리
    {
        return ATK -2;
    }

    public int Bite(int ATK)
    {
        return ATK + 5;
    }

    public int Harden(int DEF)
            // 단단해지기
    {
        return DEF + 5;
    }

    public int Slash(int ATK)
            // 베어가르기
    {
        return ATK + 5;
    }

    public int Hyper_Beam(int ATK)
            // 파괴광선
    {
        return ATK + 15;
    }

}

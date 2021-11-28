class Pokemon_Common_Skills
    // 포켓몬 객체가 공통적으로 가지고 있는 스킬들을 구현할 부모 클래스
{
    public void Common_Skills(String Skill_Type, Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    {
        if(Skill_Type == "몸통박치기")
        {
            Tackle(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "햘퀴기")
        {
            Scratch(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "꼬리흔들기")
        {
            Tail_Whip(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "울음소리")
        {
            Growl(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "물기")
        {
            Bite(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "단단해지기")
        {
            Harden(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "베어가르기")
        {
            Slash(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "거품광선")
        {
            Bubble_Beam(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "불꽃세례")
        {
            Ember(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "잎날가르기")
        {
            Razor_Leaf(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "10만볼트")
        {
            Thunderbolt(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "드래곤크루")
        {
            Dragon_Claw(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "속임수")
        {
            Foul_Play(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "힘껏치기")
        {
            Slam(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "염동력")
        {
            Confusion(player_pokemon, opponent, my_turn);
        }

        else if(Skill_Type == "엄마가준비한식사")
        {
            Moms_Food(player_pokemon, opponent, my_turn);
        }
    }

    private void Tackle(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
            // 몸통 박치기
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk;
        }
    }

    private void Scratch(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
            // 햘퀴기
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk;
        }
    }

    private void Tail_Whip(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
            // 꼬리 흔들기
    {
        if (my_turn == false)
        {
            player_pokemon.Def -= 5;
            if(player_pokemon.Def < 1)
            {
                player_pokemon.Def =1;
            }
        }

        else
        {
            opponent.opponent_pokemon.Def -= 5;
            if(opponent.opponent_pokemon.Def < 1)
            {
                opponent.opponent_pokemon.Def =1;
            }
        }
    }

    private void Growl(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
            // 울음소리
    {
        if (my_turn == false)
        {
            player_pokemon.Atk -= 5;
            if(player_pokemon.Atk < 1)
            {
                player_pokemon.Atk =1;
            }
        }

        else
        {
            opponent.opponent_pokemon.Atk -= 5;
            if(opponent.opponent_pokemon.Atk < 1)
            {
                opponent.opponent_pokemon.Atk =1;
            }
        }
    }

    public void Bite(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 5;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 5;
        }
    }

    public void Harden(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
            // 단단해지기
    {
        if (my_turn == false)
        {
            opponent.opponent_pokemon.Def += 5;
        }

        else
        {
            player_pokemon.Def += 5;
        }
    }

    public void Slash(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
            // 베어가르기
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 5;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 5;
        }
    }

    public void Hyper_Beam(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
            // 파괴광선
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 15;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 15;
        }
    }

    //////////////////////////////////////////////

    public void Bubble_Beam(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 거품광선
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Ember(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 불꽃세례
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Razor_Leaf(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 잎날 가르기
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Thunderbolt(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 10만볼트
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Dragon_Claw(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 드래곤크루
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Foul_Play(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 속임수
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Slam(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 힘껏치기
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Confusion(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 염동력
    {
        if (my_turn == false)
        {
            player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10;
        }

        else
        {
            opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10;
        }
    }

    public void Moms_Food(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 엄마가 준비한 식사
    {
        if (my_turn == false)
        {
            opponent.opponent_pokemon.Hp += 10;
            if(opponent.opponent_pokemon.Hp > opponent.opponent_pokemon.Full_Hp)
            {
                opponent.opponent_pokemon.Hp = opponent.opponent_pokemon.Full_Hp;
            }
        }

        else
        {
            player_pokemon.Hp += 10;
            if(player_pokemon.Hp > player_pokemon.Full_Hp)
            {
                player_pokemon.Hp = player_pokemon.Full_Hp;
            }
        }
    }

}

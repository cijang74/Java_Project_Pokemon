import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class Pokemon
{
    // 포켓몬 객체가 가질 변수들
    public int Level;
    public int Hp, Def, Atk, Spd, Full_Hp, Full_Def, Full_Atk, Full_Spd;
    public int Exp;
    public String Name;
    public String type;
    String[] skillArray = new String[4];

    // 포켓몬 객체의 이미지 관련 변수
    public ImageIcon Pokemon_Image;
    public JLabel Portray; // 아이콘 이미지를 라벨화

    public Pokemon()
    // 포켓몬 생성자
    {
        Set_Profile();
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("pokemon_Image//" + this.Name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = bufferedImage.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        this.Pokemon_Image = new ImageIcon(image); // 아이콘 이미지
        this.Portray = new JLabel(this.Pokemon_Image); // 위 아이콘 이미지를 받아 이미지 라벨 생성
    }

    public abstract void Set_Profile();

    public String Use_Skill(Pokemon player_pokemon, Opponent opponent, String what_use)
    {
        // 내 턴일 때
        String Log;
        Log = Common_Skills(what_use, player_pokemon, opponent, true);
        return Log;
    }

    public String Opponent_Use_Skill(Pokemon player_pokemon, Opponent opponent)
    {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int what_use = random.nextInt(3);

        String Log;
        Log = Common_Skills(this.skillArray[what_use], player_pokemon, opponent, false);
        return Log;
    }

    public void Exp_Update()
    {

        System.out.print(this.Exp);
        if (this.Exp >= 5 && this.Exp < 15)
        {
            this.Level = 2;
        }

        else if (this.Exp >= 15 && this.Exp <= 30)
        {
            this.Level = 3;
            if (this.Name == "리아코")
            {
                this.skillArray[2] = "거품광선";
            }

            else if (this.Name == "브케인")
            {
                this.skillArray[2] = "불꽃세례";
            }

            else if (this.Name == "치코리타")
            {
                this.skillArray[2] = "잎날가르기";
            }
        }

        else if (this.Exp > 30 && this.Exp < 50)
        {
            this.Level = 4;
        }

        else if (this.Exp >= 50 && this.Exp <= 75)
        {
            this.Level = 5;
            this.skillArray[3] = "파괴광선";
        }

        else if (this.Exp > 75 && this.Exp < 105)
        {
            this.Level = 6;
        }

        else if (this.Exp >= 105 && this.Exp <= 140)
        {
            this.Level = 7;
        }

        else if (this.Exp > 140 && this.Exp < 180)
        {
            this.Level = 8;
        }
    }

    public void Level_Stat_Update()
    {
        this.Full_Hp += 3;
        this.Full_Spd += 3;
        this.Full_Atk += 3;
        this.Full_Def += 3;
    }

    ////////////////////////////////////////////// 포켓몬 스킬 관련 //////////////////////////////////////////////

    public String Common_Skills(String Skill_Type, Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    {
        String Log;
        if(Skill_Type == "몸통박치기")
        {
            Log = Tackle(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "햘퀴기")
        {
            Log = Scratch(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "꼬리흔들기")
        {
            Log = Tail_Whip(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "울음소리")
        {
            Log = Growl(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "물기")
        {
            Log = Bite(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "단단해지기")
        {
            Log = Harden(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "베어가르기")
        {
            Log = Slash(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "파괴광선")
        {
            Log = Hyper_Beam(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "거품광선")
        {
            Log = Bubble_Beam(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "불꽃세례")
        {
            Log = Ember(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "잎날가르기")
        {
            Log = Razor_Leaf(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "10만볼트")
        {
            Log = Thunderbolt(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "드래곤크루")
        {
            Log = Dragon_Claw(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "속임수")
        {
            Log = Foul_Play(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "힘껏치기")
        {
            Log = Slam(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "염동력")
        {
            Log = Confusion(player_pokemon, opponent, my_turn);
            return Log;
        }

        else if(Skill_Type == "엄마가준비한식사")
        {
            Log = Moms_Food(player_pokemon, opponent, my_turn);
            return Log;
        }
        return "오류 발생";
    }

    public String Tackle(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 몸통 박치기
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * opponent.opponent_pokemon.Atk + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 몸통박치기로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 몸통박치기로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * player_pokemon.Atk + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 몸통박치기로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 몸통박치기로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def) + "의 피해를 입었다!";
            }
        }
    }

    public String Scratch(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 햘퀴기
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * opponent.opponent_pokemon.Atk + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 햘퀴기로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 햘퀴기로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * player_pokemon.Atk + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 햘퀴기로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 햘퀴기로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def) + "의 피해를 입었다!";
            }
        }
    }

    public String Tail_Whip(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 꼬리 흔들기
    {
        if (my_turn == false)
        {
            player_pokemon.Def -= 5;
            if(player_pokemon.Def < 1)
            {
                player_pokemon.Def =1;
                return opponent.opponent_pokemon.Name + "은(는) 꼬리 흔들기를 썼지만 " + player_pokemon.Name + "의 방어력은 더 이상 내려가지 않는다!";
            }
            return opponent.opponent_pokemon.Name + "은(는) 꼬리를 흔들어서 " + player_pokemon.Name + "의 방어력을 떨어뜨렸다!";
        }

        else
        {
            opponent.opponent_pokemon.Def -= 5;
            if(opponent.opponent_pokemon.Def < 1)
            {
                opponent.opponent_pokemon.Def =1;
                return player_pokemon.Name + "은(는) 꼬리 흔들기를 썼지만 " + opponent.opponent_pokemon.Name + "의 방어력은 더 이상 내려가지 않는다!";
            }
            return player_pokemon.Name + "은(는) 꼬리를 흔들어서 " + opponent.opponent_pokemon.Name + "의 방어력을 떨어뜨렸다!";
        }
    }

    public String Growl(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 울음소리
    {
        if (my_turn == false)
        {
            player_pokemon.Atk -= 5;
            if(player_pokemon.Atk < 1)
            {
                player_pokemon.Atk =1;
                return opponent.opponent_pokemon.Name + "은(는) 울음소리를 썼지만 " + player_pokemon.Name + "의 공격력은 더 이상 내려가지 않는다!";
            }
            return opponent.opponent_pokemon.Name + "은(는) 울음소리를 내어 " + player_pokemon.Name + "의 공격력을 떨어뜨렸다!";
        }

        else
        {
            opponent.opponent_pokemon.Atk -= 5;
            if(opponent.opponent_pokemon.Atk < 1)
            {
                opponent.opponent_pokemon.Atk =1;
                return player_pokemon.Name + "은(는) 울음소리를 썼지만 " + opponent.opponent_pokemon.Name + "의 공격력은 더 이상 내려가지 않는다!";
            }
            return player_pokemon.Name + "은(는) 울음소리를 내어 " + opponent.opponent_pokemon.Name + "의 공격력을 떨어뜨렸다!";
        }
    }

    public String Bite(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 5) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 물기로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 5 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 물기로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 5) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 5) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 물기로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 5 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 물기로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 5) + "의 피해를 입었다!";
            }
        }
    }

    public String Harden(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 단단해지기
    {
        if (my_turn == false)
        {
            opponent.opponent_pokemon.Def += 5;
            return opponent.opponent_pokemon.Name + "은(는) 단단해지기를 사용해 방어력을 올렸다!";
        }

        else
        {
            player_pokemon.Def += 5;
            return player_pokemon.Name + "은(는) 단단해지기를 사용해 방어력을 올렸다!";
        }
    }

    public String Slash(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 베어가르기
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 5) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 베어가르기로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 5 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 베어가르기로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 5) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 5) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 베어가르기로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 5 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 베어가르기로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 5) + "의 피해를 입었다!";
            }
        }
    }

    public String Hyper_Beam(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 파괴광선
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 15) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 파괴광선으로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 15 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 파괴광선으로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 15) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 15) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 파괴광선으로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 15 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 파괴광선으로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 15) + "의 피해를 입었다!";
            }
        }
    }

    public String Bubble_Beam(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 거품광선
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 거품광선으로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 거품광선으로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 거품광선으로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 거품광선으로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Ember(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 거품광선
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 불꽃세례로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 불꽃세례로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 불꽃세례로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 불꽃세례로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Razor_Leaf(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 잎날 가르기
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 잎날가르기로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 잎날가르기로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 잎날가르기로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 잎날가르기로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Thunderbolt(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 10만볼트
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 10만볼트로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 10만볼트로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 10만볼트로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 10만볼트로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Dragon_Claw(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 드래곤크루
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 드래곤크루로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 드래곤크루로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 드래곤크루로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 드래곤크루로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Foul_Play(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 속임수
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 속임수로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 속임수로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 속임수로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 속임수로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Slam(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 힘껏치기
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 힘껏치기로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 힘껏치기로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 힘껏치기로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 힘껏치기로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Confusion(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 염동력
    {
        if (!my_turn)
        // 상대가 나에게 공격
        {
            if(-1 * (opponent.opponent_pokemon.Atk + 10) + player_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                player_pokemon.Hp -= leastDamage;
                return opponent.opponent_pokemon.Name + "의 염동력으로 " + player_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                player_pokemon.Hp -= opponent.opponent_pokemon.Atk + 10 - player_pokemon.Def;
                return opponent.opponent_pokemon.Name + "의 염동력으로 " + player_pokemon.Name + "은(는) " + (opponent.opponent_pokemon.Atk - player_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }

        else
        // 플레이어가 상대를 공격
        {
            if(-1 * (player_pokemon.Atk + 10) + opponent.opponent_pokemon.Def >= 0)
            {
                int leastDamage = 1;
                opponent.opponent_pokemon.Hp -= leastDamage;
                return player_pokemon.Name + "의 염동력으로 " + opponent.opponent_pokemon.Name + "은(는) " + leastDamage + "의 피해를 입었다!";
            }

            else
            {
                opponent.opponent_pokemon.Hp -= player_pokemon.Atk + 10 - opponent.opponent_pokemon.Def;
                return player_pokemon.Name + "의 염동력으로 " + opponent.opponent_pokemon.Name + "은(는) " + (player_pokemon.Atk - opponent.opponent_pokemon.Def + 10) + "의 피해를 입었다!";
            }
        }
    }

    public String Moms_Food(Pokemon player_pokemon, Opponent opponent, boolean my_turn)
    // 엄마가 준비한 식사
    {
        if (my_turn == false)
        {
            opponent.opponent_pokemon.Def += 5;
            return opponent.opponent_pokemon.Name + "은(는) 엄마가 준비한 식사를 먹어 체력이 올랐다!";
        }

        else
        {
            player_pokemon.Def += 5;
            return player_pokemon.Name + "은(는) 엄마가 준비한 식사를 먹어 체력이 올랐다!";
        }
    }

}

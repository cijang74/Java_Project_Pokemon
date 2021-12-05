import javax.swing.*;
import java.io.IOException;

class Opponent
{
    public Pokemon player_pokemon;
    public Pokemon opponent_pokemon;
    public String opponent_name;

    public Opponent(boolean is_last, Pokemon player_pokemon)
    {
        this.player_pokemon = player_pokemon;

        if (is_last == false)
        {
            int who = (int) ((Math.random() * 10000) % 10);
            System.out.println(who);

            if (who == 0)
            {
                this.opponent_name = "코더 지망생 종훈";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_ggorison();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_daggori();
                }
            }

            else if (who == 1)
            {
                this.opponent_name = "전자기사 동원";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_zziririgong();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_boombole();
                }
            }

            else if (who == 2)
            {
                this.opponent_name = "학부연구생 재훈";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_mukgoja();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_zammanbo();
                }
            }

            else if (who == 3)
            {
                this.opponent_name = "수학자 서흔";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_keicy();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_yoongella();
                }
            }

            else if (who == 4)
            {
                this.opponent_name = "미스터 Um Jun-sik";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_bborokna_1();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_bborokna_2();
                }
            }

            else if (who == 5)
            {
                this.opponent_name = "파카 판매자 인욱";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_tamless();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_yossingless();
                }
            }

            else if (who == 6)
            {
                this.opponent_name = "선글라스 보이 찬호";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_akbiru();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_akbiaru();
                }
            }

            else if (who == 7)
            {
                this.opponent_name = "쥐 애호가 지환";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_ggoret();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_retra();
                }
            }

            else if (who == 8)
            {
                this.opponent_name = "취권도사 재석";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_allugi_1();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_allugi_2();
                }
            }

            else if (who == 9)
            {
                this.opponent_name = "대리기사 상길";

                if (player_pokemon.Level < 4)
                {
                    this.opponent_pokemon = new pokemon_shellgon();
                }

                else
                {
                    this.opponent_pokemon = new pokemon_bomanda();
                }
            }
        }

        else
        // 마지막 날 상대하는 사람
        {
            this.opponent_name = "대학원생 챔피언";
            this.opponent_pokemon = new pokemon_diaruga();
        }
    }
}
import javax.swing.*;
import java.io.IOException;

class Opponent
{
    public Pokemon player_pokemon;
    public Pokemon opponent_pokemon;
    public String opponent_name;

    public Opponent(boolean is_last, Pokemon player_pokemon){
        this.player_pokemon = player_pokemon;

        if (is_last == false)
        {
            int who = (int)((Math.random()*10000)%10);

            if (who == 0)
            {
                this.opponent_name = "코더 지망생 종훈";
                // String Name, String type, int Hp, int Def, int Atk, int Spd, int level, String image_file

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("꼬리선", "노말", 0, 0, 0, 0, 2,
                                "꼬리선.png", "햘퀴기", "꼬리흔들기", "햘퀴기", "꼬리흔들기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("다꼬리", "노말", 10, 0, 5, 15, 10,
                                "다꼬리.png", "햘퀴기", "물기", "울음소리", "힘껏치기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 1)
            {
                this.opponent_name = "전자기사 동원";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("찌리리공", "전기", 0, 0, 0, 0, 3,
                                "찌리리공.png", "몸통박치기", "울음소리", "몸통박치기", "울음소리");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("붐볼", "전기", 25, 10, 5, 0, 10,
                                "붐볼.png", "몸통박치기", "10만볼트", "단단해지기", "울음소리");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 2)
            {
                this.opponent_name = "학부연구생 재훈";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("먹고자", "노말", 0, 0, 0, 0, 2,
                                "먹고자.png", "몸통박치기", "꼬리흔들기", "몸통박치기", "꼬리흔들기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("잠만보", "노말", 30, 10, 0, 0, 10,
                                "잠만보.png", "몸통박치기", "꼬리흔들기", "힘껏치기", "울음소리");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 3)
            {
                this.opponent_name = "수학자 서흔";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("케이시", "에스퍼", 0, 0, 0, 0, 3,
                                "케이시.png", "햘퀴기", "울음소리", "햘퀴기", "울음소리");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("윤겔라", "에스퍼", 0, 0, 20, 5, 10,
                                "윤겔라.png", "햘퀴기", "울음소리", "염동력", "베어가르기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 4)
            {
                this.opponent_name = "미스터 Um Jun-sik";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("뽀록나", "독", 0, 0, 0, 0, 2,
                                "뽀록나.png", "몸통박치기", "울음소리", "몸통박치기", "울음소리");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("뽀록나", "독", 10, 5, 10, 10, 10,
                                "뽀록나.png", "몸통박치기", "잎날가르기", "힘껏치기", "엄마가준비한식사");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 5)
            {
                this.opponent_name = "파카 판매자 인욱";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("탐리스", "노말", 0, 0, 0, 0, 3,
                                "탐리스.png", "몸통박치기", "꼬리흔들기", "몸통박치기", "꼬리흔들기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("요씽리스", "노말", 10, 5, 5, 5, 10,
                                "요씽리스.png", "몸통박치기", "꼬리흔들기", "힘껏치기", "물기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            else if (who == 6)
            {
                this.opponent_name = "선글라스 보이 찬호";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("악비르", "악", 0, 0, 0, 0, 2,
                                "악비르.png", "햘퀴기", "울음소리", "햘퀴기", "울음소리");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("악비아르", "악", 0, 0, 10, 15, 10,
                                "악비아르.png", "햘퀴기", "울음소리", "속임수", "물기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 7)
            {
                this.opponent_name = "쥐 애호가 지환";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("꼬렛", "노말", 0, 0, 0, 0, 3,
                                "꼬렛.png", "몸통박치기", "울음소리", "몸통박치기", "울음소리");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("레트라", "노말", 10, 10, 5, 5, 10,
                                "레트라.png", "몸통박치기", "물기", "울음소리", "힘껏치기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 8)
            {
                this.opponent_name = "취권도사 재석";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("얼루기", "노말", 0, 0, 0, 0, 2,
                                "얼루기.png", "몸통박치기", "꼬리흔들기", "몸통박치기", "꼬리흔들기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("얼루기", "노말", 10, 10, 5, 10, 10,
                                "얼루기.png", "몸통박치기", "꼬리흔들기", "힘껏치기", "파괴광선");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (who == 9)
            {
                this.opponent_name = "대리기사 상길";

                if (player_pokemon.Level < 10)
                {
                    try {
                        this.opponent_pokemon = new Pokemon("쉘곤", "드래곤", 0, 0, 0, 0, 3,
                                "쉘곤.png", "몸통박치기", "단단해지기", "몸통박치기", "단단해지기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        this.opponent_pokemon = new Pokemon("보만다", "드래곤", 5, 0, 20, 5, 10,
                                "보만다.png", "몸통박치기", "파괴광선", "드래곤크루", "베어가르기");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else
        // 마지막 날 상대하는 사람
        {
            this.opponent_name = "대학원생 챔피언";
            try {
                this.opponent_pokemon = new Pokemon("디아루가", "드래곤", 30, 30, 30, 30, 20,
                        "디아루가.png", "불꽃세례", "파괴광선", "드래곤크루", "염동력");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

class Pokemon extends Pokemon_Common_Skills
    // 포켓몬 객체가 공통적으로 가지고 있는 스킬들을 구현할 부모 클래스를 상속받음
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

    public Pokemon(String Name, String type, int level)
            // 포켓몬 생성자 (플레이어 포켓몬을 생성하는데에 쓰일것)
    {
        // 매개변수르를 받아서 해당 포켓몬 객체에 저장
        this.Name = Name;
        this.type = type;
        this.Level = level;
        this.Hp = this.Level;
        this.Def = this.Level;
        this.Atk = this.Level;
        this.Spd = this.Level;
        this.Full_Hp = this.Hp;
        this.Full_Def = this.Def;
        this.Full_Atk = this.Atk;
        this.Full_Spd = this.Spd;

        // 포켓몬의 이름에 따라 알맞는 포켓몬 이미지를 저장시킴
        if (Name == "리아코")
        {
            this.Pokemon_Image = new ImageIcon("리아코.png"); // 아이콘 이미지
            this.Portray = new JLabel(this.Pokemon_Image);
            this.skillArray[0] = "햘퀴기";
            this.skillArray[1] = "울음소리";
            this.skillArray[2] = null;
            this.skillArray[3] = null;
        }
        else if (Name == "브케인")
        {
            this.Pokemon_Image = new ImageIcon("브케인.png"); // 아이콘 이미지
            this.Portray = new JLabel(this.Pokemon_Image);
            this.skillArray[0] = "몸통박치기";
            this.skillArray[1] = "울음소리";
        }
        else
        {
            this.Pokemon_Image = new ImageIcon("치코리타.png"); // 아이콘 이미지
            this.Portray = new JLabel(this.Pokemon_Image);
            this.skillArray[0] = "몸통박치기";
            this.skillArray[1] = "꼬리흔들기";
        }
    }

    public Pokemon(String Name, String type, int Hp, int Def, int Atk, int Spd, int level, String image_file, String skill1, String skill2, String skill3, String skill4) throws IOException
    // 포켓몬 생성자2(오버로딩)
    {
        this.Name = Name;
        this.type = type;
        this.Level = level;
        this.Hp = this.Level + Hp;
        this.Def = this.Level + Def;
        this.Atk = this.Level + Atk;
        this.Spd = this.Level + Spd;
        this.Full_Hp = this.Hp;
        this.Full_Def = this.Def;
        this.Full_Atk = this.Atk;
        this.Full_Spd = this.Spd;
        this.skillArray[0] = skill1;
        this.skillArray[1] = skill2;
        this.skillArray[2] = skill3;
        this.skillArray[3] = skill4;

        BufferedImage bufferedImage = ImageIO.read(new File(image_file));
        Image image = bufferedImage.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        this.Pokemon_Image = new ImageIcon(image); // 아이콘 이미지
        this.Portray = new JLabel(this.Pokemon_Image);
    }

    public String Use_Skill(Pokemon player_pokemon, Opponent opponent, String what_use)
    {
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

}

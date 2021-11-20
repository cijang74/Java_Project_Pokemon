import javax.swing.*;

class Pokemon extends Pokemon_Common_Skills
    // 포켓몬 객체가 공통적으로 가지고 있는 스킬들을 구현할 부모 클래스를 상속받음
{
    // 포켓몬 객체가 가질 변수들
    public int Level;
    public int Hp, Def, Atk, Spd;
    public int Exp;
    public String Name;
    public String Skill;
    public String type;

    // 포켓몬 객체의 이미지 관련 변수
    public ImageIcon Image;
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

        // 포켓몬의 이름에 따라 알맞는 포켓몬 이미지를 저장시킴
        if (Name == "리아코")
        {
            this.Image = new ImageIcon("리아코.png"); // 아이콘 이미지
            this.Portray = new JLabel(this.Image);
        }
        else if (Name == "브케인")
        {
            this.Image = new ImageIcon("브케인.png"); // 아이콘 이미지
            this.Portray = new JLabel(this.Image);
        }
        else
        {
            this.Image = new ImageIcon("치코리타.png"); // 아이콘 이미지
            this.Portray = new JLabel(this.Image);
        }
    }

    public Pokemon(String Name, String type, int Hp, int Def, int Atk, int Spd, int level)
            // 포켓몬 생성자2(오버로딩)
    {
        this.Name = Name;
        this.type = type;
        this.Level = level;
        this.Hp += Hp;
        this.Def += Def;
        this.Atk += Atk;
        this.Spd += Spd;
    }
}

import javax.swing.*;

class Pokemon
{
    public int Level;
    public int Hp = Level, Def = Level, Atk = Level, Spd = Level;
    public int Exp;
    public String Name;
    public String Skill;
    public String type;
    public ImageIcon Image;
    public JLabel Portray; // 아이콘 이미지를 라벨화

    public Pokemon(String Name, String type, int level)
    {
        this.Name = Name;
        this.type = type;
        this.Level = level;
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

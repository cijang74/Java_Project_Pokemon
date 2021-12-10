import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_allugi_2 extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "얼루기";
        this.type = "노말";

        this.Level = 5;
        this.Full_Hp = 30;
        this.Full_Def = 20;
        this.Full_Atk = 20;
        this.Full_Spd = 15;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "몸통박치기";
        this.skillArray[1] = "꼬리흔들기";
        this.skillArray[2] = "힘껏치기";
        this.skillArray[3] = "파괴광선";
    }
}

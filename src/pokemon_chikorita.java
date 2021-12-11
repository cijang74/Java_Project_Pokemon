import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_chikorita extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "쓰레기";
        this.type = "풀";

        this.Level = 1;
        this.Full_Hp = 1;
        this.Full_Def = 1;
        this.Full_Atk = 1;
        this.Full_Spd = 1;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "몸통박치기";
        this.skillArray[1] = "꼬리흔들기";
        this.skillArray[2] = null;
        this.skillArray[3] = null;
    }
}

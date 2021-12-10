import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_daggori extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "다꼬리";
        this.type = "노말";

        this.Level = 5;
        this.Full_Hp = 10;
        this.Full_Def = 1;
        this.Full_Atk = 15;
        this.Full_Spd = 15;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "햘퀴기";
        this.skillArray[1] = "물기";
        this.skillArray[2] = "꼬리흔들기";
        this.skillArray[3] = "힘껏치기";
    }
}

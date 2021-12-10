import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_yoongella extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "윤겔라";
        this.type = "에스퍼";

        this.Level = 5;
        this.Full_Hp = 2;
        this.Full_Def = 2;
        this.Full_Atk = 25;
        this.Full_Spd = 15;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "햘퀴기";
        this.skillArray[1] = "울음소리";
        this.skillArray[2] = "염동력";
        this.skillArray[3] = "베어가르기";
    }
}

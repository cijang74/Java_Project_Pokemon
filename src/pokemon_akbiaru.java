import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_akbiaru extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "악비아르";
        this.type = "악";

        this.Level = 5;
        this.Full_Hp = 20;
        this.Full_Def = 10;
        this.Full_Atk = 30;
        this.Full_Spd = 30;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "햘퀴기";
        this.skillArray[1] = "울음소리";
        this.skillArray[2] = "속임수";
        this.skillArray[3] = "물기";
    }
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_bcain extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "브케인";
        this.type = "불";

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
        this.skillArray[1] = "울음소리";
        this.skillArray[2] = null;
        this.skillArray[3] = null;
    }
}

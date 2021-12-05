import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_retra extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "레트라";
        this.type = "노말";

        this.Level = 5;
        this.Full_Hp = 30;
        this.Full_Def = 15;
        this.Full_Atk = 10;
        this.Full_Spd = 15;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "몸통박치기";
        this.skillArray[1] = "물기";
        this.skillArray[2] = "힘껏치기";
        this.skillArray[3] = "울음소리";

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(this.Name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = bufferedImage.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        this.Pokemon_Image = new ImageIcon(image); // 아이콘 이미지
        this.Portray = new JLabel(this.Pokemon_Image); // 위 아이콘 이미지를 받아 이미지 라벨 생성
    }
}

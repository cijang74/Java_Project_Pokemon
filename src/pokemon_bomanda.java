import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_bomanda extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "보만다";
        this.type = "드래곤";

        this.Level = 5;
        this.Full_Hp = 25;
        this.Full_Def = 25;
        this.Full_Atk = 25;
        this.Full_Spd = 25;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "몸통박치기";
        this.skillArray[1] = "파괴광선";
        this.skillArray[2] = "드래곤크루";
        this.skillArray[3] = "베어가르기";

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

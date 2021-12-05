import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pokemon_boombole extends Pokemon
{
    public void Set_Profile()
    {
        this.Name = "붐볼";
        this.type = "전기";

        this.Level = 5;
        this.Full_Hp = 25;
        this.Full_Def = 10;
        this.Full_Atk = 5;
        this.Full_Spd = 1;
        this.Hp = Full_Hp;
        this.Def = Full_Def;
        this.Atk = Full_Atk;
        this.Spd = Full_Spd;

        this.skillArray[0] = "햘퀴기";
        this.skillArray[1] = "울음소리";
        this.skillArray[2] = null;
        this.skillArray[3] = null;

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

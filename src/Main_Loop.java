import javax.swing.*;
import java.awt.*;

public class Main_Loop
{
    private static int What_End;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Pokemon"); // 프레임 이름은 Pokemon(가칭)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 누르면 꺼짐

        // 처음 시작 패널은 Start_Panel
        Start_Panel panel = new Start_Panel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
import javax.swing.*;

public class Main_Loop
{
    public static void main(String[] args)
    {
        JPanelChange win = new JPanelChange();
        win.setTitle("Pokemon");
        win.start_panel = new Start_Panel(win);
        win.intro_before_panel = new Intro_Before_Panel(win);
        win.intro_choose_panel = new Intro_Choose_Panel(win);

        // 처음 시작 패널은 Start_Panel
        win.add(win.start_panel);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 누르면 꺼짐
        win.setSize(1280,720);
        win.setVisible(true);
    }
}
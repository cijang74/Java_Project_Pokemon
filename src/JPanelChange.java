import javax.swing.*;

public class JPanelChange extends JFrame
    // 이전 패널의 컴포넌트를 모두 지우고 다음 패널의 컴포넌트를 불러오는 메소드가 있는 클래스
{
    public static String NAME;
    public Start_Panel start_panel = null;
    public Intro_Before_Panel intro_before_panel = null;
    public Intro_Choose_Panel intro_choose_panel = null;

    public void change(String panelType, String NAME)
    {
        if(panelType.equals("type_before_intro"))
        {
            this.NAME = NAME;
            getContentPane().removeAll();
            getContentPane().add(intro_before_panel);
            revalidate();
            repaint();
        }

        else if(panelType.equals("type_choose"))
        {
            getContentPane().removeAll();
            getContentPane().add(intro_choose_panel);
            revalidate();
            repaint();
        }

        else
        {
            getContentPane().removeAll();
            getContentPane().add(start_panel);
            revalidate();
            repaint();
        }
    }
}

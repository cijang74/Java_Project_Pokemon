import javax.swing.*;

public class JPanelChange extends JFrame
    // 이전 패널의 컴포넌트를 모두 지우고 다음 패널의 컴포넌트를 불러오는 메소드가 있는 클래스
{
    public static String NAME;
    private Start_Panel start_panel = null;
    private Intro_Before_Panel intro_before_panel = null;
    private Intro_Choose_Panel intro_choose_panel = null;

    public Start_Panel getStart_panel() {
        return start_panel;
    }

    public void setStart_panel(Start_Panel start_panel) {
        this.start_panel = start_panel;
    }

    public Intro_Before_Panel getIntro_before_panel() {
        return intro_before_panel;
    }

    public void setIntro_before_panel(Intro_Before_Panel intro_before_panel) {
        this.intro_before_panel = intro_before_panel;
    }

    public Intro_Choose_Panel getIntro_choose_panel() {
        return intro_choose_panel;
    }

    public void setIntro_choose_panel(Intro_Choose_Panel intro_choose_panel) {
        this.intro_choose_panel = intro_choose_panel;
    }

    public void change(String panelType, String NAME)
    {
        if(panelType.equals("type_before_intro"))
        {
            this.NAME = NAME;
            intro_before_panel = new Intro_Before_Panel(this, NAME);
            getContentPane().removeAll();
            getContentPane().add(intro_before_panel);
            revalidate();
            repaint();
        }

        else if(panelType.equals("type_choose"))
        {
            intro_choose_panel = new Intro_Choose_Panel(this);
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

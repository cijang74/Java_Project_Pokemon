import javax.swing.*;

public class JPanelChange extends JFrame
    // 이전 패널의 컴포넌트를 모두 지우고 다음 패널의 컴포넌트를 불러오는 메소드가 있는 클래스, 프레임 역할을 함.
{
    // 각 프레임에 전달하고자 하는 변수들
    public static String NAME; // 이름

    // 다른 패널로 변경시켜주기 위해 선언된 패널들
    private Start_Panel start_panel = null;
    private Intro_Before_Panel intro_before_panel = null;
    private Intro_Choose_Panel intro_choose_panel = null;

    public Start_Panel getStart_panel()
    // 메인 클래스에서 해당 패널을 불러오기 위한 메서드
    {
        return start_panel;
    }

    public void setStart_panel(Start_Panel start_panel)
    // 메인 클래스에서 생성한 Start_Panel객체를 해당 변수에 저장시켜주기 위한 메서드
    {
        this.start_panel = start_panel;
    }

    public void change(String panelType, String NAME)
    // a패널에서 b패널로 바꿔주기 위한 메서드 (매개변수는 바꾸고자 하는 패널과 전달하고싶은 데이터들)
    {
        if(panelType.equals("type_before_intro"))
        // 만약 바꾸고자 하는 패널이 "type_before_intro" 이라면
        {
            // 이전 패널에서 전달 받은 값을 해당 클래스에 저장시켜줌
            this.NAME = NAME;

            // 바꾸고자 하는 패널 객체를 생성 (### 매개변수로 무조건 this와 바꾸고자 하는 패널에 전달할 변수를 넣어줘야함!###)
            intro_before_panel = new Intro_Before_Panel(this, NAME);

            // 위에서 생성한 객체로 갈아끼워주기
            getContentPane().removeAll(); // 기존 패널에 있는 컴포넌트 모두 삭제
            getContentPane().add(intro_before_panel); // 갈아끼워줄 패널에 존재하는 컴포넌트들을 추가해줌으로서 패널 바꿔줌

            // 다시 그려줌으로서 변경사항 업데이트 해주기
            revalidate();
            repaint();
        }


        // 위 if문과 구조 동일. 새로운 패널 만들 떄는 else if문으로 추가해줘!
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

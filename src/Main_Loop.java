// 커밋하기 귀찮을 때 이걸로 날먹할게요.. 너무 바쁠 때만 쓸게영

import javax.swing.*;

public class Main_Loop
    // 가장 먼저 실행되는 메인루프
{
    public static void main(String[] args)
    {
        // 패널을 교체하는 기능을 하는 JPanelChange 객체를 생성하고 win 변수 안에 저장, 사실상 win은 프레임 역할
        JPanelChange win = new JPanelChange();

        // 타이틀 설정
        win.setTitle("Pokemon");

        // win (JPanelChange객체) 안에 존재하는 setStart_panel() 메서드에
        // 자기 자신을 매개변수로 전달하여 생성한 Start_Panel을 매개변수로 전달하여 실행, win 안에 있는 변수 start_panel에 저장시킴
        win.setStart_panel(new Start_Panel(win)); // win.setStart_panel(new Start_Panel(win));

        // win (JPanelChange객체) 안에 존재하는 getStart_panel() 메서드는 win 안에 있는 변수 start_panel을 리턴받음
        // 리턴받은 패널을 추가시켜줌으로서 가장 먼저 사용자에게 보여지게 됨
        win.add(win.getStart_panel());

        // 프레임 설정
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 누르면 꺼짐
        win.setSize(1296,759); // 프레임 창 크기 설정
        win.setVisible(true); // 보여지도록 설정
    }
}
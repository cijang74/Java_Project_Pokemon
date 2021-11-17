import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Start_Panel extends JPanel{
    // 해당 클래스에서 사용할 변수들 선언 (win은 앵간하면 선언해줘)
    public static String NAME = null; // 이름
    private JLabel Say_Give_Name; // 라벨
    private JTextField Name_Text_Field; // 텍스트 필드
    private JButton Start_Button; // 버튼
    private JPanelChange win; // win

    public Start_Panel(JPanelChange win)
    // 처음 시작패널, 사용자에게 이름을 입력받음
    {
        // 매개변수로 전달받은 win을 해당 클래스 안에 있는 win에 저장 하므로서 여기서도 win이라는 이름으로 쓰게함
        this.win = win;

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 라벨 설정
        Say_Give_Name = new JLabel("포켓몬 세상에서 사용 할 당신의 이름을 입력하세요. (최대 6글자)"); // 라벨 내용
        Say_Give_Name.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        // 텍스트 필드 설정 + 텍스트 필드 리스너(특정한 이벤트가 발생하면 메서드를 실행해주는 것) 설정
        Name_Text_Field = new JTextField(6); // 입력가능한 문자의 개수 6
        Name_Text_Field.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            // 모든 [문자키] 중 하나를 눌렀다면
            {
                // 설정 안함
            }

            @Override
            public void keyPressed(KeyEvent e)
            // 모든 [키] 중 하나를 눌렀다면
            {
                // 만약 그게 왼쪽 엔터나 오른쪽 엔터키라면
                if (e.getKeyCode() == 13 || e.getKeyCode() == 10)
                {
                    NAME = Name_Text_Field.getText(); // 텍스트 필드에서 이름 받아오기
                    Name_Text_Field.setText(""); // 텍스트 필드안의 값 지워주기
                    Right_Name(); // 올바른 이름인지 검사하고 다음 패널로 바꿔주는 메서드 실행 (82줄에 메서드 정의됨)
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            // 모든 키 중 아무거나 눌렀다가 떼면
            {
                // 설정 안함

            }
        });

        // 버튼 설정 + 버튼 리스너 설정
        Start_Button = new JButton("시작"); // 버튼 안에 들어갈 텍스트 설정
        Start_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                // 엔터키를 눌렀을 때와 동일한 이벤트가 실행되도록 설정함!
                NAME = Name_Text_Field.getText(); // 텍스트 필드에서 이름 받아오기
                Name_Text_Field.setText(""); // 텍스트 필드안의 값 지워주기
                Right_Name(); // 올바른 이름인지 검사하고 다음 패널로 바꿔주는 메서드 실행 (82줄에 메서드 정의됨)
            }
        });

        // 위에서 설정한 컴포넌트들의 크기설정
        Say_Give_Name.setBounds(400, 100, 1280, 50);
        Name_Text_Field.setBounds(120, 200, 1020, 50);
        Start_Button.setBounds(500, 400, 300, 100);

        // 위에서 설정한 컴포넌트들을 패널에 추가해줌
        this.add(Say_Give_Name);
        this.add(Name_Text_Field);
        this.add(Start_Button);
    }

    private void Right_Name()
    // 사용자가 입력한 이름이 올바른지 검사하고 다음 패널로 바꿔주도록 하는 기능을 하는 메서드
    {
        // 만약 사용자가 입력한 이름의 길이가 6글자를 초과하는 경우
        if (NAME.length() > 6)
        {
            // 아래 내용으로 라벨을 변경 (default는 "포켓몬 세상에서 사용 할 당신의 이름을 입력하세요. (최대 6글자)")
            Say_Give_Name.setText("6글자가 초과되었습니다. 다시 입력하여 주십시오.");
        }

        // 만약 사용자가 입력한 이름이 공백이라면
        else if ((NAME.trim()).length() == 0)
        {
            Say_Give_Name.setText("이름이 입력되지 않았습니다. 다시 입력하여 주십시오.");
        }

        // 올바른 이름이 입력되었다면
        else
        {
            // win 함수 안에 있는 change()함수를 사용하여 다음 패널로 바꿔줌
            // (매개변수는 바꾸고자 하는 패널의 타입과 다른 패널에서도 해당 패널에서 입력받은 변수를 사용할 수 있도록 하는 변수)
            win.change("type_before_intro", NAME);
            // 해당 변수의 'NAME'이라는 변수를 win에 메서드에 보냄으로서 다른 패널들도 해당 변수를 사용할 수 있도록 함
        }
    }
}
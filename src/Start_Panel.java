import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Start_Panel extends JPanel{
    // 변수들 선언
    public static String NAME = null;
    private JLabel Say_Give_Name;
    private JTextField Name_Text_Field;
    private JButton Start_Button;
    private JPanelChange win;

    public Start_Panel(JPanelChange win)
            // 해당 패널은 맨 처음 보여지는 패널로서, 사용자에게 이름을 입력받는다.
    {
        this.win = win;
        setLayout(null);

        // 라벨 설정
        Say_Give_Name = new JLabel("포켓몬 세상에서 사용 할 당신의 이름을 입력하세요. (최대 6글자)");
        Say_Give_Name.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        // 텍스트 필드 설정 + 텍스트 필드 리스너 설정
        Name_Text_Field = new JTextField(6); // 입력가능한 문자의 개수 6
        Name_Text_Field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // 모든 문자키 중 하나를 눌렀다면

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 모든 키 중 하나를 눌렀다면
                if (e.getKeyCode() == 13 || e.getKeyCode() == 10)
                // 만약 그게 왼쪽 엔터나 오른쪽 엔터키라면
                {
                    NAME = Name_Text_Field.getText(); // 텍스트 필드에서 이름 받아오기
                    Name_Text_Field.setText(""); // 텍스트 필드안의 값 지워주기
                    Right_Name();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 모든 키 중 아무거나 눌렀다가 떼면

            }
        });

        // 버튼 설정 + 버튼 리스너 설정
        Start_Button = new JButton("시작");
        Start_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NAME = Name_Text_Field.getText();
                Name_Text_Field.setText("");
                Right_Name();
            }
        });

        // 페널에 추가
        Say_Give_Name.setBounds(400, 100, 1280, 50);
        this.add(Say_Give_Name);
        Name_Text_Field.setBounds(120, 200, 1020, 50);
        this.add(Name_Text_Field);
        Start_Button.setBounds(500, 400, 300, 100);
        this.add(Start_Button);
    }

    private void Right_Name()
    {
        if (NAME != null)
        {
            if (NAME.length() > 6)
            {
                Say_Give_Name.setText("6글자가 초과되었습니다. 다시 입력하여 주십시오.");
            }

            else if ((NAME.trim()).length() == 0)
            {
                Say_Give_Name.setText("이름이 입력되지 않았습니다. 다시 입력하여 주십시오.");
            }

            else
            {
                win.change("type_before_intro", NAME);
            }
        }
    }
}
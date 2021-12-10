import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Intro_Before_Panel extends JPanel
{
    // 해당 클래스에서 사용할 변수들 선언 (win은 앵간하면 선언해줘)
    private String NAME; // 이름
    private JLabel Say_Dr; // 라벨
    private ImageIcon Dr_Image = new ImageIcon("ui_Image\\오박사.png"); // 아이콘 이미지
    private JLabel Image_Label = new JLabel(Dr_Image); // 아이콘 이미지를 라벨화
    private ImageIcon nextImg1 = new ImageIcon("button_Image\\next1.png");
    private ImageIcon nextImg2 = new ImageIcon("button_Image\\next2.png");
    private ImageIcon BackGround = new ImageIcon("backGround_Image\\BackGround_Chat.png");
    private JLabel BackGround_Label = new JLabel(BackGround);
    private JButton Next_Button; // 버튼
    private int count = 0; // 대화가 끝났는지 확인하기 위한 변수
    private JPanelChange win; // win

    public Intro_Before_Panel(JPanelChange win, String NAME)
    // 포켓몬을 선택하기 전에 박사와 대화하는 패널
    {
        // 매개변수로 전달받은 win을 해당 클래스 안에 있는 win에 저장 하므로서 여기서도 win이라는 이름으로 쓰게함
        this.win = win;

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 라벨에서 사용할 대화들을 배열로 선언 (맨 처음 ""는 생략)
        String[] Say_Dr_Text = {"", "..................", "....아! 손님이 왔었군! ", "혹시 자네가 포켓몬 성장 연구를 도와겠다던 " + NAME + "군?",
        "정말 고맙네. 마침 일손이 부족하던 참이었어.", "아직 연구가 진횅되지 않은 포켓몬을 3마리나 발견했다네.", "그 중 한 마리를 자네에게 맡기도록 하겠네.",
        "선택을 번복할 수 없으니 신중히 결정하도록 하게.", "아 참, 트레이너의 성격에 맞는 포켓몬을 고른다면", "포켓몬을 더 재밌게 키울 수 있을 걸세." ,
                "여기 자네의 성격에 맞는 포켓몬을 한 번 골라보게."};

        // (처음에 보여지는) 라벨 설정
        Say_Dr = new JLabel("흐으음........."); // 라벨 내용
        Say_Dr.setFont(new Font ("Helvetica", Font.BOLD, 30)); // 라벨 폰트 설정


        // 버튼 설정 + 버튼 리스너 설정
        Next_Button = new JButton(nextImg1); // 버튼 안에 들어갈 텍스트 설정
        Next_Button.setRolloverIcon(nextImg2);
        Next_Button.setBorderPainted(false);
        Next_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                count++; // 카운트를 1 증가

                if(count == Say_Dr_Text.length) // 대화가 끝났다면(카운트 횟수가 준비된 대화 배열의 길이와 같아지면)
                {
                    // win 함수 안에 있는 change()함수를 사용하여 다음 패널로 바꿔줌
                    // (매개변수는 바꾸고자 하는 패널의 타입과 다른 패널에서도 해당 패널에서 입력받은 변수를 사용할 수 있도록 하는 변수)
                    win.change("type_choose", NAME);
                    // 해당 변수의 'NAME'이라는 변수를 win 메서드에 에 보냄으로서 다른 패널들도 해당 변수를 사용할 수 있도록 함
                }

                else // 대화가 안끝났으면
                {
                    // 다음 대화 불러와서 라벨 업데이트 해주기
                    Say_Dr.setText(Say_Dr_Text[count]);
                }
            }
        });

        // 위에서 설정한 컴포넌트들의 크기설정
        Image_Label.setBounds(550, 50, 180, 384);
        Say_Dr.setBounds(110, 585, 1280, 50);
        Next_Button.setBounds(1010, 570, 200, 100);
        BackGround_Label.setBounds(0,0,1280,720);

        // 위에서 설정한 컴포넌트들을 패널에 추가해줌
        this.add(Image_Label);
        this.add(Say_Dr);
        this.add(Next_Button);
        this.add(BackGround_Label);

    }
}

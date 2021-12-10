import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Intro_Choose_Panel extends JPanel
{
    // 해당 클래스에서 사용할 변수들 선언 (win은 앵간하면 선언해줘)
    private String NAME; // 이름
    private JLabel Say_Dr; // 라벨
    private JRadioButton [] Starting_Pokemon_Img = new JRadioButton[3]; // 라디오 버튼형 배열
    private String [] Text = {"열정적인 성격", "차분한 성격", "고통을 즐기는 성격"}; // 문자 배열
    private ImageIcon[] Pokemon_Images = {new ImageIcon("pokemon_Image\\리아코.png"), new ImageIcon("pokemon_Image\\브케인.png"), new ImageIcon("pokemon_Image\\치코리타.png")}; // 이미지 아이콘 배열
    private ImageIcon Dr_Image = new ImageIcon("ui_Image\\오박사.png"); // 이미지 아이콘
    private JLabel Dr_Image_Label = new JLabel(Dr_Image); // 아이콘 이미지를 라벨화
    private JLabel ImageLabel = new JLabel(); // 라벨
    private JButton Choose_Button; // 버튼
    private JPanelChange win; // win
    private ImageIcon chooseImg1 = new ImageIcon("button_Image\\choose1.png");
    private ImageIcon chooseImg2 = new ImageIcon("button_Image\\choose2.png");
    private ImageIcon BackGround = new ImageIcon("backGround_Image\\Choose_BackGround.png");
    private JLabel BackGround_Label = new JLabel(BackGround);

    public Intro_Choose_Panel(JPanelChange win, String NAME)
    // 처음 시작패널, 사용자에게 이름을 입력받음
    {
        // 매개변수로 전달받은 win을 해당 클래스 안에 있는 win에 저장 하므로서 여기서도 win이라는 이름으로 쓰게함
        this.win = win;

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 라벨 설정
        Say_Dr = new JLabel("선택을 번복할 수 없으니 신중히 결정하도록 하게."); // 라벨 내용
        Say_Dr.setFont(new Font ("Helvetica", Font.BOLD, 30)); // 라벨 폰트 설정

        // 버튼 설정
        Choose_Button = new JButton(chooseImg1);
        Choose_Button.setRolloverIcon(chooseImg2);
        Choose_Button.setBorderPainted(false);
        Choose_Button.addActionListener(new ButtonListener());

        ButtonGroup g = new ButtonGroup(); // 버튼들을 묶어줄 그룹 선언
        JPanel radioPanel = new JPanel(); // 라디오 패널 선언

        // 라디오 버튼을 설정해주는 반복문
        for(int i = 0; i <Starting_Pokemon_Img.length; i++)
        {
            Starting_Pokemon_Img[i] = new JRadioButton(Text[i]); // 라디오 버튼형 배열에 텍스트가 설정된 라디오 버튼 객체 생성 후 넣어줌
            Starting_Pokemon_Img[i].setBackground(Color.white);
            g.add(Starting_Pokemon_Img[i]); //그룹에 추가
            radioPanel.add(Starting_Pokemon_Img[i]); // 라디오 패널에 추가
            Starting_Pokemon_Img[i].addItemListener(new MyItemListener()); // 아래(71줄)에서 만든 리스너를 적용시켜줌
        }

        Starting_Pokemon_Img[0].setSelected(true); // 처음에는 0번째 배열에 있는 버튼이 선택되어있음(리아코)

        // 위에서 설정한 컴포넌트들의 크기설정
        radioPanel.setBounds(485, 530, 340, 30);
        Choose_Button.setBounds(400, 580, 500, 80);
        Say_Dr.setBounds(310, 10, 1000, 100);
        ImageLabel.setBounds(550, 240, 250, 250);
        Dr_Image_Label.setBounds(180, 120, 180, 384);
        BackGround_Label.setBounds(0,0,1280,720);

        radioPanel.setBackground(Color.white);

        // 위에서 설정한 컴포넌트들을 패널에 추가해줌
        this.add(radioPanel); // 포켓몬 선택하는거
        this.add(Choose_Button); // 결정
        this.add(Say_Dr); // 번복 ㄴㄴ
        this.add(ImageLabel); // 포켓몬 이미지
        this.add(Dr_Image_Label); // 박사 이미지
        this.add(BackGround_Label);
    }

    class MyItemListener implements ItemListener{
        // 라디오 버튼에 적용시켜줄 아이템 리스너
        public void itemStateChanged(ItemEvent e)
        {
            // 만약 0번째 라디오 버튼(리아코)가 선택되었다면
            if(Starting_Pokemon_Img[0].isSelected())
                // 이미지 라벨을 리아코 이미지로 변경해줌
                ImageLabel.setIcon(Pokemon_Images[0]);

            // 만약 1번째 라디오 버튼(브케인)가 선택되었다면
            else if(Starting_Pokemon_Img[1].isSelected())
                // 이미지 라벨을 브케인 이미지로 변경해줌
                ImageLabel.setIcon(Pokemon_Images[1]);

            // 만약 1번째 라디오 버튼(치코리타)가 선택되었다면
            else
                // 이미지 라벨을 치코리타 이미지로 변경해줌
                ImageLabel.setIcon(Pokemon_Images[2]);
        }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent event)
        {
            // 만약 0번째 라디오 버튼(리아코)가 선택되었다면
            if (Starting_Pokemon_Img[0].isSelected())
            {
                // 포켓몬 객체 생성
                Pokemon player_pokemon = new pokemon_riako();
                // 박사와 대화를 하는 패널2로 이동
                win.change("type_after_intro", player_pokemon);
            }

            // 만약 1번째 라디오 버튼(브케인)가 선택되었다면
            else if (Starting_Pokemon_Img[1].isSelected())
            {
                // 위 if문과 동일
                Pokemon player_pokemon = new pokemon_bcain();
                win.change("type_after_intro", player_pokemon);
            }

            // 만약 1번째 라디오 버튼(치코리타)가 선택되었다면
            else
            {
                Pokemon player_pokemon = new pokemon_chikorita();
                win.change("type_after_intro", player_pokemon);
            }
        }
    }
}

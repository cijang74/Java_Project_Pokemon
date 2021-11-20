import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test_Panel extends JPanel{
    // 각 프레임에 전달받아 쓰는 변수들
    public String NAME; // 이름
    public Pokemon player_pokemon;
    private int Dua_Date;
    private int Money;

    // 컴포넌트
    private JLabel Dua_Date_Label; // 라벨
    private JLabel Money_Label; // 라벨

    private JLabel Pokemon_Inform_Label; // 라벨
    private JLabel Pokemon_Level_Label; // 라벨
    private JLabel Pokemon_HP_Label; // 라벨
    private JLabel Pokemon_DF_Label; // 라벨
    private JLabel Pokemon_SPD_Label; // 라벨
    private JLabel Pokemon_ATK_Label; // 라벨

    private JButton Training_Button; // 버튼
    private JButton Grand_Prix_Button; // 버튼
    private JButton Normal_Fight_Button; // 버튼
    private JButton Shop_Button; // 버튼

    private JPanelChange win; // win

    private ImageIcon Pokemon_Image = new ImageIcon("리아코.png"); // 이미지 아이콘 배열
    private JLabel Pokemon_Image_Label = new JLabel(Pokemon_Image);
    private TitledBorder tborder;

    public Test_Panel(JPanelChange win)
    // 처음 시작패널, 사용자에게 이름을 입력받음
    {
        // 매개변수로 전달받은 win을 해당 클래스 안에 있는 win에 저장 하므로서 여기서도 win이라는 이름으로 쓰게함
        this.win = win;

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);
        tborder = new TitledBorder("리아코");
        tborder.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더...
        tborder.setTitleJustification(TitledBorder.CENTER);//자리맞춤을 가운데로 지정...
        Pokemon_Image_Label.setBorder(tborder);
        add(Pokemon_Image_Label);

        // 라벨 설정
        Dua_Date_Label = new JLabel("남은 기간: "); // 라벨 내용
        Dua_Date_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Money_Label = new JLabel("소지금: "); // 라벨 내용
        Money_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_Inform_Label = new JLabel("속성: 풀"); // 라벨 내용
        Pokemon_Inform_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_Level_Label = new JLabel("레벨: " + 1); // 라벨 내용
        Pokemon_Level_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_HP_Label = new JLabel("HP: " + 2); // 라벨 내용
        Pokemon_HP_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_DF_Label = new JLabel("DF: " + 3); // 라벨 내용
        Pokemon_DF_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_SPD_Label = new JLabel("SPD: " + 4); // 라벨 내용
        Pokemon_SPD_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_ATK_Label = new JLabel("ATK: " + 5); // 라벨 내용
        Pokemon_ATK_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        // 버튼 설정 + 버튼 리스너 설정
        Training_Button = new JButton("훈련"); // 버튼 안에 들어갈 텍스트 설정
        Training_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {

            }
        });

        Grand_Prix_Button = new JButton("그랑프리"); // 버튼 안에 들어갈 텍스트 설정
        Grand_Prix_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {

            }
        });

        Normal_Fight_Button = new JButton("일반대전"); // 버튼 안에 들어갈 텍스트 설정
        Normal_Fight_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {

            }
        });

        Shop_Button = new JButton("상점"); // 버튼 안에 들어갈 텍스트 설정
        Shop_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {

            }
        });

        // 위에서 설정한 컴포넌트들의 크기설정
        Dua_Date_Label.setBounds(1050, 550, 1280, 50);
        Money_Label.setBounds(1050, 580, 1280, 50);

        Pokemon_Level_Label.setBounds(90, 380, 1280, 50);
        Pokemon_Inform_Label.setBounds(190, 380, 1280, 50);
        Pokemon_HP_Label.setBounds(90, 430, 1280, 50);
        Pokemon_ATK_Label.setBounds(190, 430, 1280, 50);
        Pokemon_DF_Label.setBounds(90, 480, 1280, 50);
        Pokemon_SPD_Label.setBounds(190, 480, 1280, 50);

        Training_Button.setBounds(400, 120, 300, 100);
        Normal_Fight_Button.setBounds(400, 360, 300, 100);
        Grand_Prix_Button.setBounds(800, 120, 300, 100);
        Shop_Button.setBounds(800, 360, 300, 100);

        Pokemon_Image_Label.setBounds(50,100,250,280);

        // 위에서 설정한 컴포넌트들을 패널에 추가해줌
        this.add(Dua_Date_Label);
        this.add(Money_Label);
        this.add(Pokemon_Image_Label);
        this.add(Pokemon_Inform_Label);
        this.add(Pokemon_Level_Label);
        this.add(Pokemon_HP_Label);
        this.add(Pokemon_DF_Label);
        this.add(Pokemon_SPD_Label);
        this.add(Pokemon_ATK_Label);

        this.add(Training_Button);
        this.add(Normal_Fight_Button);
        this.add(Grand_Prix_Button);
        this.add(Shop_Button);
    }
}
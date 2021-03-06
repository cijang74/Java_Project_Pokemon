import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Select_Panel extends JPanel{
    // 각 프레임에 전달받아 쓰는 변수들
    public String NAME; // 이름
    public Pokemon player_pokemon; // 플레이어의 포켓몬 정보
    private int Dua_Date; // 남은기간
    private int Money; // 소지금

    // 컴포넌트
    private JLabel Dua_Date_Label; // 라벨
    private JLabel Money_Label; // 라벨

    private JLabel Pokemon_Inform_Label; // 라벨
    private JLabel Pokemon_Level_Label; // 라벨
    private JLabel Pokemon_HP_Label; // 라벨
    private JLabel Pokemon_DF_Label; // 라벨
    private JLabel Pokemon_SPD_Label; // 라벨
    private JLabel Pokemon_ATK_Label; // 라벨
    private JLabel Pokemon_Next_Level_Label; // 라벨

    private JButton Training_Button; // 버튼
    private JButton Grand_Prix_Button; // 버튼
    private JButton Normal_Fight_Button; // 버튼
    private JButton Shop_Button; // 버튼
    private JButton Last_Battle_Button;

    private TitledBorder tborder; // 컴포넌트를 둘러싸는 테두리

    private JPanelChange win; // win

    private ImageIcon BackGround = new ImageIcon("backGround_Image\\Select_BackGround.png"); // 배경 이미지

    private ImageIcon practiceImg1 = new ImageIcon("button_Image\\practice_battle1.png");
    private ImageIcon practiceImg2 = new ImageIcon("button_Image\\practice_battle2.png");

    private ImageIcon grandprixImg1 = new ImageIcon("button_Image\\grandprix1.png");
    private ImageIcon grandprixImg2 = new ImageIcon("button_Image\\grandprix2.png");

    private ImageIcon shopImg1 = new ImageIcon("button_Image\\shop1.png");
    private ImageIcon shopImg2 = new ImageIcon("button_Image\\shop2.png");

    private ImageIcon trainingImg1 = new ImageIcon("button_Image\\Training1.png");
    private ImageIcon trainingImg2 = new ImageIcon("button_Image\\Training2.png");

    private ImageIcon lastImg1 = new ImageIcon("button_Image\\Last_battle1.png");
    private ImageIcon lastImg2 = new ImageIcon("button_Image\\Last_battle2.png");

    public Clip clip2;
    public AudioInputStream ais2;

    private JLabel BackGround_Label = new JLabel(BackGround); // 배경 이미지를 라벨로 만들어서 배치

    public Select_Panel(JPanelChange win, String NAME, Pokemon player_pokemon, int Dua_Date, int Money)
    // 처음 시작패널, 사용자에게 이름을 입력받음
    {
        // 매개변수로 전달받은 값들을 해당 클래스에 저장
        this.win = win;
        this.player_pokemon = player_pokemon;
        this.Dua_Date = Dua_Date;
        this.Money = Money;

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 포켓몬 이미지 라벨을 테두리로 둘러싸줌
        tborder = new TitledBorder(player_pokemon.Name); // 컴포넌트 타이틀은 포켓몬의 이름으로
        tborder.setTitlePosition(TitledBorder.ABOVE_TOP); //지정한 위치에 타이틀을 나타내주는 보더: 라벨 상단에
        tborder.setTitleJustification(TitledBorder.CENTER); //자리맞춤을 가운데로 지정...
        player_pokemon.Portray.setBorder(tborder); // 태두리 설정
        this.add(player_pokemon.Portray); // 포켓몬 이미지 라벨 그려주기

        // 라벨 설정
        Dua_Date_Label = new JLabel("남은 기간: " + Dua_Date); // 라벨 내용
        Dua_Date_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Money_Label = new JLabel("소지금: " + Money); // 라벨 내용
        Money_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_Inform_Label = new JLabel("속성: " + player_pokemon.type); // 라벨 내용
        Pokemon_Inform_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_Level_Label = new JLabel("레벨: " + player_pokemon.Level); // 라벨 내용
        Pokemon_Level_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_HP_Label = new JLabel("HP: " + player_pokemon.Full_Hp); // 라벨 내용
        Pokemon_HP_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_DF_Label = new JLabel("DF: " + player_pokemon.Full_Def); // 라벨 내용
        Pokemon_DF_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_SPD_Label = new JLabel("SPD: " + player_pokemon.Full_Spd); // 라벨 내용
        Pokemon_SPD_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_ATK_Label = new JLabel("ATK: " + player_pokemon.Full_Atk); // 라벨 내용
        Pokemon_ATK_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Pokemon_Next_Level_Label = new JLabel("다음 레벨업 까지: " + player_pokemon.Exp + "/" + (Next_Level_Config())); // 라벨 내용
        Pokemon_Next_Level_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        // 버튼 설정 + 버튼 리스너 설정
        Training_Button = new JButton(trainingImg1); // 버튼 안에 들어갈 텍스트 설정
        Training_Button.setRolloverIcon(trainingImg2);
        Training_Button.setBorderPainted(false);
        Training_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                btSound();
                win.change("type_training", player_pokemon);
            }
        });

        Grand_Prix_Button = new JButton(grandprixImg1); // 버튼 안에 들어갈 텍스트 설정
        Grand_Prix_Button.setRolloverIcon(grandprixImg2);
        Grand_Prix_Button.setBorderPainted(false);
        Grand_Prix_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                btSound();
                win.change("type_grand_prix", player_pokemon);
            }
        });

        Normal_Fight_Button = new JButton(practiceImg1); // 버튼 안에 들어갈 텍스트 설정
        Normal_Fight_Button.setRolloverIcon(practiceImg2);
        Normal_Fight_Button.setBorderPainted(false);
        Normal_Fight_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                btSound();
                win.change("type_normal_fight", player_pokemon);
            }
        });

        Shop_Button = new JButton(shopImg1); // 버튼 안에 들어갈 텍스트 설정
        Shop_Button.setRolloverIcon(shopImg2);
        Shop_Button.setBorderPainted(false);
        Shop_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                btSound();
                win.change("type_shop", player_pokemon);
            }
        });

        Last_Battle_Button = new JButton(lastImg1); // 버튼 안에 들어갈 텍스트 설정
        Last_Battle_Button.setRolloverIcon(lastImg2);
        Last_Battle_Button.setBorderPainted(false);
        Last_Battle_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                btSound();
                win.change("type_last_fight", player_pokemon);
            }
        });

        // 위에서 설정한 컴포넌트들의 크기설정
        Dua_Date_Label.setBounds(1120, 620, 1280, 50);
        Money_Label.setBounds(1120, 650, 1280, 50);

        Pokemon_Level_Label.setBounds(90, 390, 1280, 50);
        Pokemon_Inform_Label.setBounds(190, 390, 1280, 50);
        Pokemon_HP_Label.setBounds(90, 440, 1280, 50);
        Pokemon_ATK_Label.setBounds(190, 440, 1280, 50);
        Pokemon_DF_Label.setBounds(90, 490, 1280, 50);
        Pokemon_SPD_Label.setBounds(190, 490, 1280, 50);
        Pokemon_Next_Level_Label.setBounds(90, 540, 1280, 50);

        Training_Button.setBounds(400, 120, 300, 100);
        Grand_Prix_Button.setBounds(800, 120, 300, 100);
        Normal_Fight_Button.setBounds(400, 400, 300, 100);
        Shop_Button.setBounds(800, 400, 300, 100);

        Last_Battle_Button.setBounds(600,550,300,100);

        player_pokemon.Portray.setBounds(50,100,290,290);

        BackGround_Label.setBounds(0,0,1280,720);

        // 위에서 설정한 컴포넌트들을 패널에 추가해줌
        this.add(Dua_Date_Label);
        this.add(Money_Label);
        this.add(Pokemon_Inform_Label);
        this.add(Pokemon_Level_Label);
        this.add(Pokemon_HP_Label);
        this.add(Pokemon_DF_Label);
        this.add(Pokemon_SPD_Label);
        this.add(Pokemon_ATK_Label);
        this.add(Pokemon_Next_Level_Label);

        this.add(Training_Button);
        this.add(Normal_Fight_Button);
        this.add(Grand_Prix_Button);
        this.add(Shop_Button);

        // 5의 배수인 날은 그랑프리 패널만 선택 가능
        if ((Dua_Date != 30 && Dua_Date != 0) && Dua_Date % 5 ==0)
        {
            Training_Button.setEnabled(false);
            Normal_Fight_Button.setEnabled(false);
            Shop_Button.setEnabled(false);
            Grand_Prix_Button.setEnabled(true);
        }

        else if(Dua_Date == 0)
        {
            Training_Button.setEnabled(false);
            Normal_Fight_Button.setEnabled(false);
            Shop_Button.setEnabled(false);
            Grand_Prix_Button.setEnabled(false);
            this.add(Last_Battle_Button);
        }

        else
        {
            Training_Button.setEnabled(true);
            Normal_Fight_Button.setEnabled(true);
            Shop_Button.setEnabled(true);
            Grand_Prix_Button.setEnabled(false);
        }

        this.add(BackGround_Label);
    }

    public int Next_Level_Config()
    {
        if (player_pokemon.Level == 1)
        {
            return 5;
        }

        else if (player_pokemon.Level == 2)
        {
            return 15;
        }

        else if (player_pokemon.Level == 3)
        {
            return 30;
        }

        else if (player_pokemon.Level == 3)
        {
            return 50;
        }

        else if (player_pokemon.Level == 4)
        {
            return 75;
        }

        else if (player_pokemon.Level == 5)
        {
            return 105;
        }

        else if (player_pokemon.Level == 6)
        {
            return 140;
        }

        else if (player_pokemon.Level == 7)
        {
            return 180;
        }
        return -1;
    }

    public void btSound(){
        try {
            this.ais2 = AudioSystem.getAudioInputStream(new File("bgm\\button.wav"));
            this.clip2 = AudioSystem.getClip();
            clip2.stop();
            clip2.open(ais2);
            clip2.start();
        }
        catch (Exception ex) { }
    }
}

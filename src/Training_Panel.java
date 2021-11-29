import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class Training_Panel extends JPanel{

    public Pokemon player_pokemon;
    private int Dua_Date;
    private int Money;

    private JLabel Dua_Date_Label;//남은 기간 라벨
    private JLabel Money_Label;//돈 라벨

    private JLabel Hp_Training_Label; // 체력 훈련 설명 라벨
    private JLabel Atk_Training_Label; // 공격력 훈련 설명 라벨
    private JLabel Def_Training_Label; // 방어력 훈련 설명 라벨
    private JLabel Spd_Training_Label; // 스피드 훈련 설명 라벨

    private JButton Running_Button; // 달리기 훈련 버튼(체력)
    private JButton Bench_button; // 벤치 프레스 훈련 버튼(공격력)
    private JButton Punch_button; // 펀치 훈련 버튼(방어력)
    private JButton Rope_button; // 줄넘기 훈련 버튼(스피드)

    private JButton Back_Button; // 돌아가기 버튼

    private JPanelChange win;

    private ImageIcon Running = new ImageIcon("달리기.png");
    private ImageIcon Bench = new ImageIcon("역기.png");
    private ImageIcon Punch = new ImageIcon("펀치.png");
    private ImageIcon Rope = new ImageIcon("줄넘기.png");

    private JLabel Running_Img = new JLabel(Running);
    private JLabel Bench_Img = new JLabel(Bench);
    private JLabel Punch_Img = new JLabel(Punch);
    private JLabel Rope_Img = new JLabel(Rope);

    private ImageIcon BackGround = new ImageIcon("Tranning_BackGround.png");
    private JLabel BackGround_Label = new JLabel(BackGround);

    public Training_Panel(JPanelChange win, Pokemon player_pokemon, int Dua_Date, int Money)
    {
        this.win = win;
        this.player_pokemon = player_pokemon;
        this.Dua_Date = Dua_Date;
        this.Money = Money;

        setLayout(null); // 배치관리자 X

        Dua_Date_Label = new JLabel("남은 기간: " + Dua_Date);  // 라벨 설정
        Dua_Date_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Money_Label = new JLabel("소지금: " + Money);
        Money_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Hp_Training_Label = new JLabel("달리기 훈련(HP를 일정치 올려준다.)");
        Hp_Training_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Atk_Training_Label = new JLabel("역기 훈련(ATK를 일정치 올려준다.)");
        Atk_Training_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Def_Training_Label = new JLabel("펀치 훈련(DF를 일정치 올려준다.)");
        Def_Training_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Spd_Training_Label = new JLabel("줄넘기 훈련(SPD를 일정치 올려준다.)");
        Spd_Training_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Back_Button = new JButton("돌아가기");
        Back_Button.setFont(new Font ("Helvetica", Font.PLAIN, 20));
        Back_Button.addActionListener(new ActionListener() // 돌아가기 버튼을 클릭했을떄
        {
            public void actionPerformed(ActionEvent e)
            {
                win.change("type_select", player_pokemon); // 선택 패널로 돌아가기
            }
        });

        Running_Button = new JButton("훈련하기");
        Running_Button.setFont(new Font ("Helvetica", Font.PLAIN, 20));
        Running_Button.setForeground(Color.BLACK);
        Running_Button.addActionListener(new ActionListener() // 오랭열매 구매버튼을 클릭했을때
        {
            public void actionPerformed(ActionEvent e)
            {
                Random random = new Random();
                int ran = random.nextInt(3) + 1; // 1부터 3까지 임의의 숫자 생성
                JOptionPane.showMessageDialog(null, "HP가"+ ran +"만큼 상승했습니다."); //알림
                player_pokemon.Full_Hp += ran; // 임의의 숫자 해당하는 값에 더하기
                player_pokemon.Hp = player_pokemon.Full_Hp;
                win.Dua_Date -= 1; // 기간 조정
                win.change("type_select", player_pokemon); // 선택패널로 돌아가기

            }
        }); // 이하 같음
        Bench_button = new JButton("훈련하기");
        Bench_button.setFont(new Font ("Helvetica", Font.PLAIN, 20));
        Bench_button.setForeground(Color.BLACK);
        Bench_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                Random random = new Random();
                int ran = random.nextInt(3) + 1;
                JOptionPane.showMessageDialog(null, "ATK가"+ ran +"만큼 상승했습니다.");
                player_pokemon.Full_Atk += ran;
                player_pokemon.Atk = player_pokemon.Full_Atk;
                win.Dua_Date -= 1;
                win.change("type_select", player_pokemon);
            }
        });
        Punch_button = new JButton("훈련하기");
        Punch_button.setFont(new Font ("Helvetica", Font.PLAIN, 20));
        Punch_button.setForeground(Color.BLACK);
        Punch_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                Random random = new Random();
                int ran = random.nextInt(3) + 1;
                JOptionPane.showMessageDialog(null, "DF가"+ ran +"만큼 상승했습니다.");
                player_pokemon.Full_Def += ran;
                player_pokemon.Def = player_pokemon.Full_Def;
                win.Dua_Date -= 1;
                win.change("type_select", player_pokemon);
            }
        });
        Rope_button = new JButton("훈련하기");
        Rope_button.setFont(new Font ("Helvetica", Font.PLAIN, 20));
        Rope_button.setForeground(Color.BLACK);
        Rope_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Random random = new Random();
                int ran = random.nextInt(3) + 1;
                JOptionPane.showMessageDialog(null, "SPD가"+ ran +"만큼 상승했습니다.");
                player_pokemon.Full_Spd += ran;
                player_pokemon.Spd = player_pokemon.Full_Spd;
                win.Dua_Date -= 1;
                win.change("type_select", player_pokemon);
            }
        });

        // 라벨과 버튼 배치
        Dua_Date_Label.setBounds(1120, 620, 1280, 50);
        Money_Label.setBounds(1120, 650, 1280, 50);

        Hp_Training_Label.setBounds(180, 0, 300, 100);
        Atk_Training_Label.setBounds(780, 0, 300, 100);
        Def_Training_Label.setBounds(180, 330, 300, 100);
        Spd_Training_Label.setBounds(780, 330, 350, 100);

        Back_Button.setBounds(0, 0, 150, 100);
        Running_Button.setBounds(200, 300, 150, 50);
        Bench_button.setBounds(850, 300, 150, 50);
        Punch_button.setBounds(200, 600, 150, 50);
        Rope_button.setBounds(850, 600, 150, 50);

        Running_Img.setBounds(40, 80,  500, 200);
        Bench_Img.setBounds(670, 80, 500, 200);
        Punch_Img.setBounds(40, 250, 500, 500);
        Rope_Img.setBounds(670, 250, 500, 500);

        BackGround_Label.setBounds(0,0,1280,720);

        this.add(Dua_Date_Label);
        this.add(Money_Label);

        this.add(Hp_Training_Label);
        this.add(Atk_Training_Label);
        this.add(Def_Training_Label);
        this.add(Spd_Training_Label);

        this.add(Back_Button);
        this.add(Running_Button);
        this.add(Bench_button);
        this.add(Punch_button);
        this.add(Rope_button);

        this.add(Running_Img);
        this.add(Bench_Img);
        this.add(Punch_Img);
        this.add(Rope_Img);

        this.add(BackGround_Label);
    }
}
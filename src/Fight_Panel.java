import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Fight_Panel extends JPanel
{
    // 각 프레임에 전달받아 쓰는 변수들
    public String NAME; // 이름
    public Pokemon player_pokemon; // 플레이어의 포켓몬 정보
    public Opponent opponent;
    private int Dua_Date; // 남은기간
    private int Money; // 소지금
    private int turn = 0;

    // 컴포넌트: 라벨
    private JLabel now_Panel;
    private JLabel battle_Log;
    private JLabel battle_Log2;
    private JLabel battle_Log3;
    private JLabel battle_Log4;
    private JLabel battle_Log5;
    private JLabel battle_Log6;
    private JLabel battle_Log7;
    private JLabel battle_Log8;
    private JLabel battle_Log9;

    private JLabel player_name;
    private JLabel opponent_name; // 상대 트래이너 이름

    // 컴포넌트: 버튼(플레이어)
    private JButton p_Skill1;
    private JButton p_Skill2;
    private JButton p_Skill3;
    private JButton p_Skill4;

    // 컴포넌트: 버튼
    private JButton Back_Button; // 돌아가기 버튼

    private ImageIcon Log_Background = new ImageIcon("Log.png");
    private JLabel Log_Background_Label = new JLabel(Log_Background);

    private TitledBorder tborder; // 컴포넌트를 둘러싸는 테두리

    private JPanelChange win; // win

    public Fight_Panel(JPanelChange win, String NAME, Pokemon player_pokemon, int Dua_Date, int Money)
    {
        // 매개변수로 전달받은 값들을 해당 클래스에 저장
        this.win = win;
        this.NAME = NAME;
        this.player_pokemon = player_pokemon;
        this.Dua_Date = Dua_Date;
        this.Money = Money;

        // 상대 생성
       this.opponent = new Opponent(false, player_pokemon);

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 라벨 설정
        now_Panel = new JLabel(Label_Config()); // 라벨 내용
        now_Panel.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        battle_Log = new JLabel(opponent.opponent_name + "과(와)의 대전이 시작되었다!"); // 라벨 내용
        battle_Log.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        player_name = new JLabel(NAME); // 라벨 내용
        player_name.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        opponent_name = new JLabel(opponent.opponent_name); // 라벨 내용
        opponent_name.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        // 버튼 설정 + 버튼 리스너 설정
        p_Skill1 = new JButton(player_pokemon.skillArray[0]); // 버튼 안에 들어갈 텍스트 설정
        p_Skill1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                player_turn_attack(player_pokemon.skillArray[0]);
            }
        });

        p_Skill2 = new JButton(player_pokemon.skillArray[1]); // 버튼 안에 들어갈 텍스트 설정
        p_Skill2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {
                player_turn_attack(player_pokemon.skillArray[1]);
            }
        });

        if (player_pokemon.skillArray[2] != null)
        {
            p_Skill3 = new JButton("skill3"); // 버튼 안에 들어갈 텍스트 설정
            p_Skill3.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                // 버튼을 클릭하면
                {

                }
            });
            p_Skill3.setBounds(50, 550, 290, 50);
            this.add(p_Skill3);
        }

        if (player_pokemon.skillArray[3] != null)
        {
            p_Skill4 = new JButton("skill4"); // 버튼 안에 들어갈 텍스트 설정
            p_Skill4.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                // 버튼을 클릭하면
                {

                }
            });
            p_Skill4.setBounds(50, 610, 290, 50);
            this.add(p_Skill4);
        }

        Back_Button = new JButton("돌아가기");
        Back_Button.setFont(new Font ("Helvetica", Font.PLAIN, 20));
        Back_Button.addActionListener(new ActionListener() // 돌아가기 버튼을 클릭했을떄
        {
            public void actionPerformed(ActionEvent e)
            {
                win.change("type_select", player_pokemon); // 선택 패널로 돌아가기
            }
        });

        now_Panel.setBounds(600, 10, 1280,50);
        battle_Log.setBounds(370,65, 1280,30);
        player_name.setBounds(50, 370, 1280, 50);
        opponent_name.setBounds(930, 370, 1280, 50);

        p_Skill1.setBounds(50, 430, 290, 50);
        p_Skill2.setBounds(50, 490, 290, 50);
        Back_Button.setBounds(1000,500,150,100);

        player_pokemon.Portray.setBounds(50,50,290,290);
        opponent.opponent_pokemon.Portray.setBounds(930,50,290,290);

        Log_Background_Label.setBounds(360,60,546,593);

        // 포켓몬 이미지 라벨을 테두리로 둘러싸줌
        tborder = new TitledBorder(opponent.opponent_pokemon.Name); // 컴포넌트 타이틀은 포켓몬의 이름으로
        tborder.setTitlePosition(TitledBorder.ABOVE_TOP); //지정한 위치에 타이틀을 나타내주는 보더: 라벨 상단에
        tborder.setTitleJustification(TitledBorder.CENTER); //자리맞춤을 가운데로 지정...
        opponent.opponent_pokemon.Portray.setBorder(tborder); // 태두리 설정

        this.add(now_Panel);
        this.add(battle_Log);
        this.add(player_name);
        this.add(opponent_name);

        this.add(p_Skill1);
        this.add(p_Skill2);

        this.add(player_pokemon.Portray);
        this.add(opponent.opponent_pokemon.Portray);
        this.add(Log_Background_Label);

        if (player_pokemon.Spd < opponent.opponent_pokemon.Spd || turn == 0)
        // 상대가 스피드가 더 빠르다면 상대 먼저 선제공격
        {
            Opponent_turn_attack();
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(52 - 1, 350 - 1, 286+1, 30+1);
        g.setColor(Color.RED);

        if ((int)(286*((double)player_pokemon.Hp / (double) player_pokemon.Full_Hp)) > 0)
        {
            g.fillRect(52,350,(int)(286*((double)player_pokemon.Hp / (double) player_pokemon.Full_Hp)),30);
            this.add(Back_Button);
        }

        else
        {
            g.fillRect(52,350,0,30);
        }

        g.setColor(Color.BLACK);
        g.drawRect(932 - 1, 350 - 1, 286+1, 30+1);
        g.setColor(Color.RED);

        if ((int)(286*((double)opponent.opponent_pokemon.Hp / (double) opponent.opponent_pokemon.Full_Hp)) > 0)
        {
            g.fillRect(52,350,(int)(286*((double)opponent.opponent_pokemon.Hp / (double) opponent.opponent_pokemon.Full_Hp)),30);
            this.add(Back_Button);
        }

        else
        {
            g.fillRect(52,350,0,30);
        }

        repaint();
    }

    private String Label_Config()
    {
        String str = new String("일반 대전");
        return str;
    }

    public void player_turn_attack(String skill)
    {
        // 일정 시간 이후에 실행할 코드
        System.out.print("플레이어 포켓몬 행동함");
        player_pokemon.Use_Skill(player_pokemon, opponent, skill);
        turn++;
        Opponent_turn_attack();
    }

    private void Opponent_turn_attack()
    {
        p_Skill1.setEnabled(false);
        p_Skill2.setEnabled(false);

        if (player_pokemon.skillArray[2] != null)
        {
            p_Skill3.setEnabled(false);
        }
        if (player_pokemon.skillArray[3] != null)
        {
            p_Skill4.setEnabled(false);
        }

        Timer timer1 = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                // 일정 시간 이후에 실행할 코드
                opponent.opponent_pokemon.Opponent_Use_Skill(player_pokemon, opponent);
                p_Skill1.setEnabled(true);
                p_Skill2.setEnabled(true);

                if (player_pokemon.skillArray[2] != null)
                {
                    p_Skill3.setEnabled(true);
                }
                if (player_pokemon.skillArray[3] != null)
                {
                    p_Skill4.setEnabled(true);
                }
                System.out.print("현재 체력은 " + player_pokemon.Hp + " / " + player_pokemon.Full_Hp + "\n");
                System.out.print((int)(286*((double)player_pokemon.Hp / (double) player_pokemon.Full_Hp)));
            }
        };
        timer1.schedule(task1,3000);
        turn++;
    }
}

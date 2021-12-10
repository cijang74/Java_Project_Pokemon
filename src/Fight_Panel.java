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
    private String[] result = new String[20];
    boolean end = true; // 현재 배틀이 끝났는지 알기 위한 부울 변수
    boolean isWin = true; // 배틀에서 이겼는지 확인하기 위한 부울 변수

    // 포켓몬이 레벨업 했는지를 확인하기 위한 변수들
    private int before_level; // 대전에 참여하기 전 포켓몬의 레벨
    private int after_level; // 대전에 참여 후 포켓몬의 레벨

    // 컴포넌트: 라벨
    private JLabel now_Panel; // 현재 패널 (일반 대전 or 그랑프리 or 마지막 대전)
    private JLabel[] battle_Log = new JLabel[20]; // 배틀 로그

    private JLabel player_name; // 플레이어 이름
    private JLabel opponent_name; // 상대 트레이너 이름

    // 컴포넌트: 버튼(플레이어) - 포켓몬 스킬들
    private JButton p_Skill1;
    private JButton p_Skill2;
    private JButton p_Skill3;
    private JButton p_Skill4;

    // 컴포넌트: 버튼
    private JButton Back_Button; // 돌아가기 버튼

    private ImageIcon Log_Background = new ImageIcon("ui_Image\\Log.png");
    private JLabel Log_Background_Label = new JLabel(Log_Background);

    private TitledBorder tborder; // 컴포넌트를 둘러싸는 테두리

    private JPanelChange win; // win

    private ImageIcon BackGround = new ImageIcon("backGround_Image\\Battle_BackGround.png"); // 배경 이미지
    private JLabel BackGround_Label = new JLabel(BackGround); // 배경 이미지를 라벨로 만들어서 배치

    public Fight_Panel(JPanelChange win, String NAME, Pokemon player_pokemon, int Dua_Date, int Money, String type)
    {
        // 매개변수로 전달받은 값들을 해당 클래스에 저장
        this.win = win;
        this.NAME = NAME;
        this.player_pokemon = player_pokemon;
        this.Dua_Date = Dua_Date;
        this.Money = Money;

        if (type == "type_last_fight")
        {
            this.opponent = new Opponent(true, player_pokemon);
        }

        else
        {
            // 상대 생성
            this.opponent = new Opponent(false, player_pokemon);
        }

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 라벨 설정
        now_Panel = new JLabel(Label_Config(type)); // 라벨 내용
        now_Panel.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        battle_Log[0] = new JLabel(opponent.opponent_name + "과(와)의 대전이 시작되었다!"); // 라벨 내용
        battle_Log[0].setFont(new Font ("Helvetica", Font.PLAIN, 15)); // 라벨 폰트 설정

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
            p_Skill3 = new JButton(player_pokemon.skillArray[2]); // 버튼 안에 들어갈 텍스트 설정
            p_Skill3.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                // 버튼을 클릭하면
                {
                    {
                        player_turn_attack(player_pokemon.skillArray[2]);
                    }
                }
            });
            p_Skill3.setBounds(50, 550, 290, 50);
            this.add(p_Skill3);
        }

        if (player_pokemon.skillArray[3] != null)
        {
            p_Skill4 = new JButton(player_pokemon.skillArray[3]); // 버튼 안에 들어갈 텍스트 설정
            p_Skill4.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                // 버튼을 클릭하면
                {
                    player_turn_attack(player_pokemon.skillArray[3]);
                }
            });
            p_Skill4.setBounds(50, 610, 290, 50);
            this.add(p_Skill4);
        }

        Back_Button = new JButton(Button_Config(type));
        Back_Button.setFont(new Font ("Helvetica", Font.PLAIN, 20));
        Back_Button.setEnabled(false);
        Back_Button.addActionListener(new ActionListener() // 돌아가기 버튼을 클릭했을 때
        {
            public void actionPerformed(ActionEvent e)
            {
                if (type == "type_normal_fight" && isWin == true)
                {
                    win.Money += 50;
                    player_pokemon.Exp += 5;
                    before_level = player_pokemon.Level;
                    player_pokemon.Exp_Update();
                    after_level = player_pokemon.Level;
                    if (before_level != after_level)
                    {
                        player_pokemon.Level_Stat_Update();
                    }
                    win.Dua_Date -= 1;
                    win.change("type_select", player_pokemon); // 선택 패널로 돌아가기
                }
                else if (type == "type_grand_prix" && isWin == true)
                {
                    win.Money += 200;
                    player_pokemon.Exp += 10;
                    before_level = player_pokemon.Level;
                    player_pokemon.Exp_Update();
                    after_level = player_pokemon.Level;
                    if (before_level != after_level)
                    {
                        player_pokemon.Level_Stat_Update();
                    }
                    win.Dua_Date -= 1;
                    win.change("type_select", player_pokemon); // 선택 패널로 돌아가기
                }
                else if (type == "type_last_fight" && isWin == true)
                {
                    win.Money += 200;
                    player_pokemon.Exp += 10;
                    before_level = player_pokemon.Level;
                    player_pokemon.Exp_Update();
                    after_level = player_pokemon.Level;
                    if (before_level != after_level)
                    {
                        player_pokemon.Level_Stat_Update();
                    }
                    win.Dua_Date -= 1;
                    win.change("type_outro", player_pokemon); // 선택 패널로 돌아가기
                }
                else if (type == "type_last_fight" && isWin == false)
                {
                    win.Money += 200;
                    player_pokemon.Exp += 10;
                    player_pokemon.Exp_Update();
                    win.Dua_Date -= 1;
                    win.change("type_failure", player_pokemon); // 선택 패널로 돌아가기
                }
                else
                {
                    win.Dua_Date -= 1;
                    win.change("type_select", player_pokemon); // 선택 패널로 돌아가기
                }
            }
        });

        now_Panel.setBounds(600, 10, 1280,50);

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
        this.add(player_name);
        this.add(opponent_name);

        this.add(p_Skill1);
        this.add(p_Skill2);

        battle_Log[0].setBounds(370,65 + (0 * 30), 1280,30);
        this.add(battle_Log[0]);

        this.add(player_pokemon.Portray);
        this.add(opponent.opponent_pokemon.Portray);
        this.add(Log_Background_Label);
        this.add(Back_Button);

        if (player_pokemon.Spd < opponent.opponent_pokemon.Spd && turn == 0)
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
        g.setColor(Color.GREEN);

        if ((int)(286*((double)player_pokemon.Hp / (double) player_pokemon.Full_Hp)) > 0)
        {
            g.fillRect(52,350,(int)(286*((double)player_pokemon.Hp / (double) player_pokemon.Full_Hp)),30);
        }

        else
        {
            g.fillRect(52,350,0,30);

            Back_Button.setEnabled(true);
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
        }

        g.setColor(Color.BLACK);
        g.drawRect(932 - 1, 350 - 1, 286+1, 30+1);
        g.setColor(Color.RED);

        if ((int)(286*((double)opponent.opponent_pokemon.Hp / (double) opponent.opponent_pokemon.Full_Hp)) > 0)
        {
            g.fillRect(932,350,(int)(286*((double)opponent.opponent_pokemon.Hp / (double) opponent.opponent_pokemon.Full_Hp)),30);
        }

        else
        {
            g.fillRect(932,350,0,30);
            Back_Button.setEnabled(true);
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
        }

        BackGround_Label.setBounds(0,0,1280,720);
        this.add(BackGround_Label);
        repaint();
    }

    private String Label_Config(String type)
    {
        if (type == "type_normal_fight")
        {
            String str = new String("일반 대전");
            return str;
        }

        else if (type == "type_grand_prix")
        {
            String str = new String("그랑프리");
            return str;
        }

        else
        {
            String str = new String("최종 결전");
            return str;
        }
    }

    private String Button_Config(String type)
    {
        if (type == "type_last_fight")
        {
            String str = new String("엔딩");
            return str;
        }

        else
        {
            String str = new String("돌아가기");
            return str;
        }
    }

    public void player_turn_attack(String skill)
    {
        turn++;
        result[turn] = player_pokemon.Use_Skill(player_pokemon, opponent, skill);

        battle_Log[turn] = new JLabel(result[turn]); // 라벨 내용
        battle_Log[turn].setFont(new Font ("Helvetica", Font.PLAIN, 15)); // 라벨 폰트 설정
        Update_Log();

        if(opponent.opponent_pokemon.Hp <= 0)
        {
            battle_Log[turn + 1] = new JLabel("대전에서 승리하였다!"); // 라벨 내용
            battle_Log[turn + 1].setFont(new Font ("Helvetica", Font.PLAIN, 15)); // 라벨 폰트 설정
            Update_Log(end);
            isWin = true;
        }
        else
        {
            Opponent_turn_attack();
        }
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
                result[turn] = opponent.opponent_pokemon.Opponent_Use_Skill(player_pokemon, opponent);
                if(player_pokemon.Hp <= 0)
                {
                    battle_Log[turn] = new JLabel(result[turn]); // 라벨 내용
                    battle_Log[turn].setFont(new Font ("Helvetica", Font.PLAIN, 15)); // 라벨 폰트 설정
                    battle_Log[turn + 1] = new JLabel("대전에서 패배하였다..."); // 라벨 내용
                    battle_Log[turn + 1].setFont(new Font ("Helvetica", Font.PLAIN, 15)); // 라벨 폰트 설정
                    Update_Log(end);
                    isWin = false;
                }

                else
                {
                    p_Skill1.setEnabled(true);
                    p_Skill2.setEnabled(true);

                    battle_Log[turn] = new JLabel(result[turn]); // 라벨 내용
                    battle_Log[turn].setFont(new Font ("Helvetica", Font.PLAIN, 15)); // 라벨 폰트 설정

                    if (player_pokemon.skillArray[2] != null)
                    {
                        p_Skill3.setEnabled(true);
                    }
                    if (player_pokemon.skillArray[3] != null)
                    {
                        p_Skill4.setEnabled(true);
                    }
                    Update_Log();
                }
            }
        };
        turn++;
        timer1.schedule(task1,3000);
    }

    private void Update_Log()
    {
        for(int i = 0; i <= turn; i++)
        {
            battle_Log[i].setFont(new Font ("Helvetica", Font.PLAIN, 15));
            battle_Log[i].setBounds(370,65 + (i * 30), 1280,30);
            this.add(battle_Log[i]);
        }
    }

    private void Update_Log(boolean end)
    {
        for(int i = 0; i <= turn + 1; i++)
        {
            battle_Log[i].setFont(new Font ("Helvetica", Font.PLAIN, 15));
            battle_Log[i].setBounds(370,65 + (i * 30), 1280,30);
            this.add(battle_Log[i]);
        }
    }
}

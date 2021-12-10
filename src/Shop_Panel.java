import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class Shop_Panel extends JPanel{

    public Pokemon player_pokemon;
    private int Dua_Date;
    private int Money;

    private JLabel Dua_Date_Label;//남은 기간 라벨
    private JLabel Money_Label;//돈 라벨

    private JLabel Hp_Plus_Label; // 오랭열매 설명 라벨
    private JLabel Atk_Plus_Label; // 버치열매 설명 라벨
    private JLabel Def_Plus_Label; // 배리열매 설명 라벨
    private JLabel Spd_Plus_Label; // 과사열매 설명 라벨

    private JButton O_fruit_Button; // 오랭열매 구매 버튼
    private JButton beo_fruit_button; // 버치열매 구매 버튼
    private JButton bae_fruit_button; // 배리열매 구매 버튼
    private JButton gwa_fruit_button; // 과사열매 구매 버튼

    private JButton Back_Button; // 돌아가기 버튼

    private JPanelChange win;

    private ImageIcon O_fruit = new ImageIcon("ui_Image\\오랭열매.png");
    private ImageIcon beo_fruit = new ImageIcon("ui_Image\\버치열매.png");
    private ImageIcon bae_fruit = new ImageIcon("ui_Image\\배리열매.png");
    private ImageIcon gwa_fruit = new ImageIcon("ui_Image\\과사열매.png");

    private JLabel O_fruit_Img = new JLabel(O_fruit);
    private JLabel beo_fruit_Img = new JLabel(beo_fruit);
    private JLabel bae_fruit_Img = new JLabel(bae_fruit);
    private JLabel gwa_fruit_Img = new JLabel(gwa_fruit);

    private ImageIcon BackGround = new ImageIcon("backGround_Image\\Shop_BackGround.png");
    private ImageIcon returnImg1 = new ImageIcon("button_Image\\return1.png");
    private ImageIcon returnImg2 = new ImageIcon("button_Image\\return2.png");
    private ImageIcon g100Img1 = new ImageIcon("button_Image\\100g1.png");
    private ImageIcon g100Img2 = new ImageIcon("button_Image\\100g2.png");
    private JLabel BackGround_Label = new JLabel(BackGround);

    public Shop_Panel(JPanelChange win, Pokemon player_pokemon, int Dua_Date, int Money)
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

        Hp_Plus_Label = new JLabel("오랭열매(HP를 일정치 올려준다.)");
        Hp_Plus_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Atk_Plus_Label = new JLabel("버치열매(ATK를 일정치 올려준다.)");
        Atk_Plus_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Def_Plus_Label = new JLabel("배리열매(DF를 일정치 올려준다.)");
        Def_Plus_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Spd_Plus_Label = new JLabel("과사열매(SPD를 일정치 올려준다.)");
        Spd_Plus_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19));

        Back_Button = new JButton(returnImg1);
        Back_Button.setRolloverIcon(returnImg2);
        Back_Button.setBorderPainted(false);
        Back_Button.addActionListener(new ActionListener() // 돌아가기 버튼을 클릭했을떄
        {
            public void actionPerformed(ActionEvent e)
            {
                win.change("type_select", player_pokemon); // 선택 패널로 돌아가기
            }
        });

        O_fruit_Button = new JButton(g100Img1);
        O_fruit_Button.setRolloverIcon(g100Img2);
        O_fruit_Button.setBorderPainted(false);
        O_fruit_Button.setForeground(Color.BLACK);
        O_fruit_Button.addActionListener(new ActionListener() // 오랭열매 구매버튼을 클릭했을때
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Money >= 100)//돈이 100골드 이상이라면
                {
                    Random random = new Random();
                    int ran = random.nextInt(5) + 1; // 1부터 5까지 임의의 숫자 생성
                    JOptionPane.showMessageDialog(null, "HP가"+ ran +"만큼 상승했습니다."); //알림
                    player_pokemon.Full_Hp += ran; // 임의의 숫자 해당하는 값에 더하기
                    player_pokemon.Hp = player_pokemon.Full_Hp;
                    win.Money -= 100; // 돈 조정
                    win.Dua_Date -= 1; // 기간 조정
                    win.change("type_select", player_pokemon); // 선택패널로 돌아가기
                }
                else // 100골드가 없으면
                {
                    JOptionPane.showMessageDialog(null, "금액이 부족합니다."); // 돈부족 알림
                }
            }
        }); // 이하 같음
        beo_fruit_button = new JButton(g100Img1);
        beo_fruit_button.setRolloverIcon(g100Img2);
        beo_fruit_button.setBorderPainted(false);
        beo_fruit_button.setForeground(Color.BLACK);
        beo_fruit_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Money >= 100)
                {
                    Random random = new Random();
                    int ran = random.nextInt(5) + 1;
                    JOptionPane.showMessageDialog(null, "ATK가"+ ran +"만큼 상승했습니다.");
                    player_pokemon.Full_Atk += ran;
                    player_pokemon.Atk = player_pokemon.Full_Atk;
                    win.Money -= 100;
                    win.Dua_Date -= 1;
                    win.change("type_select", player_pokemon);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "금액이 부족합니다.");
                }
            }
        });
        bae_fruit_button = new JButton(g100Img1);
        bae_fruit_button.setRolloverIcon(g100Img2);
        bae_fruit_button.setBorderPainted(false);
        bae_fruit_button.setForeground(Color.BLACK);
        bae_fruit_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Money >= 100)
                {
                    Random random = new Random();
                    int ran = random.nextInt(5) + 1;
                    JOptionPane.showMessageDialog(null, "DF가"+ ran +"만큼 상승했습니다.");
                    player_pokemon.Full_Def += ran;
                    player_pokemon.Def = player_pokemon.Full_Def;
                    win.Money -= 100;
                    win.Dua_Date -= 1;
                    win.change("type_select", player_pokemon);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "금액이 부족합니다.");
                }
            }
        });
        gwa_fruit_button = new JButton(g100Img1);
        gwa_fruit_button.setRolloverIcon(g100Img2);
        gwa_fruit_button.setBorderPainted(false);
        gwa_fruit_button.setForeground(Color.BLACK);
        gwa_fruit_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Money >= 100)
                {
                    Random random = new Random();
                    int ran = random.nextInt(5) + 1;
                    JOptionPane.showMessageDialog(null, "SPD가"+ ran +"만큼 상승했습니다.");
                    player_pokemon.Full_Spd += ran;
                    player_pokemon.Spd = player_pokemon.Full_Spd;
                    win.Money -= 100;
                    win.Dua_Date -= 1;
                    win.change("type_select", player_pokemon);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "금액이 부족합니다.");
                }
            }
        });

        // 라벨과 버튼 배치
        Dua_Date_Label.setBounds(1120, 620, 1280, 50);
        Money_Label.setBounds(1120, 650, 1280, 50);

        Hp_Plus_Label.setBounds(180, 0, 300, 100);
        Atk_Plus_Label.setBounds(780, 0, 300, 100);
        Def_Plus_Label.setBounds(180, 330, 300, 100);
        Spd_Plus_Label.setBounds(780, 330, 300, 100);

        Back_Button.setBounds(0, 0, 150, 100);

        O_fruit_Button.setBounds(250, 300, 100, 50);
        beo_fruit_button.setBounds(850, 300, 100, 50);
        bae_fruit_button.setBounds(250, 600, 100, 50);
        gwa_fruit_button.setBounds(850, 600, 100, 50);

        O_fruit_Img.setBounds(40, 80,  500, 200);
        beo_fruit_Img.setBounds(670, 80, 500, 200);
        bae_fruit_Img.setBounds(40, 250, 500, 500);
        gwa_fruit_Img.setBounds(670, 250, 500, 500);

        BackGround_Label.setBounds(0,0,1280,720);

        this.add(Dua_Date_Label);
        this.add(Money_Label);

        this.add(Hp_Plus_Label);
        this.add(Atk_Plus_Label);
        this.add(Def_Plus_Label);
        this.add(Spd_Plus_Label);

        this.add(Back_Button);
        this.add(O_fruit_Button);
        this.add(beo_fruit_button);
        this.add(bae_fruit_button);
        this.add(gwa_fruit_button);

        this.add(O_fruit_Img);
        this.add(beo_fruit_Img);
        this.add(bae_fruit_Img);
        this.add(gwa_fruit_Img);

        this.add(BackGround_Label);
    }
}
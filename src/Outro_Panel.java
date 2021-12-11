import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Outro_Panel extends JPanel
{
    // 각 프레임에 전달받아 쓰는 변수들
    public String NAME; // 이름
    public Pokemon player_pokemon; // 플레이어의 포켓몬 정보
    public int Dua_Date;

    private int Day_Passed;
    private boolean GP_Result; // 엔딩 출현 조건(그랑프리 승리) 충족 여부
    private JLabel Outro_Comment; // 엔딩시 출력할 텍스트
    private int count = 0; // 대화가 끝났는지 확인하기 위한 변수
    private JButton Next_Button; // 버튼
    private JButton Back_Button; // 돌아가기 버튼

    private JLabel GP_Result_Label;
    private JLabel NAME_Label;
    private JLabel player_pokemon_Name_Label;
    private JLabel player_pokemon_Level_Label;
    private JLabel GP_Result_Comment_Label;
    private TitledBorder tborder; // 컴포넌트를 둘러싸는 테두리

    private JPanelChange win; // win

    private ImageIcon BackGround = new ImageIcon("backGround_Image\\Clear_BackGround.png");
    private ImageIcon returnImg1 = new ImageIcon("button_Image\\return1.png");
    private ImageIcon returnImg2 = new ImageIcon("button_Image\\return2.png");
    private JLabel BackGround_Label = new JLabel(BackGround);

    public Outro_Panel(JPanelChange win, String NAME, Pokemon player_pokemon)

    {
        this.win = win;
        this.NAME = NAME;
        this.player_pokemon = player_pokemon;

        Day_Passed = Dua_Date;

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 포켓몬 이미지 라벨을 테두리로 둘러싸줌
        tborder = new TitledBorder(player_pokemon.Name); // 컴포넌트 타이틀은 포켓몬의 이름으로
        tborder.setTitlePosition(TitledBorder.ABOVE_TOP); //지정한 위치에 타이틀을 나타내주는 보더: 라벨 상단에
        tborder.setTitleJustification(TitledBorder.CENTER); //자리맞춤을 가운데로 지정...
        player_pokemon.Portray.setBorder(tborder); // 태두리 설정
        this.add(player_pokemon.Portray); // 포켓몬 이미지 라벨 그려주기

        GP_Result_Label = new JLabel("우승!"); // 라벨 내용
        GP_Result_Label.setFont(new Font ("Helvetica", Font.BOLD, 50)); // 승리 강조, 라벨 폰트 설정

        GP_Result_Comment_Label = new JLabel("그랑프리에서 최종 승리했습니다."); // 라벨 내용
        GP_Result_Comment_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 승리 강조, 라벨 폰트 설정

        NAME_Label = new JLabel("이름 : " + NAME); // 라벨 내용
        NAME_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        player_pokemon_Name_Label = new JLabel("함께한 포켓몬 : " + player_pokemon.Name); // 라벨 내용
        player_pokemon_Name_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        player_pokemon_Level_Label = new JLabel("레벨 : " + player_pokemon.Level); // 라벨 내용
        player_pokemon_Level_Label.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        Back_Button = new JButton(returnImg1);
        Back_Button.setRolloverIcon(returnImg2);
        Back_Button.setBorderPainted(false);
        Back_Button.addActionListener(new ActionListener() // 돌아가기 버튼을 클릭했을떄
        {
            public void actionPerformed(ActionEvent e)
            {
                win.change("type_start", NAME); // 다시 시작
            }
        });

        GP_Result_Label.setBounds(580, 70, 1280, 100);
        GP_Result_Comment_Label.setBounds(700, 200, 1280, 50);

        NAME_Label.setBounds(700, 270, 1280, 50);
        player_pokemon_Name_Label.setBounds(700, 305, 1280, 50);
        player_pokemon_Level_Label.setBounds(700, 340, 1280, 50);
        Back_Button.setBounds(700, 400, 150, 100);

        player_pokemon.Portray.setBounds(350,180,290,290);

        BackGround_Label.setBounds(0,0,1280,720);

        this.add(Back_Button);
        this.add(GP_Result_Label);
        this.add(NAME_Label);
        this.add(player_pokemon_Name_Label);
        this.add(player_pokemon_Level_Label);
        this.add(GP_Result_Comment_Label);
        this.add(BackGround_Label);
    }

}
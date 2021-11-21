import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fight_Panel extends JPanel
{
    // 각 프레임에 전달받아 쓰는 변수들
    public String NAME; // 이름
    public Pokemon player_pokemon; // 플레이어의 포켓몬 정보
    private int Dua_Date; // 남은기간
    private int Money; // 소지금

    // 컴포넌트: 라벨
    private JLabel now_Panel;
    private JLabel battle_Log;
    private JLabel player_name;
    private JLabel opponent_name; // 상대 트래이너 이름

    // 컴포넌트: 버튼(플레이어)
    private JButton p_Skill1;
    private JButton p_Skill2;
    private JButton p_Skill3;
    private JButton p_Skill4;
    // 컴포넌트: 버튼(상대)
    private JButton o_Skill1;
    private JButton o_Skill2;
    private JButton o_Skill3;
    private JButton o_Skill4;
    // 컴포넌트: 버튼
    private JButton exit;

    private Pokemon opponent_pokemon; // 상대 포켓몬을 저장할 변수
    private TitledBorder tborder; // 컴포넌트를 둘러싸는 테두리

    private JPanelChange win; // win

    public Fight_Panel(JPanelChange win, String NAME, Pokemon player_pokemon, Pokemon opponent_pokemon, int Dua_Date, int Money)
    {
        // 매개변수로 전달받은 값들을 해당 클래스에 저장
        this.win = win;
        this.NAME = NAME;
        this.player_pokemon = player_pokemon;
        this.Dua_Date = Dua_Date;
        this.Money = Money;
        this.opponent_pokemon = opponent_pokemon;

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 라벨 설정
        now_Panel = new JLabel(Label_Config()); // 라벨 내용
        now_Panel.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        battle_Log = new JLabel(Label_Config()); // 라벨 내용
        battle_Log.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        player_name = new JLabel(Label_Config()); // 라벨 내용
        player_name.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        opponent_name = new JLabel(Label_Config()); // 라벨 내용
        opponent_name.setFont(new Font ("Helvetica", Font.PLAIN, 19)); // 라벨 폰트 설정

        // 버튼 설정 + 버튼 리스너 설정
        p_Skill1 = new JButton("skill1"); // 버튼 안에 들어갈 텍스트 설정
        p_Skill1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            // 버튼을 클릭하면
            {

            }
        });
    }

    private String Label_Config()
    {
        String str = new String("일반 대전");
        return str;
    }
}

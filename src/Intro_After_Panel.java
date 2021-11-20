import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Intro_After_Panel extends JPanel
{
    // 해당 클래스에서 사용할 변수들 선언 (win은 앵간하면 선언해줘)
    private String NAME; // 이름
    private Pokemon player_pokemon;
    private JLabel Say_Dr; // 라벨
    private ImageIcon Dr_Image = new ImageIcon("오박사.png"); // 아이콘 이미지
    private JLabel Image_Label = new JLabel(Dr_Image); // 아이콘 이미지를 라벨화
    private JButton Next_Button; // 버튼
    private int count = 0; // 대화가 끝났는지 확인하기 위한 변수
    private JPanelChange win; // win

    public Intro_After_Panel(JPanelChange win, String NAME, Pokemon player_pokemon)
    // 포켓몬을 선택한 후에 박사와 대화하는 패널
    {
        // 매개변수로 win 자신과 player_pokemon을 가져와서 해당 클레스에 저장
        this.win = win; // 패널에서 받아온 데이터들(이름, 날짜, 돈 등..)이 저장되어 있으며 패널을 교체하는 기능이 있음
        this.player_pokemon = player_pokemon; // 플레이어가 선택한 포켓몬의 정보가 들어있음

        // 배치 관리자 설정: 배치 관리자 사용안함
        setLayout(null);

        // 라벨에서 사용할 대화들을 배열로 선언 (맨 처음 ""는 생략)
        String[] Say_Dr_Text = {"", "자네라면 " + player_pokemon.Name + "를 선택할 줄 알았네!", "이제부터 자네에게 30일동안 내 소중한 포켓몬을 맡기겠네.",
                "그 동안 " + player_pokemon.Name + "을 열심히 성장시켜서", "해당 포켓몬의 자세한 정보를 전달해주게!",
                "마지막 날에는 우리 연구소의 직원이 자네에게 찾아올걸세.", "그 직원을 이긴다면 대학원생인 자네에게 박사 학위를 주겠네."
                ,"이것으로 내가 하고싶은 말은 끝일세.", NAME + "군, 앞으로의 여행에 행운이 있기를 바라네!"};

        // (처음에 보여지는) 라벨 설정
        Say_Dr = new JLabel("음...역시!"); // 라벨 내용
        Say_Dr.setFont(new Font ("Helvetica", Font.BOLD, 30)); // 라벨 폰트 설정


        // 버튼 설정 + 버튼 리스너 설정
        Next_Button = new JButton("다음"); // 버튼 안에 들어갈 텍스트 설정
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
                    win.change("type_select", player_pokemon);
                    // 이제 선택패널로 교체해줌
                }

                else // 대화가 안끝났으면
                {
                    // 다음 대화 불러와서 라벨 업데이트 해주기
                    Say_Dr.setText(Say_Dr_Text[count]);
                }
            }
        });

        // 위에서 설정한 컴포넌트들의 크기설정
        Image_Label.setBounds(330, 50, 180, 384);
        player_pokemon.Portray.setBounds(550,175,250,250); // 포켓몬 class 안에 있는 JLabel임
        Say_Dr.setBounds(100, 570, 1280, 50);
        Next_Button.setBounds(1000, 540, 200, 100);

        // 위에서 설정한 컴포넌트들을 패널에 추가해줌
        this.add(Image_Label);
        this.add(player_pokemon.Portray);
        this.add(Say_Dr);
        this.add(Next_Button);
    }
}

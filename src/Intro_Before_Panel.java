import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Intro_Before_Panel extends JPanel
{
    private String NAME;
    private JLabel Say_Dr;
    private ImageIcon Dr_Image = new ImageIcon("오박사.png");
    private JLabel Image_Label = new JLabel(Dr_Image);
    private JPanelChange win;
    private JButton Next_Button;
    private int count = 0;

    public Intro_Before_Panel(JPanelChange win)
    {
        this.win = win;
        setLayout(null);
        this.NAME = win.NAME;
        System.out.print(win.NAME);
        String[] Say_Dr_Text = {"", "..................", "....아! 손님이 왔었군! ", "혹시 자네가 포켓몬 성장 연구를 도와겠다던 " + this.NAME + " 군?",
        "정말 고맙네. 마침 일손이 부족하던 참이었어.", "아직 연구가 진횅되지 않은 포켓몬을 3마리나 발견했다네.", "그 중 한 마리를 자네에게 맡기도록 하겠네.",
        "선택을 번복할 수 없으니 신중히 결정하도록 하게.", "아 참, 트레이너의 성격에 맞는 포켓몬을 고른다면", "포켓몬을 더 재밌게 키울 수 있을 걸세." ,
                "여기 자네의 성격에 맞는 포켓몬을 한 번 골라보게."};

        Say_Dr = new JLabel("흐으음.........");
        Say_Dr.setFont(new Font ("Helvetica", Font.BOLD, 30));

        Next_Button = new JButton("다음");
        Next_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count >= Say_Dr_Text.length)
                {
                    win.change("type_choose", NAME);
                }

                else
                {
                    Say_Dr.setText(Say_Dr_Text[count]);
                }
            }
        });

        Image_Label.setBounds(550, 50, 180, 384);
        this.add(Image_Label);

        Say_Dr.setBounds(100, 570, 1280, 50);
        this.add(Say_Dr);

        Next_Button.setBounds(1000, 540, 200, 100);
        this.add(Next_Button);

    }
}

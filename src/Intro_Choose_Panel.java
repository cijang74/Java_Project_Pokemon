import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Intro_Choose_Panel extends JPanel
{
    private JLabel Say_Dr;
    private JRadioButton [] Starting_Pokemon_Img = new JRadioButton[3];
    private String [] Text = {"열정적인 성격", "차분한 성격", "고통을 즐기는 성격"};
    private ImageIcon[] Pokemon_Images = {new ImageIcon("리아코.png"), new ImageIcon("브케인.png"), new ImageIcon("치코리타.png")};
    private ImageIcon Dr_Image = new ImageIcon("오박사.png");
    private JLabel Dr_Image_Label = new JLabel(Dr_Image);
    private JLabel ImageLabel = new JLabel();
    private JButton Choose_Button;
    private JPanelChange win;

    public Intro_Choose_Panel(JPanelChange win)
    {
        this.win = win;
        Say_Dr = new JLabel("선택을 번복할 수 없으니 신중히 결정하도록 하게.");
        Say_Dr.setFont(new Font ("Helvetica", Font.BOLD, 30));
        Choose_Button = new JButton("이 포켓몬으로 할래요!");

        ButtonGroup g = new ButtonGroup();
        JPanel radioPanel = new JPanel();
        setLayout(null);

        for(int i = 0; i <Starting_Pokemon_Img.length; i++)
        {
            Starting_Pokemon_Img[i] = new JRadioButton(Text[i]);
            g.add(Starting_Pokemon_Img[i]);
            radioPanel.add(Starting_Pokemon_Img[i]);
            Starting_Pokemon_Img[i].addItemListener(new MyItemListener());
        }

        Starting_Pokemon_Img[0].setSelected(true);


        radioPanel.setBounds(150, 530, 1000, 30);
        this.add(radioPanel); // 포켓몬 선택하는거

        Choose_Button.setBounds(150, 580, 1000, 80);
        this.add(Choose_Button); // 결정


        Say_Dr.setBounds(310, 10, 1000, 100);
        this.add(Say_Dr); // 번복 ㄴㄴ

        ImageLabel.setBounds(550, 240, 250, 250);
        this.add(ImageLabel); // 포켓몬 이미지


        Dr_Image_Label.setBounds(180, 120, 180, 384);
        this.add(Dr_Image_Label); // 박사 이미지

        setVisible(true);

    }

    class MyItemListener implements ItemListener{
        // 리스너 클래스
        public void itemStateChanged(ItemEvent e)
        {
            if(e.getStateChange() == ItemEvent.DESELECTED)
                return;

            if(Starting_Pokemon_Img[0].isSelected())
                ImageLabel.setIcon(Pokemon_Images[0]);

            else if(Starting_Pokemon_Img[1].isSelected())
                ImageLabel.setIcon(Pokemon_Images[1]);

            else
                ImageLabel.setIcon(Pokemon_Images[2]);
        }
    }
}

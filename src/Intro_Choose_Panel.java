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
    private JLabel ImageLabel = new JLabel();
    private JPanelChange win;

    public Intro_Choose_Panel(JPanelChange win)
    {
        this.win = win;

        ButtonGroup g = new ButtonGroup();
        JPanel radioPanel = new JPanel();
        this.setLayout(new BorderLayout()); // 그리드 형식 배치

        for(int i = 0; i <Starting_Pokemon_Img.length; i++)
        {
            Starting_Pokemon_Img[i] = new JRadioButton(Text[i]);
            g.add(Starting_Pokemon_Img[i]);
            radioPanel.add(Starting_Pokemon_Img[i]);
            Starting_Pokemon_Img[i].addItemListener(new MyItemListener());
        }

        Starting_Pokemon_Img[0].setSelected(true);
        this.add(radioPanel, BorderLayout.NORTH);
        this.add(ImageLabel, BorderLayout.CENTER);
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        setVisible(true);

    }

    class MyItemListener implements ItemListener{
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

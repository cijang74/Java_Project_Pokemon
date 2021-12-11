import javax.swing.*;

public class JPanelChange extends JFrame
//이전 패널의 컴포넌트를 모두 지우고 다음 패널의 컴포넌트를 불러오는 메소드가 있는 클래스, 프레임 역할을 함.
{
    // 각 프레임에 전달받아 쓰는 변수들
    public static String NAME; // 이름
    public Pokemon player_pokemon; // 플레이어의 포켓몬
    public int Dua_Date = 30; // 남은기간(default)
    public int Money = 500; // 소지금(default)

    // 다른 패널로 변경시켜주기 위해 선언된 패널들
    private Start_Panel start_panel = null;
    private Intro_Before_Panel intro_before_panel = null;
    private Intro_After_Panel intro_after_panel = null;
    private Intro_Choose_Panel intro_choose_panel = null;
    private Select_Panel select_panel = null;
    private Shop_Panel shop_panel = null;
    private Training_Panel training_panel = null;
    private Fight_Panel normal_fight_panel = null;
    private Fight_Panel grand_prix_panel = null;
    private Fight_Panel last_fight_panel = null;
    private Outro_Panel outro_panel = null;
    private Failure_Panel failure_panel = null;

    public Start_Panel getStart_panel()
    // 메인 클래스에서 해당 패널을 불러오기 위한 메서드
    {
        return start_panel;
    }

    public void setStart_panel(Start_Panel start_panel) // (Start_Panel start_panel)
    // 메인 클래스에서 생성한 Start_Panel객체를 해당 변수에 저장시켜주기 위한 메서드
    {
        this.start_panel = start_panel;
    }

    public void change(String panelType, String NAME)
    // a패널에서 b패널로 바꿔주기 위한 메서드 (매개변수는 바꾸고자 하는 패널과 전달하고싶은 데이터들)
    // !!!!패널 추가는 아래의 오버로딩한 change 매서드에!!!!
    {
        if (panelType.equals("type_start"))
        // 만약 바꾸고자 하는 패널이 "type_start" 이라면
        {
            // 이전 패널에서 전달 받은 값을 해당 클래스에 저장시켜줌
            this.player_pokemon = player_pokemon;

            // 바꾸고자 하는 패널 객체를 생성 (### 매개변수로 무조건 this와 바꾸고자 하는 패널에 전달할 변수를 넣어줘야함!###)
            start_panel = new Start_Panel(this);
            Dua_Date = 30;
            Money = 500;

            // 위에서 생성한 객체로 갈아끼워주기
            getContentPane().removeAll(); // 기존 패널에 있는 컴포넌트 모두 삭제
            getContentPane().add(start_panel); // 갈아끼워줄 패널에 존재하는 컴포넌트들을 추가해줌으로서 패널 바꿔줌

            // 다시 그려줌으로서 변경사항 업데이트 해주기
            revalidate();
            repaint();
        }

        if (panelType.equals("type_before_intro"))
        // 만약 바꾸고자 하는 패널이 "type_before_intro" 이라면
        {
            // 이전 패널에서 전달 받은 값을 해당 클래스에 저장시켜줌
            this.NAME = NAME;

            // 바꾸고자 하는 패널 객체를 생성 (### 매개변수로 무조건 this와 바꾸고자 하는 패널에 전달할 변수를 넣어줘야함!###)
            intro_before_panel = new Intro_Before_Panel(this, NAME);

            // 위에서 생성한 객체로 갈아끼워주기
            getContentPane().removeAll(); // 기존 패널에 있는 컴포넌트 모두 삭제
            getContentPane().add(intro_before_panel); // 갈아끼워줄 패널에 존재하는 컴포넌트들을 추가해줌으로서 패널 바꿔줌

            // 다시 그려줌으로서 변경사항 업데이트 해주기
            revalidate();
            repaint();
        }

        // 위 if문과 구조 동일.
        else if (panelType.equals("type_choose"))
        {
            intro_choose_panel = new Intro_Choose_Panel(this, NAME);
            getContentPane().removeAll();
            getContentPane().add(intro_choose_panel);
            revalidate();
            repaint();
        }
    }

    public void change(String panelType, Pokemon player_pokemon)
    // a패널에서 b패널로 바꿔주기 위한 메서드 (오버로딩)
    //이름은 한번만 start패널에서 전달받아서 win에 저장시켜주면 되기때문에 choose패널에서 포켓몬을 선택하여 객체가 생성된 이후의 패널은 여기서 교체시킴)
    {
        if (panelType.equals("type_after_intro"))
        // 만약 바꾸고자 하는 패널이 "type_before_intro" 이라면
        {
            // 이전 패널에서 전달 받은 값을 해당 클래스에 저장시켜줌
            this.player_pokemon = player_pokemon;

            // 바꾸고자 하는 패널 객체를 생성 (### 매개변수로 무조건 this와 바꾸고자 하는 패널에 전달할 변수를 넣어줘야함!###)
            intro_after_panel = new Intro_After_Panel(this, this.NAME, player_pokemon);

            // 위에서 생성한 객체로 갈아끼워주기
            getContentPane().removeAll(); // 기존 패널에 있는 컴포넌트 모두 삭제
            getContentPane().add(intro_after_panel); // 갈아끼워줄 패널에 존재하는 컴포넌트들을 추가해줌으로서 패널 바꿔줌

            // 다시 그려줌으로서 변경사항 업데이트 해주기
            revalidate();
            repaint();
        }

        // 위 if문과 구조 동일. 새로운 패널 만들 떄는 else if문으로 추가해줘!
        else if (panelType.equals("type_select"))
        {
            resetPokemon();
            select_panel = new Select_Panel(this, NAME, player_pokemon, this.Dua_Date, this.Money);
            getContentPane().removeAll();
            getContentPane().add(select_panel);
            revalidate();
            repaint();
        }

        // 상점 패널로 바꿔주기
        else if (panelType.equals("type_shop"))
        {
            shop_panel = new Shop_Panel(this, player_pokemon, this.Dua_Date, this.Money);
            getContentPane().removeAll();
            getContentPane().add(shop_panel);
            revalidate();
            repaint();
        }

        // 훈련 패널로 바꿔주기
        else if (panelType.equals("type_training"))
        {
            training_panel = new Training_Panel(this, player_pokemon, this.Dua_Date, this.Money);
            getContentPane().removeAll();
            getContentPane().add(training_panel);
            revalidate();
            repaint();
        }

        // 일반 대전 패널로 바꿔주기 (이걸 부모로 써서 아래 두 패널을 상속 시켜도 될 듯)
        else if (panelType.equals("type_normal_fight"))
        {
            normal_fight_panel = new Fight_Panel(this, NAME, player_pokemon, this.Dua_Date, this.Money, "type_normal_fight");
            getContentPane().removeAll();
            getContentPane().add(normal_fight_panel);
            revalidate();
            repaint();
        }

        // 그랑프리 패널로 바꿔주기
        else if (panelType.equals("type_grand_prix"))
        {
            grand_prix_panel = new Fight_Panel(this, NAME, player_pokemon, this.Dua_Date, this.Money, "type_grand_prix");
            getContentPane().removeAll();
            getContentPane().add(grand_prix_panel);
            revalidate();
            repaint();
        }

        // 마지막 패널로 바꿔주기
        else if (panelType.equals("type_last_fight"))
        {
            last_fight_panel = new Fight_Panel(this, NAME, player_pokemon, this.Dua_Date, this.Money, "type_last_fight");
            getContentPane().removeAll();
            getContentPane().add(last_fight_panel);
            revalidate();
            repaint();
        }

        // 엔딩(성공) 패널로 바꿔주기
        else if (panelType.equals("type_outro"))
        {
            outro_panel = new Outro_Panel(this, NAME, player_pokemon);
            getContentPane().removeAll();
            getContentPane().add(outro_panel);
            revalidate();
            repaint();
        }

        // 실패 패널로 바꿔주기
        else if (panelType.equals("type_failure"))
        {
            failure_panel = new Failure_Panel(this, NAME, player_pokemon);
            getContentPane().removeAll();
            getContentPane().add(failure_panel);
            revalidate();
            repaint();
        }

    }

    // 대전이 끝나고 대전에서 입은 피해나 버프 / 디버프 초기화
    private void resetPokemon()
    {
        player_pokemon.Hp = player_pokemon.Full_Hp;
        player_pokemon.Def = player_pokemon.Full_Def;
        player_pokemon.Atk = player_pokemon.Full_Atk;
        player_pokemon.Spd = player_pokemon.Full_Spd;
    }
}

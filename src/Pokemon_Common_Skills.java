//    public Pokemon(String Name, String type, int level)
//    // 포켓몬 생성자 (플레이어 포켓몬을 생성하는데에 쓰일것)
//    {
//        // 매개변수를 받아서 해당 포켓몬 객체에 저장
//        this.Name = Name;
//        this.type = type;
//        this.Level = level;
//        this.Hp = this.Level;
//        this.Def = this.Level;
//        this.Atk = this.Level;
//        this.Spd = this.Level;
//        this.Full_Hp = this.Hp;
//        this.Full_Def = this.Def;
//        this.Full_Atk = this.Atk;
//        this.Full_Spd = this.Spd;
//
//        // 포켓몬의 이름에 따라 알맞는 포켓몬 이미지를 저장시킴
//        if (Name == "리아코")
//        {
//            this.Pokemon_Image = new ImageIcon("리아코.png"); // 아이콘 이미지
//            this.Portray = new JLabel(this.Pokemon_Image);
//            this.skillArray[0] = "햘퀴기";
//            this.skillArray[1] = "울음소리";
//            this.skillArray[2] = null;
//            this.skillArray[3] = null;
//        }
//        else if (Name == "브케인")
//        {
//            this.Pokemon_Image = new ImageIcon("브케인.png"); // 아이콘 이미지
//            this.Portray = new JLabel(this.Pokemon_Image);
//            this.skillArray[0] = "몸통박치기";
//            this.skillArray[1] = "울음소리";
//            this.skillArray[2] = null;
//            this.skillArray[3] = null;
//        }
//        else
//        {
//            this.Pokemon_Image = new ImageIcon("치코리타.png"); // 아이콘 이미지
//            this.Portray = new JLabel(this.Pokemon_Image);
//            this.skillArray[0] = "몸통박치기";
//            this.skillArray[1] = "꼬리흔들기";
//            this.skillArray[2] = null;
//            this.skillArray[3] = null;
//        }
//    }
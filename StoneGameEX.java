import java.util.Scanner;

public class StoneGameEX {
    public static void main(String[] args) {
        //事前情報入力
        System.out.println("""
        ------------------------------
        石取りゲームを開始します。
        """);
        int stone=stoneMax();//石の総数

        int getMax=stoneGetMax();//１度に取れる石の数

        //プレイヤー情報入力
        System.out.println("プレイヤーを指定してください。");
        var sc=new Scanner(System.in);
        String playersName=sc.next();
        String[] players=playersName.split(",");

        //石の記号入力
        System.out.println("石の記号を指定してください。");
        sc=new Scanner(System.in);
        String stoneMark=sc.next();

        //順番変数
        int playerTurn=0;

        while(true){
            //何個石を取るか入力する
            int get_num=stoneGet(players[playerTurn],getMax);

            //石を取る
            stone=stone-get_num;
            if(stone<=0){//石がなくなったらゲーム終了
                break;
            }

            //プレイヤー切り替え
            playerTurn++;
            //プレイヤーの順番修正
            if(playerTurn>=players.length){
                playerTurn=0;
            }

            //残りの石の個数表示
            System.out.println("残り:"+stone+"個");
            for(int i=0;i<stone;i++){
                System.out.print(stoneMark);
            }
            System.out.println("");
        }


        //勝者プレイヤー修正
        if(playerTurn==0){
            playerTurn=players.length;
        }
        System.out.println("勝者:プレイヤー"+players[playerTurn-1]);
    }


    public static int stoneMax(){
        int stoneMax=0;
        System.out.println("石の総数の総数を指定してください。");
        while(true) {
            var sc = new Scanner(System.in);
            stoneMax = Integer.parseInt(sc.next());
            if(stoneMax>=10 && stoneMax<=100){
                break;
            }else{
                System.out.println("10~100の間を入力してください");
            }
        }
        return stoneMax;
    }

    public static int stoneGetMax(){
        int getMax=0;
        System.out.println("1度に取れる石の数を指定してください。");
        while(true) {
            var sc = new Scanner(System.in);
            getMax = Integer.parseInt(sc.next());
            if(getMax>=1 && getMax<=10){
                break;
            }else{
                System.out.println("1~10の間を入力してください");
            }
        }
        return getMax;
    }

    public static int stoneGet(String player,int getMax){
        System.out.println("------------------------------");
        System.out.println("プレイヤー"+player+"の番");
        System.out.println("石の数を入力してください。（1〜"+getMax+"まで入力可能です。）");
        int get=0;

        while(true) {
            var sc = new Scanner(System.in);
            get = Integer.parseInt(sc.next());
            if(get>=1 && get<=getMax){
                break;
            }else{
                System.out.println("1~"+getMax+"の間で入力してください。");
            }
        }
        return get;
    }


}

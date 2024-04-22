import java.util.Scanner;

public class StoneGame {
    public static void main(String[] args) {
        System.out.println("""
        ------------------------------
        石取りゲームを開始します。
        石の総数：25個
        １度に取れる石の数：3個
        ------------------------------
        残り：25個
        ●●●●●●●●●●●●●●●●●●●●●●●●●
        """);
        int stone=25;//石の総数
        String playerTurn="A";//A、Bの切り替え(最初はA)
        while(true){
            //何個石を取るか入力する
            int get_num=stoneGet(playerTurn);
            //System.out.println(get_num);//個数確認

            //プレイヤー切り替え
            if(playerTurn.equals("A")){
                playerTurn="B";
            }else{
                playerTurn="A";
            }

            //石を取る
            stone=stone-get_num;
            if(stone<=0){
                break;
            }

            //残りの石の個数表示
            System.out.println("残り:"+stone+"個");
            for(int i=0;i<stone;i++){
                System.out.print("●");
            }
            System.out.println("");

        }
        System.out.println("勝者:プレイヤー"+playerTurn);
    }

    public static int stoneGet(String player){
        System.out.println("------------------------------");
        System.out.println("プレイヤー"+player+"の番");
        System.out.println("石の数を入力してください。（1〜3まで入力可能です。）");
        int get=0;

        while(true) {
            var sc = new Scanner(System.in);
            get = Integer.parseInt(sc.next());
            if(get>=1 && get<=3){
                break;
            }else{
                System.out.println("1~3の間で入力してください。");
            }
        }
        return get;
    }


}

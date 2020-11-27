package e3;

public class Gunfight {


    private int print;

    public void duel (Gunslinger g1, Gunslinger g2){
        for (int i=1;i<=50;i++){

            String action1 = g1.action().toString();
            String action2 = g2.action().toString();

            System.out.print("Round " + i +" ------------" + "\nGunslinger  1: " + action1 + "\nGunslinger  2: " + action2);

            if (action1.equals("MACHINE_GUN")){
                if(action2.equals("MACHINE_GUN")){
                    i=51;
                    print=3;
                } else {
                    i=51;
                    print=1;
                }
            } else if (action2.equals("MACHINE_GUN")){
                i=51; print=2;

            } else if(action1.equals("SHOOT")){

                if(action2.equals("SHOOT")){ i=51; print=3; }
                else if (action2.equals("RELOAD")){
                    i=51;
                    print=1;
                } else print=0;

            } else if (action2.equals("SHOOT")) {
                if (action1.equals("RELOAD")){
                    i=51;
                    print=2;
                } else print=0;

            } else print=0;

            if(i==50 ) {
                System.out.print("\n\nThe duel has came to an end\n\nOur fearless duelists need a cup of tea and some rest\n");
                return;
            }
            printRes(print);

            }
        }


    public void printRes( int print){ // 0 is continue, 1 is wins guns1, 2 is wins guns2, 3 is both die
        if(print==0) System.out.print("\n\nFaithful gunslingers, the duel shall go on ...\n\n");
        else if(print==1) System.out.print("\n\nThe duel has come to an end\n\nGUNSLINGER1 is the winner\n");
        else if(print==2) System.out.print("\n\nThe duel has come to an end\n\nGUNSLINGER2 is the winner\n");
        else if(print==3) System.out.print("\n\nThe duel has come to an end\n\nBoth gunslingers are dead, may god have mercy on their souls\n\nthere are no real winners in war\n");

    }
}

package e3;

public class Gunfight {

    private Gunslinger g1;
    private Gunslinger g2;
    private boolean bool;
    int i,print;

    Gunfight(Gunslinger g1, Gunslinger g2){
        this.g1 = g1;
        this.g2 = g2;
    }

    public void duel (Gunslinger g1, Gunslinger g2){
        for (i=0;i<50;i++){

            System.out.print("Round " + i + "\nGunslinger  1: " + g1.action().toString() + "\nGunslinger  2: " + g2.action().toString());

            if (g1.action().equals(GunslingerAction.MACHINE_GUN)){
                if(g2.action().equals(GunslingerAction.MACHINE_GUN)){
                    i=50;
                    print=3;
                } else {
                    i=50;
                    print=1;
                }
            } else if (g2.action().equals(GunslingerAction.MACHINE_GUN)){
                i=50; print=2;

            } else if(g1.action().equals(GunslingerAction.SHOOT)){

                if(g2.action().equals(GunslingerAction.SHOOT)){ i=50; print=3; }
                else if (g2.action().equals(GunslingerAction.RELOAD)){
                    i=50;
                    print=1;
                } else print=0;

            } else if (g2.action().equals(GunslingerAction.SHOOT)) {
                if (g1.action().equals(GunslingerAction.RELOAD)){
                    i=50;
                    print=2;
                } else print=0;

            } else print=0;


            printRes(print);
            if(i==49 && print!=1 && print!=1 && print!=2 && print!=3){
                System.out.print("\n\nThe duel has came to an end\n\nOur fearless duelists need a cup of tea and some rest\n");
            }
        }
    }

    public void printRes( int print){ // 0 is continue, 1 is wins guns1, 2 is wins guns2, 3 is both die
        if(print==0) System.out.print("\n\nFaithful gunslingers, the duel shall go on ...\n");
        else if(print==1) System.out.print("\n\nThe duel has came to an end\n\nGUNSLINGER1 is the winner\n");
        else if(print==2) System.out.print("\n\nThe duel has came to an end\n\nGUNSLINGER2 is the winner\n");
        else if(print==3) System.out.print("\n\nThe duel has came to an end\n\nBoth gunslingers are dead, may god have mercy on their souls\n\nthere are no real winners in war\n");

    }


    public static void main(String []args){



    }
}

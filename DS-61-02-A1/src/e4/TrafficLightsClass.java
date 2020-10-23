package e4;

public class TrafficLightsClass {

    public enum TrafficLights {

        NORTH(LightsClass.Lights.GREEN, 1),
        SOUTH(LightsClass.Lights.RED, 2),
        EAST(LightsClass.Lights.RED, 3),
        WEST(LightsClass.Lights.RED, 4);

        public final int position;
        public LightsClass.Lights color;

        TrafficLights(LightsClass.Lights color, int position) {
            this.color = color;
            this.position = position;

        }



        void Reset(TrafficJunction o, boolean a) {

            o.trafficLights[0].color = LightsClass.Lights.GREEN;
            o.trafficLights[0].color.timeToGoOff = 15;
            if (a) {
                for (int i = 1; i < 4; i++) {
                    o.trafficLights[i].color = LightsClass.Lights.RED;

                }
            }
        }

        public void AmberOn(TrafficJunction o){

            for (int i = 0; i < 4; i++) o.trafficLights[i].color = LightsClass.Lights.AMBER;

        }

    }
    /*public static class PgaAndIsGreen extends TrafficJunction {
        public int pga;
        public boolean isGreen;
        public PgaAndIsGreen() {



        }

    }*/

 public static TrafficJunction.PgaAndIsGreen FindGreenOrAmber(TrafficJunction o){
    TrafficJunction.PgaAndIsGreen pgaG = new TrafficJunction.PgaAndIsGreen();
    for (pgaG.pga=0; pgaG.pga < 4; pgaG.pga++) {

        if (o.trafficLights[pgaG.pga].color == LightsClass.Lights.GREEN) {
            pgaG.isGreen = true;

            break;
        } else if (o.trafficLights[pgaG.pga].color == LightsClass.Lights.AMBER) break;


    }
    return pgaG;
}

}

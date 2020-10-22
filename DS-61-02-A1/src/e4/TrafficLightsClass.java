package e4;

public class TrafficLightsClass {

    public enum TrafficLights {

        NORTH(LightsClass.Lights.GREEN, 1),
        SOUTH(LightsClass.Lights.RED, 2),
        EAST(LightsClass.Lights.RED, 3),
        WEST(LightsClass.Lights.RED, 4),
        ALL(0);

        private static LightsClass.Lights lights;
        public final int position;
        public LightsClass.Lights color;

        TrafficLights(LightsClass.Lights color, int position) {
            this.color = color;
            this.position = position;

        }

        TrafficLights(int position) {
            this.position = position;
        }
        static class PgaAndIsGreen {
            public int pga=0;
            public boolean isGreen=false;
            public PgaAndIsGreen(int pga, boolean isGreen) { this.pga = pga; this.isGreen = isGreen; }
        }

        public PgaAndIsGreen FindGreenOrAmber(TrafficJunction o){
            PgaAndIsGreen pgaG = new PgaAndIsGreen(0,false);
            for (; pgaG.pga < 4; pgaG.pga++) {

                if (o.trafficLights[pgaG.pga].color == LightsClass.Lights.GREEN) {
                    pgaG.isGreen = true;
                    break;
                } else if (o.trafficLights[pgaG.pga].color == LightsClass.Lights.AMBER) break;


            }
            return pgaG;
        }

    }

    /*public int FindGreenOrAmber(Traffic o, boolean isGreen){
        int pga;
        for (pga = 0; pga < 4; pga++) {

            if (o.trafficLights[pga].color == LightsClass.Lights.GREEN) {
                isGreen = true;
                break;
            } else if (o.trafficLights[pga].color == LightsClass.Lights.AMBER) break;


        }
     return pga;
    }*/

}

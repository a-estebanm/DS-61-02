package e4;


import static e4.TrafficLightsClass.TrafficLights.Reset;

public class LightsClass {

    public enum Lights {


        GREEN(15),
        AMBER(5),
        RED();

        public int timeToGoOff;

        Lights(int timeToGoOff) {
            this.timeToGoOff = timeToGoOff;
        }

        Lights() {
        }



        public static void ChangeLight(TrafficJunction o, TrafficJunction.PgaAndIsGreen pgaG) {
            if (o.trafficLights[pgaG.pga].color.timeToGoOff-- == 0) {
                if (!pgaG.isGreen) {// if the light was amber it is set to red and the next one is set to green
                    o.trafficLights[pgaG.pga].color = Lights.RED;
                    if (o.trafficLights[pgaG.pga].position == 4) Reset(o,false);
                    else {
                        o.trafficLights[pgaG.pga + 1].color = Lights.GREEN;
                        o.trafficLights[pgaG.pga + 1].color.timeToGoOff = 15;
                    }
                } else {
                    o.trafficLights[pgaG.pga].color = Lights.AMBER;
                    o.trafficLights[pgaG.pga].color.timeToGoOff = 5;
                }
            }

        }

    }



}

package e4;


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



        public void ChangeLight(TrafficJunction o, TrafficJunction.PgaAndIsGreen pgaG) {
            if (o.trafficLights[pgaG.pga].color.timeToGoOff-- == 0) {
                if (!pgaG.isGreen) {
                    o.trafficLights[pgaG.pga].color = Lights.RED;
                    if (o.trafficLights[pgaG.pga].position == 4) o.trafficLights[0].Reset(o,false);
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

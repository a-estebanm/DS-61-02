package e4;

public class LightsClass {

    public enum Lights {


        GREEN(15),
        AMBER(5),
        RED();

        public int timeToGoOff;
        private TrafficLightsClass trafficLight;

        Lights(int timeToGoOff) {
            this.timeToGoOff = timeToGoOff;
        }

        Lights() {
        }

    }

}

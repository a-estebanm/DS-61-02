package e4;

public class TrafficJunction {

    public Lights[] lights;
    public TrafficLights[] trafficLights;

    public enum Lights {


        GREEN(15),
        AMBER(5),
        RED();

        private int timeToGoOff;
        private TrafficLights trafficLight;

        Lights(int timeToGoOff) {
            this.timeToGoOff = timeToGoOff;
        }

        Lights() {
        }

    }


    public enum TrafficLights {

        NORTH(Lights.GREEN, 1),
        SOUTH(Lights.RED, 2),
        EAST(Lights.RED, 3),
        WEST(Lights.RED, 4),
        ALL(0);

        private final int position;
        private Lights color;

        TrafficLights(Lights color, int position) {
            this.color = color;
            this.position = position;

        }

        TrafficLights(int position) {
            this.position = position;
        }


    }

    private void Reset(boolean a) {

        trafficLights[0].color = Lights.GREEN;
        trafficLights[0].color.timeToGoOff = 15;
        if (a) {
            for (int i = 1; i < 4; i++) {
                trafficLights[i].color = Lights.RED;

            }
        }
    }


    /**
     * Creates a trafic junction with four traffic lights named north , south ,
     * east and west . The north traffic light has just started its green cycle .
     */
    public TrafficJunction() {

         lights = new Lights[]{Lights.GREEN, Lights.AMBER, Lights.RED};

         trafficLights = new TrafficLights[]{TrafficLights.NORTH, TrafficLights.SOUTH, TrafficLights.EAST, TrafficLights.WEST};


    }

    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy() {

        if (trafficLights[0].color == trafficLights[1].color && trafficLights[0].color == Lights.AMBER) return;
        int pga;
        boolean isGreen = false;
        for (pga = 0; pga < 4; pga++) {

            if (trafficLights[pga].color == Lights.GREEN) {
                isGreen = true;
                break;
            } else if (trafficLights[pga].color == Lights.AMBER) break;


        }
        if (trafficLights[pga].color.timeToGoOff-- == 0) {
            if (!isGreen) {
                trafficLights[pga].color = Lights.RED;
                if (trafficLights[pga].position == 4) this.Reset(false);
                else {
                    trafficLights[pga + 1].color = Lights.GREEN;
                    trafficLights[pga + 1].color.timeToGoOff = 15;
                }
            } else {
                trafficLights[pga].color = Lights.AMBER;
                trafficLights[pga].color.timeToGoOff = 5;
            }
        }
    }

    /**
     * If active is true all the traffic lights of the junction must change to
     * blinking amber ( meaning a non - controlled junction ).
     * If active is false it resets the traffic lights cycle and started again
     * with north at green and the rest at red.
     *
     * @param active true or false
     */
    public void amberJunction(boolean active) {
        if (active) {
            for (int i = 0; i < 4; i++) trafficLights[i].color = Lights.AMBER;
        } else {
            this.Reset(true);
        }
    }

    /**
     * Returns a String with the state of the traffic lights .
     * The format for each traffic light is the following :
     * - For red colors : "[ name : RED ]"
     * - For green colors : "[ name : GREEN counter ]"
     * - For yellow colors with blink at OFF : "[ name : YELLOW OFF counter ]
     * - For yellow colors with blink at ON: "[ name : YELLOW ON]
     * Examples :
     * [ NORTH : GREEN 2][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER OFF 5][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER ON ][ SOUTH : AMBER ON ][ EAST : AMBER ON ][ WEST : AMBER ON]
     *
     * @return String that represents the state of the traffic lights
     */
    @Override
    public String toString () {
        StringBuilder junctionState = new StringBuilder();
        if(trafficLights[0].color==Lights.AMBER && trafficLights[1].color==Lights.AMBER){
            junctionState.insert(0, "[NORTH: AMBER ON][SOUTH: AMBER ON][EAST: AMBER ON][WEST: AMBER ON]");
            return junctionState.toString();
        }
        for(int i=3; i>=0; i--){
            if( trafficLights[i].color==Lights.GREEN ){        // in case red null value is added as no character
                junctionState.insert(0, "[" + trafficLights[i] + ": " + trafficLights[i].color + " " + (15-trafficLights[i].color.timeToGoOff) + "]");
            } else if(trafficLights[i].color==Lights.AMBER) {
                junctionState.insert(0, "[" + trafficLights[i] + ": " + trafficLights[i].color + " OFF " + (5-trafficLights[i].color.timeToGoOff) + "]");
            } else {
                junctionState.insert(0, "[" + trafficLights[i] + ": " + trafficLights[i].color + "]");
            }
        }
        return junctionState.toString();
    }

}

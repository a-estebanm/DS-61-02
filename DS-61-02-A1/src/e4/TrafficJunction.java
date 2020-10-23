package e4;

import static e4.TrafficLightsClass.FindGreenOrAmber;

public class TrafficJunction {

    private final LightsClass.Lights[] lights;
    public TrafficLightsClass.TrafficLights[] trafficLights;



    static class PgaAndIsGreen {
        public int pga;
        public boolean isGreen;


        PgaAndIsGreen() {
        }
    }





    /**
     * Creates a trafic junction with four traffic lights named north , south ,
     * east and west . The north traffic light has just started its green cycle .
     */
    public TrafficJunction() {

         lights = new LightsClass.Lights[]{LightsClass.Lights.GREEN, LightsClass.Lights.AMBER, LightsClass.Lights.RED};

         trafficLights = new TrafficLightsClass.TrafficLights[]{TrafficLightsClass.TrafficLights.NORTH, TrafficLightsClass.TrafficLights.SOUTH, TrafficLightsClass.TrafficLights.EAST, TrafficLightsClass.TrafficLights.WEST};


    }

    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy() {

        if (trafficLights[0].color == trafficLights[1].color && trafficLights[0].color == LightsClass.Lights.AMBER) return;
        PgaAndIsGreen pgaG;
        pgaG= FindGreenOrAmber(this);
        this.lights[0].ChangeLight(this,pgaG);
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
            for (int i = 0; i < 4; i++) trafficLights[i].color = LightsClass.Lights.AMBER;
        } else {
            this.trafficLights[0].Reset(this,true);
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
        if(trafficLights[0].color== LightsClass.Lights.AMBER && trafficLights[1].color== LightsClass.Lights.AMBER){
            junctionState.insert(0, "[NORTH: AMBER ON][SOUTH: AMBER ON][EAST: AMBER ON][WEST: AMBER ON]");
            return junctionState.toString();
        }
        for(int i=3; i>=0; i--){
            if( trafficLights[i].color== LightsClass.Lights.GREEN ){        // in case red null value is added as no character
                junctionState.insert(0, "[" + trafficLights[i] + ": " + trafficLights[i].color + " " + (15-trafficLights[i].color.timeToGoOff) + "]");
            } else if(trafficLights[i].color== LightsClass.Lights.AMBER) {
                junctionState.insert(0, "[" + trafficLights[i] + ": " + trafficLights[i].color + " OFF " + (5-trafficLights[i].color.timeToGoOff) + "]");
            } else {
                junctionState.insert(0, "[" + trafficLights[i] + ": " + trafficLights[i].color + "]");
            }
        }
        return junctionState.toString();
    }

}

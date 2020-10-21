package e4;

public class TrafficJunction {


    public enum Lights{



        GREEN(15),
        YELLOW(5),
        RED();

        private int timeToStart;
        private TrafficLights trafficLight;
        Lights(int timeToStart) {
            this.timeToStart=timeToStart;
        }

        Lights(){
            this.timeToStart= (trafficLight.position)*20;

        }

    }
    public final Lights colors[] = {Lights.GREEN,Lights.YELLOW,Lights.RED};
    public static void ChangeColor(){

        if ()

    }


    public enum TrafficLights{

        NORTH(Lights.GREEN,1),
        SOUTH(Lights.RED,2),
        EAST(Lights.RED,3),
        WEST(Lights.RED,4);

        private final int position;

        TrafficLights(Lights color, int position){

            this.position=position;

        }

    }

    /**
     * Creates a trafic junction with four traffic lights named north , south ,
     * east and west . The north traffic light has just started its green cycle .
     */
    public TrafficJunction () {

        Lights[] lights = new Lights[]{Lights.GREEN,Lights.YELLOW,Lights.RED};

        TrafficLights[] trafficLights = new TrafficLights[]{TrafficLights.NORTH,TrafficLights.SOUTH,TrafficLights.EAST,TrafficLights.WEST};


    }
    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy () {

        Lights.GREEN.timeToStart-=1;
        Lights.YELLOW.timeToStart-=1;
        Lights.RED.timeToStart-=1;
        if (Lights.GREEN.timeToStart==0||Lights.YELLOW.timeToStart==0||Lights.RED.timeToStart==0)

    }
    /**
     * If active is true all the traffic lights of the junction must change to
     * blinking amber ( meaning a non - controlled junction ).
     * If active is false it resets the traffic lights cycle and started again
     * with north at green and the rest at red.
     * @param active true or false
     */
    public void amberJunction ( boolean active ) { /* ... */ }
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
     * @return String that represents the state of the traffic lights
     */
    @Override
    public String toString () { /* ... */ }
}

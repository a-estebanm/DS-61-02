
public class Thermostat {
    private boolean heating;
    private float temp = 20; //We set 20 as initial temperature
    private ThermostatState state = new Off(this); //We set initial state as Off
    private final StringBuilder info = new StringBuilder();

    public void setState(ThermostatState state) {


        this.state.setState(this, state);
    }

    protected void newState(ThermostatState state){

        String prev = this.state.getClass().getName();
        String next = state.getClass().getName();

        if(!next.equals(prev)){
            if(next.equals(Manual.class.getName())) info.append(next).append(" mode enabled\n");
            if(prev.equals(Timer.class.getName())) info.append(prev).append(" mode disabled\n");
            if(next.equals(Timer.class.getName())) info.append(next).append(" mode enabled (").append(state.getTimeLeft()).append(" remaining)\n");
            if(next.equals(Program.class.getName())) info.append(next).append(" mode enabled ").append(state.getThresHold()).append(" threshold\n");
            if(next.equals(Off.class.getName()) && prev.equals(Program.class.getName())) info.append(next).append(" mode enabled\n");
        }

        this.state = state;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public void stateChange(){

    }

    Thermostat (){
    }

    public void newTemperature (float currentTemperature){
        temp = currentTemperature;
        state.timePasses();

        insInfo();

    }
    public void insInfo(){
        info.append(temp).append("  ").append("heating ");
        if (heating) { info.append("ON "); } else info.append("OFF");
        info.append("  mode ").append(state.getClass().getName());
        if (this.state.getClass().getName().equals(Timer.class.getName())) info.append(" (").append(state.getTimeLeft()).append(" remaining)");
        if (this.state.getClass().getName().equals(Program.class.getName())) info.append(" threshold at ").append(state.getThresHold());
        info.append("\n");
    }
    public String screenInfo (){

        return info.toString();
    }

    public float getTemp() {
        return temp;
    }

    public ThermostatState getState() {
        return state;
    }

    public StringBuilder getInfo(){return info;}



    public static void main (String [] args){

        Thermostat termo = new Thermostat();
        termo.setState(new Timer(termo,8));
        termo.newTemperature(24);
       // System.out.print(termo.state.getClass().getName()+"\n");
        termo.setState(new Program(termo,25));
        termo.newTemperature(22);
        termo.newTemperature(24);
        termo.newTemperature(24);
        termo.setState(new Program(termo,25));
        termo.newTemperature(24);
        termo.newTemperature(26);
        termo.newTemperature(23);
        termo.setState(new Timer(termo,4));
        termo.setState(new Timer(termo,4));
        termo.newTemperature(21);
        termo.setState(new Off(termo));
        termo.newTemperature(24);
        termo.newTemperature(21);
        termo.setState(new Manual(termo));
        termo.newTemperature(21);
        termo.newTemperature(25);
        System.out.print(termo.screenInfo());

    }
}

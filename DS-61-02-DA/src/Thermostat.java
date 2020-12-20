
public class Thermostat {
    private boolean heating;
    private float temp = 20; //We set 20 as initial temperature
    private ThermostatState state = new Off(this); //We set initial state as Off
    private final StringBuilder info = new StringBuilder();

    public void setState(ThermostatState state) {
        state.setState(this, state);
    }

    public void newState(ThermostatState state){
        //if (this.state == state) return;
        this.state = state;
        info.append(state.getClass().getName()).append(" mode enabled\n");
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
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
        if (heating) { info.append("ON"); } else info.append("OFF");
        info.append("  mode ").append(state.getClass().getName());
        if (this.state.getClass().getName().equals(Timer.class.getName())) info.append(state.getTimeLeft()).append(" remaining\n");
        if (this.state.toString().equals("Timer")) info.append(" threshold at ").append(state.getThresHold()).append("\n");
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
        termo.setState(new Timer(termo,4));
       // System.out.print(termo.state.getClass().getName()+"\n");
        termo.setState(new Program(termo,25));
        //termo.newTemperature(22);
        termo.setState(new Program(termo,25));
        System.out.print(termo.screenInfo());

    }
}

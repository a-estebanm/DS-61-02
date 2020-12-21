package e1;

public class Thermostat {
    private boolean heating;
    private float temp = 20; //We set 20 as initial temperature
    private ThermostatState state = new Off(this); //We set initial state as e1.Off
    private final StringBuilder info = new StringBuilder();

    public void setState(ThermostatState state) {


        this.state.setState(this, state);
    }

    protected void newState(ThermostatState state){

        String prev = this.state.getClass().getSimpleName();
        String next = state.getClass().getSimpleName();

        if(!next.equals(prev)){
            if(next.equals("Manual")) info.append(next).append(" mode enabled\n");
            if(prev.equals("Timer")) info.append(prev).append(" mode disabled\n");
            if(next.equals("Timer")) info.append(next).append(" mode enabled (").append(state.getTimeLeft()).append(" remaining)\n");
            if(next.equals("Program")) info.append(next).append(" mode enabled ").append(state.getThresHold()).append(" threshold\n");
            if(next.equals("Off") && prev.equals("Program")) info.append(next).append(" mode enabled\n");
        }

        this.state = state;
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
        if (heating) { info.append("ON "); } else info.append("OFF");
        info.append("  mode ").append(state.getClass().getSimpleName());
        if (this.state.getClass().getSimpleName().equals("Timer")) info.append(" (").append(state.getTimeLeft()).append(" remaining)");
        if (this.state.getClass().getSimpleName().equals("Program")) info.append(" threshold at ").append(state.getThresHold());
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

    public boolean getHeating(){
        return heating;
    }

    public StringBuilder getInfo(){return info;}
}
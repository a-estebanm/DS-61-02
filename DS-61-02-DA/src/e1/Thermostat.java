package e1;

public class Thermostat {

    private boolean heating;
    private float temp = 20; //We set 20 as initial temperature
    private ThermostatState state = new Off(this); //We set initial state as Off
    private final ThermostatInfo info = new ThermostatInfo(this);

    Thermostat (){
    }

    public void setState(ThermostatState state) {


        this.state.setState(this, state);
    }

    protected void newState(ThermostatState state){

        if((!this.state.compare(state))){
            info.newInfo(state);
        }
        this.state = state;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }


    public void newTemperature (float currentTemperature){
        temp = currentTemperature;
        state.timePasses();
        info.insInfo();

    }
    public String screenInfo (){
        return info.getInfo().toString();
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

    public ThermostatInfo getInfo(){
        return info;
    }



}
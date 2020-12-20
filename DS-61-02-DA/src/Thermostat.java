import java.util.ArrayList;
import java.util.List;

public class Thermostat {
    private boolean heating;
    private float temp;
    private ThermostatState state;
    private ThermostatState prevstate;
    private StringBuilder info = new StringBuilder();


    public boolean isHeating() {
        return heating;
    }

    public void setState(ThermostatState state) {
        this.state = state;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public void newTemperature (float currentTemperature){
        temp = currentTemperature;
        state.timePasses(this);
        insInfo();


    }
    public void insInfo(){
        info.append(temp+"  "+"heating ");
        if (heating) { info.append("ON"); } else info.append("OFF");
        info.append("  mode "+state+"\n");

    }
    public String ScreenInfo (){
        StringBuilder str = new StringBuilder();

        return str.toString();
    }

    public float getTemp() {
        return temp;
    }

    public ThermostatState getState() {
        return state;
    }
}

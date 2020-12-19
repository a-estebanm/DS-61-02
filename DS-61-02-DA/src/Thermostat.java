import java.util.ArrayList;
import java.util.List;

public class Thermostat {
    private boolean heating;
    private float temp;
    private ThermostatState state;
    private List<Float> temps = new ArrayList<>();
    private List<ThermostatState> states = new ArrayList<>();


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
        temps.add(currentTemperature);
        states.add(state);
    }

    public float getTemp() {
        return temp;
    }

    public ThermostatState getState() {
        return state;
    }
}

public class Off implements ThermostatState{

    Off(Thermostat t){
        t.setHeating(false);
    }
}
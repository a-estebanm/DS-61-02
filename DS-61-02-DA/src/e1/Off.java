package e1;

public class Off implements ThermostatState{//a

    Off(Thermostat t){
        t.setHeating(false);
    }

}

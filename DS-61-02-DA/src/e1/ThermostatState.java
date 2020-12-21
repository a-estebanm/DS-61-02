package e1;

public interface ThermostatState {
    default void timePasses(){
    }

    default void setState(Thermostat t,ThermostatState s){
        t.newState(s);
    }
    default int getTimeLeft(){
        return 0;
    }
    default float getThresHold(){
        return 0;
    }
}
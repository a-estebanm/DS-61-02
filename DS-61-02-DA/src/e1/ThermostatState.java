package e1;

public interface ThermostatState {
    default void timePasses(){
    }

    default void setState(Thermostat t,ThermostatState s){
        t.newState(s);
    }
    default int getTimeLeft(){
        throw new UnsupportedOperationException("getTimeLeft");
    }
    default float getThresHold(){
        throw new UnsupportedOperationException("getThreshold");
    }
}
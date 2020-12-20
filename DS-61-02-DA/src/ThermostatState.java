public interface ThermostatState {
    default void timePasses(Thermostat t){
    }
    default int getTimeLeft(){
        return 0;
    }
    default float getThresHold(){
        return 0;
    }
}
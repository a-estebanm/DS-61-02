package e1;

public interface ThermostatState {//a

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
    default void writeInfo(StringBuilder info) {
        info.append(this.getClass().getSimpleName()).append(" mode enabled\n");
    }

    default void writeTP(StringBuilder info){
    }

    default boolean compare (ThermostatState state){
        return (this.getClass()==state.getClass()&&this.getTimeLeft()== state.getTimeLeft()&&this.getThresHold()== state.getThresHold());
    }
}
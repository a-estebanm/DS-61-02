package e1;

public final class ThermostatInfo {

    private final Thermostat t;
    private final StringBuilder info = new StringBuilder();

    ThermostatInfo(Thermostat t){
        this.t = t;
    }

    public StringBuilder getInfo() {
        return info;
    }

    public void newInfo(ThermostatState state){
        state.writeInfo(info);
    }

    public void insInfo(){
        ThermostatState state = t.getState();
        info.append(t.getTemp()).append("  ").append("heating ");
        if (t.getHeating()) { info.append("ON "); } else info.append("OFF");
        info.append("  mode ").append(state.getClass().getSimpleName());
        state.writeTP(info);
        info.append("\n");
    }
}

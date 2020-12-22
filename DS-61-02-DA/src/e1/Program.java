package e1;

public final class Program implements ThermostatState{//a

    private final float threshold;
    private final Thermostat t;

    Program(Thermostat t, float temp){
        this.threshold=temp;
        t.setHeating(t.getTemp() < threshold);
        this.t=t;
    }

    @Override
    public void timePasses() {
        t.setHeating(t.getTemp() < threshold);
    }

    @Override
    public float getThresHold(){
        return threshold;
    }

    @Override
    public void setState(Thermostat t, ThermostatState s) {
        if (s instanceof Timer) {
            t.newState(new Off(t));
        }
        else t.newState(s);
    }

    @Override
    public void writeInfo(StringBuilder info) {
        info.append(getClass().getSimpleName()).append(" mode enabled ").append(threshold).append(" threshold\n");
    }

    @Override
    public void writeTP(StringBuilder info) {
        info.append(" threshold at ").append(threshold);
    }
}


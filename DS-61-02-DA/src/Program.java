public class Program implements ThermostatState{

    private final float threshold;
    private final Thermostat t;

    Program(Thermostat t, float temp){
        this.threshold=temp;
        t.setHeating(t.getTemp() < threshold);
        t.getInfo().append("Program mode enabled with threshold of ").append(threshold).append("\n");
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
        if (s.getClass().getName().equals(Timer.class.getName())) {
            t.getInfo().append("Timer mode disabled\n");
            t.newState(new Off(t));

        }
        else t.newState(s);
    }
}


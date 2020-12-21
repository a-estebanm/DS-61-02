package e1;

public class Program implements ThermostatState{

    private final float threshold;
    private final Thermostat t;

    Program(Thermostat t, float temp){
        this.threshold=temp;
        t.setHeating(t.getTemp() < threshold);
        //t.getInfo().append("e1.Program mode enabled with threshold of ").append(threshold).append("\n");
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
        if (s.getClass().getSimpleName().equals("Timer")) {
            //t.getInfo().append("e1.Timer mode disabled\n");
            t.newState(new Off(t));
           // t.getInfo().append("e1.Off mode enabled\n");

        }
        else t.newState(s);
    }
}


public class Program implements ThermostatState{

    private final float threshold;

    Program(Thermostat t, float temp){
        if (t.getState().getClass()==Timer.class) throw new IllegalArgumentException();// Correcto o coupling?
        this.threshold=temp;
        t.setHeating(t.getTemp() < threshold);
    }

    @Override
    public void timePasses(Thermostat t) {
        t.setHeating(t.getTemp() < threshold);
    }
}

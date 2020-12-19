public class Timer implements ThermostatState{
    private int timeLeft;
    Timer(Thermostat t, int timeLeft){
        if (t.getState().getClass()==Program.class) throw new IllegalArgumentException();// Correcto o coupling?
        this.timeLeft=timeLeft;
    }

    @Override
    public void timePasses(Thermostat t) {
        if (timeLeft<=5){
            t.setState(new Off(t));
        }
        timeLeft-=5;

    }
}

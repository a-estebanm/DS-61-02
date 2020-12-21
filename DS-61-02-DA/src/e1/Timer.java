package e1;

public class Timer implements ThermostatState{

    private int timeLeft;
    private final Thermostat t;


    Timer(Thermostat t, int timeLeft){
        this.timeLeft=timeLeft;
        t.setHeating(true);
        this.t = t;
    }

    @Override
    public void timePasses() {
        if (timeLeft<=5){
            t.newState(new Off(t));
        }
        timeLeft-=5;
    }
    @Override
    public void setState(Thermostat t, ThermostatState s) {
        if (s.getClass().getSimpleName().equals("Program")) {
            t.newState(new Off(t));
        }
        else t.newState(s);

    }

    @Override
    public int getTimeLeft() {
        return timeLeft;
    }
}

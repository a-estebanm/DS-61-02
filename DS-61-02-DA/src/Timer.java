public class Timer implements ThermostatState{

    private int timeLeft;
    private final Thermostat t;


    Timer(Thermostat t, int timeLeft){
        this.timeLeft=timeLeft;
        t.setHeating(true);
        this.t = t;
        //t.getInfo().append("Timer mode enabled for ").append(timeLeft).append(" minutes\n");
    }

    @Override
    public void timePasses() {
        if (timeLeft<=5){
            t.newState(new Off(t));
            //t.getInfo().append("Timer mode disabled\n");
        }
        timeLeft-=5;
    }
    @Override
    public void setState(Thermostat t, ThermostatState s) {
        if (s.getClass().getName().equals(Program.class.getName())) {
            t.newState(new Off(t));
        }
        else t.newState(s);

    }

    @Override
    public int getTimeLeft() {
        return timeLeft;
    }
}

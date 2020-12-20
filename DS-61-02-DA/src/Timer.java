public class Timer implements ThermostatState{

    private int timeLeft;

    Timer(Thermostat t, int timeLeft){
        if (t.getState().getClass()==Program.class) throw new IllegalArgumentException();   // Correcto o coupling?
        this.timeLeft=timeLeft;
        t.getInfo().append("Timer mode enabled for "+timeLeft+"\n");
    }

    @Override
    public void timePasses(Thermostat t) {
        if (timeLeft<=5){

            t.setState(new Off(t));
            t.getInfo().append("Timer mode disabled\n");
        }
        timeLeft-=5;

    }

    @Override
    public int getTimeLeft() {
        return timeLeft;
    }
}

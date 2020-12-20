import java.util.ArrayList;
import java.util.List;

public class Thermostat {
    private boolean heating;
    private float temp;
    private ThermostatState state;
    private ThermostatState prevstate;
    private StringBuilder info = new StringBuilder();

    public boolean isHeating() {
        return heating;
    }

    public void setState(ThermostatState state) {
        this.state = state;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }


    public void newTemperature (float currentTemperature){
        temp = currentTemperature;
        state.timePasses(this);

        insInfo();

    }
    public void insInfo(){
        info.append(temp+"  "+"heating ");
        if (heating) { info.append("ON"); } else info.append("OFF");
        info.append("  mode "+state.getClass().getName());
        if (this.state.getClass().getName().equals(Timer.class.getName())) info.append( state.getTimeLeft()+" remaining\n");
        if (this.state.toString().equals("Timer")) info.append( " threshold at "+state.getThresHold()+"\n");
    }
    public String screenInfo (){

        return info.toString();
    }

    public float getTemp() {
        return temp;
    }

    public ThermostatState getState() {
        return state;
    }

    public StringBuilder getInfo(){return info;}


    public static void main (String [] args){

        Thermostat termo = new Thermostat();
        Thermostat termo2 = new Thermostat();
        termo.setState(new Off(termo2));
        termo.setState(new Timer(termo,4));
        System.out.print(termo.state.getClass().getName()+"\n");
        termo.newTemperature(22);
        System.out.print(termo.screenInfo());



    }
}

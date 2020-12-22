package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {

    @Test
    void offtest() {
        Thermostat termo = new Thermostat();
        termo.setState(new Timer(termo,15));
        assertTrue(termo.getState() instanceof Timer);

        termo.setState(new Program(termo,25));
        assertTrue(termo.getState() instanceof Off);

        termo.setState(new Program(termo,25));
        assertTrue(termo.getState() instanceof Program);

        termo.setState(new Manual(termo));
        assertTrue(termo.getState() instanceof Manual);

    }
    @Test
    void timerTest() {
        Thermostat termo = new Thermostat();

        termo.setState(new Timer(termo,12));
        termo.newTemperature(21);
        assertTrue(termo.getHeating());
        assertEquals(termo.getState().getTimeLeft(),7);

        termo.newTemperature(19);
        assertTrue(termo.getHeating());
        assertEquals(termo.getState().getTimeLeft(),2);

        termo.newTemperature(17);
        assertTrue(termo.getState() instanceof Off);
        assertFalse(termo.getHeating());

        termo.setState(new Manual(termo));
        assertTrue(termo.getHeating());
    }
    @Test
    void programTest() {
        Thermostat termo = new Thermostat();
        termo.setState(new Program(termo,15));

        termo.newTemperature(21);
        assertFalse(termo.getHeating());

        termo.newTemperature(12);
        assertTrue(termo.getHeating());

        termo.setState(new Timer(termo,15));
        assertTrue(termo.getState() instanceof Off);

        termo.setState(new Timer(termo,15));
        assertTrue(termo.getState() instanceof Timer);
    }

    @Test
    void logTest(){
        Thermostat termo = new Thermostat();
        termo.setState(new Program(termo,15));
        termo.newTemperature(12);
        termo.newTemperature(17);
        termo.setState(new Timer(termo,15));
        termo.setState(new Timer(termo,15));
        termo.newTemperature(12);
        termo.newTemperature(12);
        termo.newTemperature(12);
        termo.setState(new Timer(termo,15));
        termo.setState(new Program(termo,15));
        termo.setState(new Program(termo,25));
        termo.setState(new Off(termo));
        termo.setState(new Manual(termo));
        termo.newTemperature(17);
        termo.newTemperature(15);
        termo.setHeating(true);
        assertEquals(termo.screenInfo(), """
                Program mode enabled 15.0 threshold
                12.0  heating ON   mode Program threshold at 15.0
                17.0  heating OFF  mode Program threshold at 15.0
                Off mode enabled
                Timer mode enabled (15 remaining)
                12.0  heating ON   mode Timer (10 remaining)
                12.0  heating ON   mode Timer (5 remaining)
                Timer mode disabled
                Off mode enabled
                12.0  heating OFF  mode Off
                Timer mode enabled (15 remaining)
                Timer mode disabled
                Off mode enabled
                Program mode enabled 25.0 threshold
                Off mode enabled
                Manual mode enabled
                17.0  heating ON   mode Manual
                15.0  heating ON   mode Manual
                """);
    }
}
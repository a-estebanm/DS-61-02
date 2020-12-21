package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {

    @Test
    void offtest() {
        Thermostat termo = new Thermostat();
        termo.setState(new Timer(termo,15));
        assertEquals("Timer",termo.getState().getClass().getSimpleName());

        termo.setState(new Program(termo,25));
        assertEquals("Off",termo.getState().getClass().getSimpleName());

        termo.setState(new Program(termo,25));
        assertEquals("Program",termo.getState().getClass().getSimpleName());

        termo.setState(new Manual(termo));
        assertEquals("Manual",termo.getState().getClass().getSimpleName());

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
        assertEquals("Off",termo.getState().getClass().getSimpleName());
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
        assertEquals("Off",termo.getState().getClass().getSimpleName());

        termo.setState(new Timer(termo,15));
        assertEquals("Timer",termo.getState().getClass().getSimpleName());
    }
}
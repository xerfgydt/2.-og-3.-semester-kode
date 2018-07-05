import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {




    //code to test
    private Calculator calculator;

    @org.junit.Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void add() throws Exception {
        // test fixture

        int resultat = calculator.add(2,3); // skulle give 5
        assertEquals(5, resultat);
    }
    @Test
    public void divide() throws Exception {
        double resultat = calculator.divide(10,5);
        assertEquals(2,resultat,0.001);// delta er hvor meget resultatet må afvige
    }
}
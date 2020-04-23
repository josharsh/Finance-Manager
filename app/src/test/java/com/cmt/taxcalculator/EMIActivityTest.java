package com.cmt.taxcalculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class EMIActivityTest {

    @Test
    public void calPric_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(5.12f,  Test.calPric(5.12f), 0.01);
        assertNotEquals(5.1f, Test.calPric(5.12f), 0.01);

    }

    @Test
    public void calInt_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(0.01f, Test.calInt(12.0f), 0.00001);
        assertNotEquals(0.01f, Test.calInt(11.0f), 0.00001);

    }

    @Test
    public void calMonth_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(1.2f, Test.calMonth(0.1f), 0.00001);
        assertNotEquals(1.2f, Test.calMonth(0.2f), 0.00001);

    }

    @Test
    public void calDvdnt_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(1.159693f, Test.calDvdnt(0.025f, 6.0f), 0.000001);
        assertNotEquals(1.159692f, Test.calDvdnt(0.025f, 6.0f), 0.000001);

    }

    @Test
    public void calFinalDvdnt_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(1508.0f, Test.calFinalDvdnt(52000.0f, 0.025f, 1.16f), 0.1);
        assertNotEquals(1509.0f, Test.calFinalDvdnt(52000.0f, 0.025f, 1.16f), 0.1);

    }

    @Test
    public void calDivider_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(0.16f, Test.calDivider(1.16f), 0.001);
        assertNotEquals(0.15f, Test.calDivider(1.16f), 0.001);

    }

    @Test
    public void calEmi_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(768.0f, Test.calEmi(19.2f, 0.025f), 0.001);
        assertNotEquals(768.1f, Test.calEmi(19.2f, 0.025f), 0.001);

    }

    @Test
    public void calTa_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(4608.0f, Test.calTa(768.0f, 6.0f), 0.001);
        assertNotEquals(4609.1f, Test.calTa(768.0f, 6.0f), 0.001);

    }

    @Test
    public void calTotalInt_isCorrect(){

        EMIActivity Test = new EMIActivity();
        assertEquals(-5392.0f, Test.calTotalInt(4608.0f, 10000.0f), 0.001);
        assertNotEquals(5392.0f, Test.calTotalInt(4608.0f, 10000.0f), 0.001);

    }

}

package test;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import databaselayer.DatabaseLayerException;
import databaselayer.DatabasePBuy;
import modellayer.PBuy;
import modellayer.PPayStation;

public class TestInsertParkingBuy {
    private static DatabasePBuy DBP;
    private PBuy Pbuy;
    private PPayStation ppay;
    private LocalDate time;

    @Test
    public void assertsame() throws DatabaseLayerException {
        int nut = 0;
        DBP = new DatabasePBuy();

        time = LocalDate.now(); // Initialize the time variable
        Pbuy = new PBuy(time, 5, 12.0);
        Pbuy.setParkingDuration(5);
        Pbuy.setPayedCentAmount(12);
        ppay = new PPayStation(1, "station1");
        Pbuy.setAssociatedPaystation(ppay);

      try {
        	nut = DBP.insertParkingBuy(Pbuy);
        } catch (DatabaseLayerException ex) {
        }
        
        assertEquals(1, nut);
    }
}

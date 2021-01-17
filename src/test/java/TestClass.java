import com.dudek.model.Car.CarBase;
import com.dudek.model.Car.CarGenerator;
import org.junit.jupiter.api.Test;


public class TestClass {

    @Test
    public void shouldPrintCars() {
        CarBase carBase = new CarBase(new CarGenerator());
        carBase.printCarsToSell();
    }


}           //todo zrobic test dla kilkaset prob randomowego booleana

import com.dudek.model.Car.CarGenerator;
import com.dudek.model.Car.NewCarsDatabase;
import org.junit.jupiter.api.Test;


public class TestClass {

    @Test
    public void shouldPrintCars() {
        NewCarsDatabase newCarsDatabase = new NewCarsDatabase(new CarGenerator());
        newCarsDatabase.printCarsForSale();
    }


}

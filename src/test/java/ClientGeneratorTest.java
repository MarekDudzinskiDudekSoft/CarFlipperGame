import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import org.junit.jupiter.api.Test;

public class ClientGeneratorTest {

    ClientBase clientBase = new ClientBase(new ClientGenerator());

    @Test
     void checkClientPropability(){
        clientBase.printClientList();

    }

}

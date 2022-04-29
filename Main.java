import dto.Personnel;
import exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExampleUtil;

public class Main {
    public static void main(String[] args) throws Throwable {
        final Logger LOG = LoggerFactory.getLogger(Main.class);

        //... sample scenario
        Personnel personnel = null;// forexample personnel object is null
        ExampleUtil.requireNonNull(personnel, BusinessException.class,"exception message","log message", LOG::error);

    }
}

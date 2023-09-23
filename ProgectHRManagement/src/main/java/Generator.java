import java.util.Random;

public class Generator  {
    public String empIdGen() {
        Random random = new Random();
        int num = random.nextInt(99999999);
        return "EMP%" + num;
    }
}

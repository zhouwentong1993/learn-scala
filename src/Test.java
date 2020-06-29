import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        String[] arr = {"declarative","imperative","oop","fp"};
        for (String s : arr) {
            result.add(s.toUpperCase());
        }
        System.out.println(result);
    }
}

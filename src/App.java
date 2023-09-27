import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String today = dtf.format(java.time.LocalDateTime.now());
        System.out.println(today.getClass());
    }
}

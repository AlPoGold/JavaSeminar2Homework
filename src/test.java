import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
public class test {

    public class findPatterns {
        public static String[] findSurname(String text) {
            List<String> surnames = new ArrayList<>();
            Pattern pattern = Pattern.compile("\"фамилия\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                surnames.add(matcher.group(1));
                System.out.println(matcher.group(1));
            }
            return surnames.toArray(new String[0]);
        }

        public static void main(String[] args) {
            String text = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

            String[] surnames = findSurname(text);

            for (String surname : surnames) {
                System.out.println(surname);
            }
        }
    }
}



//public class findPatterns {
//    public static String[] findSurname(String text, int n){
//        String[] surnames = new String[n];
//        Pattern pattern = Pattern.compile("\"фамилия\":\"([^\"]+)\"",  Pattern.UNICODE_CHARACTER_CLASS);
//        Matcher matcher = pattern.matcher(text);
//        int count = 0;
//        while (matcher.find() && count < n) {
//            surnames[count] = matcher.group(1);
//            count++;
//        }
//        return surnames;
//    }
//
//}

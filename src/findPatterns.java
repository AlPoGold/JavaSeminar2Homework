import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.stream.Collectors;
import java.io.FileReader;




public class findPatterns {

    public static String[] findSurname(String text) {
        List<String> surnames = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"фамилия\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            surnames.add(matcher.group(1));
        }
        return surnames.toArray(new String[0]);
    }
    public static String[] findScore(String text) {
        List<String> scores = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"оценка\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            scores.add(matcher.group(1));
        }
        return scores.toArray(new String[0]);
    }

    public static String[] findSubject(String text) {
        List<String> subjects = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"предмет\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            subjects.add(matcher.group(1));
        }
        return subjects.toArray(new String[0]);
    }

    public static String readFile(String filePath) {
        String content = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content += line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void main(String[] args) {
        String pathFile = "src\\json_text.txt";
//        String text = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
//                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
//                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        String text = readFile(pathFile);
        String pathFileAnswer = "src\\answer.txt";
        try(FileWriter surnameContent = new FileWriter(pathFileAnswer)){
            String[] surnames = findSurname(text);
            String[] scores = findScore(text);
            String[] subjects = findSubject(text);
            for (int i = 0; i < surnames.length; i++) {
                surnameContent.write("Студент " + surnames[i] + " получил " + scores[i] + " по предмету " + subjects[i] + ".");
                surnameContent.write("\n");
                surnameContent.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
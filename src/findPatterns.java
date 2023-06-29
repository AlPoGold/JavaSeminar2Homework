import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class findPatterns {
    static Logger logger;
    private static void createLogger(){
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try{
            fileHandler = new FileHandler("src/logFindPatterns.txt", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();

            if (fileHandler != null) {
                fileHandler.setFormatter(formatter);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void closeLogger(){
        for(Handler handler : logger.getHandlers()){
            handler.close();
        }
    }

    public static String[] findSurname(String text) {
        List<String> surnames = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"фамилия\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
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


    public static String readFile(String pathFile){
        StringBuilder content = new StringBuilder();
        File file = new File(pathFile);
        try(Scanner scan = new Scanner(file)){
            while(scan.hasNextLine()){
                content.append(scan.nextLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        createLogger();
        String pathFile = "src\\json_text.txt";
//        String text = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
//                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
//                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        String text = readFile(pathFile);
        System.out.println(text);
        String pathFileAnswer = "src\\answer.txt";
        try(FileWriter content = new FileWriter(pathFileAnswer)){
            String[] surnames = findSurname(text);
            String[] scores = findScore(text);
            String[] subjects = findSubject(text);
            for (int i = 0; i < surnames.length; i++) {
                content.write("Студент " + surnames[i] + " получил " + scores[i] + " по предмету " + subjects[i] + ".");
                content.write("\n");
                content.flush();
            }
            logger.info("New file is written successfully");
        }catch(Exception e){
            logger.warning("Something has gone wrong");
            e.printStackTrace();
        }
        closeLogger();

    }
}
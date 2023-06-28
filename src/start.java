//import java.io.File;
//import java.io.FileReader;
//import java.util.Scanner;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class start {
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        pool.submit(Foo::foo);
//        pool.submit(() -> bar());
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                baz();
//            }
//        });
//    }
//
//    static void ex1() {
//        static String pathFile = "src\\json_text.txt";
//        public static void main(String[] args){
//
//            String text = readFile(pathFile);
//            findPatterns.main(args);
//
//        }
//
//        static String readFile(String filePath){
//            File file = new File(filePath);
//            String fileContent = new String("");
//
//            try(FileReader fr = new FileReader(file)){
//                Scanner scan = new Scanner(fr);
//                while (scan.hasNextLine()) {
//                    fileContent+=scan.nextLine();
//                }
//
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            return fileContent;
//        }
//
//    }
//    static void findPatterns() { /* долгая задача 2 */ }
//
//}
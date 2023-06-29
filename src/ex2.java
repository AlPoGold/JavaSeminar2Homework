import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class ex2 {
    /*
    Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
     */

    static Logger logger;
    public static void main(String[] args) {
        int[] array = arrRandom(20, 0, 20);
        System.out.println(Arrays.toString(array));
        createLogger();
        int[] result = bubbleSort(array);
        System.out.println(Arrays.toString(result));
    }

    private static void createLogger(){
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try{
            fileHandler = new FileHandler("src/logEx2.txt", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void closeLogger(){
        for(Handler handler : logger.getHandlers()){
            handler.close();
        }
    }
    static int[] arrRandom (int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size ; i++) {
            array[i] = random.nextInt(min, max+1);
        }
        return array;
    }

    static int[] bubbleSort(int[] initArray){
        int size = initArray.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {

                if (initArray[j] > initArray[j + 1]) {
                    int temp = initArray[j];
                    initArray[j] = initArray[j + 1];
                    initArray[j + 1] = temp;
                }
            }
            logger.info(Arrays.toString(initArray));
        }
        closeLogger();
        return initArray;
        }


}
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader {
    public static PrintWriter writer;
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(8);
        long start = System.currentTimeMillis();
        writer = new PrintWriter("C:\\Users\\vanes\\IdeaProjects\\java_basics\\22\\Performance\\CarNumberGenerator\\res\\numbers2.txt");
         // FileOutputStream writer = new FileOutputStream("C:\\Users\\vanes\\IdeaProjects\\java_basics\\22\\Performance\\CarNumberGenerator\\res\\numbers.txt");
        final char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int regionCode = 1; regionCode < 100; regionCode++) {
            service.submit(new Concatenation(regionCode));
        }
        service.shutdown();
        while (!service.isTerminated()) {
        }
        System.out.println("Время выполнения - " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
            for (int regionCode = 1; regionCode < 1000; regionCode++) {
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                            StringBuilder builder = new StringBuilder();
                            builder.append(firstLetter);
                            //builder.append(padNumber(number, 3));
                            builder.append(padNumber2(number,3).toString());
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            //builder.append(padNumber(regionCode, 2));
                                builder.append(padNumber2(regionCode, 2).toString());
                            builder.append("\n");
                            writer.write(builder.toString());
                            //String carNumber = firstLetter + padNumber(number, 3) +
                            //secondLetter + thirdLetter + padNumber(regionCode, 2);
                            //writer.write(carNumber.getBytes());
                        }//writer.write('\n');
                    }
                }
            }
            //writer.write(builder.toString());
        }
            //writer.write(builder.toString().getBytes());
        writer.flush();
        writer.close();
        System.out.println("Время выполнения -" + (System.currentTimeMillis() - start) + " ms");
    }
    private static String padNumber2(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }
    private static StringBuilder padNumber(int number, int numberLenght) {
        String numberStr = Integer.toString(number);
        int padSize = numberLenght - numberStr.length();
        StringBuilder padNumbers = new StringBuilder();
        for (int i = 0; i < padSize; i++) {
            padNumbers.append("0");
        }
        padNumbers.append(numberStr);
        return padNumbers;
    }
}


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;
import static java.lang.System.currentTimeMillis;

public class Main2 {

    private static String url;
    private static String fileName;
    private static final String DST_FOLDER = "C:\\skillbox ebana\\java_basics\\17\\Multithreading\\Links\\src\\main\\resources\\map\\";
    private static final String FILE_TYPE = "txt";
    private static final int numberOfCores = Runtime.getRuntime().availableProcessors();//���-�� ���� ����������
    private static final AtomicLong startOfTime = new AtomicLong();

    public static void main(String[] args)  {
        System.out.println("������� ����� �����: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            url = reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            fileName = new URL(url).getHost().replace(".", "_");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("������� ����������  �������: ");
        int numberOfThreads = 0;//���-�� �������� �������
        try {
            numberOfThreads = Integer.parseInt(reader.readLine());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        startOfTime.set(currentTimeMillis());
        LinkExecutor linkExecutor = new LinkExecutor(url);
        String siteMap;
        if (numberOfThreads == 0) siteMap = new ForkJoinPool(numberOfCores).invoke(linkExecutor);
        else siteMap = new ForkJoinPool(numberOfThreads).invoke(linkExecutor);
        long timeStop = (currentTimeMillis() - startOfTime.get()) / 1_000;
        System.out.printf("��������� ����� ������: %d ������.%n", timeStop);
        writeToFile(siteMap);
    }
    protected static void writeToFile(String string)  {
        if (!Files.exists(Paths.get(DST_FOLDER))) new File(DST_FOLDER).mkdir();
        String filePath = DST_FOLDER.concat(fileName).concat(".").concat(FILE_TYPE);
        File file = new File(filePath);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.write(string);
        writer.flush();
        long allTimeStop = (currentTimeMillis() - startOfTime.get()) / 1_000;
        System.out.printf("��������� ������ ��������� ����� %s �� %d ������: %s%n", url, allTimeStop, file.getName());
    }
}
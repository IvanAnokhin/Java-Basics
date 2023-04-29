import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int nrOfProcessors = runtime.availableProcessors();
        System.out.println("ядер - " + nrOfProcessors);
        String srcFolder = "C:\\Users\\vanes\\Desktop\\src";
        String dstFolder = "C:\\Users\\vanes\\Desktop\\dst";
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        long start = System.currentTimeMillis();
        int middle = files.length / nrOfProcessors;
        for (int i = 0; i < nrOfProcessors - 1; i++) {
            File[] files1 = new File[middle];
            System.arraycopy(files, 0 + (middle * i), files1, 0, middle);
            ImageResize resize1 = new ImageResize(files1, newWidth, dstFolder, start);
            new Thread(resize1).start();
        }
        File[] files2 = new File[files.length - middle * (nrOfProcessors - 1)];
        System.arraycopy(files, middle * (nrOfProcessors - 1), files2, 0, files2.length);
        ImageResize resize2 = new ImageResize(files2, newWidth, dstFolder, start);
        new Thread(resize2).start();
    }

    private static void startThread(int nrOfProcessors, File[] files, String dstFolder) {
        long start = System.currentTimeMillis();
        int middle = files.length / nrOfProcessors;
        for (int i = 0; i < nrOfProcessors - 1; i++) {
            File[] files1 = new File[middle];
            System.arraycopy(files, 0 + (middle * i), files1, 0, middle);
            ImageResize resize1 = new ImageResize(files1, newWidth, dstFolder, start);
            new Thread(resize1).start();
        }
        File[] files2 = new File[files.length - middle * (nrOfProcessors - 1)];
        System.arraycopy(files, middle * (nrOfProcessors - 1), files2, 0, files2.length);
        ImageResize resize2 = new ImageResize(files2, newWidth, dstFolder, start);
        new Thread(resize2).start();
    }

    public static BufferedImage resize(BufferedImage src, int targetWidht, int targetHeight, BufferedImageOp...
            Ops){
        return src;
    }
}

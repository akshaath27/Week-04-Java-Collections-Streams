import java.io.*;

public class BufferedVsUnbufferedCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void copyWithUnbufferedStreams(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            long startTime = System.nanoTime();
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();

            System.out.println("Unbuffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error (Unbuffered): " + e.getMessage());
        }
    }

    public static void copyWithBufferedStreams(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            long startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();

            System.out.println("Buffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error (Buffered): " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String unbufferedDest = "copy_unbuffered.txt";
        String bufferedDest = "copy_buffered.txt";

        copyWithUnbufferedStreams(sourceFile, unbufferedDest);
        copyWithBufferedStreams(sourceFile, bufferedDest);
    }
}

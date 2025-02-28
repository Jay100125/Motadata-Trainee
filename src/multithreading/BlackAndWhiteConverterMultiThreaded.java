package multithreading;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BlackAndWhiteConverterMultiThreaded {
    private BufferedImage originalImage;
    private BufferedImage bwImage;

    // Worker class to process a portion of the image
    private static class ImageProcessor implements Runnable {
        private final BufferedImage originalImage;
        private final BufferedImage bwImage;
        private final int startY;
        private final int endY;

        public ImageProcessor(BufferedImage originalImage, BufferedImage bwImage, int startY, int endY) {
            this.originalImage = originalImage;
            this.bwImage = bwImage;
            this.startY = startY;
            this.endY = endY;
        }

        @Override
        public void run() {
            for (int y = startY; y < endY; y++) {
                for (int x = 0; x < originalImage.getWidth(); x++) {
                    int rgb = originalImage.getRGB(x, y);
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                    gray = Math.min(Math.max(gray, 0), 255);

                    int newRgb = (gray << 16) | (gray << 8) | gray;
                    bwImage.setRGB(x, y, newRgb);
                }
            }
        }
    }

    public BlackAndWhiteConverterMultiThreaded(String inputImagePath) throws IOException {
        File inputFile = new File(inputImagePath);
        this.originalImage = ImageIO.read(inputFile);
        if (originalImage == null) {
            throw new IOException("Could not load the image.");
        }
        this.bwImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public void convertToBlackAndWhite(int numThreads) throws InterruptedException {
        int height = originalImage.getHeight();
        int rowsPerThread = height / numThreads; // Divide rows among threads

        Thread[] threads = new Thread[numThreads];

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            int startY = i * rowsPerThread;
            int endY = (i == numThreads - 1) ? height : (i + 1) * rowsPerThread; // Last thread takes remaining rows
            threads[i] = new Thread(new ImageProcessor(originalImage, bwImage, startY, endY));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public void saveImage(String outputImagePath) throws IOException {
        File outputFile = new File(outputImagePath);
        ImageIO.write(bwImage, "jpg", outputFile);
    }

    public static void main(String[] args) {
        String inputImagePath = "./src/multithreading/input.jpeg";
        String outputImagePath = "output_bw.jpg";
        int numThreads = 4;

        try {
            BlackAndWhiteConverterMultiThreaded converter = new BlackAndWhiteConverterMultiThreaded(inputImagePath);
            long startTime = System.currentTimeMillis();

            converter.convertToBlackAndWhite(numThreads);

            long endTime = System.currentTimeMillis();
            converter.saveImage(outputImagePath);

            System.out.println("Image converted to black and white in " + (endTime - startTime) + " ms");
            System.out.println("Saved as " + outputImagePath);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
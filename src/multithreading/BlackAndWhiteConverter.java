package multithreading;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BlackAndWhiteConverter {
    public static void main(String[] args) {
        // Specify input and output file paths
        String inputImagePath = "./src/multithreading/input.jpeg";  // Replace with your image path
        String outputImagePath = "output_bw.jpg";

        long startTime = System.currentTimeMillis();
        try {
            // Read the input image
            File inputFile = new File(inputImagePath);
            BufferedImage originalImage = ImageIO.read(inputFile);

            // Check if image was loaded successfully
            if (originalImage == null) {
                System.out.println("Error: Could not load the image.");
                return;
            }

            // Get image dimensions
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();

            // Create a new BufferedImage for the black-and-white output
            BufferedImage bwImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Process each pixel
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Get the RGB value of the pixel
                    int rgb = originalImage.getRGB(x, y);

                    // Extract red, green, and blue components
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    // Calculate grayscale value using the luminosity method
                    int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);

                    // Ensure gray value is within 0-255 range
                    gray = Math.min(Math.max(gray, 0), 255);

                    // Create new RGB value with the same gray value for R, G, and B
                    int newRgb = (gray << 16) | (gray << 8) | gray;

                    // Set the pixel in the black-and-white image
                    bwImage.setRGB(x, y, newRgb);
                }
            }

            // Save the black-and-white image
            File outputFile = new File(outputImagePath);
            ImageIO.write(bwImage, "jpeg", outputFile);

            System.out.println("Image successfully converted to black and white and saved as " + outputImagePath);

        } catch (IOException e) {
            System.out.println("Error processing the image: " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}
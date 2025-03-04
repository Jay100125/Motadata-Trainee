package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplicationThreaded{
    static class RowMultiplier implements Runnable {
        private int[][] matrix1, matrix2, result;
        private int row;

        public RowMultiplier(int[][] matrix1, int[][] matrix2, int[][] result, int row) {
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.result = result;
            this.row = row;
        }

        @Override
        public void run() {
            int cols2 = matrix2[0].length;
            int cols1 = matrix1[0].length;
            for (int j = 0; j < cols2; j++) {
                int sum = 0;
                for (int k = 0; k < cols1; k++) {
                    sum += matrix1[row][k] * matrix2[k][j];
                }
                result[row][j] = sum;
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2, int numThreads) throws InterruptedException {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        if (cols1 != matrix2.length) {
            throw new IllegalArgumentException("Matrix multiplication not possible");
        }

        int[][] result = new int[rows1][cols2];

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < rows1; i++) {
            executor.execute(new RowMultiplier(matrix1, matrix2, result, i));
        }

        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.MINUTES);

        return result;
    }
//        public static void printMatrix(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
    public static void main(String[] args) {
        int[][] matrix1 = new int[1000][1000];
        int[][] matrix2 = new int[1000][1000];

        int counter = 1;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                matrix1[i][j] = counter++;
                matrix2[i][j] = counter % 7 + 1;
            }
        }

        try {
            long start = System.currentTimeMillis();
            int[][] result = multiplyMatrices(matrix1, matrix2, 8); // Use 8 threads
            long end = System.currentTimeMillis();
            System.out.println("Elapsed time: " + (end - start) + "ms");
//            System.out.println(result.length);
//            printMatrix(result);
        } catch (InterruptedException e) {
            System.out.println("Error during matrix multiplication: " + e.getMessage());
        }
    }
}

//package multithreading;
//public class MatrixMultiplication {
//    public static void main(String[] args) {
//        // Example matrices
//        int[][] matrix1 = new int[1000][1000];
//        int[][] matrix2 = new int[1000][1000];
//
//        // Fill matrices with values
//        int counter = 1;
//        for (int i = 0; i < 1000; i++) {
//            for (int j = 0; j < 1000; j++) {
//                matrix1[i][j] = counter++;
//                matrix2[i][j] = counter % 7 + 1; // Values 1-7 repeating
//            }
//        }
//
//        if (matrix1[0].length != matrix2.length) {
//            System.out.println("Matrix multiplication is not possible");
//            return;
//        }
//
//        // Perform multiplication
//        long startTime = System.currentTimeMillis();
//        int[][] result = multiplyMatrices(matrix1, matrix2);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Elapsed Time: " + (endTime - startTime));
//    }
//
//    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
//        int rows1 = matrix1.length;
//        int cols1 = matrix1[0].length;
//        int cols2 = matrix2[0].length;
//
//        int[][] result = new int[rows1][cols2];
//
//        // Perform matrix multiplication
//        for (int i = 0; i < rows1; i++) {
//            for (int j = 0; j < cols2; j++) {
//                for (int k = 0; k < cols1; k++) {
//                    result[i][j] += matrix1[i][k] * matrix2[k][j];
//                }
//            }
//        }
//
//        return result;
//    }
//
//    public static void printMatrix(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
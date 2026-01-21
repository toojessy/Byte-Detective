import java.io.*;

/**
 * Lab 1: Byte Detective
 */
public class ByteDetective {

    private static final String MYSTERY_FILE = "mystery.bin";

    /**
     * Task 1: Read and return the first byte from the file.
     * EXAMPLE PROVIDED
     */
    public static int readFirstByte() {
        try (FileInputStream fis = new FileInputStream(MYSTERY_FILE)) {
            return fis.read();
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * Task 2: Read and display ALL bytes from the file.
     */
    public static void readAllBytes() {
        try (FileInputStream fis = new FileInputStream(MYSTERY_FILE)) {

            int byteValue;
            int count = 0;

            while ((byteValue = fis.read()) != -1) {
                count++;
                System.out.println("Byte " + count + ": " + byteValue);
            }

            System.out.println("Total bytes read: " + count);

        } catch (IOException e) {
            System.err.println("Error reading file.");
        }
    }

    /**
     * Task 3: Display all bytes in hexadecimal format.
     */
    public static void displayAsHex() {
        try (FileInputStream fis = new FileInputStream(MYSTERY_FILE)) {

            int byteValue;

            while ((byteValue = fis.read()) != -1) {
                System.out.print(String.format("%02X ", byteValue));
            }

            System.out.println();

        } catch (IOException e) {
            System.err.println("Error reading file.");
        }
    }

    /**
     * Task 4: Attempt to display bytes as ASCII characters.
     */
    public static void attemptAsAscii() {
        try (FileInputStream fis = new FileInputStream(MYSTERY_FILE)) {

            int byteValue;

            while ((byteValue = fis.read()) != -1) {
                System.out.print((char) byteValue);
            }

            System.out.println();

        } catch (IOException e) {
            System.err.println("Error reading file.");
        }
    }

    /**
     * Task 5: Analyze the file and display statistics.
     */
    public static void analyzeFile() {
        try (FileInputStream fis = new FileInputStream(MYSTERY_FILE)) {

            int count = 0;
            int min = 256;
            int max = -1;
            long sum = 0;

            int byteValue;

            while ((byteValue = fis.read()) != -1) {
                count++;
                sum += byteValue;

                if (byteValue < min) {
                    min = byteValue;
                }
                if (byteValue > max) {
                    max = byteValue;
                }
            }

            double average = (double) sum / count;

            System.out.println("Total bytes: " + count);
            System.out.println("Min value: " + min);
            System.out.println("Max value: " + max);
            System.out.println("Average: " + average);

        } catch (IOException e) {
            System.err.println("Error reading file.");
        }
    }

    /**
     * Main method - DO NOT MODIFY
     */
    public static void main(String[] args) {

        System.out.println("=== Task 1: First Byte ===");
        int firstByte = readFirstByte();
        System.out.println("First byte: " + firstByte);
        System.out.println();

        System.out.println("=== Task 2: All Bytes ===");
        readAllBytes();
        System.out.println();

        System.out.println("=== Task 3: Hex Display ===");
        displayAsHex();
        System.out.println();

        System.out.println("=== Task 4: ASCII Attempt ===");
        attemptAsAscii();
        System.out.println();

        System.out.println("=== Task 5: File Analysis ===");
        analyzeFile();
    }
}

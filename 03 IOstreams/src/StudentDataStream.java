import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Sample student data
        int[] rollNumbers = {101, 102, 103};
        String[] names = {"Alice", "Bob", "Charlie"};
        double[] gpas = {3.75, 3.4, 3.9};

        // Write data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < rollNumbers.length; i++) {
                dos.writeInt(rollNumbers[i]);
                dos.writeUTF(names[i]);
                dos.writeDouble(gpas[i]);
            }
            System.out.println("Student data written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Read data from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading student data:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.printf("Roll: %d, Name: %s, GPA: %.2f%n", roll, name, gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

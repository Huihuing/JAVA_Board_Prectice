package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleFileReader {
    public static void main(String[] args) {
        String filename = "example.txt"; // 불러올 파일의 이름

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // 파일의 내용을 한 줄씩 읽어 출력
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        }
    }
}

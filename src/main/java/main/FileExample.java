package main;
import java.io.PrintWriter;

public class FileExample {
    public static void main(String[] args) {
        String filename = "example.txt"; // 저장할 파일의 이름
        String content = "이것은 저장될 내용입니다."; // 파일에 저장할 내용

        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.println(content);
            writer.close();
            System.out.println("파일이 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}

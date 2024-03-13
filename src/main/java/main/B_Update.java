package main;
import main.BoardApp;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class B_Update {

    private List<String> titleList;
    private List<String> ScriptList;
    private List<String> DateList;
    private List<Integer> NumList;
    private List<Integer> ReadPoint;
    private Scanner scan;

    public B_Update(List<String> titleList, List<String> ScriptList, List<String> DateList, List<Integer> NumList, List<Integer> ReadPoint, Scanner scan) {
        this.titleList = titleList;
        this.ScriptList = ScriptList;
        this.DateList = DateList;
        this.NumList = NumList;
        this.ReadPoint = ReadPoint;
        this.scan = scan;

    }

    public void update() {
        System.out.println("==================");
        for (int i = 0; i < titleList.size(); i++) {
            System.out.println(i + 1);
            String title = titleList.get(i);
            System.out.printf("제목 : %s\n", title);
            System.out.println("==================");
        }
        System.out.print("수정할 게시물 번호 : ");
        int upNum = scan.nextInt();
        if (upNum < 1 || upNum > titleList.size()) { // 올바른 게시물 번호 범위 확인
            System.out.println("없는 게시물 번호입니다.");
        } else {
            scan.nextLine(); // 버퍼 비우기
            System.out.print("새로운 제목을 입력하세요 : ");
            String newTitle = scan.nextLine();
            titleList.set(upNum - 1, newTitle); // 수정된 제목 저장

            System.out.print("새로운 내용을 입력하세요 : ");
            String newScript = scan.nextLine();
            ScriptList.set(upNum - 1, newScript); // 수정된 내용 저장

            System.out.println("게시물이 수정되었습니다.\n");
        }
    }
}

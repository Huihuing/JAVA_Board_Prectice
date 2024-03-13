package main;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class B_Detail {
    private List<String> titleList;
    private List<String> ScriptList;
    private List<String> DateList;
    private List<Integer> NumList;
    private List<Integer> ReadPoint;
    private Scanner scan;

    public B_Detail(List<String> titleList, List<String> ScriptList, List<String> DateList, List<Integer> NumList, List<Integer> ReadPoint, Scanner scan) {
        this.titleList = titleList;
        this.ScriptList = ScriptList;
        this.DateList = DateList;
        this.NumList = NumList;
        this.ReadPoint = ReadPoint;
        this.scan = scan;

    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int detNum = scan.nextInt(); // 게시물 1부터 시작 and 찾게 하는 기능?
        scan.nextLine();

        if (detNum < 1 || detNum > titleList.size()) {
            System.out.println("없는 게시물입니다.");
        } else {
            System.out.println("==================");

            int calcul = detNum - 1;

            int num = NumList.get(calcul);
            System.out.printf("번호 : %d\n", num);

            String title = titleList.get(calcul);
            System.out.printf("제목 : %s\n", title);

            String Script = ScriptList.get(calcul);
            System.out.printf("내용 : %s\n", Script);

            String time = DateList.get(calcul);
            System.out.printf("등록 날짜 : %s\n", time);

            int read = ReadPoint.get(calcul);
            System.out.printf("조회수 : %d\n", read);

            ReadPoint.set(calcul, read + 1);

            System.out.println("==================");
        }
    }
}

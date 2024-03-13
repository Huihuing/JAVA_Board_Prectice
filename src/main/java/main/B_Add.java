package main;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class B_Add {
    private List<String> titleList;
    private List<String> ScriptList;
    private List<String> DateList;
    private List<Integer> NumList;
    private List<Integer> ReadPoint;
    private Scanner scan;
    SimpleDateFormat kortime = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    public B_Add(List<String> titleList, List<String> ScriptList, List<String> DateList, List<Integer> NumList, List<Integer> ReadPoint, Scanner scan) {
        this.titleList = titleList;
        this.ScriptList = ScriptList;
        this.DateList = DateList;
        this.NumList = NumList;
        this.ReadPoint = ReadPoint;
        this.scan = scan;

    }

    public void add() {
        while (true) {
            System.out.print("게시물 제목을 입력해주세요 : ");
            String title = scan.nextLine();
            titleList.add(title); // titleList 배열에 title을 추가

            System.out.print("게시물 내용을 입력해주세요 : ");
            String Script = scan.nextLine();
            ScriptList.add(Script); // ScriptList 배열에 Script을 추가

            Date now = new java.util.Date();
            String formattedDate = kortime.format(now);
            DateList.add(formattedDate);

            int num = NumList.size() + 1;
            NumList.add(num);

            ReadPoint.add(1);

            System.out.println("게시물이 등록되었습니다.\n");

            System.out.print("다시 등록 하시겠습니까? : ");

            String yn = scan.nextLine();

            if (yn.equalsIgnoreCase("no")) {
                break;
            }
        }
    }
}

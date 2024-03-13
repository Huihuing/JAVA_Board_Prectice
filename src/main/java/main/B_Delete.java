package main;
import main.BoardApp;
import java.util.List;
import java.util.Scanner;

public class B_Delete {
    private List<String> titleList;
    private List<String> ScriptList;
    private List<String> DateList;
    private List<Integer> NumList;
    private List<Integer> ReadPoint;
    private Scanner scan;

    public B_Delete(List<String> titleList, List<String> ScriptList, List<String> DateList, List<Integer> NumList, List<Integer> ReadPoint, Scanner scan) {
        this.titleList = titleList;
        this.ScriptList = ScriptList;
        this.DateList = DateList;
        this.NumList = NumList;
        this.ReadPoint = ReadPoint;
        this.scan = scan;
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int deNum = scan.nextInt();
        if (deNum < 1 || deNum > titleList.size()) {
            System.out.println("없는 게시물입니다.");
        } else {
            scan.nextLine();
            titleList.remove(deNum - 1);
            System.out.printf("%d", deNum);
            System.out.print(" 번 게시물이 삭제되었습니다.\n");
        }
    }
}


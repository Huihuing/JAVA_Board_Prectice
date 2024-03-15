package main;
import java.util.List;
import java.util.Scanner;

public class B_Detail {
    private List<String> titleList;
    private List<String> ScriptList;
    private List<String> DateList;
    private List<List<String>> CommList; // List 안에 List를 넣기 위해 List<List<String>> 이런 표현을 사용
    private List<Integer> NumList;
    private List<Integer> ReadPoint;
    private Scanner scan;

    private int calcul;

    public B_Detail(List<String> titleList, List<String> ScriptList, List<String> DateList, List<List<String>> CommList, List<Integer> NumList, List<Integer> ReadPoint, Scanner scan, int calcul) {
        this.titleList = titleList;
        this.ScriptList = ScriptList;
        this.DateList = DateList;
        this.CommList = CommList;
        this.NumList = NumList;
        this.ReadPoint = ReadPoint;
        this.scan = scan;
        this.calcul = calcul;

    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int detNum = scan.nextInt(); // 게시물 1부터 시작 and 찾게 하는 기능?
        scan.nextLine();
        calcul = detNum - 1; // 내가 편할걸 X, 통용될 수 있는 보편적인 뜻

        if (detNum < 1 || detNum > titleList.size()) {
            System.out.println("없는 게시물입니다.");
        } else {
            System.out.println("==================");

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

            System.out.println("------------------------------------");

            if (CommList.size() > calcul) {
                List<String> comments = CommList.get(calcul);
                System.out.println("===============");
                for (String comment : comments) {
                    for (int i = CommList.size(); i<comments.size(); i++) {
                        System.out.printf("댓글내용: %s\n", comment);
                        String timec = DateList.get(calcul);
                        System.out.printf("댓글작성일 : %s\n", timec);
                    }
                }
            }
            else {
                System.out.println("댓글이 없습니다.");
            }


            ReadPoint.set(calcul, read + 1);


            System.out.println("==================");
        }



    }
}

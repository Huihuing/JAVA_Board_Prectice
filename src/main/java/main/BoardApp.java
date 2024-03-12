package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class BoardApp {
    public void run() {
        Frame f = new Frame();
        f.setTitle("첫 번째 프레임 입니다.");
        f.setBounds(100, 100, 300, 300);
        f.setVisible(true);

        Scanner scan = new Scanner(System.in);
        SimpleDateFormat kortime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int bun = 0;
        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArrayList를 사용한다.
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> ScriptList = new ArrayList<>();
        ArrayList<String> DateList = new ArrayList<>();
        ArrayList<Integer> NumList = new ArrayList<>();

        titleList.add("안녕하세요 반갑습니다. 자바 공부중이에요.");
        titleList.add("자바 질문좀 할게요~");
        titleList.add("정처기 따야되나요?");
        ScriptList.add("자바 공부중이에요.");
        ScriptList.add("질문좀 할게요~");
        ScriptList.add("공부중이에요.");
        DateList.add("2024-01-01 12:12:12");
        DateList.add("2024-01-02 12:12:12");
        DateList.add("2024-01-03 12:12:12");
        NumList.add(1);
        NumList.add(2);
        NumList.add(3);

/*      String title = ""; // 딱히 처음에 값이 필요 없음. 추후에 입력을 통해 넣을 것임.
        String Script = "";*/


        System.out.println("-------------");
        // 반복 횟수 정할 수 없음 => 무한 반복 구조

        while (true) { // 반복 조건이 true이기 때문에 무한 반복
            System.out.print("명령어 : ");
            String exit = scan.nextLine();

            if (exit.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 표현 사용하지 않는다. .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (exit.equals("add")) {

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

                    System.out.println("게시물이 등록되었습니다.\n");


                    System.out.print("다시 등록 하시겠습니까? : ");

                    String yn = scan.nextLine();

                    if (yn.equalsIgnoreCase("no")) {
                        break;
                    }
                }
/*
                else {
                    while(true) {
                        System.out.println("다시 입력해주세요");
                        return;
                    }
                }
*/

            } else if (exit.equals("list")) {
                System.out.println("==================");
                    for (int i = 0; i < titleList.size(); i++) {

                        int num = NumList.get(i);
                        System.out.printf("번호 : %d\n", num);

                        String title = titleList.get(i);
                        System.out.printf("제목 : %s\n", title);

                        String Script = ScriptList.get(i);
//                      System.out.printf("내용 : %s\n", Script);

                        String time = DateList.get(i);
                    System.out.println("==================");
                }


            } else if (exit.equals("update")) {
                System.out.println("==================");
                for (int i = 0; i < titleList.size(); i++) {
                    System.out.println(i + 1);
                    String title = titleList.get(i);
                    System.out.printf("제목 : %s\n", title);
                    System.out.println("==================\n");
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

            } else if (exit.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int deNum = scan.nextInt();
                if (deNum < 1 || deNum > titleList.size()) {
                    System.out.println("없는 게시물입니다.");
                } else {
                    scan.nextLine();
                    titleList.remove(deNum - 1);
                    System.out.printf("%d", deNum);
                    System.out.printf(" 번 게시물이 삭제되었습니다.\n");
                }
            } else if (exit.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int detNum = scan.nextInt();
                if (detNum < 1 || detNum > titleList.size()) {
                    System.out.println("없는 게시물입니다.");
                } else {
                    scan.nextLine();
                    System.out.println("==================");
                    {
                        System.out.printf("번호 : %d\n", detNum);

                        String title = titleList.get(detNum - 1);
                        System.out.printf("제목 : %s\n", title);

                        String Script = ScriptList.get(detNum - 1);
                        System.out.printf("내용 : %s\n", Script);

                        String time = DateList.get(detNum - 1);
                        System.out.printf("등록 날짜 : %s\n", time);

                    }
                    System.out.println("==================");
                }

            }
            else if (exit.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String find = scan.next();

                if(find.contains("")) {
                    scan.nextLine();
                    String title = titleList.get(1);
                    System.out.printf("제목 : %s\n", title);
                }
                else {
                    System.out.println("검색결과가 없습니다.");
                }
            }
            else if (exit.equals("signup")) {

            }
            else if (exit.equals("login")) {

            }
            else {
                System.out.println("none");
            }
        }
        System.out.println("-------------");


        // 1. 반복문 제어 하던 방법 : 반복 횟수 세서 특정 횟수 지나면 탈출
        // 2. break문을 사용하여 강제 탈출 가능

/*        for(int i =1; i<=10; i++) {
            System.out.println(i);
            if(i == 5){
                break;
            }
        }*/
    }
}


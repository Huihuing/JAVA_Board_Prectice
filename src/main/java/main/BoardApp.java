package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.List;

public class BoardApp {
    public void run() {

        List<String> titleList = new ArrayList<>();
        List<String> ScriptList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat kortime = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

        B_Update updatedata = new B_Update(titleList, ScriptList, scan);
        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArrayList를 사용한다.
        /*ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> ScriptList = new ArrayList<>();*/
        ArrayList<String> DateList = new ArrayList<>();
        ArrayList<Integer> NumList = new ArrayList<>();
        ArrayList<Integer> ReadPoint = new ArrayList<>();

        titleList.add("안녕하세요 반갑습니다. 자바 공부중이에요.");
        titleList.add("자바 질문좀 할게요~");
        titleList.add("정처기 따야되나요?");
        ScriptList.add("자바 공부중이에요.");
        ScriptList.add("질문좀 할게요~");
        ScriptList.add("공부중이에요.");

        DateList.add("2024.01.01 12:12:12");
        DateList.add("2024.01.02 12:12:12");
        DateList.add("2024.01.03 12:12:12");


/*      String title = ""; // 딱히 처음에 값이 필요 없음. 추후에 입력을 통해 넣을 것임.
        String Script = "";*/
        for (int i = 1; i < titleList.size()+1; i++) { // intater로 해주면 for문으로 더 효율적으로 하자
            NumList.add(i);
            ReadPoint.add(1);
        }

        /*ReadPoint.add(0);
        ReadPoint.add(0);*/
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

                    ReadPoint.add(1);

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

/*                        String Script = ScriptList.get(i);
//                      System.out.printf("내용 : %s\n", Script);

                        String time = DateList.get(i);*/
                    System.out.println("==================");
                }


            } else if (exit.equals("update")) {
                updatedata.update();

            } else if (exit.equals("delete")) {
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
            else if (exit.equals("detail")) {
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

                        /*String manum = "";
                        int manu = 0;
                        String demanu= "";*/

                        System.out.print("상세보기 기능을 선택해주세요(1.댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : " );
                        String input = scan.nextLine();
                        /*manum = scan.nextLine();
                        scan.nextLine();*/

                    if(input.isEmpty()) {
                        System.out.println("[잘못된 입력입니다.]");
                    }
                    else {
                        int manu = Integer.parseInt(input);
                        switch (manu)
                        {
                            case 1:
                                System.out.print("\n[댓글 기능] : ");
                                String comment = scan.nextLine();
                                System.out.println("댓글이 성공적으로 등록되었습니다.\n");
                                break;
                            case 2:
                                System.out.println("\n[추천 기능]");
                                break;
                            case 3:
                                System.out.println("\n[수정 기능]");
                                updatedata.update();
                                break;
                            case 4:
                                System.out.println("\n[삭제 기능]");
                                break;
                            case 5:
                                System.out.println("\n[목록으로]");
                                break;
                            default:
                                System.out.println("[잘못된 입력입니다.]");
                                break;
                        }
                    }


                }
            }
            else if (exit.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String find = scan.next();
                boolean found = false;
                scan.nextLine();
                for (int i = 0; i < titleList.size(); i++) {
                    String title = titleList.get(i);
//                    System.out.printf("제목 : %s\n", title); 여기다 쓰면 타이틀에 있는 내용들 다 나옴
                    if (title.contains(find)) {
                        System.out.printf("검색결과 - 제목 : %s\n", title);
                        found = true;

                    }
                    if(!found) {
                        System.out.println("검색 결과가 없습니다.");
                    }

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


package main;

import java.text.SimpleDateFormat;
import java.util.*;

public class BoardApp {
    int calcul = 10; // ??

    public void run() {
        int Wrong_Value = -100;
        List<String> titleList = new ArrayList<>();
        List<String> ScriptList = new ArrayList<>();
        List<String> DateList = new ArrayList<>();
        List<String> IDList = new ArrayList<>();
        List<List<String>> CommList = new ArrayList<>();
        List<Integer> NumList = new ArrayList<>();
        List<Integer> ReadPoint = new ArrayList<>();

        
        Scanner scan = new Scanner(System.in);

        B_Update updatedata = new B_Update(titleList, ScriptList, DateList, NumList, ReadPoint, scan);
        B_Delete deletedata = new B_Delete(titleList, ScriptList, DateList, NumList, ReadPoint, scan);
        B_Detail detaildata = new B_Detail(titleList, ScriptList, DateList, CommList, NumList, ReadPoint, scan, calcul);
        B_Add adddata = new B_Add(titleList, ScriptList, DateList, NumList, ReadPoint, scan);


        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArrayList를 사용한다.
        /*ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> ScriptList = new ArrayList<>();
        ArrayList<String> DateList = new ArrayList<>();
        ArrayList<Integer> NumList = new ArrayList<>();
        ArrayList<Integer> ReadPoint = new ArrayList<>();*/

        titleList.add("안녕하세요 반갑습니다. 자바 공부중이에요.");
        titleList.add("자바 질문좀 할게요~");
        titleList.add("정처기 따야되나요?");
        ScriptList.add("자바 공부중이에요.");
        ScriptList.add("질문좀 할게요~");
        ScriptList.add("공부중이에요.");

        DateList.add("2024.01.01 12:12:12");
        DateList.add("2024.01.02 12:12:12");
        DateList.add("2024.01.03 12:12:12");

        CommList.add(Collections.singletonList("1"));
        CommList.add(Collections.singletonList("1"));
        CommList.add(Collections.singletonList("1"));
        for (int i = 1; i < titleList.size() + 1; i++) { // intater로 해주면 for문으로 더 효율적으로 하자
            NumList.add(i);
            ReadPoint.add(1);
        }

        System.out.println("-------------");
        // 반복 횟수 정할 수 없음 => 무한 반복 구조

        while (true) { // 반복 조건이 true이기 때문에 무한 반복
            System.out.print("명령어 : ");
            String exit = scan.nextLine();

            if (exit.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 표현 사용하지 않는다. .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else if (exit.equals("add")) {
                adddata.add();
            }
            else if (exit.equals("list")) {
                System.out.println("==================");
                for (int i = 0; i < titleList.size(); i++) {

                    int num = NumList.get(i);
                    System.out.printf("번호 : %d\n", num);

                    String title = titleList.get(i);
                    System.out.printf("제목 : %s\n", title);

                    System.out.println("==================");
                }


            } else if (exit.equals("update")) {
                updatedata.update();
            } else if (exit.equals("delete")) {
                deletedata.delete();
            } else if (exit.equals("detail")) {
                detaildata.detail();

                System.out.print("상세보기 기능을 선택해주세요(1.댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                String input = scan.nextLine();
                if (input.isEmpty()) {
                    System.out.println("[잘못된 입력입니다.]");
                } else {
                    int manu = Integer.parseInt(input);
                    switch (manu) {
                        case 1:
                            System.out.print("\n[댓글 작성중] : ");
                            String comment = scan.nextLine();
                            CommList.add(Collections.singletonList(comment));
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
                            deletedata.delete();
                            break;
                        case 5:
                            System.out.println("\n[목록으로]");
                            break;
                        default:
                            System.out.println("[잘못된 입력입니다.]");
                            break;
                    }
                }


            } else if (exit.equals("search")) {
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
                    if (!found) {
                        System.out.println("검색 결과가 없습니다.");
                    }

                }

            } else if (exit.equals("signup")) {
                System.out.print("아이디를 입력해주세요 : ");
                String ID = IDList.get(0);
            } else if (exit.equals("login")) {

            } else {
                System.out.println("none");
            }
        }

        System.out.println("-------------");
    }
}
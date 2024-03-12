package syrup;
import java.util.Scanner;
import java.util.ArrayList;

public class syrr {
    public void run() {
        Scanner scan = new Scanner(System.in);

        // 반복 횟수 정할 수 없음 => 무한 반복 구조

        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArrayList를 사용한다.
        ArrayList<Article> articleList = new ArrayList<>();
        int latestArticleId = 1; // 시작 번호를 1로 지정


        while (true) { // 반복 조건이 true이기 때문에 무한 반복
            System.out.print("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 아닌 .equals()를 사용해야 한다.
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출

            } else if (cmd.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();

                System.out.print("게시물 내용을 입력해주세요 : ");
                String body = scan.nextLine();



                // 기본 생성자 이용
//                Article article = new Article();
//                article.setId(latestArticleId);
//                article.setTitle(title);
//                article.setBody(body);

                // 모든 매개변수를 받는 생성자 이용
                Article article = new Article(latestArticleId, title, body);

                articleList.add(article);

                System.out.println("게시물이 등록되었습니다.");

                latestArticleId++; // 게시물이 생성될 때마다 번호를 증가

            } else if (cmd.equals("list")) {
                System.out.println("===================");
                for (int i = 0; i < articleList.size(); i++) {
                    Article article = articleList.get(i);

                    System.out.println("번호 : " + article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());

                    System.out.println("===================");
                }
            } else if (cmd.equals("update")) {
                System.out.print("수정할 게시물 번호를 입력해주세요 : ");
                int id = Integer.parseInt(scan.nextLine()); // 1 -> index : 0
                // 2 -> index : 1

                System.out.print("새로운 제목을 입력해주세요 : ");
                String newTitle = scan.nextLine();

                System.out.print("새로운 내용을 입력해주세요 : ");
                String newBody = scan.nextLine();

                // 인덱스로 찾아서 수정
                /*titleList.set(id - 1, newTitle);
                bodyList.set(id - 1, newBody);*/

                System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
            } else if (cmd.equals("delete")) {
                System.out.print("삭제할 게시물 번호를 입력해주세요 : ");
                int inputId = Integer.parseInt(scan.nextLine()); // 1 -> index : 0

                for (int i = 0; i < articleList.size(); i++) {
                    Article target = articleList.get(i);

                    if (target.getId() == inputId) { // 삭제하고자 하는 id와 i번째 id가 같다면
                        articleList.remove(i); // 삭제해라
                    }

                    System.out.printf("%d 게시물이 삭제되었습니다.\n", inputId);

                }

                // 1. 반복문 제어 하던 방법 : 반복 횟수 세서 특정 횟수 지나면 탈출
                // 2. break문을 사용하여 강제 탈출 가능

//        for(int i = 1; i <= 10; i++) {
//            if(i == 5) {
//                break; // i가 5일 때 반복문 탈출
//            }
//            System.out.println(i);
//        }
            }
        }
    }
}
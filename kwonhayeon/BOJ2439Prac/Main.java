package java_basic1.BOJ2439Prac; //현재 클래스가 속한 패키지
import java.util.Scanner; //사용자의 입력을 받기 위해 Scanner 클래스 임포트

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Scanner 객체 생성하여 사용자 입력 받기

        System.out.print("출력할 줄 수를 입력하세요 : ");
        // 사용자에게 입력 안내 메시지 출력 (작성하지 않아도 됨)
        int n = sc.nextInt(); //사용자로부터 몇 줄 출력할지에 대한 정수 출력 받기

        //1부터 n까지 반복하면서 각 줄 출력하기
        for (int i = 0; i <= n; i++) {
            //공백 출력
            // n-i만큼 공백을 출력하여 오른쪽 정렬
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            // 별 출력 : i 개 만큼 별 출력
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            // 한 줄 출력이 끝나면 줄 바꿈
            System.out.println();
        }

        // Scanner 객체 닫기 -> 자원 낭비 방지
        sc.close();
    }
}

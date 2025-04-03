package java_basic1.ProgrammersListPrac;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    // 문제 조건에 따라 num_list를 잘라서 새로운 배열을 반환하는 함수
    // n 슬라이싱 방식 선택 (1~4)
    // slicer [a, b, c] 슬라이싱 정보
    // num_list 자를 대상 배열
    // 잘라낸 결과 배열

    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        int[] result;

        // n 값에 따라 자르는 방식이 달라짐
        switch (n) {
            case 1: // 0번 인덱스부터 b번 인덱스까지 자름
                result = Arrays.copyOfRange(num_list, 0, b + 1);
                break;
            case 2: // a번 인덱스부터 끝까지 자름
                result = Arrays.copyOfRange(num_list, a, num_list.length);
                break;
            case 3: // a번 인텍스부터 끝까지 자름
                result = Arrays.copyOfRange(num_list, a, b + 1);
                break;
            case 4: // a번 인덱스부터 b번 인덱스까지 c간격으로 자름
                int size = (b - a) / c + 1; // 결과 배열의 크기 계산
                result = new int[size]; // 결과 배열 생성
                int idx = 0;
                for (int i = a; i <= b; i += c) {
                    result[idx++] = num_list[i]; // 간격대로 선택된 값을 저장
                }
                break;
            default: // 예외 방지 (n이 1~4가 아닐 경우를 뜻함)
                result = new int[0]; // 예외 방지
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자에게 입력 받기 위한 Scanner 생성
        Solution sol = new Solution(); // Solution 클래스의 객체 생성

        // (1) n 입력
        System.out.print("n을 입력하세요 (1~4): ");
        int n = sc.nextInt();
        if (n < 1 || n > 4) {
            System.out.println("오류: n은 1, 2, 3, 4 중 하나여야 합니다.");
            return;
        }

        // (2) slicer 배열 입력 받기 (a, b, c)
        int[] slicer = new int[3];
        System.out.print("slicer의 a, b, c 값을 입력하세요 (예: 1 5 2): ");
        for (int i = 0; i < 3; i++) {
            slicer[i] = sc.nextInt(); // 한 줄에 입력 받은 3개의 숫자를 차례대로 저장하기
        }

        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

// (3) num_list 입력 - 한 줄 문자열로 받아서 공백 기준 split
        System.out.print("num_list 값을 공백으로 구분하여 입력하세요 (예: 1 2 3 4 5 6 7 8 9): ");
        sc.nextLine(); // 이전 nextInt() 입력 받은 후 남은 엔터를 제거하기 위한 처리
        String inputLine = sc.nextLine(); // 사용자로부터 한 줄 전체를 문자열로 입력 받음
        String[] parts = inputLine.trim().split("\\s+"); // 공백 기준으로 잘라 문자열 배열로 저장함

        // num_list 길이 유효성 검사 : 최소 5개 이상, 최대 30개 이하
        // 조건을 충족하지 않을 경우 출력
        if (parts.length < 5 || parts.length > 30) {
            System.out.println("오류: num_list의 길이는 5 이상 30 이하이어야 합니다.");
            return;
        }

        // 문자열 배열을 정수 배열로 변환하고, 각 요소의 값도 함께 검증하기
        int[] num_list = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            int val = Integer.parseInt(parts[i]); // 문자열을 정수로 변환함
            if (val < 0 || val > 100) { // 각 값이 0~100 범위 내인지 확인함
                System.out.println("오류: num_list의 원소는 0 이상 100 이하이어야 합니다.");
                return;
            }
            num_list[i] = val; // 유효한 값을 배열에 저장함
        }



        // (4) 슬라이싱 조건 유효성 검사
        // a ≤ b ≤ num_list.length - 1 조건을 확인
        if (!(0 <= a && a <= b && b <= num_list.length - 1)) {
            System.out.println("오류: 0 ≤ a ≤ b ≤ num_list.length - 1을 만족해야 합니다.");
            return;
        }

        // c 값은 1 이상 3 이하이어야 함
        if (!(1 <= c && c <= 3)) {
            System.out.println("오류: c는 1 이상 3 이하이어야 합니다.");
            return;
        }

        // (5) 조건에 맞는 결과를 계산
        int[] result = sol.solution(n, slicer, num_list);

        // (6) 결과 메시지 출력을 구성함
        StringBuilder message = new StringBuilder();
        message.append(Arrays.toString(num_list)).append("에서 "); // 원본 배열 출력

        // 슬라이싱 방식 (n)에 다라 설명 문장을 다르게 구성
        if (n == 1) {
            // 0번 인덱스부터 b번 인덱스까지
            message.append("0번 인덱스부터 ").append(b).append("번 인덱스까지");
        } else if (n == 2) {
            // a번 인덱스부터 마지막 인덱스까지
            message.append(a).append("번 인덱스부터 마지막 인덱스까지");
        } else if (n == 3) {
            // a번 인덱스부터 b번 인덱스까지
            message.append(a).append("번 인덱스부터 ").append(b).append("번 인덱스까지");
        } else {
            // a번 인덱스부터 b번 인덱스까지 c개 간격으로
            message.append(a).append("번 인덱스부터 ").append(b).append("번 인덱스까지 ")
                    .append(c).append("개 간격으로");
        }

        // 결과 배열 출력
        message.append(" 자른 리스트는 ").append(Arrays.toString(result)).append("입니다.");
        System.out.println(message); // 최종 메시지 출력
    }
}

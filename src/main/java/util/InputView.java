package util;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);
    public static String getUserName() {
        System.out.println("플레이어 이름을 입력해주세요 : ");
        return sc.next();
    }

    public static String getDrawCard() {
        System.out.println("카드를 한장 더 뽑으시겠습니까? (YES : 1, NO : 2)");
        return sc.next();
    }
}

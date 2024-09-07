package chapter02;

import java.rmi.RMISecurityException;

enum AccountLevel {
    A, B, C
}

public class AccountInfo {

    private final long milieage;
    private long id;

    public AccountInfo(long id, long milieage) {
        this.id = id;
        this.milieage = milieage;
    }

    public AccountLevel getLevel() {
        if (milieage > 1) return AccountLevel.A;
        else if (milieage > 2) return AccountLevel.B;
        else return AccountLevel.C;
    }

    public AccountInfo withMiliege(long milieage) { // 세터가 사라진 대신 변경 요청이 들어올때 새로운 객체를 반환하는 메서드 추가
        return new AccountInfo(this.id, milieage);
    }

}

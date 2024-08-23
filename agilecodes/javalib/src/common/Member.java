package common;

import java.time.LocalDateTime;

public class Member {
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    final private Long id;
    final private String email;
    final private String nickname;
    final private LocalDateTime birthday;
    final private LocalDateTime createdAt;


    public Member(String email, String nickname, LocalDateTime birthday, LocalDateTime createdAt) {
        this.id = null;
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
        this.createdAt = createdAt;
    }

    public Member(Long id, String email, String nickname, LocalDateTime birthday, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}

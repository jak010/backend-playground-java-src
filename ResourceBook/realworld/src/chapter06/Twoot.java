package chapter06;


import javax.swing.text.Position;
import java.util.Objects;

// Value object
public class Twoot {


    private final String id;
    private final String senderId;
    private final String content;
    private final Position posiion;


    public Twoot(String id, String senderId, String content, Position posiion) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(senderId, "senderId");
        Objects.requireNonNull(content, "content");
        Objects.requireNonNull(posiion, "posiion");

        this.id = id;
        this.senderId = senderId;
        this.content = content;
        this.posiion = posiion;
    }

    public String getId() {
        return id;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getContent() {
        return content;
    }

    public Position getPosiion() {
        return posiion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Twoot twoot = (Twoot) o;
        return id.equals(twoot.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Twoot{" +
                "id='" + id + '\'' +
                ", senderId='" + senderId + '\'' +
                ", content='" + content + '\'' +
                ", posiion=" + posiion +
                '}';
    }
}


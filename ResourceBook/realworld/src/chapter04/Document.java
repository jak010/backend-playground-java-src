package chapter04;

import java.util.Map;

public class Document {

    private final Map<String, String> attributes;

    Document(final Map<String, String> attributes) { // 제한된 생성자를 갖는 Class
        this.attributes = attributes;
    }

    public String getAttributes(final String attributeName) {
        return attributes.get(attributeName);
    }


}

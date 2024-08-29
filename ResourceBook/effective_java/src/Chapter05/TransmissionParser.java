package Chapter05;

public class TransmissionParser {

    static Transmission parse(String rawMessage) {
        if (rawMessage != null && rawMessage.length() != Transmission.MESSAGE_LENGTH) {
            throw new IllegalArgumentException("Bad Message received");
        }

        String rawId = rawMessage.substring(0, Transmission.ID_LENGTH);
        String rawContent = rawMessage.substring(0, Transmission.ID_LENGTH);

        try {
            int id = Integer.parseInt(rawId);
            String content = rawContent.trim();
            return new Transmission(id, content);
        } catch (Exception e) {
            throw new IllegalArgumentException("Bad Message Receveid")
        }

    }
}

package main.java.w5_class_prob;

class AccessCheckerP1 {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("default")) {
            return accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            return accessorContext.equals("DIFFERENT_PACKAGE")
                    ? "DENIED" : "ALLOWED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (int i = 0; i < attempts.length; i++) {

            String result = classifyAccess(
                    attempts[i][0],
                    attempts[i][1]);

            if (result.equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}

class MovieTicket {

    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}

public class Week5_p1 {

    public static void main(String[] args) {

        System.out.println(
                AccessCheckerP1.classifyAccess(
                        "private", "SAME_CLASS"));

        System.out.println(
                AccessCheckerP1.classifyAccess(
                        "protected", "DIFFERENT_PACKAGE"));

        String[][] attempts = {
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
                AccessCheckerP1.summarizeBatch(attempts));
    }
}
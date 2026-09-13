package main.java.oop.w5_assign_prob;
class AccessChecker {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {
        if (fieldModifier.equals("private"))
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("default"))
            return accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("protected"))
            return accessorContext.equals("DIFFERENT_PACKAGE")
                    ? "DENIED" : "ALLOWED";

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < modifiers.length; i++) {
            int allowed = 0, denied = 0;

            for (int j = 0; j < attempts.length; j++) {
                if (attempts[j][0].equals(modifiers[i])) {
                    if (classifyAccess(attempts[j][0], attempts[j][1])
                            .equals("ALLOWED"))
                        allowed++;
                    else
                        denied++;
                }
            }

            if (i > 0) result.append(" | ");

            result.append(modifiers[i]).append(": ")
                  .append(allowed).append(" allowed / ")
                  .append(denied).append(" denied");
        }

        return result.toString();
    }
}

public class Week5_M1 {
    public static void main(String[] args) {
        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            AccessChecker.classifyAccess("private", "SAME_CLASS"));

        System.out.println(
            AccessChecker.classifyAccess("protected", "DIFFERENT_PACKAGE"));

        System.out.println(
            AccessChecker.summarizeByModifier(attempts));
    }
}
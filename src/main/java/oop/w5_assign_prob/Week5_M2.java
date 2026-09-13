package main.java.oop.w5_assign_prob;

class AccessCheckerM2 {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        if (fieldModifier.equals("private")
                || fieldModifier.equals("default"))
            return "DENIED";

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    || accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";

            return "DENIED";
        }

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            if (classifyAccess(modifier, context)
                    .equals("DENIED")) {

                return modifier + " via " + context
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }
}

public class Week5_M2 {

    public static void main(String[] args) {

        String[][] attempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            AccessCheckerM2.firstDeniedAttempt(attempts));
    }
}
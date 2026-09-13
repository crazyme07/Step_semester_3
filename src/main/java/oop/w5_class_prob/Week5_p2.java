package main.java.w5_class_prob;

class AccessCheckerP2 {

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
}

public class Week5_p2 {

    public static void main(String[] args) {

        System.out.println(
                AccessCheckerP2.classifyAccess(
                        "protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println(
                AccessCheckerP2.classifyAccess(
                        "protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
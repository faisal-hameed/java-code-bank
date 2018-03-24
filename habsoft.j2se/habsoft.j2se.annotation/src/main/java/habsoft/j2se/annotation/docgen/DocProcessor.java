package habsoft.j2se.annotation.docgen;

import java.lang.reflect.Method;

public class DocProcessor {
    /**
     * Analyzes the given class's Doc annotation, displaying output for the
     * class and for each of its non-private methods.
     * 
     * @param clazz
     *            Class to analyze
     * @return True if Doc annotation is used sufficiently on the class and its
     *         methods, false otherwise
     */
    public static boolean process(Class<?> clazz) {

        // Store simple name of the class for quicker access
        String className = clazz.getSimpleName();

        // Display class name
        System.out.printf("Analyzing '%s'...", className);

        // Track the number of class errors
        int classErrors = 0;

        // TODO: Does @Doc annotation appear on class?
        if (true) {

            // TODO: Loop over declared methods of class
            for (Method method : new Method[] {}) {

                // TODO: Get method modifiers (returned as int that needs to be
                // deciphered)
                String modStr = null;

                // TODO: Get method name
                String methodName = null;

                // TODO: Is method non-private?
                if (true) {
                    int methodErrors = 0;

                    // Display method name
                    System.out.printf("%n%n\t%s:", methodName);

                    // TODO: Does @Doc annotation appear on method?
                    if (true) {

                        // TODO: Get a reference to the actual annotation
                        Doc doc = null;

                        // Does the number of items in param descriptions match
                        // the number of actual parameters?
                        int numMissing = getNumMissingParams(method, doc);
                        if (numMissing > 0) {
                            methodErrors++;
                            String message = "%n\t\t=> Missing %s parameter description(s)";
                            System.out.printf(message, numMissing);
                        }

                        // Is there a return description when needed?
                        if (!hasReturnDescription(method, doc)) {
                            methodErrors++;
                            String message = "%n\t\t=> Missing description of return value";
                            System.out.printf(message);
                        }
                    } else { // non-private method is missing the Doc annotation
                        methodErrors++;
                        System.out.printf("%n\t\t=> Doc annotation missing");
                    }

                    // Check for zero errors
                    if (methodErrors == 0) {
                        System.out.printf("%n\t\t=> No changes needed");
                    }

                    // Add method errors to class errors
                    classErrors += methodErrors;
                }
            }

        } else { // class is missing the annotation
            classErrors++;
            System.out.printf("%n\t=> Class does not contain the proper documentation");
        }

        // Display final message
        String yayOrNay = classErrors == 0 ? "YAY" : "Get to documenting";
        String finalMessage = "%n%nDocProcessor has found %s error(s) in class '%s'. %s!%n";
        System.out.printf(finalMessage, classErrors, className, yayOrNay);

        // Return success or failure
        return classErrors == 0;
    }

    /**
     * Checks whether or not the number of descriptions provided in the Doc
     * annotation match the number of parameters in the given method.
     * 
     * @param method
     *            Method under consideration
     * @param doc
     *            Annotation to check
     * @return Number of descriptions missing. Note: This could be negative if
     *         too many descriptions are provided)
     */
    private static int getNumMissingParams(Method method, Doc doc) {
        int numMissing = 0;

        // TODO: Check if the number of parameter descriptions in the annotation
        // TODO: is less than the method's parameter count
        if (true) {
            // TODO: Calculate the number of missing parameter descriptions
            numMissing = 0;
        }
        return numMissing;
    }

    /**
     * Determines whether or not a method's return value description is missing
     * 
     * @param method
     *            Method under consideration
     * @param doc
     *            Annotation to check
     * @return True if method has a void return type or the annotation has a
     *         non-empty return description
     */
    private static boolean hasReturnDescription(Method method, Doc doc) {
        // TODO: Return true when the method return type is void OR
        // TODO: the annotation return value description is not empty
        return true;
    }
}
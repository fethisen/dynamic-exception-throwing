package utils;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;

public class ExampleUtil {

    /**
     * <p> *     Check the value to be null and if null throws a Exception with the message given
     *     Used to reduce checking if conditions for complexity.
     * </p> * @param object                Object to be checked
     * @param exceptionClassName    Exception class to be thrown
     * @param exceptionMessage      Message to be called for throwing exception
     * @param logMessage            Log message
     * @param loggerType            Log type
     * @throws Throwable
     */
    public static void requireNonNull(Object object, Class<?> exceptionClassName ,String exceptionMessage, String logMessage, Consumer<String> loggerType) throws Throwable {
        if (object == null){
            loggerType.accept(logMessage);
            try{
                throwException(exceptionClassName,exceptionMessage);
            }catch (NoSuchMethodException ex){
                throw new NoSuchMethodException("Unable to access the class's constructor methods!");
            }
        }
    }
    private static void throwException(Class<?> className,String exceptionMessage) throws Throwable {
        Class<?> exceptionClass;
        Class[] t = {String.class};
        try {
            exceptionClass = Class.forName(className.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        Constructor cons = exceptionClass.getConstructor(t);
        Object[] objct = {exceptionMessage};
        throw (Throwable) cons.newInstance(objct);
    }


}

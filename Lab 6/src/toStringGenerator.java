import java.lang.reflect.Method;

public class toStringGenerator {
    public static String generate(Object object) {
        String result = "";
        Class<?> cls = object.getClass();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            String mtd = method.getName();
            if (mtd.contains("get")) {
                try {
                    result = result.concat(String.valueOf(method.invoke(object)));
                    result = result.concat("\t");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}

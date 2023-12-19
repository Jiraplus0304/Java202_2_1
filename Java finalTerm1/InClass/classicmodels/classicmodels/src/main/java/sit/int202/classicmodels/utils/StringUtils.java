package sit.int202.classicmodels.utils;

public class StringUtils {
    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}

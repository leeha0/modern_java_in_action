package chapter3;

import java.util.function.Function;

public class Ex16_Letter {

    public static String addHeader(String text) {
        return "From Raoul, Mario And Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Ex16_Letter::addHeader;
        Function<String, String> transformationPipeline =
            addHeader
                .andThen(Ex16_Letter::checkSpelling)
                .andThen(Ex16_Letter::addFooter);

        String result = transformationPipeline.apply("labda !");
        System.out.println(result); // From Raoul, Mario And Alan: lambda ! Kind regards
    }
}

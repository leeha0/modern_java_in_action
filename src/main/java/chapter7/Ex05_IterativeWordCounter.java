package chapter7;

public class Ex05_IterativeWordCounter {

    private static final String SENTENCE =
        "Nel   mezzo del cammi di nostra vita "
            + "mi ritrovai in una  selva oscura "
            + "ch la dritta via era smarrita ";

    public static void main(String[] args) {
        int wordCount = countWordsIteratively(SENTENCE);
        System.out.println("Found " + wordCount + " words");
        // Found 19 words
    }

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        // 모든 문자열 탐색
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                // 공백 문자를 만나면 단어의 종료로 간주하여 단어 수 증가
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

}

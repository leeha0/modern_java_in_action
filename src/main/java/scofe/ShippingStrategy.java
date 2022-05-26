package scofe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShippingStrategy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] path = br.readLine().substring(0, n).split("");

        int counter = startShipping(0, 0, path);
        System.out.println(counter);
    }

    public static int startShipping(int counter, int cursor, String[] path) {
        if (cursor == path.length - 1) {
            return counter + 1;
        } else if (cursor > path.length - 1) {
            return 0;
        } else if (path[cursor].equals("0")) {
            return 0;
        } else {
            return startShipping(counter, cursor + 1, path) + startShipping(counter, cursor + 2, path);
        }
    }
}

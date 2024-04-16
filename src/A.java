import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            final int emptyPlaceQuant = Integer.parseInt(reader.readLine());

            ArrayList<String> inputLine = new ArrayList<>(List.of(reader.readLine().split(" ")));
            int leftEmpty = -1;
            int rightEmpty = -1;

            for (int i = 0; i < emptyPlaceQuant; i++) {
                if (inputLine.get(i).equals("0")) {
                    System.out.print("0 ");
                    rightEmpty = i;
                } else {
                    if (!inputLine.get(i).equals("0") && rightEmpty < leftEmpty && leftEmpty > 0) {
                        System.out.print(rightEmpty > 0 ? Math.min(i - rightEmpty, leftEmpty - i) + " " :
                                leftEmpty - i + " ");
                        continue;
                    }

                    if (leftEmpty <= rightEmpty || leftEmpty < 0) {
                        for (int j = i; j < emptyPlaceQuant; j++) {
                            if (inputLine.get(j).equals("0")) {
                                leftEmpty = j;
                                System.out.print(rightEmpty > -1 ? Math.min(i - rightEmpty, leftEmpty - i) + " "
                                        : leftEmpty - i + " ");
                                break;
                            }
                            if (j == emptyPlaceQuant - 1) {
                                System.out.print(i - rightEmpty + " ");
                            }
                        }
                    }
                }
            }
        }
    }
}
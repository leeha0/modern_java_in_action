package scofe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RentalTime {

    private static final DateTimeFormatter rentalTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> rentalTimes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rentalTimes.add(br.readLine());
        }

        LocalTime startTime = LocalTime.of(0, 0, 0);
        LocalTime endTime = LocalTime.of(23, 59, 59);
        for (String rentalTime : rentalTimes) {
            String[] rentalStartAndEndTime = rentalTime.split(" ~ ");
            LocalTime startRentalTime = LocalTime.parse(rentalStartAndEndTime[0], rentalTimeFormatter);
            LocalTime endRentalTime = LocalTime.parse(rentalStartAndEndTime[1], rentalTimeFormatter);

            if (startRentalTime.isAfter(startTime)) {
                startTime = startRentalTime;
            }

            if (endRentalTime.isBefore(endTime)) {
                endTime = endRentalTime;
            }
        }

        if (startTime.isAfter(endTime)) {
            System.out.println("-1");
        } else if (startTime.equals(endTime)) {
            System.out.println("-1");
        } else {
            for (String rentalTime : rentalTimes) {
                String[] rentalStartAndEndTime = rentalTime.split(" ~ ");

                LocalTime startRentalTime = LocalTime.parse(rentalStartAndEndTime[0], rentalTimeFormatter);
                LocalTime endRentalTime = LocalTime.parse(rentalStartAndEndTime[1], rentalTimeFormatter);

                if (!(startRentalTime.isBefore(startTime) || startRentalTime.equals(startTime))
                    || !(endRentalTime.isAfter(endTime) || endRentalTime.equals(endTime))) {
                    System.out.println("-1");
                    break;
                }
            }

            System.out.println(startTime.toString() + " ~ " + endTime.toString());
        }
    }
}

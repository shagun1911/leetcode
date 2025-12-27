import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0]
                ? Long.compare(a[1], b[1])
                : Long.compare(a[0], b[0])
        );

        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                int freedRoom = (int) busyRooms.poll()[1];
                availableRooms.offer(freedRoom);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                busyRooms.offer(new long[]{end, room});
                meetingCount[room]++;
            }
            else {
                long[] earliest = busyRooms.poll();
                long newEndTime = earliest[0] + duration;
                int room = (int) earliest[1];

                busyRooms.offer(new long[]{newEndTime, room});
                meetingCount[room]++;
            }
        }

        int maxMeetings = 0;
        int resultRoom = 0;

        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}

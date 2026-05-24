class Solution {
    private record Car(int position, int speed) {}

    public int carFleet(int target, int[] position, int[] speed) {
        // sort cars by position (furthest cars first)
        PriorityQueue<Car> pq = new PriorityQueue<>((a,b) -> b.position() - a.position());
        int n = position.length;
        for (int i = 0; i < n; i++) {
            pq.add(new Car(position[i], speed[i]));
        }

        // a car is a new fleet if it takes longer to reach target 
        // than the car in front of it
        double lastTime = 0;
        int fleets = 0;
        for (int i = 0; i < n; i++) {
            Car next = pq.remove();
            double time = calculateTime(target, next.position(), next.speed());
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }
        return fleets;
    }

    private double calculateTime(int target, int position, int speed) {
        return (double)(target - position) / speed;
    }
}
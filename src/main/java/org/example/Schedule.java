package org.example;

public class Schedule {
    private final double bestTime;
    private final double averageTime;
    private final double worstTime;

    public Schedule(double averageTime, double bestTime, double worstTime) {
        this.bestTime = bestTime;
        this.averageTime = averageTime;
        this.worstTime = worstTime;
    }
    // Getters for the times
    public double getBestTime() { return bestTime; }
    public double getAverageTime() { return averageTime; }
    public double getWorstTime() { return worstTime; }

    @Override
    public String toString() {
        return "Schedule{" +
                "averageTime=" + averageTime +
                ", bestTime=" + bestTime +
                ", worstTime=" + worstTime +
                '}';
    }
}

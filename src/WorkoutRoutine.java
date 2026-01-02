public abstract class WorkoutRoutine {

    protected String name;
    protected int duration;
    protected int caloriesBurned;

    public WorkoutRoutine(String name, int duration, int caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + name +
                " (" + duration + " min, " + caloriesBurned + " cal)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorkoutRoutine)) return false;
        WorkoutRoutine other = (WorkoutRoutine) obj;
        return name.equals(other.name) && duration == other.duration;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + duration;
    }
}
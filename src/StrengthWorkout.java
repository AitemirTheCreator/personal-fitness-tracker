public class StrengthWorkout extends WorkoutRoutine {

    public StrengthWorkout(String name, int duration, int caloriesBurned) {
        super(name, duration, caloriesBurned);
    }

    @Override
    public String getType() {
        return "Strength";
    }
}

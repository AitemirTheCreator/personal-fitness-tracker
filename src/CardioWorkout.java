public class CardioWorkout extends WorkoutRoutine {

    public CardioWorkout(String name, int duration, int caloriesBurned) {
        super(name, duration, caloriesBurned);
    }

    @Override
    public String getType() {
        return "Cardio";
    }
}
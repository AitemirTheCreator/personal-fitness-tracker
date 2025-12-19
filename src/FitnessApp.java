public class FitnessApp {

    public int compareCalories(WorkoutRoutine w1, WorkoutRoutine w2) {
        return Integer.compare(w1.getCaloriesBurned(), w2.getCaloriesBurned());
    }
}

public class Main {

    public static void main(String[] args) {

        User user = new User("Alex", 20, 68.5);
        user.printInfo();

        FitnessApp app = new FitnessApp();

        WorkoutRoutine w1 = new CardioWorkout("Morning Run", 30, 250);
        WorkoutRoutine w2 = new StrengthWorkout("Gym Training", 45, 400);
        WorkoutRoutine w3 = new CardioWorkout("Cycling", 60, 500);

        app.addWorkout(w1);
        app.addWorkout(w2);
        app.addWorkout(w3);

        System.out.println("\n=== ALL WORKOUTS ===");
        app.printAllWorkouts();

        System.out.println("\n=== LONG WORKOUTS (>40 min) ===");
        app.printLongWorkouts(40);

        System.out.println("\n=== SORTED BY CALORIES ===");
        app.sortByCalories();
        app.printAllWorkouts();

        System.out.println("\n=== SEARCH WORKOUT ===");
        WorkoutRoutine found = app.findWorkoutByName("Gym Training");
        System.out.println(found != null ? found : "Workout not found");
    }
}
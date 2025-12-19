public class Main {

    public static void main(String[] args) {

        user user = new user("Alex", 20, 68.5);

        WorkoutRoutine w1 = new WorkoutRoutine("Cardio", 30, 250);
        WorkoutRoutine w2 = new WorkoutRoutine("Strength", 45, 400);

        FitnessApp app = new FitnessApp();

        System.out.println("=== USER INFO ===");
        user.printInfo();

        System.out.println("\n=== WORKOUTS ===");
        w1.printInfo();
        w2.printInfo();

        System.out.println("\n=== COMPARISON ===");
        int result = app.compareCalories(w1, w2);

        if (result > 0) {
            System.out.println("First workout burns more calories.");
        } else if (result < 0) {
            System.out.println("Second workout burns more calories.");
        } else {
            System.out.println("Both workouts burn the same calories.");
        }
    }
}
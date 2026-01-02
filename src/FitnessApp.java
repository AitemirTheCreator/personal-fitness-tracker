import java.util.ArrayList;
import java.util.Comparator;

public class FitnessApp {

    private ArrayList<WorkoutRoutine> workouts = new ArrayList<>();

    public void addWorkout(WorkoutRoutine workout) {
        workouts.add(workout);
    }

    public void printAllWorkouts() {
        for (WorkoutRoutine w : workouts) {
            System.out.println(w);
        }
    }

    // фильтрация
    public void printLongWorkouts(int minDuration) {
        for (WorkoutRoutine w : workouts) {
            if (w.getDuration() > minDuration) {
                System.out.println(w);
            }
        }
    }

    // поиск
    public WorkoutRoutine findWorkoutByName(String name) {
        for (WorkoutRoutine w : workouts) {
            if (w.getName().equals(name)) {
                return w;
            }
        }
        return null;
    }

    // сортировка
    public void sortByCalories() {
        workouts.sort(Comparator.comparingInt(WorkoutRoutine::getCaloriesBurned));
    }
}
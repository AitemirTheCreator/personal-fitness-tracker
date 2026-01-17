public class Main {

    public static void main(String[] args) {
        // Инициализация обработчика БД
        DatabaseHandler dbHandler = new DatabaseHandler();

        // 1. Создаем объекты (как в вашем старом коде)
        User user = new User("Alex", 20, 68.5);
        WorkoutRoutine w1 = new CardioWorkout("Morning Run", 30, 250);
        WorkoutRoutine w2 = new StrengthWorkout("Gym Training", 45, 400);

        System.out.println("=== DB OPERATIONS STARTED ===");

        // 2. WRITE: Сохраняем их в базу данных
        dbHandler.addUser(user);
        dbHandler.addWorkout(w1);
        dbHandler.addWorkout(w2);

        // 3. READ: Читаем список тренировок из базы
        dbHandler.getAllWorkouts();

        // 4. UPDATE: Обновляем вес пользователя
        System.out.println("\nUpdating Alex's weight...");
        dbHandler.updateUserWeight("Alex", 70.0);

        // 5. DELETE: Удаляем тренировку
        System.out.println("\nDeleting 'Morning Run'...");
        dbHandler.deleteWorkoutByName("Morning Run");

        // Проверяем, что осталось
        dbHandler.getAllWorkouts();

        System.out.println("=== DB OPERATIONS FINISHED ===");
    }
}
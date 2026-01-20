import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    // Параметры подключения
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/FitnessAppTracker_db";
    private static final String USER = "postgres";
    private static final String PASS = "timkaandrakhat"; // Укажите ваш пароль

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // --- CREATE (Добавление данных) ---

    public void addUser(User user) {
        String sql = "INSERT INTO users (name, age, weight) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getAge());
            pstmt.setDouble(3, user.getWeight());
            pstmt.executeUpdate();
            System.out.println("User added to DB successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addWorkout(WorkoutRoutine workout) {
        String sql = "INSERT INTO workouts (name, duration, calories_burned, workout_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, workout.getName());
            pstmt.setInt(2, workout.getDuration());
            pstmt.setInt(3, workout.getCaloriesBurned());
            pstmt.setString(4, workout.getType()); // Сохраняем тип (Cardio или Strength)
            pstmt.executeUpdate();
            System.out.println("Workout added to DB successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- READ (Чтение данных) ---

    public void getAllWorkouts() {
        String sql = "SELECT * FROM workouts";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Workouts from DB ---");
            while (rs.next()) {
                String name = rs.getString("name");
                int duration = rs.getInt("duration");
                int calories = rs.getInt("calories_burned");
                String type = rs.getString("workout_type");

                System.out.println(type + ": " + name + " (" + duration + " min, " + calories + " cal)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- UPDATE (Обновление данных) ---

    public void updateUserWeight(String userName, double newWeight) {
        String sql = "UPDATE users SET weight = ? WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newWeight);
            pstmt.setString(2, userName);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User weight updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- DELETE (Удаление данных) ---

    public void deleteWorkoutByName(String workoutName) {
        String sql = "DELETE FROM workouts WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, workoutName);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Workout deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
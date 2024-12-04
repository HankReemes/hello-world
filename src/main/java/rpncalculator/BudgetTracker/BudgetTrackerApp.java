package rpncalculator.BudgetTracker;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BudgetTrackerApp extends Application {
    private BudgetTracker tracker;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tracker = new BudgetTracker();


        Label balanceLabel = new Label("Current Balance: 0.00");
        balanceLabel.setFont(new Font(18));

        TextField incomeField = new TextField();
        incomeField.setPromptText("Enter income amount");

        TextField expenseField = new TextField();
        expenseField.setPromptText("Enter expense amount");

        Button addIncomeButton = new Button("Add Income");
        Button addExpenseButton = new Button("Add Expense");
        Button resetButton = new Button("Reset Balance");
        Button exitButton = new Button("Exit");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);


        grid.add(new Label("Income Amount:"), 0, 0);
        grid.add(incomeField, 1, 0);
        grid.add(new Label("Expense Amount:"), 0, 1);
        grid.add(expenseField, 1, 1);
        grid.add(addIncomeButton, 0, 2);
        grid.add(addExpenseButton, 1, 2);
        grid.add(balanceLabel, 0, 3, 2, 1);
        grid.add(resetButton, 0, 4);
        grid.add(exitButton, 1, 4);

        addIncomeButton.setOnAction(e -> {
            try {
                double income = Double.parseDouble(incomeField.getText());
                tracker.addIncome(income);
                balanceLabel.setText("Current Balance: Rs " + formatCurrency(tracker.getBalance()));
                incomeField.clear();
            } catch (NumberFormatException ex) {
                showError("Please enter a valid income amount.");
            }
        });

        addExpenseButton.setOnAction(e -> {
            try {
                double expense = Double.parseDouble(expenseField.getText());
                tracker.addExpense(expense);
                balanceLabel.setText("Current Balance: Rs " + formatCurrency(tracker.getBalance()));
                expenseField.clear();
            } catch (NumberFormatException ex) {
                showError("Please enter a valid expense amount.");
            }
        });

        resetButton.setOnAction(e -> {
            tracker.resetBalance();
            balanceLabel.setText("Current Balance: " + formatCurrency(tracker.getBalance()));
        });

        exitButton.setOnAction(e -> primaryStage.close());


        Scene scene = new Scene(grid, 350, 300);
        primaryStage.setTitle("Budget Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String formatCurrency(double amount) {
        return String.format("%.2f", amount);
    }
}

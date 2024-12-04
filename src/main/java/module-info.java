module rpncalculator.budgettrackergui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens rpncalculator.BudgetTracker to javafx.fxml;
    exports rpncalculator.BudgetTracker;
}
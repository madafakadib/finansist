import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    double getExpensesSum(){// напишите метод для получения суммы всех трат
        double getExpensesSum = 0;
        for (String name : expensesByCategories.keySet()){
            for (Double exp : expensesByCategories.get(name)){
                getExpensesSum += exp;
            }
        }
        return getExpensesSum;
    }

    void removeCategory(String category){// напишите метод для удаления категории
        expensesByCategories.remove(category);
    }

    String getMaxCategoryName(){// напишите метод для получения категории, где размер трат больше всего
        // используйте эти переменные для сохранения промежуточных значений
            double maxCategorySum = 0;
            String maxCategoryName = "";

            for (String name : expensesByCategories.keySet()) {
                ArrayList<Double> value = expensesByCategories.get(name);
                double ordersSum = 0;
                for (double orderPrice : value) {
                    ordersSum += orderPrice;
                }
                if (ordersSum > maxCategorySum) {
                    maxCategorySum = ordersSum;
                    maxCategoryName = name;
                }
            }
            return maxCategoryName;
    }
}
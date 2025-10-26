import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spending = 0;

        while (true) {

            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Чтобы закончить введите - end");
            System.out.print("Здесь введите запрашиваемые данные:");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation){
                case 1:
                    System.out.print ("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;

                case 2:
                    System.out.print ("Введите сумму расхода:");
                    String spendStr = scanner.nextLine();
                    int spend = Integer.parseInt(spendStr);
                    spending += spend;
                    break;

                case 3:
                    taxation (earnings,spending);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }

        }

        System.out.println ("Программа завершена!");
    }

    public static int taxEarnings (int earnings) {
        int taxEarn = earnings * 6 / 100;
        return taxEarn;
    }

    public static int taxEarningsMinusSpendings (int earnings, int spending) {
        int tax = (earnings - spending) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static void taxation (int earnings, int spending) {
        int f1 = taxEarnings (earnings);
        int f2 = taxEarningsMinusSpendings(earnings, spending);
        if (f2 > f1) {
            System.out.println("Мы советуем Вам УСН доходы 6%");
            System.out.println("Ваш налог составит:" + f1);
            System.out.println("Налог на другой системе налогооблажения:" + f2);
            System.out.println("Экономия:" + (f2 - f1));
        } else if (f1 > f2) {
            System.out.println("Мы советуем Вам УСН доходы минус расходы 15%");
            System.out.println("Ваш налог составит:" + f2);
            System.out.println("Налог на другой системе налогооблажения:" + f1);
            System.out.println("Экономия:" + (f1 - f2));
        } else {
            System.out.println("Можете выбрать любую систему налогообложения");
            System.out.println("Ваш налог составит:" + f2);
        }
    }
}
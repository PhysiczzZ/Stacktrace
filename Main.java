import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordChecker pc = new PasswordChecker();

        try {
            System.out.print("Введите мин. длину пароля: ");
            int minLength = Integer.parseInt(sc.nextLine());
            pc.setMinLength(minLength);

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int MaxRepeat = Integer.parseInt(sc.nextLine());
            pc.setMaxRepeat(MaxRepeat);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                System.out.print("Введите пароль или end: ");
                String password = sc.nextLine();
                if (password.equals("end")) {
                    break;
                }
                System.out.println(pc.verify(password) ? "Подходит!" : "Не подкодит!");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

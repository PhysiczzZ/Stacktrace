public class PasswordChecker {
    private int minLength = - 1;
    private int maxRepeat = - 1;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Длинна пароля не может быть отрицательной");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeat(int maxRepeat) {
        if (maxRepeat <= 0) {
            throw new IllegalArgumentException("Колличество повторений не может быть отрицательным");
        }
        this.maxRepeat = maxRepeat;
    }
    public boolean verify(String password) {
        if (minLength < 0 || maxRepeat < 0) {
            throw new IllegalStateException("Заданы недопустимые параметры пароля");
        }
        if (password.length() < minLength) {
            return false;
        }
        int repeat = 0;
        char previous = password.charAt(0);
        for (char lettet : password.toCharArray()) {
            if (lettet == previous) {
                repeat++;
            } else {
                repeat = 1;
            }
            if (repeat > maxRepeat) {
                return false;
            }
            previous = lettet;
        }
        return true;
    }
}

package Lesson2;

public class SecondLesson {

        public static void main(String[] args) {
            //логические операторы - возвращают тим boolean
            // && - и
            int x = 50, y = 100, z = 91;
            boolean res =  ( x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0); // false
            System.out.println(res);
            res = (x < z) && (y > z);
            System.out.println(res); // true

            // || - или
            int code = 3333, age = 34;
            res = (code == 2222) || (code == 3333) || (code == 4444);
            System.out.println(res); // true

            res = (code != 3333) || (age < 18);
            System.out.println(res); // false

            // ! - не - меняет значение на противоположное
            System.out.println(!res); // true

            boolean isActive = false, isConnected = true;
            res = !isActive || !isConnected;
            System.out.println(res); // true

            res = !((code != 3333) || (age < 18));
            System.out.println(res); //true

            /*
            if (boolean выражение) {
                инструкции
            }

            if (boolean выражение) {
                инструкции
            } else {
                инструкции
            }

            if (boolean выражение1) {
                инструкции
            } else if (boolean выражение2) {
                инструкции
            }

            if (boolean выражение1) {
                инструкции
            } else if (boolean выражение2) {
                инструкции
            } else {
                инструкции
            }
            */

            int state = 1;

            if (state == 0) System.out.println("Закрытие приложения");
            else if (state == 1) System.out.println("Открытие приложения");
            else System.out.println("Ошибка статуса");

            int month = 13;

            if (month == 1 || month == 2 || month == 12) System.out.println("Зима");
            else if (month < 6) System.out.println("Весна");
            else if (month < 9)System.out.println("Лето");
            else if (month < 12) System.out.println("Осень");
            else System.out.println("Число не соответствует номеру месяца");

            switch (month) {
                case 1:
                    System.out.println("Зима");
                    break;
                case 2:
                    System.out.println("Зима");
                    break;
                case 3:
                    System.out.println("Весна");
                    break;
                case 4:
                    System.out.println("Весна");
                    break;
                case 5:
                    System.out.println("Весна");
                    break;
                case 6:
                    System.out.println("Лето");
                    break;
                case 7:
                    System.out.println("Лето");
                    break;
                case 8:
                    System.out.println("Лето");
                    break;
                case 9:
                    System.out.println("Осень");
                    break;
                case 10:
                    System.out.println("Осень");
                    break;
                case 11:
                    System.out.println("Осень");
                    break;
                case 12:
                    System.out.println("Зима");
                    break;
                default:
                    System.out.println("Ошибка");
            }

            /* switch(выражение) {
                case значение:
                инструкции
                case значение:
                инструкции
            }
             */

        }
}

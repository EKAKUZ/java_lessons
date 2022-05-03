package ru.itmo.lessons.lesson11_enums_datetime.enums;

//каждый эллимент перечисления может иметь собственную резализацию метода
// если нужно написать реализацию обстрактного метода после элемента перечисления рекомендуется писать {@Override
public enum Operation {
    SUM {
        @Override
        public int action (int a, int b) {
            return a+b;
        }

    },
    MULTI{
        @Override
        public int action (int a, int b) {
            return a * b;
        }
    };

    public abstract int action(int a, int b);

}

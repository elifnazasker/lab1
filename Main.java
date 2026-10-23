import java.util.Random;

public class Main {

    // Вычисление одного элемента двумерного массива
    public static double calculate(short fi, float x) {
        if (fi == 9) {
            double t = (Math.log(Math.abs(x)) - 0.25) / Math.asin((x - 4) / 22.0);
            return Math.log(Math.pow(Math.cos(Math.pow(t, 3)), 2));
        } else if (fi == 5 || fi == 6 || fi == 8 || fi == 10 || fi == 12 || fi == 13) {
            double num = Math.pow(Math.PI / x, 2);
            double den = Math.pow(x / 2.0, 3) + 1;
            return Math.tan(Math.pow(num / den, 3));
        } else {
            return 2 * Math.log(Math.pow(Math.abs(x) + 1, x));
        }
    }

    // Вывод матрицы с тремя знаками после запятой
    public static void printMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%10.3f", m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 1. Массив f типа short: числа от 4 до 16
        short[] f = new short[13];
        for (int i = 0; i < f.length; i++) {
            f[i] = (short) (4 + i);
        }

        // 2. Массив x типа float: 15 случайных чисел в диапазоне [-15.0; 7.0]
        float[] x = new float[15];
        Random rnd = new Random();
        for (int j = 0; j < x.length; j++) {
            x[j] = -15.0f + rnd.nextFloat() * 22.0f;
        }

        // 3. Двумерный массив 13x15 (f1, т.к. имя f уже занято)
        double[][] f1 = new double[13][15];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 15; j++) {
                f1[i][j] = calculate(f[i], x[j]);
            }
        }

        // 4. Вывод
        printMatrix(f1);
    }
}

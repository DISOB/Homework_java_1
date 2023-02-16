package ComplexNumberWork;

import ComplexNumberWork.ComplexNumber;
import ComplexNumberWork.complexMatrix;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите количество строк и столбцов матрицы");
        int row = in.nextInt(), col = in.nextInt();

        complexMatrix Matrix = new complexMatrix(row, col);

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                Matrix.setItem(i, j, new ComplexNumber(i, j));
            }
        }

        /**
         * Тесты
         */
        System.out.println("Вывод комплексного числа в тригонометрической форме");
        ComplexNumber Num = new ComplexNumber(5, 6);
        Num.print_trig();
        System.out.println();
        System.out.println();

        System.out.println("Вывод матрицы с комплексными числами");
        Matrix.print_matrix();
        System.out.println();

        System.out.println("Сложение двух матриц");
        complexMatrix tmp = Matrix.add(Matrix);
        tmp.print_matrix();
        System.out.println();

        System.out.println("Умножение двух матриц");
        tmp = Matrix.multiplication(Matrix);
        tmp.print_matrix();
        System.out.println();

        System.out.println("Транспонирование");
        tmp = Matrix.T();
        tmp.print_matrix();
        System.out.println();

        System.out.println("Нахождение детерминанта");
        ComplexNumber a = Matrix.determination();
        a.print_alg();
    }
}
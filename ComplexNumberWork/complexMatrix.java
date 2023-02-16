package ComplexNumberWork;

public class complexMatrix {
    /**
     * Создание двумерной матрицы
     */
    private ComplexNumber[][] matrix;

    /**
     * Занесение комплексного числа в матрицу
     * @param i - индекс по строке
     * @param j - индекс по столбцу
     * @param number - комплексное число
     */
    public void setItem(int i, int j, ComplexNumber number)
    {
        this.matrix[i][j] = number;
    }
    /**
     * Занесение double числа в матрицу
     * @param i - индекс по строке
     * @param j - индекс по столбцу
     * @param number - число типа double
     */
    public void setItem(int i, int j, double number)
    {
        this.setItem(i, j, new ComplexNumber(number));
    }
    /**
     * Получения элемента из матрицы
     * @param i - индекс по строке
     * @param j - индекс по столбцу
     * @return - получаемое число
     */
    public ComplexNumber getItem(int i, int j)
    {
        return this.matrix[i][j];
    }
    /**
     * Конструктор квадратных матриц
     * @param size - размер матрицы
     */
    public complexMatrix(int size)
    {
        this(size, size);
    }
    /**
     * Создание двумерной матрицы
     * @param Row - кол-во строк
     * @param Col - кол-во столбцов
     */
    public complexMatrix(int Row, int Col)
    {
        this.matrix = new ComplexNumber[Row][Col];
        for (int i = 0; i < Row; i++)
        {
            for (int j = 0; j < Col; j++)
            {
                this.matrix[i][j] = new ComplexNumber();
            }
        }
    }
    /**
     * Конструктор копирования
     * @param matr - матрица для копирования
     */
    public complexMatrix(complexMatrix matr)
    {
        this.matrix = new ComplexNumber[matr.matrix.length][matr.matrix[0].length];
        for (int i = 0; i < matr.matrix.length; i++)
        {
            for (int j = 0; j < matr.matrix[0].length; j++)
            {
                this.matrix[i][j] = new ComplexNumber(matr.getItem(i, j).getReal(), matr.getItem(i, j).getImage());
            }
        }
    }
    /**
     * Сложение матриц
     * @param rMatrix - вторая матрица
     * @return - результирующая матрица
     */
    public complexMatrix add(complexMatrix rMatrix)
    {
        if (this.matrix.length != rMatrix.matrix.length || this.matrix[0].length != rMatrix.matrix[0].length)
        {
            throw new ArithmeticException("Сложение невозможно, матрицы разной размерности!");
        }
        complexMatrix Result = new complexMatrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++)
        {
            for (int j = 0; j < this.matrix[0].length; j++)
            {
                Result.setItem(i, j, new ComplexNumber(this.getItem(i, j).getReal() + rMatrix.getItem(i, j).getReal(), this.getItem(i, j).getImage() + rMatrix.getItem(i, j).getImage()));
            }
        }
        return Result;
    }
    /**
     * Вычитание матриц
     * @param rMatrix - вычетаемая матрица
     * @return - результат вычитания
     */
    public complexMatrix sub(complexMatrix rMatrix)
    {
        if (this.matrix.length != rMatrix.matrix.length || this.matrix[0].length != rMatrix.matrix[0].length)
        {
            throw new ArithmeticException("Вычитание невозможно, матрицы разной размерности!");
        }
        complexMatrix Result = new complexMatrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++)
        {
            for (int j = 0; j < this.matrix[0].length; j++)
            {
                Result.setItem(i, j, new ComplexNumber(this.getItem(i, j).getReal() - rMatrix.getItem(i, j).getReal(), this.getItem(i, j).getImage() - rMatrix.getItem(i, j).getImage()));
            }
        }
        return Result;
    }
    /**
     * Перемножение матриц
     * @param rMatrix - матрица, на которую умножаем
     * @return - резульат умножения
     */
    public complexMatrix multiplication(complexMatrix rMatrix)
    {
        if (this.matrix[0].length != rMatrix.matrix.length)
        {
            throw new ArithmeticException("Умножение невозможно, так как размерности не совпадают!");
        }
        complexMatrix Result = new complexMatrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++)
        {
            for (int j = 0; j < rMatrix.matrix[0].length; j++)
            {
                for (int g = 0; g < this.matrix[0].length; g++)
                {
                    Result.setItem(i, j, Result.getItem(i, j).add(this.getItem(i, g).multiplication(rMatrix.getItem(g, j))));
                }
            }
        }
        return Result;
    }
    /**
     * Транспонирование матрицы
     * @return - транспонированная матрица
     */
    public complexMatrix T()
    {
        complexMatrix Result = new complexMatrix(this.matrix[0].length, this.matrix.length);
        for (int i = 0; i < this.matrix[0].length; i++)
        {
            for (int j = 0; j < this.matrix.length; j++)
            {
                Result.setItem(i, j, this.getItem(j, i));
            }
        }
        return Result;
    }
    /**
     * Нахождение определителя
     * @return - значение определителя
     */
    public ComplexNumber determination()
    {
        if (this.matrix.length != this.matrix[0].length)
        {
            throw new ArithmeticException("Определитель нельзя вычислить, матрица не квадратная!");
        }

        if (this.matrix.length == 1)
        {
            return this.getItem(0, 0);
        }
        else
        {
            ComplexNumber Result = new ComplexNumber();
            for (int i = 0; i < this.matrix.length; i++)
            {
                complexMatrix tmp_minor = new complexMatrix(this.matrix.length - 1);
                int ind_1 = 0, ind_2 = 0;
                for (int j = 1; j < this.matrix.length; j++)
                {
                    for (int g = 0; g < this.matrix[0].length; g++) {
                        if (g != i)
                        {
                            tmp_minor.setItem(ind_1, ind_2++, this.getItem(j, g));
                        }
                    }
                    ind_2 = 0;
                    ind_1++;
                }
                Result = Result.add(tmp_minor.determination().multiplication(new ComplexNumber(Math.pow(-1, i)).multiplication(this.getItem(0, i))));
            }
            return Result;
        }
    }
    /**
     * Вывод матрицы
     */
    public void print_matrix()
    {
        for (int i = 0; i < this.matrix.length; i++)
        {
            for (int j = 0; j < this.matrix[0].length; j++)
            {
                this.getItem(i, j).print_alg();
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}

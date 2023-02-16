package ComplexNumberWork;

public class ComplexNumber {
    /**
     * Действительная часть
     */
    private double real;
    /**
     * Мнимая часть
     */
    private double image;
    /**
     * Setter для действительной части
     * @param real - действ. часть
     */
    public void setReal(double real) {
        this.real = real;
    }
    /**
     * Setter для мнимой части
     * @param image - мнимая часть
     */
    public void setImage(double image) {
        this.image = image;
    }
    /**
     * Getter для действительной части
     * @return действ. часть
     */
    public double getReal() {
        return real;
    }
    /**
     * Getter для мнимой части
     * @return мнимую часть
     */
    public double getImage() {
        return image;
    }
    /**
     * Конструктор по умолчанию
     */
    public ComplexNumber()
    {
        this(0,0);
    }
    /**
     * Конструктор только с действиетльной частью
     * @param real - действ. часть
     */
    public ComplexNumber(double real)
    {
        this(real, 0);
    }
    /**
     * Конструктор с действительной и мнимой частями
     * @param real - действ. часть
     * @param image - мнимая часть
     */
    public ComplexNumber(double real, double image)
    {
        this.real = real;
        this.image = image;
    }
    /**
     * Конструктор копирования
     * @param number - комплексное число
     */
    public ComplexNumber(ComplexNumber number)
    {
        this.real = number.getReal();
        this.image = number.getImage();
    }
    /**
     * Сложение
     * @param number - второе комплексное число
     * @return - результат сложения
     */
    public ComplexNumber add(ComplexNumber number)
    {
        return new ComplexNumber(this.getReal() + number.getReal(), this.getImage() + number.getImage());
    }
    /**
     * Вычитание
     * @param number - второе комплексное число
     * @return - результат вычитания
     */
    public ComplexNumber sub(ComplexNumber number)
    {
        return new ComplexNumber(this.getReal() - number.getReal(), this.getImage() - number.getImage());
    }
    /**
     * Умножение
     * @param number - второе комплексное число
     * @return - результат умножения
     */
    public ComplexNumber multiplication(ComplexNumber number)
    {
        return new ComplexNumber(this.getReal() * number.getReal() - this.getImage() * number.getImage(), this.getReal() * number.getImage() + this.getImage() * number.getReal());
    }
    /**
     * Деление
     * @param number - второе комплексное число
     * @return - результат деления
     */
    public ComplexNumber division(ComplexNumber number)
    {
        return new ComplexNumber((this.getReal() * number.getReal() + this.getImage() * number.getImage())/(number.getReal() * number.getReal() + number.getImage() * number.getImage()),
                (this.getImage() * number.getReal() - this.getReal() * number.getImage())/(number.getReal() * number.getReal() + number.getImage() * number.getImage()));
    }
    /**
     * Модуль комплексного числа
     * @return - модуль
     */
    public ComplexNumber abs()
    {
        return new ComplexNumber(Math.sqrt(Math.pow(this.getReal(), 2) + Math.pow(this.getImage(), 2)));
    }
    /**
     * Вывод числа в тригонометрической форме
     */
    public void print_trig()
    {
        if (this.abs().getReal() != 0)
        {
            System.out.printf(this.getImage() >= 0 ? "%f*(%f+%f*i)" : "%f*(%f%f*i)", this.abs().getReal(), this.getReal()/this.abs().getReal(), this.getImage()/this.abs().getReal());
        }
        else
        {
            System.out.print("0");
        }
    }

    /**
     * Вывод числа в алгебраической форме
     */
    public void print_alg()
    {
        if (this.image != 0)
        {
            System.out.printf(this.getImage() > 0 ? "%f+%f*i" : "%f%f*i", this.getReal(), this.getImage());
        }
        else
        {
            System.out.print(this.getReal());
        }
    }
}

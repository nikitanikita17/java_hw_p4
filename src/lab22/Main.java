package lab22;

class Complex {
    private int real;
    private int imaginary;

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return real + (imaginary >= 0 ? "+" : "") + imaginary + "i";
    }
}

interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int imaginary);
}

class ConcreteFactory implements ComplexAbstractFactory {
    @Override
    public Complex createComplex() {
        return new Complex(0, 0);
    }

    @Override
    public Complex createComplex(int real, int imaginary) {
        return new Complex(real, imaginary);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a ConcreteFactory
        ComplexAbstractFactory factory = new ConcreteFactory();

        // Creating a complex number using createComplex() method
        Complex complex1 = factory.createComplex();
        System.out.println("Complex Number 1: " + complex1);

        // Creating a complex number with specific values using createComplex(int real, int imaginary) method
        Complex complex2 = factory.createComplex(5, -3);
        System.out.println("Complex Number 2: " + complex2);
    }
}


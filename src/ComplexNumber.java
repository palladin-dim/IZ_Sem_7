public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double resultReal = real * other.real - imaginary * other.imaginary;
        double resultImaginary = real * other.imaginary + imaginary * other.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    @Override
    public String toString() {
        if (imaginary < 0) {
            return real + " - " + Math.abs(imaginary) + "i";
        } else {
            return real + " + " + imaginary + "i";
        }
    }
}


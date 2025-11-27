/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shape;

/**
 *
 * @author LE THI BICH NGAN
 */
public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.printf("Width: %.2f\n", width);
        System.out.printf("Length: %.2f\n", length);
        System.out.printf("Area: %.2f\n", getArea());
        System.out.printf("Perimeter: %.2f\n", getPerimeter());
    }

    public String getResult() {
        return "-----Rectangle-----\n"
                + String.format("Width: %.2f\n", width)
                + String.format("Length: %.2f\n", length)
                + String.format("Area: %.2f\n", getArea())
                + String.format("Perimeter: %.2f\n", getPerimeter());
    }

}

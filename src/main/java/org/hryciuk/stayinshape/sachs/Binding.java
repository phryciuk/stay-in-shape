package org.hryciuk.stayinshape.sachs;

public class Binding {

    class A {
        int temp = 10;

        public int getTemp() {
            return temp;
        }

        public void print() {
            System.out.println("In Class A");
        }
    }

    class B extends A {
        int temp = 20;

        public int getTemp() {
            return temp;
        }

        public void print() {
            System.out.println("In Class B");
        }
    }

    public void main() {
        A a = new B();
        System.out.println(a.temp); // 10
        System.out.println(a.getTemp()); // 20
        a.print(); // In class B
    }
}

package com.myspace;

public class TaxPayer {
    private int salary;
    private int hra;
    private  int tax = 0;
    private  int age = 81;
    private int sa = 1000;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSa() {
        return sa;
    }

    public void setSa(int sa) {
        this.sa = sa;
    }

    public int getTa() {
        return ta;
    }

    public void setTa(int ta) {
        this.ta = ta;
    }

    public int getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(int taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    private int ta = 1000;
    private int taxableIncome =0;


    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public TaxPayer() {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHra() {
        return hra;
    }

    public void setHra(int hra) {
        this.hra = hra;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "salary=" + salary +
                ", hra=" + hra +
                ", tax=" + tax +
                ", age=" + age +
                ", sa=" + sa +
                ", ta=" + ta +
                ", taxableIncome=" + taxableIncome +
                '}';
    }
}

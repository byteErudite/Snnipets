package com.vaibhav.snippets.core_java;


public class ImmutableClassImplementation {

    static public  void main(String[] args) {
        Company company = new Company(1, "oldCompany");
        ImmutableEmployee immutableEmployee = new ImmutableEmployee(1, company);
        MutableEmployee mutableEmployee = new MutableEmployee(1, company);

        System.out.println(immutableEmployee.getCompany().getComapanyName());
        System.out.println(mutableEmployee.getCompany().getComapanyName());

        // change value of employee field in original object assigned to the classes
        company.setComapanyName("newCompany");

        System.out.println("Immutable class field -> "+immutableEmployee.getCompany().getComapanyName());
        System.out.println("mutable class field -> "+mutableEmployee.getCompany().getComapanyName());
    }
}

final class ImmutableEmployee {
    private final int employeeId;
    private final Company company;

    public ImmutableEmployee(int employeeId, Company company) {
        this.employeeId = employeeId;
        // don't assign the passed object directly to the class variable instead assign a deep copy
        // so that it cannot be  modified through referece of the originally passed parameter from outside
        this.company = new Company(company.getCompanyId(), company.getComapanyName());
    }

    public int getEmployeeId() {
        return employeeId;
    }

    // deep copy object before returning so original class object cannot be modified
    public Company getCompany() {
        return new Company(this.company.getCompanyId(), this.company.getComapanyName());
    }
}

class MutableEmployee {
    private int employeeId;
    private Company company;

    public MutableEmployee(int employeeId, Company company) {
        this.employeeId = employeeId;
        this.company = company;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

class Company {
    private int companyId;
    private String comapanyName;

    public Company(int companyId, String comapanyName) {
        this.companyId = companyId;
        this.comapanyName = comapanyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getComapanyName() {
        return comapanyName;
    }

    public void setComapanyName(String comapanyName) {
        this.comapanyName = comapanyName;
    }
}

package hrProgect;

import hrProgect.enums.Department;
import hrProgect.enums.Grade;

import java.util.*;

public class ServiceCollection {
    private final List<Employee> employees;

    public ServiceCollection(List<Employee> employee) {
        this.employees = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // показать всех отсортировав по имени
    public void showEverythingSortedByName() {
        Collections.sort(employees);
    }

    //показать всех отсортировав по зарплате
    public void showEverythingSortedBySalary() {
        SalaryComparator salaryComparator = new SalaryComparator();
        employees.sort(salaryComparator);
    }

    //показать имя, фамилию, департамент и грейд
    public List<String> showFirstNameLastNameDepartmentAndGrade() {
        List<String> myString = new ArrayList<>();
        for (Employee employee : employees) {
            myString.add("{ Name: " + employee.getName() +
                    ", Surname: " + employee.getSurname() +
                    ", Department: " + employee.getDepartment() +
                    ", Grade: " + employee.getGrade() + " }");
        }
        return myString;
    }

    // показать среднюю зарплату по департаментам
    public List<String> showAverageSalaryByDepartment() {
        Map<String, List<Double>> departmentSalaries = new HashMap<>();
        Map<String, Integer> departmentCounts = new HashMap<>();

        for (Employee employee : employees) {
            String department = String.valueOf(employee.getDepartment());
            if (!departmentSalaries.containsKey(department)) {
                departmentSalaries.put(department, new ArrayList<>());
            }
            departmentSalaries.get(department).add(employee.getSalary());
            if (!departmentCounts.containsKey(department)) {
                departmentCounts.put(department, 0);
            }
            departmentCounts.put(department, departmentCounts.get(department) + 1);
        }
        List<String> averageSalaries = new ArrayList<>();

        for (String department : departmentSalaries.keySet()) {
            List<Double> salaries = departmentSalaries.get(department);
            int count = departmentCounts.get(department);
            double sumSalary = 0;

            for (Double salary : salaries) {
                sumSalary += salary;
            }

            double avgSalary = sumSalary / count;
            averageSalaries.add("{" + department + " -- " + avgSalary + "}");
        }
        return averageSalaries;
    }

    //- показать имя, фамилию и грейд только у тех кто выполнил план. hasPlanBeenCompleted = true
    public List<String> showFistNameLastNameAndGradeOnlyForThoseWhoCompletedThePlan() {
        List<String> myString = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.isHasPlanBeenCompleted()) {
                myString.add("{ Name: " + employee.getName() +
                        ", Surname: " + employee.getSurname() +
                        ", Grade: " + employee.getGrade() + " }");
            }
        }
        return myString;
    }

    //повысить % бонуса у всех сотрудников того департамента, в котором больше всего сотрудников hasPlanBeenCompleted = тру,
    // если таких несколько то повысить у всех.
    public void increaseBonusForAllEmployeesOfTheDepartmentThePlanWasTrue() {
        Map<String, String> stringStringMapSales = new HashMap<>();
        int countSales = 0;
        Map<String, String> stringStringMapHR = new HashMap<>();
        int countHR = 0;
        Map<String, String> stringStringMapFinance = new HashMap<>();
        int countFinance = 0;
        Map<String, String> stringStringMapSecurity = new HashMap<>();
        int countSecurity = 0;
        Map<String, String> stringStringMapAdministration = new HashMap<>();
        int countAdministration = 0;

        for (Employee employee : employees) {
            if (employee.isHasPlanBeenCompleted()) {
                switch (employee.getDepartment()) {
                    case SALES:
                        stringStringMapSales.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countSales++;
                        break;
                    case HR:
                        stringStringMapHR.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countHR++;
                        break;
                    case FINANCE:
                        stringStringMapFinance.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countFinance++;
                        break;
                    case SECURITY:
                        stringStringMapSecurity.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countSecurity++;
                        break;
                    case ADMINISTRATION:
                        stringStringMapAdministration.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countAdministration++;
                        break;
                }
            }
        }
        int maxMaxV = Math.max(Math.max(countSales, countHR), Math.max(countFinance, countSecurity));
        int maxMax = Math.max(countAdministration, maxMaxV);

        if (maxMax == countSales) {
            employeeBonusIncrease(stringStringMapSales);
        }
        if (maxMax == countHR) {
            employeeBonusIncrease(stringStringMapHR);
        }
        if (maxMax == countFinance) {
            employeeBonusIncrease(stringStringMapFinance);
        }
        if (maxMax == countSecurity) {
            employeeBonusIncrease(stringStringMapSecurity);
        }
        if (maxMax == countAdministration) {
            employeeBonusIncrease(stringStringMapAdministration);
        }
    }

    private void employeeBonusIncrease(Map<String, String> stringStringMap) {
        Department department = null;
        for (String employeeId : stringStringMap.values()) {
            for (Employee employee : employees) {
                if (employee.getId().equals(employeeId)) {
                    department = employee.getDepartment();
                    break;
                }
            }
        }
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                double currentBonus = employee.getBonusPCT();
                double newBonus = currentBonus * 1.20; // Например, повышение на 20%
                employee.setBonusPCT(newBonus);
            }
        }
    }

    // понизить % бонуса у департамента у которого меньше всего сотрудников выполнило план, если таких несколько то у всех
    public void decreaseBonusForDepartmentWithFewestPlanCompleted() {
        Map<String, String> stringStringMapSales = new HashMap<>();
        int countSales = 0;
        Map<String, String> stringStringMapHR = new HashMap<>();
        int countHR = 0;
        Map<String, String> stringStringMapFinance = new HashMap<>();
        int countFinance = 0;
        Map<String, String> stringStringMapSecurity = new HashMap<>();
        int countSecurity = 0;
        Map<String, String> stringStringMapAdministration = new HashMap<>();
        int countAdministration = 0;

        for (Employee employee : employees) {
            if (!(employee.isHasPlanBeenCompleted())) {
                switch (employee.getDepartment()) {
                    case SALES:
                        stringStringMapSales.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countSales++;
                        break;
                    case HR:
                        stringStringMapHR.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countHR++;
                        break;
                    case FINANCE:
                        stringStringMapFinance.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countFinance++;
                        break;
                    case SECURITY:
                        stringStringMapSecurity.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countSecurity++;
                        break;
                    case ADMINISTRATION:
                        stringStringMapAdministration.put(String.valueOf(employee.getDepartment()), employee.getId());
                        countAdministration++;
                        break;
                }
            }
        }
        int maxMaxV = Math.max(Math.max(countSales, countHR), Math.max(countFinance, countSecurity));
        int maxMax = Math.max(countAdministration, maxMaxV);

        if (maxMax == countSales) {
            employeeBonusDecrease(stringStringMapSales);
        }
        if (maxMax == countHR) {
            employeeBonusDecrease(stringStringMapHR);
        }
        if (maxMax == countFinance) {
            employeeBonusDecrease(stringStringMapFinance);
        }
        if (maxMax == countSecurity) {
            employeeBonusDecrease(stringStringMapSecurity);
        }
        if (maxMax == countAdministration) {
            employeeBonusDecrease(stringStringMapAdministration);
        }
    }

    private void employeeBonusDecrease(Map<String, String> stringStringMap) {
        Department department = null;
        for (String employeeId : stringStringMap.values()) {
            for (Employee employee : employees) {
                if (employee.getId().equals(employeeId)) {
                    department = employee.getDepartment();
                    break;
                }
            }
        }
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                double currentBonus = employee.getBonusPCT();
                double newBonus = currentBonus * 0.80; // Например, уменьшить на 20%
                employee.setBonusPCT(newBonus);
            }
        }
    }

    // у департамента продаж взять всех кто выполнили план и если у сотруднка который выполнил план грейд А то повысить зп и бонус,
    // если грейд ниже то повысить на 1 ступень и только зп.
    public void whoReceivedAnAGradeIncreaseTheirSalaryAndBonusInSales() {
        List<Employee> myString = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment() == Department.SALES) {
                if (employee.isHasPlanBeenCompleted()) {
                    myString.add(employee);
                }
            }
        }
        for (Employee employee : myString) {
            if (employee.getGrade() == Grade.A) {
                double currentBonus = employee.getBonusPCT();
                double newBonus = currentBonus * 1.20; // Например, повышение на 20%
                employee.setBonusPCT(newBonus);

                double currentSalary = employee.getSalary();
                double newSalary = currentSalary * 1.20; // Например, повышение на 20%
                employee.setSalary(newSalary);
            } else {
                employee.setGrade(getNextGrade(employee.getGrade()));

                double currentSalary = employee.getSalary();
                double newSalary = currentSalary * 1.10; // Например, повышение на 10%
                employee.setSalary(newSalary);
            }
        }
    }

    private Grade getNextGrade(Grade currentGrade) {
        Grade[] grades = {Grade.D, Grade.C, Grade.B, Grade.A};
        for (int i = grades.length - 1; i > 0; i--) {
            if (grades[i] == currentGrade) {
                return grades[i - 1];
            }
        }
        return null; // Если текущая оценка самая высокая
    }
}

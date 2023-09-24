public class Main {
    public static void main(String[] args) {
        SetUp set = new SetUp();
        ServiceCollection serviceCollection = new ServiceCollection(set.setUp(40)); // укажем сколько создать сотрудников
        //создаем 40 сотрудников

//        // вывод 40 сотрудников
//        System.out.println(serviceCollection.getEmployees());
//        // сортировка по имени
//        serviceCollection.showEverythingSortedByName();
//        // вывод 40 сотрудников после сортировки
//        System.out.println(serviceCollection.getEmployees());

        System.out.println("--------------------------------------------");
        // вывод 40 сотрудников
//        System.out.println(serviceCollection.getEmployees());
//        // сортировка по зарплатам
//        serviceCollection.showEverythingSortedBySalary();
//        // вывод 40 сотрудников после сортировки
//        System.out.println(serviceCollection.getEmployees());

        System.out.println("--------------------------------------------");
//        //показать имя, фамилию, департамент и грейд
        System.out.println(serviceCollection.showFirstNameLastNameDepartmentAndGrade());

        System.out.println("--------------------------------------------");
//        //показать среднюю зарплату по департаментам
        System.out.println(serviceCollection.showAverageSalaryByDepartment());

        System.out.println("--------------------------------------------");
        // показать имя, фамилию и грейд только у тех кто выполнил план. hasPlanBeenCompleted = тру
        System.out.println(serviceCollection.showFistNameLastNameAndGradeOnlyForThoseWhoCompletedThePlan());

        System.out.println("--------------------------------------------");
        System.out.println(serviceCollection.getEmployees());
        // повысить % бонуса у всех сотрудников того департамента, в котором больше всего сотрудников hasPlanBeenCompleted = тру,
        // если таких несколько то повысить у всех.
        serviceCollection.increaseBonusForAllEmployeesOfTheDepartmentThePlanWasTrue();
        System.out.println(serviceCollection.getEmployees());

        System.out.println("--------------------------------------------");
        System.out.println(serviceCollection.getEmployees());
        //понизить % бонуса у департамента у которого меньше всего сотрудников выполнило план, если таких несколько то у всех
        serviceCollection.decreaseBonusForDepartmentWithFewestPlanCompleted();
        System.out.println(serviceCollection.getEmployees());

        System.out.println("--------------------------------------------");
        System.out.println(serviceCollection.getEmployees());
        //- у департамента продаж взять всех кто выполнили план и если у сотруднка который выполнил план грейд
        // А то повысить зп и бонус,если грейд ниже то повысить на 1 ступень и только зп.
        serviceCollection.whoReceivedAnAGradeIncreaseTheirSalaryAndBonusInSales();
        System.out.println(serviceCollection.getEmployees());
    }
}

public class Main {
    public static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        fillEmployees();
        printFullInfo();
        System.out.println("Сумма зарплат: " + totalWages());
        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeWithMinWages());
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeWithMaxWages());
        System.out.println("Седняя зарплата: " + findAverageWages());
        printFullNameInfo();

        int indexPercent = 15;
        indexWages(15);
        System.out.printf("Заработная плата после индексации на %d%%%n",indexPercent);
        printFullInfo();

        int department = 2;
        System.out.printf("Сотрудник с минимальной зарплатой из отдела %d: %s%n", department, findEmployeeWithMinWages(department));
        System.out.printf("Сотрудник с максимальной зарплатой из отдела %d: %s%n",department, findEmployeeWithMaxWages(department));
        System.out.printf("Сумма зарплат отдела %d: %s%n",department, totalWages(department));
        System.out.printf("Седняя зарплата отдела %d: %s%n",department, findAverageWages(department));
        indexWages(10, 3);
        System.out.printf("Заработная плата после индексации на %d%% отдела %d%n",indexPercent, department);
        printFullInfo();
        System.out.printf("Данные всех сотрудников отдела %d%n",department);
        printFullNameInfo(5);
        int wags = 19000;
        printEmploeeesWagsLessThen(wags);
        printEmploeeesWagsMoreThen(wags);




    }

    private static void fillEmployees() {
        EMPLOYEES[0] = new Employee("Иванов", "Иван", "Иванович", 1, 14500);
        EMPLOYEES[1] = new Employee("Петров", "Иван", "Васильевич", 5, 15500);
        EMPLOYEES[2] = new Employee("Пупкин", "Василий", "Петрович", 3, 15685);
        EMPLOYEES[3] = new Employee("Васильева", "Марфа", "Петровна", 4, 16524);
        EMPLOYEES[4] = new Employee("Сидоров", "Александр", "Иванович", 3, 14327);
        EMPLOYEES[5] = new Employee("Пупенко", "Ольга", "Владимировна", 2, 15458);
        EMPLOYEES[6] = new Employee("Дудка", "Николай", "Александрович", 3, 16895);
        EMPLOYEES[7] = new Employee("Иванова", "Марина", "Николаевна", 1, 15855);
        EMPLOYEES[8] = new Employee("Петрова", "Любовь", "Александровна", 5, 14252);
        EMPLOYEES[9] = new Employee("Сидорова", "Елена", "Львовна", 2, 15328);

    }

    private static void printFullInfo() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int totalWages() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getWages();
        }
        return sum;

    }

    private static Employee findEmployeeWithMinWages() {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getWages() < min) {
                min = emp.getWages();
                employee = emp;
            }
        }
        return employee;
    }

    private static Employee findEmployeeWithMaxWages() {
        int min = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getWages() > min) {
                min = emp.getWages();
                employee = emp;
            }
        }
        return employee;
    }

    private static double findAverageWages() {
        return totalWages()/(double)EMPLOYEES.length;
    }
    private static void printFullNameInfo() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getSurnameEmployee() + " " + employee.getNameEmployee() + " " + employee.getPatronymicEmployee());
        }
    }

    private static void indexWages(int percent) {
        double coeff = 1+ percent/100D;
        for (Employee employee : EMPLOYEES) {
            employee.setWages((int)(employee.getWages()* coeff));

        }
    }
    private static Employee findEmployeeWithMinWages(int department) {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getWages() < min && emp.getDepartment() == department) {
                min = emp.getWages();
                employee = emp;
            }
        }
        return employee;
    }
    private static Employee findEmployeeWithMaxWages(int department) {
        int min = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getWages() > min && emp.getDepartment() == department) {
                min = emp.getWages();
                employee = emp;
            }
        }
        return employee;
    }
    private static int totalWages(int dpartment) {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == dpartment) {
                sum += employee.getWages();
            }

        }
        return sum;

    }
    private static double findAverageWages(int department) {
        int count = 0;
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                count++;
                sum+= employee.getWages();
            }
        }
        if (count != 0) {
            return sum / (double) count;
        } else {
            return 0;
        }
    }
    private static void indexWages(int percent, int department) {
        double coeff = 1+ percent/100D;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                employee.setWages((int)(employee.getWages()* coeff));
            }
        }
    }
    private static void printFullNameInfo(int department) {
        System.out.println("Сотрудники отдела " + department);
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                System.out.println("ID " + employee.getId() + " ФИО: " + employee.getSurnameEmployee() + " " + employee.getNameEmployee() + " " + employee.getPatronymicEmployee() + ", зарплата сотрудника " + employee.getWages());
            }
        }
    }

    private static void printEmploeeesWagsLessThen(int wages) {
        System.out.println("Сотрудники с зарплатой меньше " + wages);
        for (Employee employee : EMPLOYEES) {
            if (employee.getWages() < wages) {
                System.out.println("ID " + employee.getId() + " ФИО: " + employee.getSurnameEmployee() + " " + employee.getNameEmployee() + " " + employee.getPatronymicEmployee() + ", зарплата сотрудника " + employee.getWages());
            }
        }
    }
    private static void printEmploeeesWagsMoreThen(int wages) {
        System.out.println("Сотрудники с зарплатой больше " + wages);
        for (Employee employee : EMPLOYEES) {
            if (employee.getWages() > wages) {
                System.out.println("ID " + employee.getId() + " ФИО: " + employee.getSurnameEmployee() + " " + employee.getNameEmployee() + " " + employee.getPatronymicEmployee() + ", зарплата сотрудника " + employee.getWages());
            }
        }
    }

}



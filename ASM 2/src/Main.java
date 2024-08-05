import jdk.jshell.Snippet;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1: Add Strudent \n" + "2: Remove Student \n" +
                    "3: Sort by Grade \n" + "4: Search Student \n" + "5:Search Grade \n" + "6:Exit. ");
            System.out.println("Enter:");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("\nNumber of student: ");
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    addStudent();
                }
                System.out.println("\n" + "Add " + num + " students successfully!");
            } else if (input == 2) {
                System.out.println("Enter Student code: ");
                int num = scanner.nextInt();
                if (num <= Student.count) {
                    for (int i = 0; i < num; i++) {
                        removeStudent();
                    }
                }
            } else if (input == 3) {
                sortStudentGrade();
            } else if (input == 4) {
                searchStudent();
            } else if (input == 5) {
                searchGrade();
            } else if (input == 6) {
                System.out.println("Exit Program.");
                break;
            }
        }
    }

    private static void searchGrade() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        List<Student> foundStudent = new ArrayList<>();
        System.out.println("Enter grade to Search");
        Double search = scanner.nextDouble();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getGrade().equals(search)) {
                foundStudent.add(student);
            } else if (student.getGrade() > search) {
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("No student found");
        } else {
            for (Student s : foundStudent) {
                System.out.println(s.PrintStudent());
            }
        }
    }

    public static void addStudent() {
        scanner.nextLine();
        System.out.println("Enter Student code: ");
        String code = scanner.nextLine();
        System.out.println("Enter Student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        System.out.println("Enter Gender(0:Male/1:Female): ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        System.out.println("Enter Grade: ");
        double grade = scanner.nextInt();

        Student student = new Student(code, name, age, gender, address, grade);
        studentList.add(student);
        System.out.println(studentList.toString());
    }

    public static void removeStudent() {
        scanner.nextLine();
        Iterator<Student> iteratorStudent = studentList.iterator();
        System.out.println("Enter Student's Code to remove: ");
        String code = scanner.nextLine();
        boolean removed = false;

        while (iteratorStudent.hasNext()) {
            Student student = iteratorStudent.next();
            if (student.getCode().equals(code)) {
                iteratorStudent.remove();
                Student.count = -1;
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Student " + code + "has been removed.");

        } else {
            System.out.println("Can not found this Student");
        }
    }

    public static void sortStudentGrade()
    {
        Comparator<Student> compareStudent = (s1, s2) -> s2.getGrade().compareTo(s1.getGrade());
        Collections.sort(studentList, compareStudent);
        printStudent();
    }
    public static void searchStudent() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        List<Student> foundStudent = new ArrayList<>();
        System.out.println("Enter student code to search: ");
        String search = scanner.nextLine();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCode().equals((search))) {
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("\n No Student found!");
        } else {
            for (Student s : foundStudent) {
                System.out.println(s.PrintStudent());
            }
        }
    }


    public static void printStudent() {
        for (Student s : studentList) {
            System.out.println(s.PrintStudent());
        }
    }

}
package lesson05;
/*
 * Author Lina Rusakova.
 * This is main package for homework for lesson5 of course Java Level1.
 *
 * Thanks!
 */
public class StaffMember {

    //* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;

    private String firstMiddleLastName;
    private String position;
    private String email;
    private String phoneNumber;
    private float wage;
    private int age;

    //* Конструктор класса должен заполнять эти поля при создании объекта;
    public StaffMember(String firstMiddleLastName, String position, String email, String phoneNumber, int wage, int age) {
        this.firstMiddleLastName = firstMiddleLastName;
        this.position=position;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.wage=wage;
        this.age=age;
    }

    //* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
public void printInfoStaffMember() {
    System.out.printf("Свеедения о сотруднике: \nФИО - %s\nДолжность - %s\nEmail - %s\nPhone - %s\nЗарплата - %.2f Euro\nВозраст - %d\n\n", firstMiddleLastName, position, email, phoneNumber, wage, age);
}

    public static  void  main(String[] args) {
        StaffMember staffMember=new StaffMember("Иванов Иван Иванович", "Ведущий разработчик", "ivanovii@mail.ru", "+79991234567", 2500, 42 );
        staffMember.printInfoStaffMember();
//* Создать массив из 5 сотрудников
//* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
       StaffMember[] staffMembers = new StaffMember[5];
       staffMembers[0] = new StaffMember("Kris Kaspersky", "IT security researcher", "kasperskyk@mailbox.com", "+79991234567", 2500, 40 );
        staffMembers[1] = new StaffMember("Steve Wozniak", "Electronics engineer", "wozniaks@mailbox.com", "+79991234567", 3900, 70 );
        staffMembers[2] = new StaffMember("Linus Torwalds", "Developer of the Linux kernel", "torwaldsl@mailbox.com", "+79991234567", 2500, 50 );
        staffMembers[3] = new StaffMember("Kevin Mitnick", "Hacker", "mitnikk@mailbox.com", "+79991234567", 4500, 57 );
        staffMembers[4] = new StaffMember("Gleb Alexandrov", "Creative/Art Director в Creative Shrimp", "gleba@mailbox.com", "+79991234567", 4900, 36 );

        for (int i=0; i< staffMembers.length;i++) {
            if (staffMembers[i].age>40) {
                staffMembers[i].printInfoStaffMember();

            }
        }
    }

}


package lesson05;
/*
 * Author Lina Rusakova.
 * This is main package for homework for lesson5 of course Java Level1.
 *
 * Thanks!
 */

import java.util.Objects;
import java.util.Random;

    public class StaffMemberTest {

        //* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;

        private String firstMiddleLastName;
        private String position;
        private String email;
        private String phoneNumber;
        private float wage;
        private int age;
        private static final int STAFF_MEMBER_COUNT = 5;
        private static final int MIN_AGE = 40;
        private static Random ageRandom = new Random();

        public String getFirstMiddleLastName() {
            return firstMiddleLastName;
        }

        public String getPosition() {
            return position;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public float getWage() {
            return wage;
        }

        public int getAge() {
            return age;
        }

        public void setFirstMiddleLastName(String firstMiddleLastName) {
            this.firstMiddleLastName = firstMiddleLastName;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setWage(float wage) {
            this.wage = wage;
        }

        public void setAge(int age) {
            this.age = age;
        }

        //* Конструктор класса должен заполнять эти поля при создании объекта;
        public StaffMemberTest(String firstMiddleLastName, String position, String email, String phoneNumber, float wage, int age) {
            this.firstMiddleLastName = firstMiddleLastName;
            this.position = position;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.wage = wage;
            this.age = age;
        }

        //* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
        public void printInfoStaffMember() {
            System.out.printf("Свеедения о сотруднике: \nФИО - %s\nДолжность - %s\nEmail - %s\nPhone - %s\nЗарплата - %.2f Euro\nВозраст - %d\n\n", firstMiddleLastName, position, email, phoneNumber, wage, age);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            lesson05.StaffMemberTest staffMember = (lesson05.StaffMemberTest) obj;
            return age == staffMember.age &&
                    wage == staffMember.wage &&
                    Objects.equals(firstMiddleLastName, staffMember.firstMiddleLastName) &&
                    Objects.equals(email, staffMember.email) &&
                    Objects.equals(phoneNumber, staffMember.phoneNumber) &&
                    Objects.equals(position, staffMember.position);
        }

        private lesson05.StaffMemberTest createStaffMember(int i) {
            return new lesson05.StaffMemberTest(
                    "FIO" + i,
                    "superPosition" + i,
                    "email" + i + "@mail.ru",
                    "+91198765432" + i,
                    2000 + i * 100,
                    40 + i);

        }

        public static void main(String[] args) {
            lesson05.StaffMemberTest staffMember = new lesson05.StaffMemberTest("Иванов Иван Иванович", "Ведущий разработчик", "ivanovii@mail.ru", "+79991234567", 2500, 42);
            staffMember.printInfoStaffMember();
//* Создать массив из 5 сотрудников
//* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
            lesson05.StaffMemberTest[] staffMembers = new lesson05.StaffMemberTest[5];
            staffMembers[0] = new lesson05.StaffMemberTest("Kris Kaspersky", "IT security researcher", "kasperskyk@mailbox.com", "+79991234567", 2500, 40);
            staffMembers[1] = new lesson05.StaffMemberTest("Steve Wozniak", "Electronics engineer", "wozniaks@mailbox.com", "+79991234567", 3900, 70);
            staffMembers[2] = new lesson05.StaffMemberTest("Linus Torwalds", "Developer of the Linux kernel", "torwaldsl@mailbox.com", "+79991234567", 2500, 50);
            staffMembers[3] = new lesson05.StaffMemberTest("Kevin Mitnick", "Hacker", "mitnikk@mailbox.com", "+79991234567", 4500, 57);
            staffMembers[4] = new lesson05.StaffMemberTest("Gleb Alexandrov", "Creative/Art Director в Creative Shrimp", "gleba@mailbox.com", "+79991234567", 4900, 36);

            for (int i = 0; i < staffMembers.length; i++) {
                if (staffMembers[i].getAge() > 40) {
                    staffMembers[i].printInfoStaffMember();
                }
            }


            lesson05.StaffMemberTest[] staffMembers2 = new lesson05.StaffMemberTest[STAFF_MEMBER_COUNT];
            for (int i = 0; i < staffMembers2.length; i++) {
                staffMembers2[i].createStaffMember(i);
            }



            for (int i = 0; i < staffMembers2.length; i++) {
                if (staffMembers2[i].getAge() > MIN_AGE) {
                    staffMembers2[i].printInfoStaffMember();


                }
            }
//
//        for (StaffMember staffMembersPrint: staffMembers2) {
//            if (staffMembersPrint.getAge()>MIN_AGE) {
//                staffMembersPrint.printInfoStaffMember();
//            }
//        }
        }

    }



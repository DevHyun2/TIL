package com.shinhan.week2.day05.test;

import java.util.Scanner;

//함수, 메서드 : 문장들의 묶음, 로직구현, (반복사용시, 모듈화하기 위해)
public class BankApplication {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean isGo = true;

        Account[] arr = new Account[100];
        int index = 0;

        while (isGo) {
            menuPrint();
            System.out.print("선택> ");
            int job = sc.nextInt();

            switch (job) {
                case 1:
                    menuPrint2("계좌생성");

                    if (index == arr.length) {
                        System.out.println("더 이상 계좌를 생성할 수 없습니다.");
                        break;
                    }

                    arr[index++] = creatAccount();
                    break;

                case 2:
                    menuPrint2("계좌목록");

                    for (int i = 0; i < index; i++) {
                        if (arr[i] == null) break;
                        System.out.printf("%s %10s %10d%n", arr[i].accNo, arr[i].owner, arr[i].balance);
                    }
                    break;

                case 3:
                    menuPrint2("예금");
                    inputAccount(arr, index);
                    break;

                case 4:
                    menuPrint2("출금");
                    outputAccount(arr, index);
                    break;

                case 5:
                    System.out.println("프로그램을 종료");
                    isGo = false;
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        sc.close();
    }

    private static void inputAccount(Account[] arr, int index) {
        System.out.print("계좌번호: ");
        String accNo = sc.next();

        boolean found = false; // 계좌번호를 찾았는지 여부를 나타내는 변수

        for (int i = 0; i < index; i++) {
            if (accNo.equals(arr[i].accNo)) {
                found = true;
                System.out.print("입금액: ");
                int amount = sc.nextInt();
                arr[i].save(amount);
                System.out.println(amount + "원 입금되었습니다.");
                break;
            }
        }

        if (!found) {
            System.out.println("없는 계좌번호입니다.");
        }
    }

    private static void outputAccount(Account[] arr, int index) {
        System.out.print("계좌번호: ");
        String accNo = sc.next();

        boolean found = false; // 계좌번호를 찾았는지 여부를 나타내는 변수

        for (int i = 0; i < index; i++) {
            if (accNo.equals(arr[i].accNo)) {
                found = true;
                System.out.print("출금액: ");
                int amount = sc.nextInt();
                int withdrawnAmount = arr[i].withdraw(amount);
                if (withdrawnAmount == -1) {
                    System.out.println("잔액이 부족합니다.");
                } else {
                    System.out.println(withdrawnAmount + "원 출금되었습니다.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("없는 계좌번호입니다.");
        }
    }

    private static Account creatAccount() {
        System.out.print("계좌번호: ");
        String accNo = sc.next();

        System.out.print("계좌주: ");
        String owner = sc.next();

        System.out.print("초기입금액: ");
        int balance = sc.nextInt();

        return new Account(accNo, owner, balance);
    }

    private static void menuPrint2(String title) {
        System.out.println("------");
        System.out.println(title);
        System.out.println("------");
    }

    static void menuPrint() {
        System.out.println("-----------------------------------");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
        System.out.println("-----------------------------------");
    }
}
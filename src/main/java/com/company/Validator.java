package com.company;

import static com.company.Main.scanner;

public class Validator {

    private Integer from;
    private Integer to;

    public void getToCode(){

        System.out.println("Converting to");
        System.out.println("1.USD \t 2.EUR \t 3.RUB");
        to = scanner.nextInt();

        while(to < 1 || to > 3){
            System.out.println("Only 1-3 codes are available, try again.");
            System.out.println("1.USD \t 2.EUR \t 3.RUB");
            to = scanner.nextInt();
        }
    }

    public void getFromCode(){

        System.out.println("Converting from");
        System.out.println("1.USD \t 2.EUR \t 3.RUB");
        from = scanner.nextInt();

        while(from < 1 || from > 3){
            System.out.println("Only 1-3 codes are available, try again.");
            System.out.println("1.USD \t 2.EUR \t 3.RUB");
            from = scanner.nextInt();
        }
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}

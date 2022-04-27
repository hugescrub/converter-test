package com.company;

import static com.company.Main.scanner;

public class Validator {

    private Integer from;
    private Integer to;

    public Integer getToCode(Integer to){

        while(to < 1 || to > 3){
            System.out.println("Only 1-3 codes are available, try again.");
            System.out.println("1.USD \t 2.EUR \t 3.RUB");
            to = scanner.nextInt();
            this.to = to;
        }
        return this.to;
    }

    public Integer getFromCode(Integer from){

        while(from < 1 || from > 3){
            System.out.println("Only 1-3 codes are available, try again.");
            System.out.println("1.USD \t 2.EUR \t 3.RUB");
            from = scanner.nextInt();
            this.from = from;
        }
        return this.from;
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

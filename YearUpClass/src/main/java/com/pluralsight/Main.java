package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Jane","Doe","janedoe1@example.com","Female");
        Student me = new Student("Jakeyl","Johnson","jjohnson1@my.yearupunited.org",
                "Male",13,"https://github.com/jakeyljohnson13",
                "www.linkedin.com/in/jakeyl-johnson","keylmonger",
                "0","https://avatars.githubusercontent.com/jakeyljohnson13",
                "Windows",50,"Extending Classes");

        System.out.println("Full name: " + me.getName() + "\nNickname: " + me.getCodingNickname() + "\nGithub: " + me.getGithub() + "\nDevice: " + me.getDeviceType() + "\nCurrent page: " + me.getPageNumberWorkbook());

    }
}
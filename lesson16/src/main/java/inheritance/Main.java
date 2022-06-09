package inheritance;

public class Main {
    public static void main(String[] args){
        Man man1 = new Man("Ivan", "Pidubniy", 61, true, false, 2000000);
        Man man2 = new Man("Petro", "Semenov", 67, false, true, 25000);
        Woman woman1 = new Woman("Svetlana", "Loboda", 37, false, 0, true, 5.25);
        Woman woman2 = new Woman("Maria", "Sereda", 60, true, 3, false, 0.5);

        System.out.println(man1.name +" "+ man1.lastname +"' gross salary was "+ man1.grosSalary);
        System.out.println(man2.name +" "+ man2.lastname +"' age is "+ man2.age);
        man1.setGrosSalary(0);
        man1.setSmoking(true);
        System.out.println(woman1.name +" "+ woman1.lastname +" was blond "+ woman1.isBlond);
        System.out.println(woman2.name +" "+ woman2.lastname +" has had "+ woman2.getNumberOfChildren()+ " children.");
        System.out.println("\nBut Because of War time in Ukraine:");
        woman1.setBlond(false);
        woman1.setLostWeight(3.5);
        woman2.setNumberOfChildren(1);
        System.out.println(man1.name +" "+ man1.lastname +" lost his job, so his salary is "+ man1.grosSalary+ " now.");
        System.out.println(woman1.name +" "+ woman1.lastname +" is blond "+ woman1.isBlond + ". She has lost " + woman1.getLostWeight()+ " kg of her weight.");
        System.out.println(woman2.name +" "+ woman2.lastname +" has only "+ woman2.getNumberOfChildren()+ " child now" +
                ".");
        System.out.println("\n"+man1.name +" "+man1.lastname+" is "+man1.getAge()+ " now.");
        man1.isRetired();
        System.out.println("\n"+man2.name +" "+man2.lastname+" has already "+man2.getAge()+" years old.");
        man2.isRetired();
        System.out.println("\n"+woman1.name +" "+ woman1.lastname +" is only "+woman1.getAge()+ " now.");
        woman1.isRetired();
        System.out.println("\n"+woman2.name +" "+ woman2.lastname +" is "+ woman2.getAge()+" years old.");
        woman2.isRetired();

        woman1.registerPartnership(man1.lastname);
        System.out.println("\nAfter wedding "+woman1.name +" "+"changed her lastname for "+ woman1.lastname);

        woman1.deregisterPartnership(true, "Loboda");
        System.out.println("\nBut in case of the diworce with Ivan, "+ woman1.name+" will " +
                        "again change her lastname to "+woman1.lastname);

        man1.registerPartnership(man2.lastname);
        System.out.println("\nAfter getting relationship "+man1.name +" "+"changed her lastname for "+ man2.lastname);
        man2.deregisterPartnership(true, "Semenov");

        man2.registerPartnership(man1.lastname);
        System.out.println("\nAfter getting relationship "+man2.name +" "+"changed her lastname for "+ man1.lastname);
        man2.deregisterPartnership(false, "Semenov");
//
//        maSystem.out.printf("This woman is %s retired", (age >= 60)? "" : "not");n2.deregisterPartnership(false, "Semenov");
    }
}

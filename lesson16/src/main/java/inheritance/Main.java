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

        System.out.println("\nman1: "+man1.name+" "+man1.lastname);
        System.out.println("man2: "+man2.name+" "+man2.lastname);


        System.out.println("\nwoman1: "+woman1.name+" "+woman1.lastname);
        System.out.println("woman2: "+woman2.name+" "+woman2.lastname);


    }
}

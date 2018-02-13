package com.goura.test.featuresinjava8;

import static com.goura.test.featuresinjava8.Person.createPerson;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Sample {

    public static List<Person> createPeopleList() {
    	return new Random().ints(100, 65, 91)
	      .mapToObj(i -> new String(new char[]{(char) i, (char) random(97, 122)}))
	      .map(s -> createPerson(UUID.randomUUID(), s, Gender.values()[random(0, 4)], random(22, 45)))
	      .collect(Collectors.toList());

    	/*return Arrays.asList(
            createPerson(UUID.randomUUID(), "Goura", Gender.MALE, 38),
            createPerson(UUID.randomUUID(), "Gita", Gender.FEMALE, 31),
            createPerson(UUID.randomUUID(), "Gautam", Gender.MALE, 7),
            createPerson(UUID.randomUUID(), "Gita", Gender.FEMALE, 48),
            createPerson(UUID.randomUUID(), "Mantu", Gender.MALE, 37),
            createPerson(UUID.randomUUID(), "Mantu", Gender.MALE, 36),
            createPerson(UUID.randomUUID(), "Kunmun", Gender.MALE, 38),
            createPerson(UUID.randomUUID(), "Tanuja", Gender.FEMALE, 35),
            createPerson(UUID.randomUUID(), "Ekansh", Gender.MALE, 7),
            createPerson(UUID.randomUUID(), "Ranjita", Gender.FEMALE, 37),
            createPerson(UUID.randomUUID(), "Ranjita", Gender.FEMALE, 3)
        );*/
    }

    public static void main(String[] args) {
        // Problem: Get the names of all females whose age greater than 18 yrs in upper case.
        List<Person> peoples = createPeopleList();
        /*System.out.println("Person with min age: " + peoples.stream()
            .min((e1, e2) -> e1.getAge() > e2.getAge()? 1 : -1)
            .orElse(null)
            );

        System.out.println("Sum of all ages: " + peoples.stream()
                .mapToInt(e -> e.getAge())
                .sum()
                );

        List<String> names =
            peoples.stream()
               .filter(e -> e.getGender() == Gender.FEMALE)
               .filter(e -> e.getAge() > 18)
               .map(e -> e.getName())
               .map(s -> s.toUpperCase())
               .collect(Collectors.toList());
               /*.collect(
                   () -> new ArrayList<>(),
                   (list, name) -> list.add(name),
                   (list1, list2) -> list1.addAll(list2));*/

        long t1 = System.currentTimeMillis();
        peoples.stream()
	           .filter(e -> e.getGender() == Gender.FEMALE)
	           .filter(e -> e.getAge() > 18)
	           .map(e -> {
	        	   System.out.println("mapping...");
	        	   return e.getName();
	           })
	           .map(s -> s.toUpperCase())
	           .forEach(s -> {});
        System.out.println("time taken: " + (System.currentTimeMillis() - t1) + " ms.");
        System.out.println(Runtime.getRuntime().availableProcessors());
        CompletableFuture.supplyAsync(() -> {return 4;})
        	.thenApply(i -> i*4)
        	.thenAccept(System.out::println);

    }

    private static int random(int start, int end) {
        return new Random().nextInt(end - start) + start;
    }
}

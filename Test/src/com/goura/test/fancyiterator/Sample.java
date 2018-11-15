package com.goura.test.fancyiterator;

import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args) {
    	String[] names = new String[] {"Goura", "Hari", "Balram", "Bhanu", "Guru"};

    	// Usage of Stream
    	System.out.println("Usage of Stream");
    	Stream.of(names)
    		.filter(n -> n.length() > 4)
    		.map(String::toUpperCase)
    		.forEach(System.out::println);
    	System.out.println();

    	System.out.println("Usage of Stream Builder");
    	Stream.Builder<String> builder = Stream.builder();
    	Stream<String> stream = builder
    		.add("Goura")
    		.add("Gita")
    		.add("Gautam")
    		.build();
    	stream
    		.filter(n -> n.length() > 4)
    		.map(String::toUpperCase)
    		.forEach(System.out::println);
    	System.out.println();
    }

}

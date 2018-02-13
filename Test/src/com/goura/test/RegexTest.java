package com.goura.test;

import java.util.regex.Pattern;

public class RegexTest {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-\\+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String ID_PATTERN = "^[A-Za-z0-9\\._-]+$";
    private static final String PHONE_NUMBER_PATTERN = "^(\\+[1-9][0-9]{0,2})?([1-9][0-9]{9})$";
    private static final String URL_PATTERN = "^[\\w\\d\\.\\?\\/\\-=:&]+$";
    private static final String CORS_PATTERN = "^[\\w\\.(example.com)](1)+$";
    private static final String CORS1_PATTERN = "^[(example.com)]+$";
    private static final String CORS2_PATTERN = ".*\\bexample.com\\b";
    private static final String CORS3_PATTERN = "example.com";
    private static final String CLEAN_XSS_REGEX_PATTERN = "((\\%3C)|<|(\\&lt;))[^\\n]+((\\%3E)|>|(\\&gt;))";

    private static final String[] values = new String[] {
    	"goura@gmail.com",
    	"goura.das@gmail.com",
    	"goura_123.das@gmail.com",
    	"goura123_212+DD@gmail.co.in",
    	"_12go-ur@something-vla-bla.com",
    	"goura@gmail.com",
    	"000p2tgh3q5mi@IntegrationTest.com",
    	"003aflx1dcxr@IntegrationTest.com",
    	"goura",
    	"+09886234561",
    	"+910886234561",
    	"+919886234561",
    	"+15031279361",
    	"+05031279361",
    	"+10031279361",
    	"+15000079361",
    	"427398472938",
    	"1235346344",
    	"0235346344",
    	"http://asdf.com",
    	"http://www.google.com",
    	"http://www.google.com/something/anything",
    	"http://www.yahoo.com:9000/something/anything",
    	"http://www.facebook.com:9000/something/anything?foo=bar&q=asdf",
    	"http://localhost:9000/",
    	"https://localhost:9000",
    	"fcapp://forgetPassword",
    	"http://regexr.com/foo.html",
    	"1064878016517-momk9us97np2j52r0tqm28gc2o8fbmk8.apps.googleusercontent.com",
    	"27CF85285047A4F670D314215F07A83E",
    	"95b208e0-392c-44b9-99c5-ff9711e035de",
    	"email@example.com",
    	"firstname.lastname@example.com",
    	"email@subdomain.example.com",
    	"firstname+lastname@example.com",
    	"email@123.123.123.123",
    	"email@[123.123.123.123]",
    	"email1+asdf@example.com",
    	"1234567890@example.com",
    	"email@example-one.com",
    	"_______@example.com",
    	"email@example.name",
    	"email@example.museum",
    	"email@example.co.jp",
    	"firstname-lastname@example.com",
        "asd.das.example.com.sdf",
        "example.comsdf",
        "asdf.fakeexample.com",
        "asd.das.example.com",
        "example.com",
        "asd.example.com",
        "+919880623373"
        /*"<goura>",
        "<javascript>",
        "%3csdlfkj%3E",
        "%3Csdlfkj%3E",
        "<>",
        "mnmfg<goura>",
        "hdgf<javascript>",
        "fghs%3csdlfkj%3E",
        "ghdghj%3Csdlfkj%3E",
        ">",
        "<goura>dfg",
        "<javascript>sdfsdf",
        "%3csdlfkj%3edfg",
        "%3Csdlfkj%3Eerer",
        "<",
        "sdfg<goura>dfg",
        "dfgdfg<javascript>sdfsdf",
        "hfg%3csdlfkj%3edfg",
        "jdfgj%3Csdlfkj%3Eerer",
        "gourahari"*/
    };

    public static void main(String[] args) {
        Pattern p = Pattern.compile(EMAIL_PATTERN);
    	for (String v : values) {
			//System.out.println(v + " --> " + v.matches(CLEAN_XSS_REGEX_PATTERN));
    	    System.out.println(v + " --> " + p.matcher(v).matches());
		}
	}
}

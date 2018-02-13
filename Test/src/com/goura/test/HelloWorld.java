package com.goura.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.UUID;

public class HelloWorld {

    static enum Activation {
        NONE,
        EMAIL,
        SMS,
        BOTH;

        Activation union(Activation current) {
            return Activation.values()[ordinal() | current.ordinal()];
        }

        Activation intersect(Activation current) {
            return Activation.values()[ordinal() & current.ordinal()];
        }
    }

	private static final String FORMAT = "%1$s_%2$tm_%2$te_%2$tY_%2$tH_%2$tM_%2$tS_%2$tL_%3$s";
	public static void main(String[] args) {
		/*System.out.println("Hello World!");
		String str = String.format(FORMAT, "ndgThunderDome", new Date(), "eula1.doc");
		System.out.println(str);*/

		/*Map<String, Object> model = new HashMap<String, Object>();
		model.put("state", "abc123");
		model.put("token", "5fcbae358527ccf5e253b22d2589246c1b23debb258397776255a1706b7281f0");
		String redirectUri = "http://asdf.com";

		UriComponentsBuilder queryBuilder = UriComponentsBuilder.newInstance();
    	for (Map.Entry<String, Object> entry: model.entrySet()) {
    		queryBuilder = queryBuilder.queryParam(entry.getKey(), entry.getValue());
		}
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(redirectUri);
		builder.fragment(queryBuilder.build().getQuery());

    	System.out.println(builder.build().toUriString());*/
		/*String[] urls = new String[] {
			"https://devar-login.td.wearables.infra-host.com/oauth/authorize",
			"https://www.google.com",
			"http://123.0.0.1:8080/check",
			"127.0.0.1:8080/check",
			"javascript://127.0.0.1:8080/check"
		};

		List<String> groups = Collections.<String>emptyList();
		for (String url : urls) {
			groups.add(url);
			System.out.println(url + " " + getHost(url));
		}
		System.out.println(groups);*/
	    /*String arr[] = new String[] {"fr", "mm-US", "hi-US",
	            "fr-FR", "fr-FR", "fr FR",
	            "fr-FR-xyz", "fr-FR-xyz", "fr FR xyz"};
	    String lang = "", country = "", variant = "";
	    for (String s : arr) {
            System.out.print(s + " : ");
            String a[] = StringUtils.tokenizeToStringArray(s, "_ -");
            lang = a[0];
            if (a.length > 1) {
                country = a[1];
            }
            if (a.length > 2) {
                variant = a[2];
            }
            Locale locale = new Locale(lang, country, variant);
            System.out.print(Arrays.asList(a) + ", " + locale);
            System.out.println();
        }*/
		//System.out.println(shortUUID());
	    /*Activation a = Activation.NONE;
	    System.out.println("a: " + a);

        Activation b = a.union(Activation.EMAIL);
        System.out.println("b: " + b);

        Activation bb = b.union(Activation.EMAIL);
        System.out.println("bb: " + bb);

        Activation c = a.union(Activation.SMS);
        System.out.println("c: " + c);

        Activation d = bb.union(Activation.SMS);
        System.out.println("d: " + d);

        Activation e = c.union(Activation.EMAIL);
        System.out.println("e: " + e);

        System.out.println("1: " + Activation.EMAIL.intersect(Activation.EMAIL));
        System.out.println("2: " + Activation.BOTH.intersect(Activation.EMAIL));
        System.out.println("3: " + Activation.SMS.intersect(Activation.SMS));
        System.out.println("4: " + Activation.BOTH.intersect(Activation.SMS));

        System.out.println("5: " + Activation.EMAIL.intersect(Activation.SMS));
        System.out.println("6: " + Activation.SMS.intersect(Activation.EMAIL));
        System.out.println("7: " + Activation.NONE.intersect(Activation.EMAIL));
        System.out.println("8: " + Activation.NONE.intersect(Activation.SMS));
        System.out.println("9: " + Activation.NONE.intersect(Activation.BOTH));*/

	    /*long[] arr = new long[]{12332L, 6345347345765L, 2587L, 538904527L};
	    for (long l : arr) {
	        String hex = Long.toHexString(l);
	        String str = String.format("%0" + (16 - hex.length()) + "d%s", 0, hex);
	        System.out.println(str);
        }*/

	    String clientId = "cc576e38ace3dec6c155a5ae376f1812";
	    System.out.println(clientId);
	    clientId = "app-" + clientId.substring(4);
        System.out.println(clientId);
        System.out.println(System.currentTimeMillis()/1000);
	}

	private static String getHost(final String s) {
		try {
			URL url = new URL(s);
			return url.getHost();
		} catch (MalformedURLException e) {
			return null;
		}
	}
    private static final String shortUUID() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, 23);
  }
}

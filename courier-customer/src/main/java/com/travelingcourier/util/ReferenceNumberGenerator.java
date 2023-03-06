package com.travelingcourier.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ReferenceNumberGenerator {
	
	public static String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        return timestamp + randomNumber;
    }
}

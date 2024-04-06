package com.task.FoodOrder;

import java.util.Base64;

public class ImageUtils {
	public static String convertToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}

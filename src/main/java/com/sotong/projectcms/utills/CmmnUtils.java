package com.sotong.projectcms.utills;

import java.util.ArrayList;
import java.util.Arrays;

public class CmmnUtils {
    public static <T> boolean isValidEnumString(String s , ArrayList<T> e){
        return Arrays.asList(e.toArray()).contains(s);
    }
}

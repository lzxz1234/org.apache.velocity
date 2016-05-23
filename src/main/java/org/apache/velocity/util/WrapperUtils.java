package org.apache.velocity.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WrapperUtils {

    public static Object wrap(Object original) {
        
        if(original == null) return null;
        if(original instanceof Date) 
            return new DateWrapper((Date)original);
        return original;
    }
    
    public static class DateWrapper extends Date {
        
        private static final long serialVersionUID = 4151529163481666716L;

        public DateWrapper(Date date) {
            super(date.getTime());
        }

        @Override
        public String toString() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this);
        }
        
        public String format(String fmt) {
            return new SimpleDateFormat(fmt).format(this);
        }
    }
    
}

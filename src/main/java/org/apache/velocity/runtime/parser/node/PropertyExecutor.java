package org.apache.velocity.runtime.parser.node;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.VelocityException;
import org.apache.velocity.runtime.RuntimeLogger;
import org.apache.velocity.runtime.log.Log;
import org.apache.velocity.runtime.log.RuntimeLoggerLog;
import org.apache.velocity.util.WrapperUtils;
import org.apache.velocity.util.introspection.Introspector;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("all")
public class PropertyExecutor extends AbstractExecutor {
    private final Introspector introspector;

    public PropertyExecutor(final Log log, final Introspector introspector,
                            final Class clazz, final String property) {
        this.log = log;
        this.introspector = introspector;

        if (StringUtils.isNotEmpty(property)) {
            discover(clazz, property);
        }
    }

    public PropertyExecutor(final RuntimeLogger r,
                            final Introspector introspector, final Class clazz,
                            final String property) {
        this(new RuntimeLoggerLog(r), introspector, clazz, property);
    }

    protected Introspector getIntrospector() {
        return this.introspector;
    }

    protected void discover(final Class clazz, final String property) {
        /*
         * this is gross and linear, but it keeps it straightforward.
         */

        try {
            Object[] params = {};

            StringBuffer sb = new StringBuffer("get");
            sb.append(property);

            setMethod(introspector.getMethod(clazz, sb.toString(), params));

            if (!isAlive()) {
                char c = sb.charAt(3);
                if (Character.isLowerCase(c)) {
                    sb.setCharAt(3, Character.toUpperCase(c));
                } else {
                    sb.setCharAt(3, Character.toLowerCase(c));
                }
                setMethod(introspector.getMethod(clazz, sb.toString(), params));
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            String msg = "Exception while looking for property getter for '"
                    + property;
            log.error(msg, e);
            throw new VelocityException(msg, e);
        }
    }

    public Object execute(Object o) throws IllegalAccessException,
            InvocationTargetException {
        Object result = isAlive() ? getMethod().invoke(o, ((Object[]) null))
                : null;
        return WrapperUtils.wrap(result);
    }

}

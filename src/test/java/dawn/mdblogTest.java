package dawn;

import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vincent on 16/10/26.
 */
public class mdblogTest {

    private static Logger log = LoggerFactory.getLogger(mdblogTest.class);

    public static void main(String[] args) {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
    }
    @Test
    public void testDateDiff(){
        System.out.println(new DateTime().toString("/yyyy/MM/dd"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(new Date()));
    }
}




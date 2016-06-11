package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Created by ilugovova on 11.06.2016.
 */
public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
       GeoIP geoIP =  new GeoIPService().getGeoIPServiceSoap12().getGeoIP("109.195.23.33");
        assertEquals(geoIP.getCountryCode(),"RUS");
    }

    @Test
    public void testInvalidIp(){
        GeoIP geoIP =  new GeoIPService().getGeoIPServiceSoap12().getGeoIP("109.xx.23.33");
        assertEquals(geoIP.getCountryCode(),"RUS");
    }
}

package com.thed.zephyr.cloud.rest.client.impl;
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;
public class JWTGenerator {
                public static void main(String[] args) throws URISyntaxException, IllegalStateException, IOException {
                                String zephyrBaseUrl = "https://prod-api.zephyr4jiracloud.com/connect";
                             
                                String accessKey = "NzM2YjQyOWItOGRjYi0zNjVkLWJlMzYtODM4MjE2YTQ1ODBmIHNoZWV0aGFsLmQxMSBVU0VSX0RFRkFVTFRfTkFNRQ";
                                String secretKey = "swVWLyRRIo8ui37gwAifW6dWeWmoR6U_MyRup_r_79Q";
                                String userName = "sheethal.d11@wipro.com";
                                  
                                ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName).build();
                                JwtGenerator jwtGenerator = client.getJwtGenerator();
                              
                                String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/execution/bbf045d9-1ecd-49e3-ae5a-95348f40c347";
                               
                                URI uri = new URI(createCycleUri);
                                int expirationInSec = 36000000;
                                //String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);
                                String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);
                                //String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
                                
                                System.out.println("FINAL API : " +uri.toString());
                                System.out.println("JWT Token : " +jwt);    
               
                }
}

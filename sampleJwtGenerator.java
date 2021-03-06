package com.thed.zapi.cloud.sample;

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

/**
* @author swapna.vemula 12-Dec-2016
*
*/
public class sampleJwtGenerator {

                /**
                * @param args
                * @author Created by sheethal.d11 on 28-Jan-2019.
                * @throws URISyntaxException
                * @throws JobProgressException
                * @throws JSONException
                * @throws IOException 
                 * @throws IllegalStateException 
                 */
                public static void main(String[] args) throws URISyntaxException, IllegalStateException, IOException {
                                // Replace Zephyr BaseUrl with the <ZAPI_CLOUD_URL> shared with ZAPI Cloud Installation
                                String zephyrBaseUrl = "https://prod-api.zephyr4jiracloud.com/connect";
                                // zephyr accessKey , we can get from Addons >> zapi section
                                String accessKey = "NzM2YjQyOWItOGRjYi0zNjVkLWJlMzYtODM4MjE2YTQ1ODBmIHNoZWV0aGFsLmQxMSBVU0VSX0RFRkFVTFRfTkFNRQ";
                                // zephyr secretKey , we can get from Addons >> zapi section
                                String secretKey = "swVWLyRRIo8ui37gwAifW6dWeWmoR6U_MyRup_r_79Q";
                                // Jira UserName
                                String userName = "sheethal.d11@wipro.com";

                                // Jira UserName
                                // String accountId = "accountId";
                                ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName).build();
                                JwtGenerator jwtGenerator = client.getJwtGenerator();
                                
                                // API to which the JWT token has to be generated
                                String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/executions/83564823-286c-45a0-9a2c-b4536aec3af5";
                                
                                URI uri = new URI(createCycleUri);
                                int expirationInSec = 15811200;
                                String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);
                                
                                // Print the URL and JWT token to be used for making the REST call
                                System.out.println("FINAL API : " +uri.toString());
                                System.out.println("JWT Token : " +jwt);               

                
                }

}

package com.directory.nuance;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.directory.service.ListFilesInDirectory;

/**
 * @author R_Legend
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.directory.nuance.NuanceApplicationTests.class)
@AutoConfigureMockMvc
public class NuanceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@MockBean
	private ListFilesInDirectory listFilesInDirectory;
	
    
	
	/**
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void apiSuccessStatusCheck()
	  throws ClientProtocolException, IOException {
	  
	    // Given
	    HttpUriRequest request = new HttpGet( "http://localhost:9091/listAllFiles?directoryPath=G:/Images" );
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertThat(
	      httpResponse.getStatusLine().getStatusCode(),
	      equalTo(HttpStatus.SC_OK));
	}
	
	/**
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void responseContentTypeIsXml()
	  throws ClientProtocolException, IOException {
	  
	   // Given
	   String xmlMimeType = "application/xml";
	   HttpUriRequest request = new HttpGet("http://localhost:9091/listAllFiles?directoryPath=G:/Images");
	 
	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( xmlMimeType, mimeType );
	}
	
	

}


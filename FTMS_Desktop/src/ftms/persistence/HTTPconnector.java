package ftms.persistence;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.security.*;
import java.security.cert.*;

public class HTTPconnector {
	private final String dns = "https://shawnluxy.ddns.net:80/";
	private final String AHeader = "Authorization";
	private final String USER_AGENT = "Mozilla/5.0";
	private CloseableHttpClient client;
	
	@SuppressWarnings("deprecation")
	public HTTPconnector() {
//		trust SSL Certificate
		SSLContextBuilder builder = new SSLContextBuilder();
		try {
			builder.loadTrustMaterial(null, new TrustStrategy(){
			    public boolean isTrusted(X509Certificate[] chain, String authType)
			        throws CertificateException {
			        return true;
			    }
			});
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		    client = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
			e.printStackTrace();
		}
	}
//	HTTP get request
	public String getData(String api) throws Exception {
		String url = dns + api;
		//HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		get.setHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(get);
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}
//	HTTP post request
	public String addData(String api, String auth, String data) throws Exception {
		String url = dns + api;
		//HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		StringEntity entity = new StringEntity(data);
		post.setEntity(entity);
		post.addHeader(AHeader, auth);
		post.setHeader("Content-type", "application/json");
		post.setHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(post);
		
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}
//	HTTP put request
	public String updateData(String api, String auth, String data) throws Exception {
		String url = dns + api;
		//HttpClient client = HttpClientBuilder.create().build();
		HttpPut put = new HttpPut(url);
		StringEntity entity = new StringEntity(data);
		put.setEntity(entity);
		put.addHeader(AHeader, auth);
		put.setHeader("Content-type", "application/x-www-form-urlencoded");
		put.setHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(put);
		
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}
//	HTTP delete request
	public String deleteData(String api, String auth) throws Exception {
		String url = dns + api;
		//HttpClient client = HttpClientBuilder.create().build();
		HttpDelete delete = new HttpDelete(url);
		delete.addHeader(AHeader, auth);
		delete.setHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(delete);
		
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}
}
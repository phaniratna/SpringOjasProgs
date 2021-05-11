package com.ojas;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateExampleApplication.class, args);
	}



//    public void getTopicByIdDemo() {
//   	HttpHeaders headers = getHeaders();  
//       RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/user/topic/{id}";
//       HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//       ResponseEntity<Topic> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Topic.class, 1);
//       Topic topic = responseEntity.getBody();
//       System.out.println("Id:"+topic.getTopicId()+", Title:"+topic.getTitle()
//                +", Category:"+topic.getCategory());      
//   }
    
//	public void getAllTopicsDemo() {
//   	HttpHeaders headers = getHeaders();  
//       RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/user/topics";
//       HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//       ResponseEntity<Topic[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, 
//    		   requestEntity, Topic[].class);
//       Topic[] topics = responseEntity.getBody();
//       for(Topic topic : topics) {
//             System.out.println("Id:"+topic.getTopicId()+", Title:"+topic.getTitle()
//                     +", Category: "+topic.getCategory());
//       }
//   }
	
//   public void addTopicDemo() {
//   	HttpHeaders headers = getHeaders();  
//       RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8888/api/tickets";
//	    Ticket topic = new Ticket();
//	    topic.setTitle("Vijay Spring REST Web Service");
//	    topic.setCategory("Vijay Spring Boot Rest");
//       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic, headers);
//       URI uri = restTemplate.postForLocation(url, requestEntity);
//       System.out.println(uri.getPath());    	
//   }
   
//   public void updateTopicDemo() {
//   	HttpHeaders headers = getHeaders();  
//       RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/user/topic";
//	    Topic topic = new Topic();
//	    topic.setTopicId(1);
//	    topic.setTitle("Update:Java Concurrency");
//	    topic.setCategory("Java");
//       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic, headers);
//       restTemplate.put(url, requestEntity);
//   }
//   
//   public void deleteTopicDemo() {
//   	HttpHeaders headers = getHeaders();  
//       RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/user/topic/{id}";
//       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(headers);
//       restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 6);        
//   }
//   
//   private HttpHeaders getHeaders() {
//   	String credential="vijay:vijay";
//   	//String credential="nareshguest:nareshguest";
//   	
//   	//String credential="martin:m@123";
//   	String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
//       HttpHeaders headers = new HttpHeaders();
//       headers.setContentType(MediaType.APPLICATION_JSON);
//    	headers.add("Authorization", "Basic " + encodedCredential);
//   	return headers;
//   }
//   public static void main(String args[]) {
//   	TopicRestClientUtil topicRestClientUtil = new TopicRestClientUtil();
//       //topicRestClientUtil.getTopicByIdDemo();
//    
//   	topicRestClientUtil.addTopicDemo();
//   //	topicRestClientUtil.updateTopicDemo();
//    
//   	//topicRestClientUtil.deleteTopicDemo();
//   	//topicRestClientUtil.getAllTopicsDemo();
//   }    

}

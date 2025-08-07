package problem16;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;


@Service
public class PostService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Post[] getAllPosts() {
        return restTemplate.getForObject(BASE_URL, Post[].class);
    }

    public Post getPostById(int id) {
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
        } catch (HttpClientErrorException e) {
            System.out.println("Error: " + e.getStatusCode() + " - " + e.getMessage());
            return null;
        }
    }

    public Post createPost(Post post) {
        return restTemplate.postForObject(BASE_URL, post, Post.class);
    }

    public void updatePost(int id, Post post) {
        restTemplate.put(BASE_URL + "/" + id, post);
    }

    public void deletePost(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}

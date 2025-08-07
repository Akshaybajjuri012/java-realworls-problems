package problem16;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public Post[] getAll() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Post post) {
        postService.updatePost(id, post);
        return "Post updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        postService.deletePost(id);
        return "Post deleted successfully!";
    }
}

package wcs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import wcs.rest.repository.BlogRepository;
import wcs.rest.entity.Blog;

import java.util.List;
import java.util.Map;


@RestController
public class BlogController {
    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/blogs")
    public List<Blog> getAll(){
            return blogRepository.findAll();
        }

        @GetMapping("/blogs/{id}")
        public Blog show(@PathVariable int id){
            return blogRepository.findById(id).get();
        }

        @PostMapping("/blogs/search")
        public List<Blog> search(@RequestBody Map<String, String> body){
            String searchTerm = body.get("text");
            return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
        }

        @PostMapping("/blogs")
        public Blog create(@RequestBody Blog blog){
            return blogRepository.save(blog);
        }

        @PutMapping("/blogs/{id}")
        public Blog update(@PathVariable int id, @RequestBody Blog blog){
            Blog blogToUpdate = blogRepository.findById(id).get();
            blogToUpdate.setTitle(blog.getTitle());
            blogToUpdate.setContent(blog.getContent());
            return blogRepository.save(blogToUpdate);
        }

        @DeleteMapping("blogs/{id}")
        public boolean delete(@PathVariable int id){
            blogRepository.deleteById(id);
            return true;
        }
    }


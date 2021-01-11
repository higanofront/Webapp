package com.example.Webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.Webapp.entity.Post;
import com.example.Webapp.repository.PostRepository;
@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public Post findById(int id) {
		return postRepository.findById(id).get();
	}

	public void deleteById(int id) {
		postRepository.deleteById(id);
	}

	public List<Post> findAllByTitle (String title) {
		return postRepository.findAllByTitle(title);
	}

	public List<Post> findPostsByTitleContain(String searchTitle) {
	    return postRepository.findAll(Specification
	        .where(titleContains(searchTitle))
	    );
	}

	public Specification<Post> titleContains(String searchTitle) {
        return (root, query, cb) -> {
            return cb.like(root.get("title"), "%" + searchTitle + "%");
        };
    }

}

package com.example.Webapp.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Webapp.entity.Post;

import lombok.Data;


@Data
@Component
public class PostsJto {

	private List<Post> posts;

	public void setPostsList(List<Post> postsData) {
		posts = new ArrayList<Post>();
		for (Post post : postsData) {
			posts.add(post);
		}
	}
}

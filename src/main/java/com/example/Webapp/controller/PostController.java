package com.example.Webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Webapp.entity.Post;
import com.example.Webapp.post.PostsJto;
import com.example.Webapp.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;

	@Autowired
	PostsJto postsJto;

	@GetMapping("/add")
	public String getAdd (
			Model model) {
		Post post = new Post();
		model.addAttribute("Post", post);

		return "add";
	}

	@PostMapping("/regist")
	public String getRegist (
			Post post,
			Model model) {
//		現在日時をセット
		post.setCreationDate();
		postService.save(post);

		return "redirect:home";
	}

	@GetMapping("/edit")
	public String getEdit (
			@RequestParam int id,
			Model model) {
		Post editTarget = postService.findById(id);
		model.addAttribute("Post", editTarget);

		return "edit";
	}

	@GetMapping("/delete")
	public String getDelete (
			@RequestParam int id,
			Model model) {
		postService.deleteById(id);

		return "redirect:home";
	}

	@GetMapping("detail")
	public String getPostDetail (
			Model model,
			@RequestParam final Integer id) {
		Post detailTarget = postService.findById(id);
		model.addAttribute("Post", detailTarget);

		return "detail";
	}

	@GetMapping("search")
	@ResponseBody
	public PostsJto getSearch (
			@RequestParam final String title,
			Model model) {
		List<Post> posts = postService.findPostsByTitleContain(title);
		postsJto.setPostsList(posts);

		return postsJto;
	}
}

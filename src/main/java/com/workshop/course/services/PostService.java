package com.workshop.course.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.course.domain.Post;
import com.workshop.course.repository.PostRepository;
import com.workshop.course.services.exception.ObjectNotFoundException;

@Service

public class PostService {

	@Autowired

	private PostRepository repo;

	public Optional<Post> findById(String id) {

		Optional<Post> user = repo.findById(id);

		if (user == null) {

			throw new ObjectNotFoundException("Objeto não encontrado");

		}

		return user;

	}

	public List<Post> findByTitle(String text) {

		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {


		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);//24horas


		return repo.fullSearch(text, minDate, maxDate);


	}

}

package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.classes.Category;
import com.web.classes.Genre;
import com.web.classes.Movie;
import com.web.repository.CategoryRepository;
import com.web.repository.GenreRepository;
import com.web.repository.MovieRepository;

@Controller
@RequestMapping(path="/movie")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/new")
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newMovie(Model model) throws Exception {		
		List<Category> categoryList = (List<Category>) categoryRepository.findAll();
		List<Genre> genreList = (List<Genre>) genreRepository.findAll();
		
		
		model.addAttribute("genreList", genreList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("movie", new Movie());			
		
		return "movie_new";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newMovieAdded(Movie movie) {
		movieRepository.save(movie);
		
		return "movie_included";
	}
	
	@GetMapping(value="/add")
	public @ResponseBody String addMovie(@RequestParam String title, @RequestParam String genre, @RequestParam String cover, @RequestParam String category, @RequestParam String description, @RequestParam String image_detail) {
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setGenre(genre);
		movie.setCover(cover);
		movie.setCategory(category);
		movie.setDescription(description);
		movie.setImageDetail(image_detail);
		movieRepository.save(movie);
		return "Movie added";
	}
	
	@GetMapping(value="/all")
	public @ResponseBody Iterable<Movie> getMovies() {
		return movieRepository.findAll();		
	}	
		
	//return cover
	@GetMapping("/image/{cover}")
	public ResponseEntity<byte[]> getImage(@PathVariable("cover") String cover) throws IOException {
		File imgCover = new File("src/main/resources/static/images/" + cover);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(Files.readAllBytes(imgCover.toPath()));
	}
}

package edu.ldcollege.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import edu.ldcollege.bean.*;
import edu.ldcollege.exception.RestRespErrorException;
import edu.ldcollege.util.RestResult;
import edu.ldcollege.util.RestStatus;

@RestController
public class HellowCtrl {
	// ResourceHttpRequestHandler ss;
	@RequestMapping("/hello")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/helloworld")
	public RestResult sayHello() {
		return new RestResult(RestStatus.SUCCEED, "hello");
	}
	
	@GetMapping("/exception")
	public RestResult makeError() {
		throw new RestRespErrorException(RestStatus.ERROR_SERVER);
	}
	
	@RequestMapping(value = "/departments", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String findDepatment(@RequestParam("departmentId") String departmentId) {
		System.out.println("Find department with ID: " + departmentId);
		return "<html><body><h2>hellow me </h2></body></html>";

	}

	@RequestMapping(value = "/departments2")
	@ResponseBody
	public List<String> findDepatment2(
			@RequestParam(name = "departmentId", required = false, defaultValue = "01") String departmentId) {
		System.out.println("Find department with ID: " + departmentId);
		List<String> values = new ArrayList<>();
		values.add("test1");
		values.add("test2");
		return values;

	}

	@RequestMapping(value = "/departments3")
	@ResponseBody
	public List<String> findDepatment3() {

		List<String> values = new ArrayList<>();
		values.add("test1");
		values.add("test2");
		return values;

	}

	@JsonView(View.Summary.class)
	@RequestMapping("/listbook")
	@ResponseBody
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Book book = new Book();
			book.setId((long) i);
			book.setTitle("book " + i);
			book.setCountry("CN");
			book.setCity("Wuhan");
			books.add(book);
		}
		return books;
	}

	@RequestMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Book getBook(@PathVariable Long id) {
		Book book = new Book();
		book.setId((long) 1);
		book.setTitle("book " + 1);
		book.setCountry("CN");
		book.setCity("Wuhan");
		return book;
	}

	@RequestMapping(value = "/mybook/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public MyBook getMyBook(@PathVariable Long id) {
		MyBook book = new MyBook();
		book.setId((long) 1);
		book.setName(" Leader java");
		return book;
	}

	@RequestMapping(value = "/createmybook", method = RequestMethod.POST)
	@ResponseBody
	public String createMyBook(@RequestBody MyBook book) {
		// valid and save db
		return "Success ";
	}

	// @RequestMapping(value = "/createmybook2", method =
	// RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// @ResponseBody
	// public String createMyBook2(@RequestBody
	// LinkedMultiValueMap<String,String> requestForm) {
	// requestForm.entrySet().stream().forEach(o->System.out.println(o));
	// return "Success ";
	// }

	@RequestMapping(value = "/createmybook2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String createMyBook2(MyBook requestForm) {
		System.out.println("received body " + requestForm);
		// requestForm.entrySet().stream().forEach(o->System.out.println(o));
		return "Success ";
	}

//	@RequestMapping(value = "/showdate", method = RequestMethod.GET)
//	@ResponseBody
//	public String showdate(@RequestParam("date") Date theDate) {
//		System.out.println("theDate " + theDate);
//		return "Success ";
//	}

	@RequestMapping(value = "/showdate", method = RequestMethod.GET)
	@ResponseBody
	public String showdate(@RequestParam("date")  @DateTimeFormat(pattern = "yyyy-MM-dd")  Date theDate) {
		System.out.println("theDate " + theDate);
		return "Success ";
	}

	@RequestMapping(value = "/showdate2", method = RequestMethod.GET)
	@ResponseBody
	public String showdate2(@RequestParam("date")  @DateTimeFormat  Date theDate) {
		System.out.println("theDate " + theDate);
		return "Success ";
	}
}

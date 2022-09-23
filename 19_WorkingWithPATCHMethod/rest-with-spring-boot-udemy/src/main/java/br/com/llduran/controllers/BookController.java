package br.com.llduran.controllers;

import br.com.llduran.data.vo.v1.BookVO;
import br.com.llduran.services.BookServices;
import br.com.llduran.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoints for Managing Book")
public class BookController
{
	@Autowired
	private BookServices service;

	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@Operation(summary = "Finds all Book", description = "Finds all Book", tags = "Book", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public List<BookVO> findAll()
	{
		return this.service.findAll();
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML })
	@Operation(summary = "Finds a Book", description = "Finds a Book", tags = "Book", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = BookVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public BookVO findById(@PathVariable("id") final Long id)
	{
		return this.service.findById(id);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML })
	@Operation(summary = "Adds a new Book", description = "Adds a new Book by passing in a JSON, XML or YML representation of the book!", tags = "Book", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = BookVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public BookVO create(@RequestBody final BookVO book)
	{
		return this.service.create(book);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML })
	@Operation(summary = "Updates a Book", description = "Updates a Book by passing in a JSON, XML or YML representation of the book!", tags = "Book", responses = {
			@ApiResponse(description = "Updated", responseCode = "200", content = @Content(schema = @Schema(implementation = BookVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public BookVO update(@RequestBody final BookVO book)
	{
		return this.service.update(book);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletes a Book", description = "Deletes a Book by passing in a JSON, XML or YML representation of the book!", tags = "Book", responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content), })
	public ResponseEntity<?> delete(@PathVariable("id") final Long id)
	{
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

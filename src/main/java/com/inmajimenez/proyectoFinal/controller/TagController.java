package com.inmajimenez.proyectoFinal.controller;

import com.inmajimenez.proyectoFinal.model.Tag;
import com.inmajimenez.proyectoFinal.service.TagService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


/**
 * Rest controller of tags
 */
@RestController
@RequestMapping("/api")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    /**
     * It returns all tags
     * @return List of tags
     */
    @GetMapping("/etiquetas")
    @ApiOperation("Encuentra todas las etiquetas con filtro y paginación")
    public ResponseEntity<List<Tag>> findAll(){

        List<Tag> result = tagService.findAllTags();

        return result.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok().body(result);
    }

    /**
     * It returns a tag by id
     * @param id Long id of tag
     * @return A tag from database
     */
    @GetMapping("/etiquetas/{id}")
    @ApiOperation("Encuentra una etiqueta por su id")
    public ResponseEntity<Tag> findOne(@ApiParam("Clave primaria de la etiqueta")
                                       @PathVariable Long id) {

        Tag result = tagService.findOneTagById(id);

        return result == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok().body(result);
    }

    /**
     * It saves a tag and returns the tag created with id
     * @param tag New tag
     * @return Tag created
     */
    @PostMapping("/etiquetas")
    @ApiOperation("Guarda en base de datos una etiqueta nueva")
    public ResponseEntity<Tag> createTag(@ApiParam("Objeto tag nueva")
                                         @RequestBody Tag tag) throws URISyntaxException {

        Tag result = tagService.createTag(tag);

        return  result == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                ResponseEntity.created(new URI("/api/tags/" + result.getId())).body(result);
    }

    /**
     * It updates a tag
     * @param tag Tag to update
     * @return Updated tag
     */
    @PutMapping("/etiquetas") //PONER ID?????
    @ApiOperation("Actualiza en base de datos una etiqueta")
    public ResponseEntity<Tag> updateTag(@ApiParam("Etiqueta con datos actualizados")
                                             @RequestBody Tag tag) {

        Tag result = tagService.updateTag(tag);

        return result == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                ResponseEntity.ok().body(result);
    }

    /**
     * It deletes one tag by id
     * @param id id of tag
     * @return Response of delete
     */
    @DeleteMapping("/etiquetas/{id}")
    @ApiOperation("Borra de base de datos una etiqueta según su id")
    public ResponseEntity<Void> deleteComputer(@ApiParam("Id de la etiqueta")
                                               @PathVariable Long id) {

        return !tagService.deleteTagById(id) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.noContent().build();
    }
}
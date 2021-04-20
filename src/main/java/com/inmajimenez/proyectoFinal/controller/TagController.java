package com.inmajimenez.proyectoFinal.controller;

import com.inmajimenez.proyectoFinal.model.TagResponse;
import com.inmajimenez.proyectoFinal.model.TagResponseGetAll;
import com.inmajimenez.proyectoFinal.model.entities.Tag;
import com.inmajimenez.proyectoFinal.model.TagFilters;
import com.inmajimenez.proyectoFinal.service.TagService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
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
     * @return Response with list of tags
     */
    @GetMapping("/etiquetas")
    @ApiOperation("Encuentra todas las etiquetas con filtro y paginación")
    public TagResponseGetAll findAll(@QueryParam("name") String name, @QueryParam("page") String page,
                                             @QueryParam("limit") String limit){


        TagResponseGetAll response = tagService.findAllTags(new TagFilters(name, page, limit));

        if(!response.getTags().isEmpty()){
            response.setResponse(new TagResponse("Etiquetas encontradas",
                                        new ResponseEntity(HttpStatus.OK).getStatusCode()));
        }else{
            response.setResponse(new TagResponse("No hubo resultados en la búsqueda",
                                        new ResponseEntity(HttpStatus.NOT_FOUND).getStatusCode()));
        }
        return response;
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
                ResponseEntity.created(new URI("/api/etiquetas/" + result.getId())).body(result);
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
    public ResponseEntity<Void> deleteTag(@ApiParam("Id de la etiqueta")
                                               @PathVariable Long id) {

        return !tagService.deleteTagById(id) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.noContent().build();
    }
}

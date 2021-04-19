package com.inmajimenez.proyectoFinal.controller;

import com.inmajimenez.proyectoFinal.model.ExpertFilters;
import com.inmajimenez.proyectoFinal.model.entities.Expert;
import com.inmajimenez.proyectoFinal.service.ExpertService;
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
 * Rest controller of experts
 */
@RestController
@RequestMapping("/api")
public class ExpertController {

    private final ExpertService expertService;

    public ExpertController(ExpertService expertService){
        this.expertService = expertService;
    }

    /**
     * It returns all experts
     * @return List of experts
     */
    @GetMapping("/expertos")
    @ApiOperation("Encuentra todos los expertos con filtro y paginación")
    public ResponseEntity<List<Expert>> findAll(@QueryParam("name") String name, @QueryParam("mode") String mode,
                                                @QueryParam("state") String state,
                                                @QueryParam("score") Integer score,
                                                @QueryParam("tag") String tag,
                                                @QueryParam("page") String page, @QueryParam("limit") String limit){

        List<Expert> result = expertService.findAllExperts(new ExpertFilters(name, mode, state,score, tag, page, limit));

        return result.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok().body(result);
    }

    /**
     * It returns an expert by id
     * @param id Long id of expert
     * @return An expert from database
     */
    @GetMapping("/expertos/{id}")
    @ApiOperation("Encuentra un experto por su id")
    public ResponseEntity<Expert> findOne(@ApiParam("Clave primaria del experto")
                                        @PathVariable Long id) {

        Expert result = expertService.findOneExpertById(id);

        return result == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok().body(result);
    }

    /**
     * It saves an expert and returns the expert created with id
     * @param expert New expert
     * @return Expert created
     */
    @PostMapping("/expertos")
    @ApiOperation("Guarda en base de datos un experto nuevo")
    public ResponseEntity<Expert> createExpert(@ApiParam("Objeto experto nuevo")
                                           @RequestBody Expert expert) throws URISyntaxException {

        Expert result = expertService.createExpert(expert);

        return  result == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                ResponseEntity.created(new URI("/api/expertos/" + result.getId())).body(result);
    }

    /**
     * It updates an expert
     * @param expert Expert to update
     * @return Updated expert
     */
    @PutMapping("/expertos") //IDDDDDDDD????
    @ApiOperation("Actualiza en base de datos un experto existente")
    public ResponseEntity<Expert> updateExpert(@ApiParam("Información del experto")
                                           @RequestBody Expert expert) {

        Expert result = expertService.updateExpert(expert);

        return result == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                ResponseEntity.ok().body(result);
    }

    /**
     * It deletes one expert by id
     * @param id id of expert
     * @return Response of delete
     */
    @DeleteMapping("/expertos/{id}")
    @ApiOperation("Borra de base de datos un experto según su id")
    public ResponseEntity<Void> deleteExpert(@ApiParam("Id del experto")
                                               @PathVariable Long id) {

        return !expertService.deleteExpertById(id) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.noContent().build();
    }


}

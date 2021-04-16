package com.inmajimenez.proyectoFinal.service.impl;

import com.inmajimenez.proyectoFinal.dao.ExpertDAO;
import com.inmajimenez.proyectoFinal.model.Expert;
import com.inmajimenez.proyectoFinal.repository.ExpertRepository;
import com.inmajimenez.proyectoFinal.service.ExpertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {

    private final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);

    private final ExpertDAO expertDAO;
    private ExpertRepository expertRepository;

    public ExpertServiceImpl (ExpertDAO expertDAO, ExpertRepository expertRepository){
        this.expertDAO = expertDAO;
        this.expertRepository = expertRepository;
    }

    /**
     * It returns a list of experts
     * @return List of experts
     */
    @Override
    public List<Expert> findAllExperts() {
        log.debug("Find all experts");
        return this.expertDAO.findAllExperts();
    }

    /**
     * It returns an expert depending of id
     * @param id Long id of expert
     * @return An expert
     */
    @Override
    public Expert findOneExpertById(Long id) {
        log.debug("Find one expert by id: {}", id);
        return expertDAO.findOneExpert(id);
    }

    /**
     * It saves an expert
     * @param expert New expert
     * @return The expert created
     */
    @Override
    public Expert createExpert(Expert expert) {
        log.debug("Create expert: {}", expert);

        Expert expertCreated = null;

        if (expert.getId() == null) {
            try{
                expertCreated = expertRepository.save(expert);
            }catch(Exception e) {
                log.error("Cannot save the expert: {} , error : {}", expert, e);
            }
        }else{
            log.warn("Creating expert with id");
        }
        return expertCreated;
    }

    /**
     * It updates an expert
     * @param expert The expert
     * @return The expert updated
     */
    @Override
    public Expert updateExpert(Expert expert) {
        log.debug("Update a expert: {}", expert);

        Expert result = null;

        if (expertRepository.existsById(expert.getId())) {
            try{
                result = expertRepository.save(expert);
            }catch(Exception e){
                log.error("Cannot save expert: {} , error : {}", expert, e);
            }
        }else{
            log.warn("Cannot save expert: {}, because it doesn´t exist", expert);
        }
        return result;
    }

    /**
     * It deletes one expert by id
     *
     * @param id id of expert
     * @return true or false
     */
    @Override
    public boolean deleteExpertById(Long id) {
        log.debug("Delete an expert by id: {}", id);

        if (expertRepository.existsById(id)) {

            try{
                expertRepository.deleteById(id);
            }catch(Exception e){
                log.error("Cannot delete expert with id {}", id);
                return false;
            }
        }else {
            log.error("Doesn´t exist expert with id {}", id);
            return false;
        }

        return true;
    }
}

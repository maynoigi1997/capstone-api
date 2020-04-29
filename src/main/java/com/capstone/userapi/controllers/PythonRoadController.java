/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.controllers;

import com.capstone.userapi.dtos.ShortestRoute;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.userapi.repositories.ShortestRouteRepository;

/**
 *
 * @author hoang
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/python")
public class PythonRoadController {

    @Autowired
    ShortestRouteRepository pythonRoadRepository;

    @GetMapping(value = "/roads")
    public List<ShortestRoute> getAllRoads() {
        return pythonRoadRepository.findAll();
    }

    @PostMapping("/roads")
    ResponseEntity<String> createRoad(@RequestBody ShortestRoute newPython) { 
        Boolean exist = pythonRoadRepository.checkExistByUV(newPython.getStart_node(),newPython.getEnd_node());
        if(!exist){
             pythonRoadRepository.save(newPython);
             return new ResponseEntity<>("Create Successful", HttpStatus.CREATED);
        } else{
             pythonRoadRepository.updateData(newPython.getMeta_data(), newPython.getQlearning_data(),newPython.getStart_node(),newPython.getEnd_node());
             if (pythonRoadRepository.updateData(newPython.getMeta_data(), newPython.getQlearning_data(),newPython.getStart_node(),newPython.getEnd_node())>0){
                  return new ResponseEntity<>("Update Successful", HttpStatus.OK);
             }
        }       
    return new ResponseEntity<>("Error", HttpStatus.EXPECTATION_FAILED);
    }
    
//     @PutMapping("/roads/{id}")
//    ShortestRoute updateUsers(@RequestBody ShortestRoute newRoad, @PathVariable Long id) {
//         Optional<PythonRoad> p = pythonRoadRepository.findById(id);
//        p.get().setU(newRoad.get);
//        p.get().setV(newRoad.getV());
//        p.get().setMeta_data(newRoad.getMeta_data());
//        return pythonRoadRepository.save(p.get());
//    }
    
    @DeleteMapping("/roads")
    ResponseEntity<String> deletePython() {
       pythonRoadRepository.deleteAll();
       return new ResponseEntity<>("Deleted All",HttpStatus.OK);
    }
}

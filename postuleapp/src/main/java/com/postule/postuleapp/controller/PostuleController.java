package com.postule.postuleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;



import java.util.List;

import com.postule.postuleapp.exception.ResourceNotFoundException;

import com.postule.postuleapp.model.ListePostule;
import com.postule.postuleapp.repository.PostuleRepository;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api")
public class PostuleController {

    @Autowired
    PostuleRepository postuleRepository;

    // Get All Notes
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/postule")
    public List<ListePostule> getAllPostules() {
       return postuleRepository.findAll();
    
    
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/postule/count/")
    public Long count() {
      
        return postuleRepository.count();
    }
    // Create a new Note
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path="/postule", consumes = "application/json")
    public ListePostule createNote(@Valid @RequestBody ListePostule postuleDetails) {
       
        return postuleRepository.save(postuleDetails);
    }
    // Get a Single Note
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path="/postule/{id}",consumes = "application/json")
    public ListePostule getNoteById(@PathVariable(value = "id") Long id) {
        ListePostule postule = postuleRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Postule", "id", id));
        return postule;
    }
    // Update a Note
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path="/postule/{id}",consumes = "application/json")
    public ListePostule updateNote(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody ListePostule postuleDetails) {
    
                                                ListePostule postule = postuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Postule", "id", id));
    postule.setSrcimg(postuleDetails.getSrcimg());
        postule.setTarget(postuleDetails.getTarget());
        postule.setText(postuleDetails.getText());
    postule.setTime(postuleDetails.getTime());
    postule.setFeatures(postuleDetails.getFeatures());
        ListePostule updatedPostule = postuleRepository.save(postule);
        return updatedPostule;
    }



    // Delete a Note
    
    @PostMapping("/postule/delete/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) {
    ListePostule note = postuleRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("postule", "id", id));

    postuleRepository.delete(note);

    return ResponseEntity.ok().build();
}
  
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    http.csrf().disable();
}




}


}

package com.pokemonurpg.controller;

import com.pokemonurpg.dto.species.SpeciesDto;
import com.pokemonurpg.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin
public class SpeciesController {

    private SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    /*@GetMapping(path="/all")
    public @ResponseBody ResponseEntity getAllSpecies() {
        return ResponseEntity.ok(speciesService.findAll());
    }*/

    @GetMapping(path="/{name}")
    public @ResponseBody
    ResponseEntity<SpeciesDto> getSpeciesByName(@PathVariable("name") String name) {
        try {
            SpeciesDto dto = speciesService.findByName(name);
            if (dto != null) {
                return ResponseEntity.ok(dto);
            }
            else return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /*@GetMapping(path="/{name}")
    public @ResponseBody
    ResponseEntity getSpeciesByName(@PathVariable("name") String name) {
        Optional<Species> speciesOptional = service.findByName(name);
        if (speciesOptional.isPresent()) {
            Species species = speciesOptional.get();
            species.addTransientFields(service, alteredFormMethodService,evolutionService);
            return ResponseEntity.ok(species);
        }
        else {
            speciesOptional = service.findByNameStartingWith(name);
            if (speciesOptional.isPresent()) {
                Species species = speciesOptional.get();
                species.addTransientFields(service, alteredFormMethodService, evolutionService);
                return ResponseEntity.ok(species);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
    }*/

    /*@PostMapping(path="/create")
    public ResponseEntity createSpecies(@RequestBody Species species) {
        Errors errors = speciesValidator.validate(species);
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        else {
            String name = species.getName();
            Optional<Species> speciesOptional = speciesService.findByName(name);
            if (speciesOptional.isPresent()) {
                return ResponseEntity.badRequest().body("A Pokemon named " + name + " already exists!");
            }

            List<SpeciesAttack> attacks = species.getAttacks();
            for (SpeciesAttack attack : attacks) {
                errors = speciesAttackValidator.validate(attack);
                if (errors.hasErrors()) {
                    return ResponseEntity.badRequest().body(errors.getAllErrors());
                }
            }

            List<SpeciesAbility> abilities = species.getAbilities();
            for (SpeciesAbility ability : abilities) {
                errors = speciesAbilityValidator.validate(ability);
                if (errors.hasErrors()) {
                    return ResponseEntity.badRequest().body(errors.getAllErrors());
                }
            }

            speciesService.save(species);
            return ResponseEntity.ok("Pokemon " + name + " was created successfully!");
        }
    }

    @PutMapping(path="/{name}")
    public ResponseEntity updateSpecies(@RequestBody Species species, @PathVariable String name) {

        Optional<Species> speciesOptional = speciesService.findByName(name);

        if (!speciesOptional.isPresent())
            return ResponseEntity.notFound().build();
        else if (!name.equals(species.getName()))
            return ResponseEntity.badRequest().build();
        else {
            species.cloneValuesFrom(speciesOptional.get());

            Errors errors = speciesValidator.validate(species);
            if(errors.hasErrors()) {
                return ResponseEntity.badRequest().body(errors.getAllErrors());
            }
            else {
                speciesService.save(species);
                return ResponseEntity.ok("Pokemon " + name + " was updated successfully!");
            }
        }
    }

    @DeleteMapping(path="/{name}")
    public ResponseEntity deleteSpecies(@PathVariable String name) {
        Optional<Species> speciesOptional = speciesService.findByName(name);

        if (!speciesOptional.isPresent())
            return ResponseEntity.notFound().build();
        else
        {
            speciesService.delete(speciesOptional.get());
            return ResponseEntity.ok("Pokemon " + name + " was deleted successfully!");
        }
    }*/

}

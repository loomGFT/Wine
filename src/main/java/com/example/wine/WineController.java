package com.example.wine;

import com.example.wine.Exceptions.WineNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class WineController {

    private final WineRepository repository;
    private final WineModelAssembler assembler;

    public WineController(WineRepository repository, WineModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

//    @GetMapping("/api/wine/{id}")
//    EntityModel<Wine> wine(@PathVariable Long id) {
//
//        Wine wine = repository.findById(id)
//                .orElseThrow(() -> new WineNotFoundException(id));
//        return assembler.toModel(wine);
//    }
    @GetMapping("/api/wineshop/{id}")
    EntityModel<Wine> one(@PathVariable Long id) {

        Wine wineshop = repository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id));
        return assembler.toModel(wineshop);
    }
    @GetMapping("/api/wineshop")
    CollectionModel<EntityModel<Wine>> all() {

        List<EntityModel<Wine>> wineshop = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(wineshop, linkTo(methodOn(WineController.class).all()).withSelfRel());
    }
}

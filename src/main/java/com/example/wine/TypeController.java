package com.example.wine;

import com.example.wine.Classes.Type;
import com.example.wine.Exceptions.RegionNotFoundException;
import com.example.wine.Exceptions.TypeNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TypeController
{
        private final TypeRepository repository;
        private final TypeModelAssembler assembler;

        public TypeController(TypeRepository repository, TypeModelAssembler assembler) {
            this.repository = repository;
            this.assembler = assembler;
        }

        @GetMapping("/api/type/{id}")
        EntityModel<Type> one(@PathVariable Long id) {

            Type type = repository.findById(id)
                    .orElseThrow(() -> new TypeNotFoundException(id));
            return assembler.toModel(type);
        }
        @GetMapping("/api/type")
        CollectionModel<EntityModel<Type>> all() {

            List<EntityModel<Type>> type = repository.findAll().stream() //
                    .map(assembler::toModel) //
                    .collect(Collectors.toList());

            return CollectionModel.of(type, linkTo(methodOn(TypeController.class).all()).withSelfRel());
        }
}



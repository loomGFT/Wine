package com.example.wine;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class WineModelAssembler implements RepresentationModelAssembler<Wine, EntityModel<Wine>> {
    @Override
    public EntityModel<Wine> toModel(Wine wineshop) {

        return EntityModel.of(wineshop,
                linkTo(methodOn(WineController.class).one(wineshop.getId())).withSelfRel(),
                linkTo(methodOn(WineController.class).all()).withRel("wineshop"));
    }
}

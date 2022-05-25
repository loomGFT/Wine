package com.example.wine;

import com.example.wine.Classes.Winery;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class WineryModelAssembler implements RepresentationModelAssembler<Winery, EntityModel<Winery>> {
    @Override
    public EntityModel<Winery> toModel(Winery winery) {

        return EntityModel.of(winery,
                linkTo(methodOn(WineryController.class).one(winery.getId())).withSelfRel(),
                linkTo(methodOn(WineryController.class).all()).withRel("wine"));
    }
}

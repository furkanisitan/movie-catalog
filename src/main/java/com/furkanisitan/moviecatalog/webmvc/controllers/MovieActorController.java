package com.furkanisitan.moviecatalog.webmvc.controllers;

import com.furkanisitan.moviecatalog.business.abstracts.MovieActorService;
import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;
import com.furkanisitan.moviecatalog.webmvc.dtos.actor.CharacterDto;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import com.furkanisitan.moviecatalog.webmvc.utils.Constants;
import com.furkanisitan.moviecatalog.webmvc.utils.ServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("movie-actor")
public class MovieActorController {

    private final MovieActorService movieActorService;

    @Autowired
    public MovieActorController(MovieActorService movieActorService) {
        this.movieActorService = movieActorService;
    }

    @PostMapping("/create")
    public String create(@RequestParam String redirectController, CharacterDto characterDto, BindingResult result, RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> movieActorService.createForActor(MapperHelper.map(characterDto, MovieActor.class)), result, Constants.ModelAttr.CHARACTER_DTO);

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Constants.ModelAttr.CHARACTER_DTO, result);
            attributes.addFlashAttribute(Constants.ModelAttr.CHARACTER_DTO, characterDto);
            attributes.addFlashAttribute(Constants.ModelAttr.SHOW_MODAL, "createRole");
        }

        return redirectController.equals("movie") ?
                "redirect:/movies/update/" + characterDto.getMovieId() :
                "redirect:/actors/update/" + characterDto.getActorId();
    }

    @PostMapping("/update")
    public String update(@RequestParam String redirectController, CharacterDto characterDto, BindingResult result, RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> movieActorService.update(MapperHelper.map(characterDto, MovieActor.class)), result, "characterDto");

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Constants.ModelAttr.CHARACTER_DTO, result);
            attributes.addFlashAttribute(Constants.ModelAttr.CHARACTER_DTO, characterDto);
            attributes.addFlashAttribute(Constants.ModelAttr.SHOW_MODAL, "updateRole");
        }

        return redirectController.equals("movie") ?
                "redirect:/movies/update/" + characterDto.getMovieId() :
                "redirect:/actors/update/" + characterDto.getActorId();
    }

    @GetMapping("/delete/{movieId}/{actorId}")
    public String delete(@PathVariable int movieId, @PathVariable int actorId, @RequestParam String redirectController) {

        var movieActorId = new MovieActorId(movieId, actorId);
        var movieActor = movieActorService.get(movieActorId).orElseThrow(() -> new ResourceNotFoundException("Invalid movie actor Id:" + movieActorId));
        movieActorService.delete(movieActor);

        return redirectController.equals("movie") ?
                "redirect:/movies/update/" + movieId :
                "redirect:/actors/update/" + actorId;
    }

}

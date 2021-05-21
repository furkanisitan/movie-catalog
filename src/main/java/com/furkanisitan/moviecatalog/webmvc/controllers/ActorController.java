package com.furkanisitan.moviecatalog.webmvc.controllers;

import com.furkanisitan.moviecatalog.business.abstracts.ActorService;
import com.furkanisitan.moviecatalog.business.abstracts.MovieActorService;
import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;
import com.furkanisitan.moviecatalog.webmvc.dtos.actor.ActorDto;
import com.furkanisitan.moviecatalog.webmvc.dtos.actor.CharacterDto;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import com.furkanisitan.moviecatalog.webmvc.utils.ServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("actors")
public class ActorController {

    private static final String showModal = "showModal";

    private final ActorService actorService;
    private final MovieService movieService;
    private final MovieActorService movieActorService;

    @Autowired
    public ActorController(ActorService actorService, MovieService movieService, MovieActorService movieActorService) {
        this.actorService = actorService;
        this.movieService = movieService;
        this.movieActorService = movieActorService;
    }

    @GetMapping({"", "/index"})
    public String index(Model model) {

        if (!model.containsAttribute("actorDto")) {
            model.addAttribute("actorDto", new ActorDto());
        }

        var actorDtoList = MapperHelper.mapList(actorService.getAll(), ActorDto.class);
        model.addAttribute("actors", actorDtoList);

        return "actor/index";
    }

    @PostMapping("/create")
    public String create(@Valid ActorDto actorDto, final BindingResult result, final RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() ->
                actorService.create(MapperHelper.map(actorDto, Actor.class)), result, "actorDto");

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "actorDto", result);
            attributes.addFlashAttribute("actorDto", actorDto);
            attributes.addFlashAttribute(showModal, "create");
        }

        return "redirect:/actors/index";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {

        if (!model.containsAttribute("characterDto")) {
            model.addAttribute("characterDto", new CharacterDto());
        }

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        var movies = movieService.getAll();
        var characters = actorService.getAllCharacters(id);

        model.addAttribute("actorDto", MapperHelper.map(actor, ActorDto.class));
        model.addAttribute("movies", movies);
        model.addAttribute("characters", characters);

        return "actor/update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid ActorDto actorDto, BindingResult result) {

        ServiceWrapper.of(() -> actorService.update(MapperHelper.map(actorDto, Actor.class)), result, "actorDto");

        return "redirect:/actors/update/" + actorDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        actorService.delete(actor);

        return "redirect:/actors/index";
    }

    @PostMapping("/create-role")
    public String createRole(@Valid CharacterDto characterDto, final BindingResult result, final RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() ->
                movieActorService.createForActor(MapperHelper.map(characterDto, MovieActor.class)), result, "characterDto");

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "characterDto", result);
            attributes.addFlashAttribute("characterDto", characterDto);
        }

        return "redirect:/actors/update/" + characterDto.getActorId();
    }

    @PostMapping("/update-role")
    public String updateRole(@Valid CharacterDto characterDto, final BindingResult result, final RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() ->
                movieActorService.update(MapperHelper.map(characterDto, MovieActor.class)), result, "characterDto");

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "characterDto", result);
            attributes.addFlashAttribute("characterDto", characterDto);
            attributes.addFlashAttribute(showModal, "updateRole");
        }


        return "redirect:/actors/update/" + characterDto.getActorId();
    }

    @GetMapping("/delete-role")
    public String deleteRole(@RequestParam int actorId, @RequestParam int movieId) {

        var movieActorId = new MovieActorId(movieId, actorId);
        var movieActor = movieActorService.get(movieActorId).orElseThrow(() -> new ResourceNotFoundException("Invalid movie actor Id:" + movieActorId));
        movieActorService.delete(movieActor);

        return "redirect:/actors/update/" + actorId;
    }

}

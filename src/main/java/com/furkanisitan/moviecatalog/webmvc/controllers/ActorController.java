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

    private static final String actorDtoAttr = "actorDto";
    private static final String characterDtoAttr = "characterDto";
    private static final String showModalAttr = "showModal";

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

        if (!model.containsAttribute(actorDtoAttr))
            model.addAttribute(actorDtoAttr, new ActorDto());

        var actorDtoList = MapperHelper.mapList(actorService.getAll(), ActorDto.class);
        model.addAttribute("actors", actorDtoList);

        return "actor/index";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        var characterDetailResults = actorService.getAllCharacterDetailResults(id);

        model.addAttribute(actorDtoAttr, MapperHelper.map(actor, ActorDto.class));
        model.addAttribute("characterDetailResults", characterDetailResults);

        return "actor/detail";
    }

    @PostMapping("/create")
    public String create(@Valid final ActorDto actorDto, final BindingResult result, final RedirectAttributes attributes) {

        actorDto.setId(0);

        var wrapper = ServiceWrapper.of(() -> actorService.create(MapperHelper.map(actorDto, Actor.class)), result, actorDtoAttr);

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + actorDtoAttr, result);
            attributes.addFlashAttribute(actorDtoAttr, actorDto);
            attributes.addFlashAttribute(showModalAttr, "create");
        }

        return "redirect:/actors/index";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {

        if (!model.containsAttribute(characterDtoAttr))
            model.addAttribute(characterDtoAttr, new CharacterDto());

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        var movieIdNameResults = movieService.getAllMovieIdNameResult();
        var characterDetailResults = actorService.getAllCharacterDetailResults(id);

        model.addAttribute(actorDtoAttr, MapperHelper.map(actor, ActorDto.class));
        model.addAttribute("movieIdNameResults", movieIdNameResults);
        model.addAttribute("characterDetailResults", characterDetailResults);

        return "actor/update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid final ActorDto actorDto, final BindingResult result) {

        ServiceWrapper.of(() -> actorService.update(MapperHelper.map(actorDto, Actor.class)), result, actorDtoAttr);

        return "redirect:/actors/update/" + actorDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        actorService.delete(actor);

        return "redirect:/actors/index";
    }

    @PostMapping("/roles/create")
    public String createRole(@Valid final CharacterDto characterDto, final BindingResult result, final RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> movieActorService.createForActor(MapperHelper.map(characterDto, MovieActor.class)), result, characterDtoAttr);

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + characterDtoAttr, result);
            attributes.addFlashAttribute(characterDtoAttr, characterDto);
        }

        return "redirect:/actors/update/" + characterDto.getActorId();
    }

    @PostMapping("/roles/update")
    public String updateRole(@Valid final CharacterDto characterDto, final BindingResult result, final RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> movieActorService.update(MapperHelper.map(characterDto, MovieActor.class)), result, "characterDto");

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + characterDtoAttr, result);
            attributes.addFlashAttribute(characterDtoAttr, characterDto);
            attributes.addFlashAttribute(showModalAttr, "updateRole");
        }

        return "redirect:/actors/update/" + characterDto.getActorId();
    }

    @GetMapping("/roles/delete")
    public String deleteRole(@RequestParam int actorId, @RequestParam int movieId) {

        var movieActorId = new MovieActorId(movieId, actorId);
        var movieActor = movieActorService.get(movieActorId).orElseThrow(() -> new ResourceNotFoundException("Invalid movie actor Id:" + movieActorId));
        movieActorService.delete(movieActor);

        return "redirect:/actors/update/" + actorId;
    }

}

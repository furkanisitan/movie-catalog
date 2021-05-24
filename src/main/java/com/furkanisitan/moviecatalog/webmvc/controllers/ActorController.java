package com.furkanisitan.moviecatalog.webmvc.controllers;

import com.furkanisitan.moviecatalog.business.abstracts.ActorService;
import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import com.furkanisitan.moviecatalog.webmvc.dtos.actor.ActorDto;
import com.furkanisitan.moviecatalog.webmvc.dtos.actor.CharacterDto;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import com.furkanisitan.moviecatalog.webmvc.utils.Constants;
import com.furkanisitan.moviecatalog.webmvc.utils.ServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("actors")
public class ActorController {

    private final ActorService actorService;
    private final MovieService movieService;

    @Autowired
    public ActorController(ActorService actorService, MovieService movieService) {
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping({"", "/index"})
    public String index(Model model) {

        if (!model.containsAttribute(Constants.ModelAttr.ACTOR_DTO))
            model.addAttribute(Constants.ModelAttr.ACTOR_DTO, new ActorDto());

        var actorDtoList = MapperHelper.mapList(actorService.getAll(), ActorDto.class);
        model.addAttribute("actors", actorDtoList);

        return "actor/index";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        var characterDetailResults = actorService.getAllCharacterDetailResults(id);

        model.addAttribute(Constants.ModelAttr.ACTOR_DTO, MapperHelper.map(actor, ActorDto.class));
        model.addAttribute("characterDetailResults", characterDetailResults);

        return "actor/detail";
    }

    @PostMapping("/create")
    public String create(ActorDto actorDto, BindingResult result, RedirectAttributes attributes) {

        actorDto.setId(0);

        var wrapper = ServiceWrapper.of(() -> actorService.create(MapperHelper.map(actorDto, Actor.class)), result, Constants.ModelAttr.ACTOR_DTO);

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Constants.ModelAttr.ACTOR_DTO, result);
            attributes.addFlashAttribute(Constants.ModelAttr.ACTOR_DTO, actorDto);
            attributes.addFlashAttribute(Constants.ModelAttr.SHOW_MODAL, "create");
        }

        return "redirect:/actors";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        var movieIdNameResults = movieService.getAllMovieIdNameResult();
        var characterDetailResults = actorService.getAllCharacterDetailResults(id);

        if (!model.containsAttribute(Constants.ModelAttr.CHARACTER_DTO))
            model.addAttribute(Constants.ModelAttr.CHARACTER_DTO, new CharacterDto());

        model.addAttribute(Constants.ModelAttr.ACTOR_DTO, MapperHelper.map(actor, ActorDto.class));
        model.addAttribute("movieIdNameResults", movieIdNameResults);
        model.addAttribute("characterDetailResults", characterDetailResults);

        return "actor/update";
    }

    @PostMapping("/update/{id}")
    public String update(ActorDto actorDto, BindingResult result) {

        ServiceWrapper.of(() -> actorService.update(MapperHelper.map(actorDto, Actor.class)), result, Constants.ModelAttr.ACTOR_DTO);

        return "redirect:/actors/update/" + actorDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {

        var actor = actorService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid actor Id:" + id));
        actorService.delete(actor);

        return "redirect:/actors";
    }

}

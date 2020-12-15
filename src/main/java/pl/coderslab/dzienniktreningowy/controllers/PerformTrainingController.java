package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.dzienniktreningowy.dtos.training.NewTrainingDTO;
import pl.coderslab.dzienniktreningowy.services.PerformTrainingService;

import javax.enterprise.inject.Produces;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("user/performTraining")
@Controller
public class PerformTrainingController {

    private final PerformTrainingService performTrainingService;

    @GetMapping("{id}")
    public String createTraining(Model model, @PathVariable Long id) {
        model.addAttribute("newTrainingDTO", performTrainingService.newTraining(id));
        return "training/newTraining";
    }

    @PostMapping
    public String json(@ModelAttribute NewTrainingDTO newTrainingDTO) {
        performTrainingService.save(newTrainingDTO);
        return "redirect:history";
    }


//    @PostMapping("{id}")
//    @ResponseBody
//    public String json(String json,@PathVariable Long id) {
//        System.out.println(json);
//        return json;
//    }

//    @PostMapping("{id}")
//    @ResponseBody
//    public String json(@PathVariable String id, @RequestBody String trainingSessionId,
//                       @RequestParam List<String> exerciseId,
//                       @RequestParam ) {
////        redirectAttributes.addFlashAttribute("json",json);
//        System.out.println(trainingSessionId);
//        System.out.println(exerciseId);
//        return exerciseId.toString();
////        return "redirect:performTraining/training";
//
//    }

//    @GetMapping("/training")
//    @ResponseBody
//    public String printJson(@ModelAttribute("json") String json){
//        System.out.println(json);
//        return json;
//    }
}

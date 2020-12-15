package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dzienniktreningowy.services.TrainingService;

@RequiredArgsConstructor
@RequestMapping("user/history")
@Controller
public class TrainingHistoryController {
    private final TrainingService trainingService;


    @GetMapping
//    @ResponseBody
    public String getHistory(Model model) {
        model.addAttribute("trainings", trainingService.getDTOList());
//        return trainingService.getDTOList().toString();
        return "training/generalHistory";
    }

    @GetMapping("training/{id}")
//    @ResponseBody
    public String getTrainingHistory(@PathVariable Long id, Model model) {
        model.addAttribute("training", trainingService.getTrainingDTOById(id));
//        return trainingService.getTrainingDTOById(id).toString();
        return "training/history";
    }
}

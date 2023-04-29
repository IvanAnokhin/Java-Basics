package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;


@Controller
public class DefaultController {
    @Autowired
    private ToDoRepository toDoRepository;
    @Value("${someParameter}")
    private Integer someParameter;
    @RequestMapping("/")
    public String index(Model model){
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> toDos = new ArrayList<>();
        for (ToDo toDo : toDoIterable){
            toDos.add(toDo);
        }
        model.addAttribute("list", toDos);
        model.addAttribute("todoCount", toDos.size());
        model.addAttribute("someParameter", someParameter);
        return "index";
    }
}
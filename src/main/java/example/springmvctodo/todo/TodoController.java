package example.springmvctodo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("todos", todoService.retrieveTodos("in28Minutes"));
        model.addAttribute("message", "Hello Spring MVC 5!");
        return "index";
    }

    @PostMapping("/")
    public String addTodo(ModelMap model, @RequestParam String name) {
        todoService.addTodo("in28Minutes", name, new Date(), false);
//        model.clear();// to prevent request parameter "name" to be passed
        return "redirect:/";
    }
}

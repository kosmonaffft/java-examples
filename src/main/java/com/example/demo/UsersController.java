package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class UsersController {

    public static Map<String, Object> DB = new HashMap<>() {{
        put("1", new HashMap<String, String>() {{
            put("firstname", "Anton");
            put("lastname", "Ivanov");
        }});
        put("2", new HashMap<String, String>() {{
            put("firstname", "Ivan");
            put("lastname", "Kuznetsov");
        }});
        put("42", new HashMap<String, String>() {{
            put("firstname", "Petrov");
            put("lastname", "Petr");
        }});
    }};

    @GetMapping("/all")
    public String getAll(Model model) {
        Set<String> keys = DB.keySet();
        List<User> users = new ArrayList<>();
        for (String key : keys) {
            HashMap<String, String> o = (HashMap<String, String>) DB.get(key);
            User user = new User(key, o.get("firstname"), o.get("lastname"));
            users.add(user);
        }
        model.addAttribute("users", users);
        return "all";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String doAdd(String id,
                        String firstname,
                        String lastname) {

        DB.put(id, new HashMap<String, String>() {{
            put("firstname", firstname);
            put("lastname", lastname);
        }});
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        DB.remove(id);
        return "redirect:/all";
    }
}

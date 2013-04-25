package com.bo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Users.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
@Controller
@RequestMapping("/user")
public class UsersController {

    private int nextId;
    private Map<Integer, User> users = new LinkedHashMap<Integer, User>();

    public UsersController() {
        add();
        add();
        add();
    }

    @RequestMapping("/read")
    @ResponseBody
    public List<User> read() {
        return new ArrayList<User>(users.values());
    }

    @RequestMapping("/create")
    @ResponseBody
    public User create() {
        User user = add();
        System.out.println("CREATE: " + user);
        return user;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody User user) {
        users.put(user.getId(), user);
        System.out.println("UPDATE: " + user);
    }

    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    @ResponseBody
    public void destroy(@RequestBody User[] users) {
        for (User user : users) {
            this.users.remove(user.getId());
            System.out.println("DESTROY: " + user);
        }
    }

    private User add() {
        int id = nextId++;
        User user = new User(id, "user-" + id, "user-" + id + "@mail.com");
        users.put(id, user);
        return user;
    }

}

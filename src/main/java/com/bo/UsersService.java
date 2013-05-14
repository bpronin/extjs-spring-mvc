package com.bo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Users.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
@Controller
@RequestMapping("/user")
public class UsersService {

    private List<User> users = new ArrayList<User>();

    public UsersService() {
        for (int i = 0; i < 100; i++) {
            add();
        }
    }

    @RequestMapping("/read")
    @ResponseBody
    public Users read(@RequestParam int start, @RequestParam int limit) {
        int size = users.size();
        int end = start + limit;
        if (end > size) {
            end = size;
        }
        System.out.println("GET: " + start + " : " + end);
        return new Users(users.subList(start, end), size);
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
    public void update(@RequestBody User[] users) {
        for (User user : users) {
            this.users.set(user.getId(), user);
            System.out.println("UPDATE: " + user);
        }
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
        int id = users.size();
        int no = id + 1;
        User user = new User(id, "user-" + no, "user-" + no + "@mail.com");
        users.add(user);
        return user;
    }

}

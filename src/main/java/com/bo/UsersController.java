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
@RequestMapping("/data")
public class UsersController {

    private Map<Integer, User> users = new LinkedHashMap<Integer, User>();

    public UsersController() {
        users.put(0, new User(0, "user 0", "user-0@mail.com"));
        users.put(1, new User(1, "user 1", "user-1@mail.com"));
        users.put(2, new User(2, "user 2", "user-2@mail.com"));
    }

    @RequestMapping("/read.json")
    @ResponseBody
    public List<User> read() {
        return new ArrayList<User>(users.values());
    }

    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody User user) {
        System.out.println("UPDATE:" + user);
        users.put(user.getId(), user);
    }

}

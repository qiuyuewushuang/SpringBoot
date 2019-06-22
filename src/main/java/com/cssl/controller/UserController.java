package com.cssl.controller;

import com.cssl.pojo.Street;
import com.cssl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UserController {

    @RequestMapping("/validate")
    public String validate(User user, HttpServletRequest request){
        request.setAttribute("user",user);
        request.setAttribute("age","32");
        System.out.println(user.getBirthday());
        return "success";
    }

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("name","张三");
        model.addAttribute("pwd","123456");
        return "info";
    }

    @RequestMapping("/listString")
    public String list(@RequestParam List<String> list, Model model){
        System.out.println("list===="+list);
        for (String s : list) {
            System.out.println("list:"+s);
        }
        model.addAttribute("list",list);
        return "listInfo";
    }

    @RequestMapping("/map")
    public String map(@RequestParam Map<String,Object> map, Model model){
        System.out.println("map===="+map);
        Set<String> set=map.keySet();
        for (String s : set) {
            System.out.println("map:"+map.get(s));
        }
        model.addAttribute("map",map);
        return "listInfo";
    }

    @RequestMapping("/index")
    public String index(@ModelAttribute(name = "path") String path){
        return "index";
    }

    @RequestMapping("/param")
    public String page(@ModelAttribute(name = "name") String name, @ModelAttribute(name = "age") String age, HttpSession session){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("hello world");
        session.setAttribute("context","hello world");
        return "param";
    }

    @RequestMapping("/ajax")
    public Map ajax(@RequestParam Map<String,Object> map){
        System.out.println(map);
        return map;
    }

    @RequestMapping("/select")
    public String select(Model model){
        Street s1=new Street(1,"张三");
        Street s2=new Street(2,"李四");
        Street s3=new Street(3,"王五");
        Street s4=new Street(4,"赵六");
        List<Object> list=new ArrayList<Object>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        model.addAttribute("ss",s2);
        model.addAttribute("list",list);
        return "select";
    }

    @RequestMapping("/mapTest")
    public String mapTest(@RequestParam Map<String,Object> map,Model model){
        model.addAttribute("map",map);
        return "map";
    }
}

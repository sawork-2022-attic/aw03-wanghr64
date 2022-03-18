package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("categories", posService.categories());
        return "index";
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "pid") String pid, Model model) {
        posService.add(pid, 1);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("categories", posService.categories());
        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "pid") String pid, Model model) {
        posService.delete(pid);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("categories", posService.categories());
        return "index";
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "pid") String pid, Model model) {
        posService.modify(pid, -1);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("categories", posService.categories());
        return "index";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "pid") String pid, Model model) {
        posService.add(pid, 1);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("categories", posService.categories());
        return "index";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        posService.clear();
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("categories", posService.categories());
        return "index";
    }

    @GetMapping("/category")
    public String catogory(@RequestParam(name = "cate") String cate, Model model) {
        model.addAttribute("products", posService.products(cate));
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("categories", posService.categories());
        return "index";
    }

}

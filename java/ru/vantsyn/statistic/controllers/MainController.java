package ru.vantsyn.statistic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vantsyn.statistic.model.entity.Page2User;
import ru.vantsyn.statistic.model.services.Page2UserService;
import ru.vantsyn.statistic.model.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    private final UserService userService;
    private final Page2UserService page2UserService;

    public MainController(UserService userService, Page2UserService page2UserService) {
        this.userService = userService;
        this.page2UserService = page2UserService;
    }

    @GetMapping("/")
    public String mainPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Page2User page2User = (Page2User) session.getAttribute("mainPage");
        if (page2User == null) {
            page2User = page2UserService.getPageToUser((int) session.getAttribute("userId"), "/");
            session.setAttribute("mainPage", page2User);
        }
        page2UserService.updateViews(page2User);

        model.addAttribute("usersCount", page2UserService.getUsersCountForPage("/"));

        return "index";
    }

    @GetMapping("/detail/")
    public String detailPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Page2User page2User = (Page2User) session.getAttribute("detailPage");
        if (page2User == null) {
            page2User = page2UserService.getPageToUser((int) session.getAttribute("userId"), "/detail/");
            session.setAttribute("detailPage", page2User);

        }
        page2UserService.updateViews(page2User);

        model.addAttribute("usersCount", page2UserService.getUsersCountForPage("/detail/"));
        model.addAttribute("userViewsCount", page2UserService.getUserViewsCount((int) session.getAttribute("userId")));
        model.addAttribute("mainPageViews", page2UserService.
                getUserViewsCountByPage((int) session.getAttribute("userId"), "/"));
        model.addAttribute("detailPageViews", page2UserService.
                getUserViewsCountByPage((int) session.getAttribute("userId"), "/detail/"));
        model.addAttribute("allUsersPageViews", page2UserService.
                getUserViewsCountByPage((int) session.getAttribute("userId"), "/all-users/"));

        return "detail-page";
    }

    @GetMapping("/all-users/")
    public String allUsersPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Page2User page2User = (Page2User) session.getAttribute("allUsersPage");
        if (page2User == null) {
            page2User = page2UserService.getPageToUser((int) session.getAttribute("userId"), "/all-users/");
            session.setAttribute("allUsersPage", page2User);
        }
        page2UserService.updateViews(page2User);

        model.addAttribute("usersCount", userService.getUsersCount());
        model.addAttribute("usersOnPageCount", page2UserService.getUsersCountForPage("/all-users/"));
        model.addAttribute("allUsersViewsCount", page2UserService.getAllUserViewsCount());
        model.addAttribute("allUsersViewsCountOnMainPage", page2UserService.getViewsCountByPage("/"));
        model.addAttribute("allUsersViewsCountOnDetailPage", page2UserService.getViewsCountByPage("/detail/"));
        model.addAttribute("allUsersViewsCountOnAllUsersPage", page2UserService.getViewsCountByPage("/all-users/"));

        return "all-users-page";
    }
}


package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.mypage.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/mypage")
    public String myPage(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("myPageInfo", myPageService.getMyPage(user.getEmail()));
        }
        return "mypage/mypage";
    }
}
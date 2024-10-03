package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepo;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private MemberRepo memberRepo = MemberRepo.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(userName, age);
        memberRepo.save(member);

        //model 에 데이터를 보관한다.
        req.setAttribute("member", member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);

    }
}

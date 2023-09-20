package org.zerock.demo.todo;

import org.zerock.demo.todo.dtd.TodoDTO;
import org.zerock.demo.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoReadController", urlPatterns="/todo/read")
public class TodoReatController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/read");

//         /todo/read?tno=123  (게시물 번호 123 조회)

        Long tno = Long.parseLong(req.getParameter("tno"));  // Long 타입으로 변환

        TodoDTO dto = TodoService.INSTANCE.get(tno);

        req.setAttribute("dto", dto);  // 데이터 저장,

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req,resp);// jsp로 전달


    }

}

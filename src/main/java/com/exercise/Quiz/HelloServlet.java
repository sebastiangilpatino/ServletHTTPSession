package com.exercise.Quiz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // set session scoped attribute
        HttpSession session = request.getSession();

        if (session.getAttribute("quiz") == null) {
            session.setAttribute("quiz", new QuestionAnswer());
        }//create a session if not exist

        QuestionAnswer questionAnswer = (QuestionAnswer) session.getAttribute("quiz"); //bring objects store in sess
        questionAnswer.setUserAns(request.getParameter("answer")); // set the user answer
        int index = questionAnswer.getIndex() + 1; //next index of quest and answer
        questionAnswer.setIndex(index); //set index to classes

        if (questionAnswer.getUserAns().equals(questionAnswer.getAnswers(index - 1))) { //if the answer its +1
            questionAnswer.setScore(questionAnswer.getScore() + 1);
        }

        out.println("<html><body>");
        out.println("<h1>The Number Quiz</h1>");
        out.println("<p>Your current score is: " + questionAnswer.getScore() + "</p>");
        if (index < 5) {
            out.println("<p>Guess the next number in the sequence</p>");
            out.println("<p>" + questionAnswer.getQuestions(index) + "</p>");
            out.println("<form action='hello-servlet' method='get'>");
            out.println("<div>Your answer:  <input type='text' name='answer'></div>");
            out.println("<br><input type='submit'></form>");
        } else {
            out.println("You have completed the Number Quiz, with a score of " + questionAnswer.getScore() + " out of 5");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
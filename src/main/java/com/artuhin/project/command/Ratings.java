package com.artuhin.project.command;

import com.artuhin.project.factory.ServiceFactory;
import com.artuhin.project.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Ratings implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<List<User>> masters = ServiceFactory.getInstance().getUserService().getAllMastersBySpecilizationSortByRating();
        req.setAttribute("ratings", masters);
        return "pages/ratings.jsp";
    }
}

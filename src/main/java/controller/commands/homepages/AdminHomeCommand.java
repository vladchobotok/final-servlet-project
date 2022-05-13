package controller.commands.homepages;

import constants.HospitalJspPaths;
import controller.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminHomeCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(HospitalJspPaths.ADMIN_HOME).forward(request, response);
    }
}

package controller.commands.admin;

import constants.HospitalJspPaths;
import constants.HospitalUriPaths;
import controller.commands.Command;
import model.entity.User;
import utils.validation.AuthenticationValidation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class RegisterDoctor implements Command {
    private final AuthenticationValidation authenticationValidation = new AuthenticationValidation();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        LocalDate birthday;
        if(!request.getParameter("birthday").equals("")){
            birthday = Date.valueOf((request.getParameter("birthday"))).toLocalDate();
        }
        else {
            birthday = null;
        }
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        int role = 2;
        int doctorType = 3;
        if(request.getParameter("doctorType") != null) {
            doctorType = Integer.parseInt(request.getParameter("doctorType"));
        }

        User regUser = new User(name, surname, birthday, email, password, role);

        if (authenticationValidation.registerDoctor(regUser, confirmPassword, doctorType, request)) {
            response.sendRedirect(HospitalUriPaths.ADMIN_HOME);
            return;
        }

        request.getRequestDispatcher(HospitalJspPaths.REGISTER_DOCTOR).forward(request, response);
    }
}

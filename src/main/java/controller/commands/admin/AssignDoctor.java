package controller.commands.admin;

import constants.HospitalJspPaths;
import controller.commands.Command;
import model.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.HospitalUriPaths.ADMIN_HOME;

public class AssignDoctor implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("patientId"));
        int docId;
        if(request.getParameter("doctorId") != null){
            docId = Integer.parseInt(request.getParameter("doctorId"));
        }
        else {
            request.setAttribute("bad_getaway", "emptyDoctor");
            request.getRequestDispatcher(HospitalJspPaths.ADMIN_HOME).forward(request, response);
            return;
        }

        PatientService service = new PatientService();
        service.assignDoctor(docId, id);

        response.sendRedirect(ADMIN_HOME);
    }
}

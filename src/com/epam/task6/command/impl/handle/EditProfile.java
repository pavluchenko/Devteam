package com.epam.task6.command.impl.handle;

import com.epam.task6.command.Command;
import com.epam.task6.command.CommandException;
import com.epam.task6.dao.DAOException;
import com.epam.task6.dao.impl.UserDAOImpl;
import com.epam.task6.domain.user.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by olga on 18.05.15.
 */
public class EditProfile extends Command {
    private static EditProfile instance = new EditProfile();
    private static Logger logger = Logger.getLogger(DeleteProject.class);
    private static final String MSG_EXECUTE_ERROR = "logger.error.execute.create.order";
    private static final String ATTRIBUTE_USER = "user";
    private static final String ATTRIBUTE_FIRST_NAME = "firstName";
    private static final String ATTRIBUTE_LAST_NAME = "lastName";
    private static final String ATTRIBUTE_EMAIL = "email";
    private static final String ATTRIBUTE_PASS1 = "pass1";
    private static final String ATTRIBUTE_PASS2 = "pass2";


    public static EditProfile getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ATTRIBUTE_USER);
        String firstName = request.getParameter(ATTRIBUTE_FIRST_NAME);
        String lastName = request.getParameter(ATTRIBUTE_LAST_NAME);
        String email = request.getParameter(ATTRIBUTE_EMAIL);
        String pass1 = request.getParameter(ATTRIBUTE_PASS1);
        String pass2 = request.getParameter(ATTRIBUTE_PASS2);

        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        try {
            if (pass1.equals(pass2)) {
                userDAO.updateUserProfile(firstName, lastName, email, pass1, user.getId());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return "Controller?executionCommand=SHOW_SPECIFICATIONS";
    }
}

package basicclass;

import dao.MicropostDAO;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.UserDAO;
import entity.Micropost;
import entity.User;

public class TestMySQL {

    public static void main(String[] args) {
        try {
//            UserDAO userDAO = new UserDAO();

//            //create user
//            User newUser = new User();
//            newUser.setName("Nguyen Minh Duc22222");
//            newUser.setEmail("ottffssent9892227@gmail.com");
//            SimpleDateFormat dateformat2 = new SimpleDateFormat("MM/dd/yyyy");
//            newUser.setBirthDay(dateformat2.parse("01/09/1998"));
//            userDAO.create(newUser);

//            //list all user
//            List<User> users = userDAO.all();
//            for (User user : users) {
//                System.out.println(user);
//            }

//            //find and delete user
//            userDAO.delete(userDAO.find(3));

//            //update user
//            User user = new User();
//            user.setId(2);
//            user.setName("hahaha");
//            user.setEmail("@@@@@");
//            SimpleDateFormat dateformat2 = new SimpleDateFormat("MM/dd/yyyy");
//            user.setBirthDay(dateformat2.parse("01/09/1998"));
//            userDAO.update(user);
            MicropostDAO micropostDAO = new MicropostDAO();
            
//            //create micropost
//            Micropost micropost = new Micropost();
//            micropost.setUser_id(1);
//            micropost.setContent("hahahahahahahahhahahahahahhaha");
//            micropostDAO.create(micropost);

            //count content
            micropostDAO.subquery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

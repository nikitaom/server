package main.receiver;

import main.entity.Data;
import main.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import static org.apache.naming.factory.Constants.FACTORY;

@Component
public class UserReceiver {

    @Autowired
    private UserService userService;

    @Transactional
    @JmsListener(destination = "server", containerFactory = FACTORY)
    @SendTo("client")
    public Data userOperations(Data data) {
        switch (data.getOperation()) {
            case "SAVE":
                userService.saveAll(data.getUserList());
                data.setOperation("SAVED");
                break;
            case "DELETE":
                userService.deleteAll(data.getUserList());
                data.setOperation("DELETED");
                break;
            case "SHOW_ALL":
                data.setUserList(userService.findAll());
                data.setOperation("RETURNED");
                break;
        }
        return data;
    }
}

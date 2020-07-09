package edu.escuelaing.arsw.tictactoe.controller;

import edu.escuelaing.arsw.tictactoe.entity.Room;
import edu.escuelaing.arsw.tictactoe.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/create")
    public void savePoints(@RequestBody List<String> room){
        Room r = new Room(room.get(0), room.get(1));
        roomService.create(r);
    }
        
}

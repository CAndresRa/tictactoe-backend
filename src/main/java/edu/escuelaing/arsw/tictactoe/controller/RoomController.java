package edu.escuelaing.arsw.tictactoe.controller;

import edu.escuelaing.arsw.tictactoe.entity.Room;
import edu.escuelaing.arsw.tictactoe.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/obtainstatesave")
    public String sendLastState(@RequestParam(value = "name") String roomName){
        List<Room> r = roomService.sendLastState(roomName);
        return r.get(0).getSaveState();
    }
}

package edu.escuelaing.arsw.tictactoe.services.impl;

import edu.escuelaing.arsw.tictactoe.entity.Room;
import edu.escuelaing.arsw.tictactoe.repository.RoomRepository;
import edu.escuelaing.arsw.tictactoe.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Boolean existRoom(String roomName) {
        return roomRepository.existsById(roomName);
    }

    @Override
    public List<Room> sendLastState(String roomName) {
        List<Room> rooms = roomRepository.findByName(roomName);
        return rooms;
    }

}


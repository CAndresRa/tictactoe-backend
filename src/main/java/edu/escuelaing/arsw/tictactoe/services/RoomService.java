package edu.escuelaing.arsw.tictactoe.services;

import edu.escuelaing.arsw.tictactoe.entity.Room;

import java.util.List;

public interface RoomService {

    /**
     * @param room
     * @return add room in database
     */
    Room create(Room room);

    Boolean existRoom(String roomName);

    List<Room> sendLastState(String roomName);

}

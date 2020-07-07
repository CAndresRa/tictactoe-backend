package edu.escuelaing.arsw.tictactoe.services;

import edu.escuelaing.arsw.tictactoe.entity.Room;

public interface RoomService {

    /**
     * @param room
     * @return add room in database
     */
    Room create(Room room);

}

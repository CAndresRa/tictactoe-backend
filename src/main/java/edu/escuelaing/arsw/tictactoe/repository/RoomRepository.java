package edu.escuelaing.arsw.tictactoe.repository;

import edu.escuelaing.arsw.tictactoe.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

}

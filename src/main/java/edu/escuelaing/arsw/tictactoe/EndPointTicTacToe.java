package edu.escuelaing.arsw.tictactoe;
import java.io.IOException;
import java.util.logging.Level;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;


@Component
@ServerEndpoint("/tictactoe/{room}")
public class EndPointTicTacToe {
    private static final Logger logger = Logger.getLogger(EndPointTicTacToe.class.getName());
    /* Queue for all open WebSocket sessions */
    private Queue<Room> rooms = new ConcurrentLinkedQueue<>();
    private Queue<String> namesOfRooms = new ConcurrentLinkedQueue<>();
    Session ownSession = null;

    @OnOpen
    public void openConnection(Session session, @PathParam("room") String room) {
        /* Register this connection in the queue */
        if(namesOfRooms.contains(room)){
            for(Room r : rooms){
                if(r.getName().equals(room)){
                    r.addSession(session);
                }
            }
        }
        else {
            Room r = new Room(room);
            namesOfRooms.add(room);
            rooms.add(r);
            r.addSession(session);
        }
        ownSession = session;
        logger.log(Level.INFO, "Connection opened.");
        try {
            session.getBasicRemote().sendText("Connection established.");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

    }
}

package edu.escuelaing.arsw.tictactoe;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@ServerEndpoint("/room/{room}")
public class EndPointToGame {
    static Queue<Room> rooms = new ConcurrentLinkedQueue<>();
    static Queue<String> namesOfRooms = new ConcurrentLinkedQueue<>();

    private static final Logger logger = Logger.getLogger(EndPointTicTacToe.class.getName());
    Session ownSession = null;

    @OnOpen
    public void openConnection(Session session, @PathParam("room") String room) {
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

        System.out.println(rooms);

        for(Room r : rooms ){
            for(Session s: r.getMySessions()) {
                System.out.println(r.getMySessions().size()  + " " + r.getName());
                System.out.println(s + " pertenece " + r.getName());
            }
        }
    }

    /* Call this method to send a message to all clients */
    public void send(String message, Session session) throws IOException {
        Room isInRoom = null;
        for(Room r: rooms){
            for(Session s: r.getMySessions()){
                if(s.equals(session)){
                    isInRoom = r;
                    break;
                }
            }
        }
        broadcast(isInRoom, session , message);
    }

    public  void broadcast(Room room, Session session, String message) throws IOException {

        for(Session s: room.getMySessions()){
            if(!s.equals(session)){
                s.getBasicRemote().sendText(message);
            }
        }
    }

    @OnMessage
    public void processPoint(String message, Session session) throws IOException {
        System.out.println("Point received:" + message + ". From session: " + session);
        this.send(message, session);
    }

}

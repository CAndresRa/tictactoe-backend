package edu.escuelaing.arsw.tictactoe;

import javax.websocket.Session;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Room {
    private String name;
    private Queue<Session> mySessions;

    public Room(String name){
        this.name = name;
        this.mySessions = new ConcurrentLinkedQueue<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Session> getMySessions() {
        return mySessions;
    }

    public void setMySessions(Queue<Session> mySessions) {
        this.mySessions = mySessions;
    }

    public void addSession(Session session){
        mySessions.add(session);
    }

}

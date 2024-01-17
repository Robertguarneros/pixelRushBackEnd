package edu.upc.dsa.manager;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.*;

import java.sql.SQLException;
import java.util.List;

public interface Manager {
    public int numberOfUsers();
    public Users getUser(String username)throws UsernameDoesNotExistException;
    public List<Users> getAllUsers();
    public void register(String username, String password, String mail, String name, String surname,  String birthDate) throws UsernameDoesExist, SQLException, UsernameDoesNotExistException;
    public boolean login (String username, String password) throws UsernameDoesNotExistException, IncorrectPassword;
    public int storeSize();
    public void addObjectToStore(String objectID, String articleName, int price, String description) throws ObjectIDDoesNotExist;//create a new item available on the store
    public List<StoreObject>  getObjectListFromStore();
    public StoreObject getObject(String objectID)throws ObjectIDDoesNotExist;
    public void addItemToUser(String username, String objectID) throws UsernameDoesNotExistException, ObjectIDDoesNotExist,NotEnoughPoints, AlreadyOwned; //add ObjectID to users list of objects
    public List<OwnedObjects> getOwnedObjects(String username)throws UsernameDoesNotExistException;
    public void createMatch(String username) throws UsernameDoesNotExistException, UsernameIsInMatchException;
    public int getLevelFromMatch(String username) throws UsernameDoesNotExistException, UsernameisNotInMatchException;
    public int getMatchTotalPoints(String username) throws UsernameDoesNotExistException, UsernameisNotInMatchException;
    public void nextLevel(String username, int points) throws UsernameDoesNotExistException, UsernameisNotInMatchException, SQLException;
    public void endMatch(String username) throws UsernameDoesNotExistException, UsernameisNotInMatchException, SQLException;
    public List<Matches> getPlayedMatches(String username)throws UsernameDoesNotExistException;
    public Matches getLastMatch(String username);

    //Minimo  2
    public void askQuestion(Question question);
    public void sendReport(Report report);
    public List<Message> getMessages();
    public void addMessage(String message);
}
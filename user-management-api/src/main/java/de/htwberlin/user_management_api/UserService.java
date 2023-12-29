package de.htwberlin.user_management_api;

/**
 * Eine Schnittstelle für das User-management.
 * Diese Schnittstelle definiert Methoden zur Erzeugung von Usern.
 */
public interface UserService {

    /**
     * Erzeugt einen neuen User mit dem angegebenen Namen.
     *
     * @param name Der Name des Benutzers der erstellt werden soll.
     * @return Ein Benutzerobjekt mit dem angegebenen Namen.
     * @throws InvalidNameException wenn der Name ungültig ist.
     */
    User createUser(String name) throws InvalidNameException;

}

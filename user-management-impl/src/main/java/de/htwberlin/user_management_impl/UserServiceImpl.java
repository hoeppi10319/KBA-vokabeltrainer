package de.htwberlin.user_management_impl;


import de.htwberlin.user_management_api.InvalidNameException;
import de.htwberlin.user_management_api.User;
import de.htwberlin.user_management_api.UserService;

/**
 * Implementierung des {@link UserService} Interface.
 * Diese Klasse ermöglicht die Erstellung eines Users mit einem gültigen Namen.
 */

public class UserServiceImpl implements UserService {

    /**
     * Erstellt einen neuen Benutzer mit dem angegebenen Namen.
     *
     * @param name Der Name des Benutzers, der erstellt werden soll.
     * @return Ein User mit dem angegebenen Namen.
     * @throws InvalidNameException wenn der Name ungültig ist.
     */
    @Override
    public User createUser(String name) throws InvalidNameException {
        if (!isValidName(name)) {
            throw new InvalidNameException("Name not valid!");
        }
        return new User(name);
    }

    /**
     * Überprüft, ob ein Name gültig ist. Ein gültiger Name enthält nur Buchstaben (A-Z, a-z) und Zahlen (0-9)
     * und ist nicht leer.
     *
     * @param name Der zu überprüfende Name.
     * @return true, wenn der Name gültig ist, andernfalls false.
     */
    private boolean isValidName(String name) {
        // Überprüfen, ob der Name nur Buchstaben (A-Z, a-z) und Zahlen (0-9) enthält
        // und nicht leer ist
        return name != null && !name.isEmpty() && name.matches("^[a-zA-Z0-9]+$");
    }
}

/**
 * PROG5121 - Part 1
 * =====================
 * Login.java
 *
 * Handles user registration and authentication.
 *
 * USERNAME RULES:
 *   - Must contain an underscore (_)
 *   - Must be no longer than 5 characters
 *
 * PASSWORD RULES:
 *   - At least 8 characters
 *   - At least one uppercase letter
 *   - At least one digit (0–9)
 *   - At least one special character (non-alphanumeric)
 */
public class Login {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;

    // ----------------------------------------------------------------
    // Constructor
    // ----------------------------------------------------------------
    public Login(String firstName, String lastName,
                 String username,  String password) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.username  = username;
        this.password  = password;
    }

    // ----------------------------------------------------------------
    // checkUserName()
    //   Returns true if username contains '_' AND length <= 5
    // ----------------------------------------------------------------
    public boolean checkUserName() {
        if (username == null || username.isEmpty()) return false;
        return username.contains("_") && username.length() <= 5;
    }

    // ----------------------------------------------------------------
    // checkPasswordComplexity()
    //   Returns true if ALL four password rules are satisfied
    // ----------------------------------------------------------------
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper   = false;
        boolean hasDigit   = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if      (Character.isUpperCase(c))      hasUpper   = true;
            else if (Character.isDigit(c))          hasDigit   = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    // ----------------------------------------------------------------
    // registerUser()
    //   Returns a descriptive message covering every failure combination
    // ----------------------------------------------------------------
    public String registerUser() {
        boolean validUser = checkUserName();
        boolean validPass = checkPasswordComplexity();

        if (!validUser && !validPass) {
            return "Username is not correctly formatted, please ensure that your "
                 + "username contains an underscore and is no more than five "
                 + "characters in length.\n"
                 + "Password is not correctly formatted, please ensure that the "
                 + "password contains at least 8 characters, a capital letter, "
                 + "a number and a special character.";
        }
        if (!validUser) {
            return "Username is not correctly formatted, please ensure that your "
                 + "username contains an underscore and is no more than five "
                 + "characters in length.";
        }
        if (!validPass) {
            return "Password is not correctly formatted, please ensure that the "
                 + "password contains at least 8 characters, a capital letter, "
                 + "a number and a special character.";
        }
        return "Username successfully captured.\nPassword successfully captured.";
    }

    // ----------------------------------------------------------------
    // loginUser(username, password)
    //   Returns true only when BOTH supplied credentials match exactly
    // ----------------------------------------------------------------
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (enteredUsername == null || enteredPassword == null) return false;
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // ----------------------------------------------------------------
    // returnLoginStatus(username, password)
    //   Returns welcome message on success, error message on failure
    // ----------------------------------------------------------------
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName
                 + ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }

    // ----------------------------------------------------------------
    // Getters
    // ----------------------------------------------------------------
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
    public String getUsername()  { return username;  }
}

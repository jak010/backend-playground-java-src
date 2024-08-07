package common;

public interface CruiseControl {

    public void grantAccess(User u);

    public void grantAdminAccess(User u);

    public void logUnauthorizedAccessAttempt();
}

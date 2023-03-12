package service;


import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * @Description development team management: add, delete function
 */
public class TeamService {

    private static int counter = 1;  // memberId for the programmer in the team
    private final int MAX_MEMBER = 5;  // the max member in a team;
    private Programmer[] team = new Programmer[MAX_MEMBER]; // store the Programmer;
    private int total; // record the actual number of member in the team;

    public TeamService() {
    }

    /**
     * get the member in the team. created new programmer array to avoid return array with empty member.
     * @return the new created array which store the member in the team.
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * add the specific programmer into the team.
     * @param e the employee which will join the team.
     */
    public void addMember(Employee e) throws TeamException {
        // check if the team is full
        if (total >= MAX_MEMBER) {
            throw new TeamException("The team is full, can't add member");
        }

        // check if the employee is a programmer
        if  (!(e instanceof Programmer)) {
            throw new TeamException("This member is not a programmer");
        }

        // check if the employee is in the team
        if (isExist(e)) {
            throw new TeamException("This member is already in the team");
        }

        Programmer p = (Programmer) e; // will not occur ClassCastException
        // check if the employee is available
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("The member belongs to other team");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("This member is on the vocation");
        }

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDes++;
            else if (team[i] != null) numOfPro++;
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("Team can have at most 1 Architect");
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) throw new TeamException("Team can have at most 2 Designer");
        } else {
            if (numOfPro >= 3) throw new TeamException("Team can have at most 3 Programmer");
        }

        // add this member into team.
        team[total++] = p;
        // set this member property
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * remove member in the team
     * @param memberId the memberId of the member who will be removed
     */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        // the member id doesn't match any member
        if (i == total) {
            throw new TeamException("Can't fine the specific member with member id");
        }

        // replace member from i to total-1 with their next member to implement delete
        for (int j = i+1; j < total; j++) {
            team[j-1] = team[j];
        }

        // set the last member to null
        team[--total] = null;
    }

    /**
     * Check if the employee is in the team
     * @param e the employee
     * @return true if the employee is in the team, else false
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()){
                return true;
            }
        }

        return false;
    }
}

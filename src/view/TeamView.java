package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {

    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu(){
        boolean flag = true;
        char menu = 0;
        while(flag){
            if (menu != '1') listAllEmployees();
            System.out.println("\"1-Team list 2-Add team member 3-Delete member 4-Exit please choose(1-4): \"");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("Confirm exit?(Y/N)");
                    char confirm = TSUtility.readConfirmSelection();
                    if (confirm == 'Y') {
                        System.out.println("The system exit");
                        flag = false;
                    }
            }
        }
    }

    /**
     * display the information of all employees
     */
    private void listAllEmployees(){
        System.out.println("----------------------------------------------------------------------");

        Employee[] employees = listService.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("No employee information in the program");
        } else {
            System.out.println("ID\tname\tage\tsalary\trole\tbonus\tstock\tequipment");
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
        System.out.println("--------------------------------------------------------------------");
    }

    /**
     * This method will get the team information
     */
    private void getTeam() {
        System.out.println("----------------------------Team list--------------------------------");
        Programmer[] team = teamService.getTeam();
        if (team.length == 0) {
            System.out.println("The team has no member currently");
        } else {
            System.out.println("TID/ID\tname\tage\tsalary\trole\tbonus\tstock");
            for (Programmer programmer : team) {
                System.out.println(programmer.getDetailForTeam());
            }
        }

        System.out.println("--------------------------------------------------------------------");
    }

    /**
     * This method will add member to the team
     */
    private void addMember(){
        System.out.println("--------------------------------add member -------------------------");
        System.out.println("Please enter the employee ID");
        int id = TSUtility.readInt();
        try{
            Employee e = listService.getEmployeeById(id);
            teamService.addMember(e);
            System.out.println("Successfully added");
            TSUtility.readReturn();
        } catch (TeamException ex) {
            System.out.println("Fail to add member, "+ ex.getMessage());
        }
    }

    /**
     * This method will read user input from terminal and delete the member in the team according to the input
     */
    private void deleteMember(){
        System.out.println("------------------------------delete member-------------------------");
        System.out.println("Please enter the TID of the member");
        int tid = TSUtility.readInt();
        System.out.println("Confirm deletion?(Y/N)");
        char confirm = TSUtility.readConfirmSelection();
        if (confirm == 'Y') {
            try{
                teamService.removeMember(tid);
                System.out.println("Successfully delete");

            } catch (TeamException ex) {
                System.out.println("Deletion failed, "+ ex.getMessage());
            }
            TSUtility.readReturn();
        }
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}

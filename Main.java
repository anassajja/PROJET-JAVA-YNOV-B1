import Project_java.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n**** MAIN MENU ****");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Logout");
            System.out.println("4. Competition");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    User.login();
                    break;

                case 2:
                    User.register();
                    break;

                case 3:
                    User.logout();

                    break;
                case 4:
                    System.out.println("\n**** COMPETITION MENU ****");
                    System.out.println("1.Team");
                    System.out.println("2.Match");
                    System.out.println("3.League");
                    System.out.println("4.Tournament");
                    System.out.println("5.Field");
                    System.out.println("6.Back");

                    System.out.print("Enter your choice: ");
                    Scanner input = new Scanner(System.in);
                    int subChoice = input.nextInt();
                    scanner.nextLine(); // consume the newline character

                    switch (subChoice) {
                        case 1:
                            System.out.println("\n**** TEAM MENU ****");
                            System.out.println("1. Create Team");
                            System.out.println("2. Edit Team");
                            System.out.println("3. Delete Team");
                            System.out.println("4. Play Match");
                            System.out.println("5. Play Competition");
                            System.out.println("6. Back");

                            System.out.print("Enter your choice: ");
                            int teamChoice = input.nextInt();

                            switch (teamChoice) {
                                case 1:
                                    Team.createTeam();
                                    break;
                                case 2:
                                    Team.editTeam();
                                    break;
                                case 3:
                                    Team.deleteTeam();
                                    break;
                                case 4:
                                    Team.playMatch();
                                    break;
                                case 5:
                                    Team.playCompetition();
                                    break;
                                case 6:
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                                    break;
                            }
                            break;

                        case 2:
                            System.out.println("\n**** MATCH MENU ****");
                            System.out.println("1. Create Match");
                            System.out.println("2. Edit Match");
                            System.out.println("3. Delete Match");
                            System.out.println("4. Invite User");
                            System.out.println("5. Remove User");
                            System.out.println("6. Add Referee");
                            System.out.println("7. Get One Match");
                            System.out.println("8. Get All Matches");
                            System.out.println("9. Back");

                            System.out.print("Enter your choice: ");
                            int matchChoice = input.nextInt();

                            switch (matchChoice) {
                                case 1:
                                    Match.createMatch();
                                    break;
                                case 2:
                                    Match.editMatch();
                                    break;
                                case 3:
                                    Match.deleteMatch();
                                    break;
                                case 4:
                                    Match.inviteUser();
                                    break;
                                case 5:
                                    Match.removeUser();
                                    break;
                                case 6:
                                    Match.addReferee();
                                    break;
                                case 7:
                                    Match.getOneMatch();
                                    break;
                                case 8:
                                    Match.getAllMatch();
                                    break;
                                case 9:
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                                    break;

                            }
                            break;

                        case 3:
                            System.out.println("\n**** LEAGUE MENU ****");
                            System.out.println("1. Create League");
                            System.out.println("2. Edit League");
                            System.out.println("3. Delete League");
                            System.out.println("4. start League");
                            System.out.println("5. End League");
                            System.out.println("6. play League Match");
                            System.out.println("9. Back");

                            System.out.print("Enter your choice: ");
                            int leagueChoice = input.nextInt();

                            switch (leagueChoice) {
                                case 1:
                                    League.createLeague();
                                    break;
                                case 2:
                                    League.editLeague();
                                    break;
                                case 3:
                                    League.deleteLeague();
                                    break;
                                case 4:
                                    League.startLeague();
                                    break;
                                case 5:
                                    League.endLeague();
                                    break;
                                case 6:
                                    League.playLeagueMatch();
                                    break;
                                case 7:
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                                    break;
                            }
                            break;

                        case 4:
                            System.out.println("\n**** TOURNAMENT MENU ****");
                            System.out.println("1. Create Tournament");
                            System.out.println("2. Edit Tournament");
                            System.out.println("3. Delete Tournament");
                            System.out.println("4. Invite Team");
                            System.out.println("5. Remove Team");
                            System.out.println("6. Get One Tournament");
                            System.out.println("7. Get All Tournaments");
                            System.out.println("8. End The Tournament");
                            System.out.println("9. Back");

                            System.out.print("Enter your choice: ");
                            int tournamentChoice = input.nextInt();

                            switch (tournamentChoice) {
                                case 1:
                                    Tournament.createTournament();
                                    break;
                                case 2:
                                    Tournament.editTournament();
                                    break;
                                case 3:
                                    Tournament.deleteTournament();
                                    break;
                                case 4:
                                    Tournament.inviteTeam();
                                    break;
                                case 5:
                                    Tournament.removeTeam();
                                    break;
                                case 6:
                                    Tournament.getOneTournamentByID();
                                    break;
                                case 7:
                                    Tournament.getAllTournamentsByID();
                                    break;
                                case 8:
                                    Tournament.endTheTournament();
                                    break;
                                case 9:
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                                    break;
                            }
                            break;

                        case 5:
                            System.out.println("\n**** FIELD MENU ****");
                            System.out.println("1. Terrain 1");
                            System.out.println("2. Terrain 2");
                            System.out.println("3. Terrain 3");
                            System.out.println("4. Terrain 4");
                            System.out.println("5. Back");

                            System.out.print("Enter your choice: ");
                            int fieldChoice = input.nextInt();

                            switch (fieldChoice) {
                                case 1:
                                    System.out.println("Terrain 1 reserved !");
                                    break;
                                case 2:
                                    System.out.println("Terrain 2 reserved !");
                                    break;
                                case 3:
                                    System.out.println("Terrain 3 reserved !");
                                    break;
                                case 4:
                                    System.out.println("Terrain 4 reserved !");
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Terrain 5 reserved !");
                                    break;
                            }
                            break;

                        case 6:
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;

                default:
                    System.out.println("See you soon !");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

}

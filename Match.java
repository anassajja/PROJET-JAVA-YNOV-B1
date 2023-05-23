package Project_java;
import java.util.*;

import static Project_java.Team.teamList;

public class Match {

    public static List<Match> matchList = new ArrayList<>(); // Déclaration de la liste à l'extérieur de createMatch()
    public static final List<String> userList = new ArrayList<>();
    public  String referee;
    public  String team2;
    public  String team1;

    public String date;

    public  String number;
    public  String userName;

    public String toString() {
        return "Match " + number + " | Date: " + date;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getNumber() {

        return number;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getDate() {

        return date;
    }

    public void setTeam1(String team1) {

        this.team1 = team1;
    }

    public String getTeam1() {

        return team1;
    }

    public void setTeam2(String team2) {

        this.team2 = team2;
    }

    public String getTeam2() {

        return team2;
    }

    public void setReferee(String referee) {

        this.referee = referee;
    }

    public String getReferee() {

        return referee;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }

    public void removeUser(String username) {

        userList.remove(username);
    }

    public List<String> getUserList() {

        return userList;
    }

    public static void createMatch() {
        Scanner scanner = new Scanner(System.in);

        // Création d'un nouveau match
        Match match = new Match();

        // Demande du numéro du match
        System.out.println("Please enter the match ID:");
        String matchNumber = scanner.nextLine();
        match.setNumber(matchNumber);
        System.out.println(match.getNumber());


        // Demande de la date du match
        System.out.println("Please enter the date of the match:");
        String matchDate = scanner.nextLine();
        match.setDate(matchDate);

        // Demande de la première équipe
        System.out.println("Please enter the name of the first team:");
        String teamName1 = scanner.nextLine();
        Team team1 = Team.getTeamByName(teamName1);
        if (team1 == null) {
            System.out.println("Team not found.");
            return;
        }
        match.setTeam1(String.valueOf(team1));

        // Demande de la deuxième équipe
        System.out.println("Please enter the name of the second team:");
        String teamName2 = scanner.nextLine();
        Team team2 = Team.getTeamByName(teamName2);
        if (team2 == null) {
            System.out.println("Team not found.");
            return;
        }
        match.setTeam2(String.valueOf(team2));

        // Vérification que les équipes existent dans la liste teamList
        if (!teamList.contains(team1) || !teamList.contains(team2)) {
            System.out.println("One or more teams not found in the team list.");
            return;
        }

        // Ajout du match à la liste des matchs
        matchList.add(match);
        System.out.println(Arrays.toString(matchList.toArray()));
        System.out.println("Match " + match.getNumber() + " created successfully.");
    }

    public static void editMatch() {
        Scanner scanner = new Scanner(System.in);

        // Demande du numéro du match à modifier
        System.out.println("Please enter the number of the match to edit:");
        String matchNumber = scanner.nextLine();



        // Recherche du match correspondant dans la liste
        Match matchToEdit = null;
        for (Match match : matchList) {
            if (Objects.equals(match.getNumber(), matchNumber)) {
                matchToEdit = match;
                break;
            }
        }

        // Vérification si le match a été trouvé
        if (matchToEdit == null) {
            System.out.println("Match not found.");
            return;
        }

        // Demande des modifications à apporter
        System.out.println("Please enter the new date of the match:");
        String newDate = scanner.nextLine();
        matchToEdit.setDate(newDate);
        scanner.nextLine();

        System.out.println("Please enter the new name of the first team:");
        String teamName1 = scanner.nextLine();
        Team team1 = Team.getTeamByName(teamName1);
        if (team1 == null) {
            System.out.println("Team not found.");
            return;
        }
        matchToEdit.setTeam1(team1.getName());

        System.out.println("Please enter the new name of the second team:");
        String teamName2 = scanner.nextLine();
        Team team2 = Team.getTeamByName(teamName2);
        if (team2 == null) {
            System.out.println("Team not found.");
            return;
        }
        matchToEdit.setTeam2(team2.getName());

        System.out.println("Match " + matchToEdit.getNumber() + " edited successfully.");
    }

    public static void deleteMatch() {
        Scanner scanner = new Scanner(System.in);

        // Demande du numéro du match à supprimer
        System.out.println("Please enter the number of the match to delete:");
        String matchNumber = scanner.nextLine();

        // Recherche du match correspondant dans la liste
        Match matchToDelete = null;
        for (Match match : matchList) {
            if (Objects.equals(match.getNumber(), matchNumber)) {
                matchToDelete = match;
                break;
            }
        }

        // Si le match est trouvé, on le supprime de la liste
        if (matchToDelete != null) {
            matchList.remove(matchToDelete);
            System.out.println("Match " + matchNumber + " deleted successfully.");
        } else {
            System.out.println("Match not found.");
        }
    }

    public static void inviteUser() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom de l'utilisateur
        System.out.println("Please enter the name of the user:");
        String userName = scanner.nextLine();

        // Création d'un nouveau joueur
        userList.add(userName);
        // Demande du numéro du match
        System.out.println("Please enter the match ID:");
        String matchNumber = scanner.nextLine();

        // Récupération du match correspondant
        Match matchToEdit = null;
        for (Match match : matchList) {
            if (Objects.equals(match.getNumber(), matchNumber)) {
                matchToEdit = match;
                break;
            }
        }

        // Vérification que le match existe
        if (matchToEdit == null) {
            System.out.println("Match not found.");
            return;
        }

        // Ajout du joueur au match
        matchToEdit.setUserName(userName);

        System.out.println("User " + matchToEdit.getUserName() + " invited to match " + matchNumber + ".");
    }

    public static void removeUser() {
        Scanner scanner = new Scanner(System.in);

        // Demande du numéro du match
        System.out.println("Please enter the match ID:");
        String matchNumber = scanner.nextLine();

        // Récupération du match correspondant
        Match matchToEdit = null;
        for (Match match : matchList) {
            if (Objects.equals(match.getNumber(), matchNumber)) {
                matchToEdit = match;
                break;
            }
        }

        // Vérification que le match existe
        if (matchToEdit == null) {
            System.out.println("Match not found.");
            return;
        }

        // Demande du nom de l'utilisateur à retirer
        System.out.println("Please enter the name of the user to remove:");
        String userName = scanner.nextLine();

        // Vérification que l'utilisateur existe dans la liste des utilisateurs du match
        if (!userList.contains(userName)) {
            System.out.println("User not found in match.");
            return;
        }

        // Retrait de l'utilisateur de la liste des utilisateurs du match
        matchToEdit.removeUser(userName);

        System.out.println("User " + matchToEdit.getUserName() + " removed from match " + matchToEdit.getNumber() + ".");
    }

    public static void addReferee() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom du referee
        System.out.println("Please enter the name of the referee:");
        String refereeName = scanner.nextLine();

        // Demande du numéro du match
        System.out.println("Please enter the number of the match:");
        String matchNumber = scanner.nextLine();

        // Récupération du match correspondant
        Match matchToEdit = null;
        for (Match match : matchList) {
            if (Objects.equals(match.getNumber(), matchNumber)) {
                matchToEdit = match;
                break;
            }
        }

        // Vérification que le match existe
        if (matchToEdit == null) {
            System.out.println("Match not found.");
            return;
        }

        // Ajout du referee au match
        matchToEdit.setReferee(refereeName);
        System.out.println("Referee " +  matchToEdit.getReferee() + " added to match " + matchToEdit.getNumber() + ".");
    }

    public static void getOneMatch() {
        Scanner scanner = new Scanner(System.in);

        // Demande du numéro du match
        System.out.println("Please enter the number of the match:");
        String matchNumber = scanner.nextLine();

        // Recherche du match dans la liste des matchs
        Match matchToDisplay = null;
        for (Match match : matchList) {
            if (Objects.equals(match.getNumber(), matchNumber)) {
                matchToDisplay = match;
                break;
            }
        }

        if (matchToDisplay == null) {
            System.out.println("Match not found.");
            return;
        }

        // Affichage des informations sur le match
        System.out.println("Match ID: " + matchToDisplay.getNumber());
        System.out.println("Match date: " + matchToDisplay.getDate());
        System.out.println("Team 1: " + matchToDisplay.getTeam1());
        System.out.println("Team 2: " + matchToDisplay.getTeam2());
        System.out.println("Referee: " + matchToDisplay.getReferee());
        System.out.print("Show user list? (y/n): ");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            System.out.println("User list: " + matchToDisplay.getUserName());
        }
    }

    public static void getAllMatch() {
        for (Match match : matchList) {
            System.out.println("Match ID: " + match.getNumber());
            System.out.println("Match date: " + match.getDate());
            System.out.println("Team 1: " + match.getTeam1());
            System.out.println("Team 2: " + match.getTeam2());
            System.out.println("Referee: " + match.getReferee());
            System.out.println("User list: " + match.getUserName());
            System.out.println("------------------------");
        }
    }
    }

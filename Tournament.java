package Project_java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Project_java.Team.teamList;

public class Tournament extends Competition {

    public String date;
    public  ArrayList<Team> invitedTeams = new ArrayList<>();

    public static Tournament getTournamentByName(String name) {
        for (Tournament tournament : tournamentList) {
            if (tournament.getName().equals(name)) {
                return tournament;
            }
        }
        return null;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
    public static List<Tournament> tournamentList = new ArrayList<>();

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public void addInvitedTeam(Team team) {
        invitedTeams.add(team);
    }


    public static void createTournament() {
        Scanner scanner = new Scanner(System.in);

        // Création d'un nouveau tournoi
        Tournament tournament = new Tournament();

        // Demande du nom du tournoi
        System.out.println("Please enter the name of the tournament:");
        String tournamentName = scanner.nextLine();
        tournament.setName(tournamentName);

        // Demande de la date du tournoi
        System.out.println("Please enter the date of the tournament:");
        String tournamentDate = scanner.nextLine();
        tournament.setDate(tournamentDate);

        // Ajout du tournoi à la liste des tournois
        tournamentList.add(tournament);
        tournament.setName(tournamentName);

        System.out.println( tournament.getName() + " created successfully.");
    }

    public static void editTournament() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom du tournoi à modifier
        System.out.println("Please enter the name of the tournament to edit:");
        String tournamentName = scanner.nextLine();

        // Recherche du tournoi dans la liste des tournois
        Tournament tournamentToEdit = null;
        for (Tournament tournament : tournamentList) {
            if (tournament.getName().equals(tournamentName)) {
                tournamentToEdit = tournament;
                break;
            }
        }

        if (tournamentToEdit == null) {
            System.out.println("Tournament not found.");
            return;
        }

        // Modification du nom du tournoi
        System.out.println("Please enter the new name of the tournament:");
        String newTournamentName = scanner.nextLine();
        if (!newTournamentName.isEmpty()) {
            tournamentToEdit.setName(newTournamentName);
        }

        // Modification de la date du tournoi
        System.out.println("Please enter the new date of the tournament:");
        String newTournamentDate = scanner.nextLine();
        if (!newTournamentDate.isEmpty()) {
            tournamentToEdit.setDate(newTournamentDate);
        }

        System.out.println( newTournamentName + " edited successfully.");
    }

    public static void deleteTournament() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom du tournoi à supprimer
        System.out.println("Please enter the name of the tournament to delete:");
        String tournamentName = scanner.nextLine();

        // Recherche du tournoi dans la liste des tournois
        boolean tournamentFound = false;
        for (int i = 0; i < tournamentList.size(); i++) {
            Tournament tournament = tournamentList.get(i);
            if (tournament.getName().equals(tournamentName)) {
                // Suppression du tournoi de la liste
                tournamentList.remove(i);
                tournamentFound = true;
                break;
            }
        }

        // Affichage d'un message en fonction du résultat de la recherche
        if (tournamentFound) {
            System.out.println( tournamentName + " deleted successfully.");
        } else {
            System.out.println("Tournament not found.");
        }
    }

    public static void inviteTeam() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom du tournoi
        System.out.println("Please enter the name of the tournament:");
        String tournamentName = scanner.nextLine();

        // Recherche du tournoi correspondant
        Tournament tournament = null;
        for (Tournament t : tournamentList) {
            if (t.getName().equals(tournamentName)) {
                tournament = t;
                break;
            }
        }
        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        // Sélection de l'équipe à inviter
        System.out.println("Please select the team to invite:");
        for (int i = 0; i < teamList.size(); i++) {
            System.out.println((i+1) + ". " + teamList.get(i).getName());
        }
        int teamIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Team teamToInvite = teamList.get(teamIndex);

        // Ajout de l'équipe invitée à la liste des équipes invitées
        tournament.addInvitedTeam(teamToInvite);

        System.out.println("Team invited successfully.");
    }
    public ArrayList<Team> getTeams() {

        return invitedTeams;
    }

    public static void removeTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the tournament:");
        String tournamentName = scanner.nextLine();

        // Chercher le tournoi dans la liste des tournois
        Tournament tournament = null;
        for (Tournament t : tournamentList) {
            if (t.getName().equals(tournamentName)) {
                tournament = t;
                break;
            }
        }

        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        // Afficher la liste des équipes du tournoi
        System.out.println("Teams in the tournament:");
        ArrayList<Team> teams = tournament.getTeams();
        for (int i = 0; i < teams.size(); i++) {
            System.out.println( teams.get(i).getName());
        }

        // Demander quelle équipe supprimer
        System.out.println("Please enter the name of the team to remove:");
        String teamName = scanner.nextLine();

        // Chercher l'équipe à supprimer dans la liste des équipes du tournoi
        Team teamToRemove = null;
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                teamToRemove = team;
                break;
            }
        }

        if (teamToRemove == null) {
            System.out.println("Team not found in the tournament.");
            return;
        }

        // Supprimer l'équipe de la liste des équipes du tournoi
        teams.remove(teamToRemove);

        System.out.println( teamName + " removed from the tournament successfully.");
    }

    public static void getOneTournamentByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the tournament:");
        String tournamentName = scanner.nextLine();

        // Chercher le tournoi dans la liste des tournois
        Tournament tournament = null;
        for (Tournament t : tournamentList) {
            if (t.getName().equals(tournamentName)) {
                tournament = t;
                break;
            }
        }

        if (tournament == null) {
            System.out.println("Tournament not found.");
            return;
        }

        // Afficher les informations du tournoi
        System.out.println("Tournament details:");
        System.out.println("Name: " + tournament.getName());
        System.out.println("Date: " + tournament.getDate());
        System.out.println("Teams in the tournament:");
        ArrayList<Team> teams = tournament.getTeams();
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i+1) + ". " + teamList.get(i).getName());
        }

    }

    public static void getAllTournamentsByID() {
        if (tournamentList.isEmpty()) {
            System.out.println("No tournaments created yet.");
            return;
        }

        System.out.println("List of all tournaments:");
        for (Tournament tournament : tournamentList) {
            System.out.println("------------------------");
            System.out.println("Name: " + tournament.getName());
            System.out.println("Date: " + tournament.getDate());
            System.out.println("Teams in the tournament:");
            ArrayList<Team> teams = tournament.getTeams();
            for (int i = 0; i < teams.size(); i++) {
                System.out.println((i+1) + ". " + teams.get(i).getName());
            }
        }
    }

    public static void endTheTournament() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the tournament to end:");
        String tournamentName = scanner.nextLine();

        // Chercher le tournoi dans la liste des tournois
        Tournament tournamentToRemove = null;
        for (Tournament tournament : tournamentList) {
            if (tournament.getName().equals(tournamentName)) {
                tournamentToRemove = tournament;
                break;
            }
        }

        if (tournamentToRemove == null) {
            System.out.println("Tournament not found.");
            return;
        }

        // Supprimer le tournoi de la liste des tournois
        tournamentList.remove(tournamentToRemove);

        System.out.println( tournamentName + " ended and removed from the list successfully.");
    }

}




package Project_java;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Team {
    protected String name;
    protected String homePitch;
    protected String playerName;
    protected String coachName;
    protected String captain;

    public String toString() {
        return name;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String newName) {
        this.name = newName;
    }

    protected void setHomePitch(String homePitch) {
        this.homePitch = homePitch ;
    }

    protected void setPlayerNames(String playerName) {
        this.playerName = playerName;
    }

    protected void setCoachName(String coachName) {
        this.coachName = coachName;
    }
    protected void setCaptainName(String captain) {
        this.captain = captain;
    }
    protected static List<Team> teamList = new ArrayList<>();
    protected static List<String> playerNames = new ArrayList<>();

    public static void createTeam() {
        Scanner scanner = new Scanner(System.in);
        Team team = new Team();
        // Saisie du nom de l'équipe
        System.out.println("Enter the name of the team:");
        String teamName = scanner.nextLine();
        team.setName(teamName);


        System.out.println("Enter the name of the coach:");
        String coachName = scanner.nextLine();
        team.setCoachName(coachName);

        System.out.println("Enter the captain name:");
        String captain = scanner.nextLine();
        team.setCaptainName(captain);

        // Saisie des noms des joueurs (chaque nom est saisi sur une ligne séparée)
        System.out.println("Enter the names of the players (one per line), enter 'done' when finished:");
        String playerName = scanner.nextLine();
        team.setPlayerNames(playerName);

        while (!playerName.equalsIgnoreCase("done")) {
            playerNames.add(playerName);
            playerName = scanner.nextLine();
        }

        // Saisie du stade de l'équipe
        System.out.println("Enter the home pitch of the team:");
        String homePitch = scanner.nextLine();
        team.setHomePitch(homePitch);

        teamList.add(team);
        System.out.println(teamList);

        System.out.println("Team created with name: " + team.getName());
    }


    public static void editTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the team you want to edit:");
        String teamName = scanner.nextLine();

        // Chercher l'équipe à modifier dans la liste des équipes
        Team teamToEdit = null;
        for (Team team : teamList) {
            if (team.getName().equals(teamName)) {
                teamToEdit = team;
                break;
            }
        }

        if (teamToEdit == null) {
            System.out.println("Team not found.");
            return;
        }

        System.out.println("Please enter the new name of the team:");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            teamToEdit.setName(newName);
        }

        System.out.println("Please enter the new captain name:");
        String newcaptain = scanner.nextLine();
        if (!newcaptain.isEmpty()) {
            teamToEdit.setCaptainName(newcaptain);
        }


        System.out.println("Please enter the new coach name:");
        String newCoachName = scanner.nextLine();
        if (!newCoachName.isEmpty()) {
            teamToEdit.setCoachName(newCoachName);
        }

        System.out.println("Please enter the new home pitch:");
        String newHomePitch = scanner.nextLine();
        if (!newHomePitch.isEmpty()) {
            teamToEdit.setHomePitch(newHomePitch);
        }

        // Modifier la liste des joueurs de l'équipe
        List<String> newPlayerNames = new ArrayList<>();
        System.out.println("Please enter the new list of player names:");
        String playerName = scanner.nextLine();
        while (!playerName.isEmpty()) {
            newPlayerNames.add(playerName);
            playerName = scanner.nextLine();
        }
        if (!newPlayerNames.isEmpty()) {
            teamToEdit.setPlayerNames(playerName);
        }

        System.out.println("Team edited successfully.");
    }

    public static void deleteTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the team you want to delete:");
        String teamName = scanner.nextLine();

        // Chercher l'équipe à supprimer dans la liste des équipes
        Team teamToDelete = null;
        for (Team team : teamList) {
            if (team.getName().equals(teamName)) {
                teamToDelete = team;
                break;
            }
        }

        if (teamToDelete == null) {
            System.out.println("Team not found.");
            return;
        }

        // Supprimer l'équipe de la liste des équipes
        teamList.remove(teamToDelete);

        System.out.println("Team deleted successfully.");
    }


    public static void playMatch() {
        Scanner scanner = new Scanner(System.in);

        // Afficher la liste des équipes
        System.out.println("List of teams:");
        for (Team team : teamList) {
            System.out.println("- " + team.getName());
        }

        // Sélectionner les deux équipes qui vont jouer
        System.out.println("Enter the name of the first team:");
        String team1Name = scanner.nextLine();
        Team team1 = null;
        for (Team team : teamList) {
            if (team.getName().equalsIgnoreCase(team1Name)) {
                team1 = team;
                break;
            }
        }
        if (team1 == null) {
            System.out.println("Team not found.");
            return;
        }

        System.out.println("Enter the name of the second team:");
        String team2Name = scanner.nextLine();
        Team team2 = null;
        for (Team team : teamList) {
            if (team.getName().equalsIgnoreCase(team2Name)) {
                team2 = team;
                break;
            }
        }
        if (team2 == null) {
            System.out.println("Team not found.");
            return;
        }

        // Simuler le match en utilisant des scores aléatoires
        Random random = new Random();
        int team1Score = random.nextInt(5);
        int team2Score = random.nextInt(5);
        System.out.println("Match result: " + team1.getName() + " " + team1Score + " - " + team2Score + " " + team2.getName());
    }

    public static void playCompetition() {
        Scanner scanner = new Scanner(System.in);

        // Sélection de la compétition
        System.out.println("Please select the competition:");
        System.out.println("1. League");
        System.out.println("2. Tournament");
        int competitionType = scanner.nextInt();
        scanner.nextLine();

        Competition competition;
        if (competitionType == 1) {
            // Sélection de la ligue
            System.out.println("Please enter the name of the league:");
            String leagueName = scanner.nextLine();
            League league = League.getLeagueByName(leagueName);
            if (league == null) {
                System.out.println("League not found.");
                return;
            }
            competition = league;
        } else if (competitionType == 2) {
            System.out.println("Please enter the name of the tournament:");
            String tournamentName = scanner.nextLine();
            Tournament tournament = Tournament.getTournamentByName(tournamentName);
            if (tournament == null) {
                System.out.println("Tournament not found.");
                return;
            }
            competition = tournament;
        } else {
            System.out.println("Invalid competition type.");
            return;
        }

        // Sélection de l'équipe
        System.out.println("Please enter the name of the team to participate:");
        String teamName = scanner.nextLine();
        Team teamToPlay = Team.getTeamByName(teamName);
        if (teamToPlay == null) {
            System.out.println("Team not found.");
            return;
        }

        // Ajout de l'équipe à la compétition
        competition.addTeam();

        // Simulation de la compétition
        competition.play();

        System.out.println("Team " + teamToPlay.getName() + " has been successfully added to the competition.");

    }


    public static Team getTeamByName(String name) {
        for (Team team : teamList) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }



}


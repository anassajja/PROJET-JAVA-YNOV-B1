package Project_java;
import java.util.*;
import static Project_java.Team.teamList;


public class League extends Competition{
    private static final List<League> leagueList = new ArrayList<>();
    public String date;

    public void setName(String name) {

        this.name = name;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {

        return name;
    }
    public static void createLeague() {
        Scanner scanner = new Scanner(System.in);

        // Création d'une nouvelle ligue
        League league = new League();

        // Demande du nom de la ligue
        System.out.println("Please enter the name of the league:");
        String leagueName = scanner.nextLine();
        league.setName(leagueName);

        // Demande de la date de la ligue
        System.out.println("Please enter the date of the league:");
        String leagueDate = scanner.nextLine();
        league.setDate(leagueDate);

        // Ajout de la ligue à la liste des ligues
        leagueList.add(league);

        System.out.println(league.getName() + " created successfully.");
    }

    public static League getLeagueByName(String name) {
        for (League league : leagueList) {
            if (league.getName().equals(name)) {
                return league;
            }
        }
        return null;
    }

    public static void editLeague() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom de la league à éditer
        System.out.println("Please enter the name of the league to edit:");
        String leagueName = scanner.nextLine();

        // Recherche de la league dans la liste
        League leagueToEdit = null;
        for (League league : leagueList) {
            if (league.getName().equals(leagueName)) {
                leagueToEdit = league;
                break;
            }
        }

        if (leagueToEdit == null) {
            System.out.println("League not found.");
            return;
        }

        // Modification des propriétés de la league
        System.out.println("Enter new name for the league (or press enter to keep current name):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            leagueToEdit.setName(newName);
        }

        System.out.println("Enter new start date for the league (or press enter to keep current date):");
        String newStartDate = scanner.nextLine();
        if (!newStartDate.isEmpty()) {
            leagueToEdit.setDate(newStartDate);
        }


        System.out.println( leagueName + " edited successfully.");
    }


    public static void deleteLeague() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom de la league à supprimer
        System.out.println("Please enter the name of the league to delete:");
        String leagueName = scanner.nextLine();

        // Recherche de la league dans la liste
        League leagueToDelete = null;
        for (League league : leagueList) {
            if (league.getName().equals(leagueName)) {
                leagueToDelete = league;
                break;
            }
        }

        // Suppression de la league de la liste si elle existe
        if (leagueToDelete != null) {
            leagueList.remove(leagueToDelete);
            System.out.println("League " + leagueName + " deleted successfully.");
        } else {
            System.out.println("League " + leagueName + " not found.");
        }
    }


    public static void startLeague() {
        // Vérification que la ligue a au moins deux équipes
        if (teamList.size() < 2) {
            System.out.println("A league must have at least two teams to start.");
            return;
        }

        // Génération des paires d'équipes aléatoirement
        List<Team> remainingTeams = new ArrayList<>(teamList);
        List<List<Team>> pairsList = new ArrayList<>();
        Random random = new Random();
        while (remainingTeams.size() > 1) {
            Team team1 = remainingTeams.remove(random.nextInt(remainingTeams.size()));
            Team team2 = remainingTeams.remove(random.nextInt(remainingTeams.size()));
            pairsList.add(Arrays.asList(team1, team2));
        }
        // Cas où il reste une équipe seule
        if (remainingTeams.size() == 1) {
            System.out.println("One team does not have an opponent in this round.");
        }

        // Affichage des paires d'équipes générées
        System.out.println(" list for the league:");
        for (List<Team> pair : pairsList) {
            System.out.println(pair.get(0) + " vs. " + pair.get(1));
        }
    }

    public static void endLeague() {
        Scanner scanner = new Scanner(System.in);

        // Demande du nom de la league à supprimer
        System.out.println("Please enter the name of the league to end:");
        String leagueName = scanner.nextLine();

        // Recherche de la league dans la liste
        League leagueToDelete = null;
        for (League league : leagueList) {
            if (league.getName().equals(leagueName)) {
                leagueToDelete = league;
                break;
            }
        }

        // Suppression de la league de la liste si elle existe
        if (leagueToDelete != null) {
            leagueList.remove(leagueToDelete);
            System.out.println("League " + leagueName + " ended successfully.");
        } else {
            System.out.println("League " + leagueName + " not found.");
        }
    }

    public static void playLeagueMatch() {
        Scanner scanner = new Scanner(System.in);

        // Affichage des matchs disponibles
        System.out.println("Available matches:");
        int matchNumber = 1;
        for (int i = 0; i < teamList.size() - 1; i++) {
            for (int j = i + 1; j < teamList.size(); j++) {
                System.out.println(matchNumber + ". " + teamList.get(i) + " vs. " + teamList.get(j));
                matchNumber++;
            }
        }

        // Demande du numéro du match
        System.out.println("Please enter the number of the match to play:");
        int selectedMatchNumber = scanner.nextInt();
        scanner.nextLine();

        // Recherche des équipes du match sélectionné
        int matchNumberCounter = 1;
        Team team1 = null;
        Team team2 = null;
        for (int i = 0; i < teamList.size() - 1; i++) {
            for (int j = i + 1; j < teamList.size(); j++) {
                if (matchNumberCounter == selectedMatchNumber) {
                    team1 = teamList.get(i);
                    team2 = teamList.get(j);
                    break;
                }
                matchNumberCounter++;
            }
            if (team1 != null) {
                break;
            }
        }

        if (team1 == null || team2 == null) {
            System.out.println("Match not found.");
            return;
        }

        // Affichage des équipes jouant le match
        System.out.println("Playing match: " + team1 + " vs " + team2);

        // Simulation du match avec un résultat aléatoire
        Random random = new Random();
        int randomNumber = random.nextInt(2); // génère un nombre entre 0 et 1 inclus

        // Affichage du résultat du match
        if (randomNumber == 1) {
            System.out.println(team1 + " wins!");
        } else {
            System.out.println(team2 + " wins!");
        }
    }

}


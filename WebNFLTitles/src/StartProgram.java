

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a Team: ");
			String team = in.nextLine();
			System.out.print("Enter Super Bowl wins: ");
			int titles = in.nextInt();
			ListItem toAdd = new ListItem(team, titles);
			lih.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter Team to delete: ");
			String team = in.nextLine();
			System.out.print("Enter Super Bowls to delete: ");
			int titles = in.nextInt();
			
			ListItem toDelete = new ListItem(team, titles);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Team");
			System.out.println("2 : Search by Titles");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the Team name: ");
				String teamName = in.nextLine();
				foundItems = lih.searchForTitlesByTeam(teamName);
				
			} else {
				System.out.print("Enter Titles: ");
				int titles = in.nextInt();
				foundItems = lih.searchForTitlesByTitles(titles);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForTeamById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitles() + " from " + toEdit.getTeamName());
				System.out.println("1 : Update Team");
				System.out.println("2 : Update Titles");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Team: ");
					String newTeam = in.nextLine();
					toEdit.setTeamName(newTeam);
				} else if (update == 2) {
					System.out.print("Titles: ");
					int nTitles = in.nextInt();
					toEdit.setTitles(nTitles);
				}

				lih.updateTeam(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- NFL Teams Super Bowl Wins ---");
			while (goAgain) {
				System.out.println("*  Selections:");
				System.out.println("*  1 -- Add a Team");
				System.out.println("*  2 -- Edit a Team");
				System.out.println("*  3 -- Delete a Team");
				System.out.println("*  4 -- View the list of Teams");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Have a nice Day!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem: allItems) {
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}

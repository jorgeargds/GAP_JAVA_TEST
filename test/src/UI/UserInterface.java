package UI;

import UI.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    Menu menu = new Menu();
    static BufferedReader br;

    public UserInterface() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void initApp() {
        try {
            this.runMainMenu();
        } catch (IOException io) {
            System.err.println("Error IOException!");
        }
    }

    public void runMainMenu() throws IOException {
        int mainMenuOption = -1;
        while (mainMenuOption != this.menu.getMainMenu().length) {
            mainMenuOption = this.executeMenuOptions(this.menu.showMainMenu(), "mainMenu");
        }
    }

    public void showCoinsOptions(String[] menu, int mainMenuOption) throws IOException {
        int selectedCoinOption = -1;
        while (selectedCoinOption != menu.length + 1) {
            selectedCoinOption = this.executeMenuOptions(this.menu.showCoinsOptionsMenu(mainMenuOption), mainMenuOption);
        }
    }

    private int executeMenuOptions(String menuToShow, String choseMenu) throws IOException {
        int mainMenuOption = -1;
        try {
            System.out.print(menuToShow);
            mainMenuOption = Integer.parseInt(br.readLine());
            if (mainMenuOption == 1 || mainMenuOption == 3 && choseMenu.equals("mainMenu"))
                this.showCoinsOptions(menu.getCoinsOptionsMenu(), mainMenuOption);
            else
            menu.runOption(mainMenuOption, -1);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid format insert only numbers!");
        }
        return mainMenuOption;
    }

    private int executeMenuOptions(String menuToShow, int mainMenuOption) throws IOException {
        int selectedCoinOption = -1;
        try {
            System.out.print(menuToShow);
            selectedCoinOption = Integer.parseInt(br.readLine());
            if (selectedCoinOption != this.menu.getCoinsOptionsMenu().length + 1 && selectedCoinOption >= 1)
                menu.runOption(mainMenuOption, selectedCoinOption);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid format insert only numbers!");
        }
        return selectedCoinOption;
    }

}

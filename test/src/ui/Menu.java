package ui;

import be.PiggyBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private String[] mainMenu;
    private String[] coinsOptionsMenu;
    private PiggyBank pb = new PiggyBank();
    static BufferedReader br;


    Menu() {
        br = new BufferedReader(new InputStreamReader(System.in));
        mainMenu = new String[4];
        coinsOptionsMenu = new String[pb.getCoins().length];
        initMainMenu();
        initCoinsOptionsMenu();
    }

    private void initMainMenu() {
        this.mainMenu[0] = "1.Insert coins";
        this.mainMenu[1] = "2.Check piggy bank account ";
        this.mainMenu[2] = "3.Check specific coin";
        this.mainMenu[3] = "4.Exit";
    }

    private void initCoinsOptionsMenu() {
        for (int i = 0; i < coinsOptionsMenu.length; i++)
            this.coinsOptionsMenu[i] = (i + 1) + "." + pb.getCoins()[i];
    }

    public String showMainMenu() {
        String piggyBankMenu = "\n PIGGY BANK MENU \n";
        for (String option : this.mainMenu
        ) {
            piggyBankMenu += option + "\n";
        }
        piggyBankMenu += "Insert an option: ";
        return piggyBankMenu;
    }

    public String showCoinsOptionsMenu(int mainMenuOption) {
        String action = (mainMenuOption == 1) ? "to insert " : "to check";
        String piggyBankMenu = "\n Choose a coin " + action +" \n";
        for (String option : this.coinsOptionsMenu
        ) {
            piggyBankMenu += option + "\n";
        }
        piggyBankMenu += (this.coinsOptionsMenu.length + 1) + ".Go back \n";
        piggyBankMenu += "Insert an option: ";
        return piggyBankMenu;
    }

    public void runOption(int menuOption, int selectedCoinOption) throws IOException {
        switch (menuOption) {
            case 1:
                try {
                    System.out.print("How much coins you want to insert: ");
                    int quantity = Integer.parseInt(br.readLine());
                    System.out.println(this.pb.insertCoins(selectedCoinOption -1, quantity));
                } catch (NumberFormatException nfe) {
                    System.err.println("Invalid format insert only numbers!");
                }
                break;
            case 2:
                System.out.print(this.pb.getPiggyBankAccount());
                break;
            case 3:
                System.out.print(this.pb.getSpecificCoin(selectedCoinOption - 1));
                break;
        }

    }

    public String[] getMainMenu() {
        return mainMenu;
    }

    public String[] getCoinsOptionsMenu() {
        return coinsOptionsMenu;
    }

    public void setMainMenu(String[] mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void setCoinsOptionsMenu(String[] piggyBankCoinsMenu) {
        this.coinsOptionsMenu = piggyBankCoinsMenu;
    }
}

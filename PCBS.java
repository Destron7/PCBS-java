import java.util.*;

import javax.lang.model.util.ElementScanner14;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.plaf.synth.SynthSplitPaneUI;

public class PCBS {
    static Scanner sc = new Scanner(System.in);

    int m_mb;
    int m_ram;
    int m_st_s;
    int m_st_h;
    int m_cab;
    int m_ps;
    int m_gc;
    int m_p;
    int a1;

    String p;
    String mb;
    String ram;
    String gc;
    String st_s;
    String st_h;
    String cab;
    String ps;
    String Sname;
    static int u;

    double bill = 0.0, gst_bill = 0.0;

    String name, password, login_id;
    String clogin_id, cpassword;

    static String status = "out";

    int attempts;

    void setData() {
        System.out.println("!!WELCOME TO THE SIGNIN PAGE!!");
        sc.nextLine();
        System.out.print("ENTER THE NAME: ");
        name = sc.nextLine();
        System.out.print("ENTER LOGIN ID: ");
        login_id = sc.nextLine();
        passwordGuidelines();
        outer: while (true) {
            System.out.print("ENTER PASSWORD: ");
            password = sc.nextLine();
            String str = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";
            if (password.length() < 8) {
                System.out.println("INVALID PASSWORD HAVE SMALL SIZE");
                continue outer;
            } else if (password.length() >= 8) {
                if (password.matches(str)) {
                    char pass[] = new char[password.length()];
                    for (int j = 0; j < password.length(); j++) // CHECKING PASSWORD CHARACTERS
                    {
                        pass[j] = password.charAt(j);
                        if (pass[j] == ' ') {
                            System.out.println("INVALID PASSWORD CONTAINS SPACE");
                            continue outer;
                        }
                    }
                } else if (password.matches(str) == false) {
                    System.out.println("INVALID PASSWORD DON'T HAVE SPECIAL");
                    continue outer;
                }
                break outer;
            }
        }
        System.out.println("PASSWORD SET SUCCESSFULLY");

    }

    void options(PCBS person) {
        System.out.println("DO YOU WANT TO SIGN IN!\n1.YES\n2.NO");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                person.setData();
                break;
            case 2:
                System.out.println("WELCOME TO THE SYSTEM!!");

                break;
        }
    }

    void logOptions(PCBS person) {
        if (person.name != null) {
            System.out.println("DO YOU WANT TO LOG IN!\n1.YES\n2.NO");
            int schoice = sc.nextInt();
            switch (schoice) {
                case 1:
                    LoginByID(person);
                    break;
                case 2:
                    // EDITING WINDOW DIRECT TO THE SYSTEM
                    System.out.println("NOT LOGGED IN!!");
                    status = "out";// SETTING STATUS NOT LOGGED IN
                    break;
            }
        } else {
            options(person);
        }
    }

    void LoginByID(PCBS person) {
        if (person.name != null) {
            System.out.println("!!WELCOME TO PCBS LOG IN PAGE!!");
            sc.nextLine();
            System.out.print("ENTER LOGIN ID: ");
            clogin_id = sc.nextLine();
            if (clogin_id.equalsIgnoreCase(person.login_id)) {
                for (attempts = 3; attempts > 0; attempts--) {
                    System.out.print("ENTER PASSWORD: ");
                    cpassword = sc.nextLine();
                    if (cpassword.equalsIgnoreCase(person.password)) {
                        System.out.println("LOGGED IN SUCCESSFULLY");
                        status = "in";
                        break;
                    } else {
                        System.out.println("ACCESS DENIED!!");
                        System.out.println("ENTER CORRECT PASSWORD AGAIN!!");
                        attempts--;
                    }
                }
                if (attempts == 0) {
                    System.out.println("ENTER VALID CREDENTIALS!!");
                    logOptions(person);
                }
            }
        }
        // else if(person.name.equals(null))
        else if (status == null) {
            System.out.println("YOU WILL NEED TO SIGNUP FOR LOGGIN IN!!");
            options(person);
        }
    }

    void passwordGuidelines() {
        System.out.println("PASSWORD SHOULD CONTAIN ATLEAST 8 CHARACTERS!!");
        System.out.println("PASSWORD SHOULD CONTAIN ATLEAST 1 SPECIAL CHARACTERS!!");
        System.out.println("PASSWORD SHOULDN'T CONTAIN ANY SPACES!!");
        System.out.println("PASSWORD SHOULD CONTAIN BOTH LETTERS AND NUMBERS!!");
    }

    void compOptions() {
        System.out.println("HOW MAY SYSTEMS DO YOU WANT TO CHECK AND COMPARE:");
        System.out.println("1. ONE\n2. TWO\n3. THREE");
        int compSwitch = sc.nextInt();
        switch (compSwitch) {
            case 1:
                u = 1;
                break;
            case 2:
                u = 2;
                break;
            case 3:
                u = 3;
                break;
        }
    }

    void sysSetup() {
        System.out.println("THIS IS SYSTEM SETUP METHOD!!");
        System.out.println("1 => Processor");
        System.out.println("2 => MotherBoard");
        System.out.println("3 => RAM");
        System.out.println("4 => Power Supply");
        System.out.println("5 => Storage Type SSDs");
        System.out.println("6 => Storage Type HDDs");
        System.out.println("7 => Cabinet");
        System.out.println("8 => Graphic Card");
        System.out.println("---------------------------------------");
        System.out.println("Enter your choice: ");
        int a = sc.nextInt();

        switch (a) {
            case 1:
                System.out.println("1 => intel i3 - 12000f");
                System.out.println("2 => intel i3 - 12600KF");
                System.out.println("3 => intel i5 - 13500");
                System.out.println("4 => intel i5 - 13600KF");
                System.out.println("5 => intel i7 - 12700K");
                System.out.println("6 => intel i9 - 13900K");
                System.out.println("7 => Ryzen 3 - 4300G");
                System.out.println("8 => Ryzen 5 - 7600");
                System.out.println("9 => Ryzen 7 - 7700");
                System.out.println("10 => Ryzen 9 - 7950X");
                System.out.println("11 => FOR NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for thee Processor: ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {

                    case 1:
                        System.out.println("Intel i3 - 12000f is saved succesfully");
                        p = "intel i3 - 12000f";
                        m_p = 8499;
                        bill += m_p;
                        break;
                    case 2:
                        System.out.println("Intel i5 - 12600KF is saved succesfully!!");
                        p = "intel i3 - 12600KF";
                        m_p = 18200;
                        bill += m_p;
                        break;
                    case 3:
                        System.out.println("Intel i5 - 13500 is saved succesfully!!");
                        p = "intel i5 - 13500";
                        m_p = 23345;
                        bill += m_p;
                        break;
                    case 4:
                        System.out.println("intel i5 - 13600KF is saved succesfully!!");
                        p = "intel i5 - 13600KF";

                        m_p = 25200;
                        bill += m_p;
                        break;
                    case 5:
                        System.out.println("intel i7 - 12700K is saved succesfully!!");
                        p = "intel i7 - 12700K";

                        m_p = 27100;
                        bill += m_p;
                        break;
                    case 6:
                        System.out.println("intel i9 - 13900K is saved succesfully!!");
                        p = "intel i9 - 13900K";

                        m_p = 55199;
                        bill += m_p;
                        break;
                    case 7:
                        System.out.println("Ryzen 3 - 4300G is saved succesfully!!");
                        p = "Ryzen 3 - 4300G";

                        m_p = 10399;
                        bill += m_p;
                        break;
                    case 8:
                        System.out.println("Ryzen 5 - 7600 is saved succesfully!!");
                        p = "Ryzen 5 - 7600";

                        m_p = 22700;
                        bill += m_p;
                        break;
                    case 9:
                        System.out.println("Ryzen 7 - 7700 is saved succesfully!!");
                        p = "Ryzen 7 - 7700";

                        m_p = 33099;
                        bill += m_p;
                        break;
                    case 10:
                        System.out.println("Ryzen 9 - 7950X is saved succesfully!!");
                        p = "Ryzen 9 - 7950X";

                        m_p = 61000;
                        bill += m_p;
                        break;
                    case 11:
                        break;
                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }
                // break;

            case 2:
                System.out.println("1 => Asus-H610M-E");
                System.out.println("2 => Asus Prime B650M-A");
                System.out.println("3 => Asus TUF Gaming Z690-PLUS");
                System.out.println("4 => Asus Prime X299-A");
                System.out.println("5 => GIGABYTE H610M-S2");
                System.out.println("6 => GIGABYTE B550 Arous Elite AX V2");
                System.out.println("7 => GIGABYTE Z790 UD DDR5");
                System.out.println("8 => MSI Pro H610M-E");
                System.out.println("9 => MSI MAG B760 TomaHawk");
                System.out.println("10 => MSI MPG Z690 Edge");
                System.out.println("11 => FOR NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for the MotherBoard: ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {
                    case 1:
                        System.out.println("Asus-H610M-E is saved succesfully!!");
                        mb = "Asus-H610M-E";
                        m_mb = 7995;
                        bill += m_mb;
                        break;
                    case 2:
                        System.out.println("Asus Prime B650M-A is saved succesfully!!");
                        mb = "Asus Prime B650M-A";
                        m_mb = 19850;
                        bill += m_mb;
                        break;
                    case 3:
                        System.out.println("Asus TUF Gaming Z690-PLUS is saved succesfully!!");
                        mb = "Asus TUF Gaming Z690-PLUS";
                        m_mb = 26849;
                        bill += m_mb;
                        break;
                    case 4:
                        System.out.println("Asus Prime X299-A is saved succesfully!!");
                        mb = "Asus Prime X299-A";
                        m_mb = 52500;
                        bill += m_mb;
                        break;
                    case 5:
                        System.out.println("GIGABYTE H610M-S2 is saved succesfully!!");
                        mb = "GIGABYTE H610M-S2";
                        m_mb = 7149;
                        bill += m_mb;
                        break;
                    case 6:
                        System.out.println("GIGABYTE B550 Arous Elite AX V2 is saved succesfully!!");
                        mb = "GIGABYTE B550 Arous Elite AX V2";
                        m_mb = 15900;
                        bill += m_mb;
                        break;
                    case 7:
                        System.out.println("GIGABYTE Z790 UD DDR5 is saved succesfully!!");
                        mb = "GIGABYTE Z790 UD DDR5";
                        m_mb = 21545;
                        bill += m_mb;
                        break;
                    case 8:
                        System.out.println("MSI Pro H610M-E is saved succesfully!!");
                        mb = "MSI Pro H610M-E";
                        m_mb = 6599;
                        bill += m_mb;
                        break;
                    case 9:
                        System.out.println("MSI MAG B760 TomaHawk is saved succesfully!!");
                        mb = "MSI MAG B760 TomaHawk";
                        m_mb = 24369;
                        bill += m_mb;
                        break;
                    case 10:
                        System.out.println("MSI MPG Z690 Edge is saved succesfully!!");
                        mb = "MSI MPG Z690 Edge";
                        m_mb = 32999;
                        bill += m_mb;
                        break;
                    case 11:
                        break;
                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }
                // break;

            case 3:
                System.out.println("1 => XPG GAMMIX D30 8GB DDR4");
                System.out.println("2 => Kingston Fury Beast RGB 8GB DDR4");
                System.out.println("3 => Corsair Vengeance LPX 8GB DDR4");
                System.out.println("4 => Kingston FURY 16GB 3200MHz DDR4");
                System.out.println("5 => Corsair Vengeance RGB PRO 16 GB (2x8GB)");
                System.out.println("6 => G.Skill Trident Z RGB 32GB (16GBx2) DDR4 ");
                System.out.println("7 => Corsair Vengeance 32GB (16GBx2) DDR5");
                System.out.println("8 => FOR NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for the RAMS : ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {
                    case 1:
                        System.out.println("XPG GAMMIX D30 8GB is saved succesfully!!");
                        ram = "XPG GAMMIX D30 8GB";
                        m_ram = 2055;
                        bill += m_ram;
                        break;
                    case 2:
                        System.out.println("Kingston Fury Beast RGB 8GB is saved succesfully!!");
                        ram = "Kingston Fury Beast RGB 8GB";
                        m_ram = 2899;
                        bill += m_ram;
                        break;
                    case 3:
                        System.out.println("Corsair Vengeance LPX 8GB is saved succesfully!!");
                        ram = "Corsair Vengeance LPX 8GB";
                        m_ram = 2245;
                        bill += m_ram;
                        break;
                    case 4:
                        System.out.println("Kingston FURY 16GB 3200MHz DDR4 is saved succesfully!!");
                        ram = "Kingston FURY 16GB 3200MHz DDR4";
                        m_ram = 3745;
                        bill += m_ram;
                        break;
                    case 5:
                        System.out.println("Corsair Vengeance RGB PRO 16 GB (2x8GB) is saved succesfully!!");
                        ram = "Corsair Vengeance RGB PRO 16 GB (2x8GB)";
                        m_ram = 6228;
                        bill += m_ram;
                        break;
                    case 6:
                        System.out.println("G.Skill Trident Z RGB 32GB (16GBx2) DDR4 is saved succesfully!!");
                        ram = "G.Skill Trident Z RGB 32GB (16GBx2) DDR4";
                        m_ram = 12000;
                        bill += m_ram;
                        break;
                    case 7:
                        System.out.println("Corsair Vengeance 32GB (16GBx2) DDR5 is saved succesfully!!");
                        ram = "Corsair Vengeance 32GB (16GBx2) DDR5";
                        m_ram = 17800;
                        bill += m_ram;
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }
                // break;

            case 4:
                System.out.println("1 => MSI MAG A650BN(BRONZE)");
                System.out.println("2 => MSI MAG A650GF(GOLD)");
                System.out.println("3 => DEEPCOOL DO750-M");
                System.out.println("4 => CORSAIR RMX RMI1000X");
                System.out.println("5 => CORSAIR RM550X");
                System.out.println("6 => CORSAIR CU450");
                System.out.println("7 => SILVER STONE ST1000 SFX-1");
                System.out.println("8 => Cooler Master MWE 750 Bronze V2 Power Supply");
                System.out.println("9 => GIGABYTE GP-P450B 80 Plus");
                System.out.println("10 => ASUS ROG Thor 850P 850 Watts PSU");
                System.out.println("11 => FOR NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for thee Power Supplies: ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {
                    case 1:
                        System.out.println("MSI MAG A650BN(BRONZE) is saved succesfully!!");
                        ps = "MSI MAG A650BN(BRONZE)";
                        m_ps = 5109;
                        bill += m_ps;
                        break;
                    case 2:
                        System.out.println("MSI MAG A650GF(GOLD) is saved succesfully!!");
                        ps = "MSI MAG A650GF(GOLD)";
                        m_ps = 7455;
                        bill += m_ps;
                        break;
                    case 3:
                        System.out.println("DEEPCOOL DO750-M is saved succesfully!!");
                        ps = "DEEPCOOL DO750-M";
                        m_ps = 7545;
                        bill += m_ps;
                        break;
                    case 4:
                        System.out.println("CORSAIR RMX RM1000X is saved succesfully!!");
                        ps = "CORSAIR RMX RM1000X";
                        m_ps = 16999;
                        bill += m_ps;
                        break;
                    case 5:
                        System.out.println("CORSAIR RM550X is saved succesfully!!");
                        ps = "CORSAIR RM550X";
                        m_ps = 9999;
                        bill += m_ps;
                        break;
                    case 6:
                        System.out.println("CORSAIR CU450 is saved succesfully!!");
                        ps = "CORSAIR CU450";
                        m_ps = 2897;
                        bill += m_ps;
                        break;
                    case 7:
                        System.out.println("SILVER STONE ST1000 SFX-1 is saved succesfully!!");
                        ps = "SILVER STONE ST1000 SFX-1";
                        m_ps = 23855;
                        bill += m_ps;
                        break;
                    case 8:
                        System.out.println("Cooler Master MWE 750 Bronze V2 is saved succesfully!!");
                        ps = "Cooler Master MWE 750 Bronze V2 ";
                        m_ps = 6899;
                        bill += m_ps;
                        break;
                    case 9:
                        System.out.println("GIGABYTE GP-P450B 80 Plus is saved succesfully!!");
                        ps = "GIGABYTE GP-P450B 80 Plus ";
                        m_ps = 2849;
                        bill += m_ps;
                        break;
                    case 10:
                        System.out.println("ASUS ROG Thor 850P 850 Watts PSU is saved succesfully!!");
                        ps = "ASUS ROG Thor 850P 850 Watts PSU";
                        m_ps = 19349;
                        bill += m_ps;
                        break;
                    case 11:
                        break;
                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }

            case 5:
                System.out.println("SSD'S");
                System.out.println("1 => KINGSTON FURY RENEGADE - 500-GB");
                System.out.println("2 => KINGSTON FURY RENEGADE - 1-TB");
                System.out.println("3 => SAMSUNG 970 EVO PLUS - 250-GB");
                System.out.println("4 => SAMSUNG 970 EVO PLUS - 1-TB");
                System.out.println("5 => WESTERN DIGITAL WD SN850 - 2-TB");
                System.out.println("6 => SAMSUNG 980 PRO - 2-TB");
                System.out.println("6 => NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for the SSD Storage's: ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {
                    case 1:
                        System.out.println("KINGSTON FURY RENEGADE-500-GB is saved succesfully!!");
                        st_s = "KINGSTON FURY RENEGADE-500-GB";
                        m_st_s = 11605;
                        bill += m_st_s;
                        break;
                    case 2:
                        System.out.println("KINGSTON FURY RENEGADE - 1-TB is saved succesfully!!");
                        st_s = "KINGSTON FURY RENEGADE - 1-TB";
                        m_st_s = 14210;
                        bill += m_st_s;
                        break;
                    case 3:
                        System.out.println("SAMSUNG 970 EVO PLUS - 250-GB is saved succesfully!!");
                        st_s = "SAMSUNG 970 EVO PLUS - 250-GB";
                        m_st_s = 4099;
                        bill += m_st_s;
                        break;
                    case 4:
                        System.out.println("SAMSUNG 970 EVO PLUS - 1-TB is saved succesfully!!");
                        st_s = "SAMSUNG 970 EVO PLUS - 1-TB";
                        m_st_s = 11605;
                        bill += m_st_s;
                        break;
                    case 5:
                        System.out.println("WESTERN DIGITAL WD SN850 - 2-TB is saved succesfully!!");
                        st_s = "WESTERN DIGITAL WD SN850 - 2-TB";
                        m_st_s = 24999;
                        bill += m_st_s;
                        break;
                    case 6:
                        System.out.println("SAMSUNG 980 PRO - 2-TB is saved succesfully!!");
                        st_s = "SAMSUNG 980 PRO - 2-TB";
                        m_st_s = 25215;
                        bill += m_st_s;
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }
                // break;

            case 6:
                System.out.println("HDD'S");
                System.out.println("1 => SEAGATE FIRE CUBA - 2-TB");
                System.out.println("2 => SEAGATE BARRACUDA - 8-TB");
                System.out.println("3 => WESTERN DIGITAL GOLD UTLTRASTAR - 14-TB");
                System.out.println("4 => WB BLACK - 8-TB");
                System.out.println("5 => FOR NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for the HDD Storage: ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {
                    case 1:
                        System.out.println("SEAGATE FIRE CUDA - 2-TB is saved succesfully!!");
                        st_h = "SEAGATE FIRE CUBA - 2-TB";
                        m_st_h = 10990;
                        bill += m_st_h;
                        break;
                    case 2:
                        System.out.println("SEAGATE BARRACUDA - 8-TB is saved succesfully!!");
                        st_h = "SEAGATE BARRACUDA - 8-TB";
                        m_st_h = 18000;
                        bill += m_st_h;
                        break;
                    case 3:
                        System.out.println("WESTERN DIGITAL GOLD UTLTRASTAR - 14-TB is saved succesfully!!");
                        st_h = "WESTERN DIGITAL GOLD UTLTRASTAR - 14-TB";
                        m_st_h = 57390;
                        bill += m_st_h;
                        break;
                    case 4:
                        System.out.println("WB BLACK - 8-TB is saved succesfully!!");
                        st_h = "WB BLACK - 8-TB";
                        m_st_h = 28200;
                        bill += m_st_h;
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }

            case 7:
                System.out.println("1 => LIAN LI LAN COOL MESH");
                System.out.println("2 => ANT ESPORTS ICE-511MT");
                System.out.println("3 => NZXT H510");
                System.out.println("4 => ANTEE NX 800 MID TOWER");
                System.out.println("5 => LIAN LI ALUMINIUM PC-011");
                System.out.println("6 => Nzxt H210i (Matte Black) ");
                System.out.println("7 => Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)");
                System.out.println("8 => AeroCool Cronus ARGB Cabinet (Black)");
                System.out.println("9 => MSI MPG SEKIRA 100R mid Tower");
                System.out.println("10 => Lian Li Aluminium PC-O11 Dynamic Razer Edition");
                System.out.println("11 => FOR NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for thee Cabinat: ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {
                    case 1:
                        System.out.println("LIAN LI LAN COOL MESH is saved succesfully!!");
                        cab = "LIAN LI LAN COOL MESH";
                        m_cab = 11999;
                        bill += m_cab;
                        break;
                    case 2:
                        System.out.println("ANT ESPORTS ICE-511MT is saved succesfully!!");
                        cab = "ANT ESPORTS ICE-511MT";
                        m_cab = 4719;
                        bill += m_cab;
                        break;
                    case 3:
                        System.out.println("NZXT H510 is saved succesfully!!");
                        cab = "NZXT H510";
                        m_cab = 6399;
                        bill += m_cab;
                        break;
                    case 4:
                        System.out.println("ANTEE NX 800 MID TOWER is saved succesfully!!");
                        cab = "ANTEE NX 800 MID TOWER";
                        m_cab = 6730;
                        bill += m_cab;
                        break;
                    case 5:
                        System.out.println("LIAN LI ALUMINIUM PC-011 is saved succesfully!!");
                        cab = "LIAN LI ALUMINIUM PC-011";
                        m_cab = 15299;
                        bill += m_cab;
                        break;
                    case 6:
                        System.out.println("Nzxt H210i (Matte Black) is saved succesfully!!");
                        cab = "Nzxt H210i (Matte Black)";
                        m_cab = 5599;
                        bill += m_cab;
                        break;
                    case 7:
                        System.out.println("Ant Esports 690 Air ARGB (E-ATX) Cabinet (White) is saved succesfully!!");
                        cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                        m_cab = 6649;
                        bill += m_cab;
                        break;
                    case 8:
                        System.out.println("AeroCool Cronus ARGB Cabinet (Black) is saved succesfully!!");
                        cab = "AeroCool Cronus ARGB Cabinet (Black)";
                        m_cab = 7290;
                        bill += m_cab;
                        break;
                    case 9:
                        System.out.println("MSI MPG SEKIRA 100R mid Tower is saved succesfully!!");
                        cab = "MSI MPG SEKIRA 100R mid Tower";
                        m_cab = 9299;
                        bill += m_cab;
                        break;
                    case 10:
                        System.out.println("Lian Li Aluminium PC-O11 Dynamic Razer Edition is saved succesfully!!");
                        cab = "Lian Li Aluminium PC-O11 Dynamic Razer Edition";
                        m_cab = 16999;
                        bill += m_cab;
                        break;
                    case 11:
                        break;

                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }
                // break;

            case 8:
                System.out.println("1 => RTX 3050 8 GB");
                System.out.println("2 => RTX 3060 12 GB");
                System.out.println("3 => RTX 3080 ti 12 GB");
                System.out.println("4 => RTX 3090 ti 24 GB");
                System.out.println("5 => RTX 4090 24 GB");
                System.out.println("6 => AMD RX 6500 XT 4 GB");
                System.out.println("7 => AMD RX 6650 XT 8 GB");
                System.out.println("8 => AMD RX 6750 XT 12 GB");
                System.out.println("9 => AMD RX 6800 XT 16 GB");
                System.out.println("10 => AMD RX 6950 XT 16 GB");
                System.out.println("11 => FOR NULL");
                System.out.println("---------------------------------------");
                System.out.println("Enter the Choice for thee Graphic Card: ");
                try {
                    a1 = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid write proper digits are metion above");
                }
                switch (a1) {
                    case 1:
                        System.out.println("RTX 3050 8 GB is saved succesfully!!");
                        gc = "RTX 3050 8 GB";
                        m_gc = 32999;
                        bill += m_gc;
                        break;
                    case 2:
                        System.out.println("RTX 3060 12 GB is saved succesfully!!");
                        gc = "RTX 3060 12 GB";
                        m_gc = 43000;
                        bill += m_gc;
                        break;
                    case 3:
                        System.out.println("RTX 3080 ti 12 GB is saved succesfully!!");
                        gc = "RTX 3080 ti 12 GB";
                        m_gc = 150000;
                        bill += m_gc;
                        break;
                    case 4:
                        System.out.println("RTX 3090 ti 24 GB is saved succesfully!!");
                        gc = "RTX 3090 ti 24 GB";
                        m_gc = 205000;
                        bill += m_gc;
                        break;
                    case 5:
                        System.out.println("RTX 4090 24 GB is saved succesfully!!");
                        gc = "RTX 4090 24 GB";
                        m_gc = 240000;
                        bill += m_gc;
                        break;
                    case 6:
                        System.out.println("AMD RX 6500 XT 4 GB is saved succesfully!!");
                        gc = "AMD RX 6500 XT 4 GB";
                        m_gc = 18000;
                        bill += m_gc;
                        break;
                    case 7:
                        System.out.println("AMD RX 6650 XT 8 GB is saved succesfully!!");
                        gc = "AMD RX 6650 XT 8 GB";
                        m_gc = 35000;
                        bill += m_gc;
                        break;
                    case 8:
                        System.out.println("AMD RX 6750 XT 12 GB is saved succesfully!!");
                        gc = "AMD RX 6750 XT 12 GB";
                        m_gc = 48000;
                        bill += m_gc;
                        break;
                    case 9:
                        System.out.println("AMD RX 6800 XT 16 GB is saved succesfully!!");
                        gc = "AMD RX 6800 XT 16 GB";
                        m_gc = 85000;
                        bill += m_gc;
                        break;
                    case 10:
                        System.out.println("AMD RX 6950 XT 16 GB is saved succesfully!!");
                        gc = "AMD RX 6950 XT 16 GB";
                        m_gc = 95000;
                        bill += m_gc;
                        break;
                    case 11:
                        break;

                    default:
                        System.out.println("Invalid Choice !!! Plz Enter again");
                }
                break;

            default:
                System.out.println("Invaild choice");
        }
    }

    void compareSystem(PCBS[] compObjs) {
        if (u == 1) {
            System.out.println("                    SYSTEM 1");
            System.out.println("PROCESSOR:   " + String.format("%25s", compObjs[0].p));
            System.out.println("MOTHERBOARD: " + String.format("%25s", compObjs[0].mb));
            System.out.println("RAM:         " + String.format("%25s", compObjs[0].ram));
            System.out.println("POWER SUPPLY:" + String.format("%25s", compObjs[0].ps));
            System.out.println("SSD:         " + String.format("%25s", compObjs[0].st_s));
            System.out.println("HHD:         " + String.format("%25s", compObjs[0].st_h));
            System.out.println("CABLE:       " + String.format("%25s", compObjs[0].cab));
            System.out.println("GRAPHIC CARD:" + String.format("%25s", compObjs[0].gc));

        } else if (u == 2) {
            System.out.println("                      SYSTEM 1                                    SYSTEM 2");
            System.out.println("PROCESSOR:   " + String.format("%25s", compObjs[0].p) + "     "
                    + String.format("%25s", compObjs[1].p));
            System.out.println("MOTHERBOARD: " + String.format("%25s", compObjs[0].mb) + "     "
                    + String.format("%25s", compObjs[1].mb));
            System.out.println("RAM:         " + String.format("%25s", compObjs[0].ram) + "     "
                    + String.format("%25s", compObjs[1].ram));
            System.out.println("POWER SUPPLY:" + String.format("%25s", compObjs[0].ps) + "     "
                    + String.format("%25s", compObjs[1].ps));
            System.out.println("SSD:         " + String.format("%25s", compObjs[0].st_s) + "     "
                    + String.format("%25s", compObjs[1].st_s));
            System.out.println("HHD:         " + String.format("%25s", compObjs[0].st_h) + "     "
                    + String.format("%25s", compObjs[1].st_h));
            System.out.println("CABLE:       " + String.format("%25s", compObjs[0].cab) + "     "
                    + String.format("%25s", compObjs[1].cab));
            System.out.println("GARPHIC CARD:" + String.format("%25s", compObjs[0].gc) + "     "
                    + String.format("%25s", compObjs[1].gc));

                    
        } else if (u == 3) {
            System.out.println(
                    "                       SYSTEM 1                                                SYSTEM 2                                                SYSTEM 3");
            System.out.println("PROCESSOR:   " + String.format("%25s", compObjs[0].p) + "     "
                    + String.format("%25s", compObjs[1].p) + "     " + String.format("%25s", compObjs[2].p));
            System.out.println("MOTHERBOARD: " + String.format("%25s", compObjs[0].mb) + "     "
                    + String.format("%25s", compObjs[1].mb) + "     " + String.format("%25s", compObjs[2].mb));
            System.out.println("RAM:         " + String.format("%25s", compObjs[0].ram) + "     "
                    + String.format("%25s", compObjs[1].ram) + "     " + String.format("%25s", compObjs[2].ram));
            System.out.println("POWER SUPPLY:" + String.format("%25s", compObjs[0].ps) + "     "
                    + String.format("%25s", compObjs[1].ps) + "     " + String.format("%25s", compObjs[2].ps));
            System.out.println("SSD:         " + String.format("%25s", compObjs[0].st_s) + "     "
                    + String.format("%25s", compObjs[1].st_s) + "     " + String.format("%25s", compObjs[2].st_s));
            System.out.println("HHD:         " + String.format("%25s", compObjs[0].st_h) + "     "
                    + String.format("%25s", compObjs[1].st_h) + "     " + String.format("%25s", compObjs[2].st_h));
            System.out.println("CABLE:       " + String.format("%25s", compObjs[0].cab) + "     "
                    + String.format("%25s", compObjs[1].cab) + "     " + String.format("%25s", compObjs[2].cab));
            System.out.println("GARPHIC CARD:" + String.format("%25s", compObjs[0].gc) + "     "
                    + String.format("%25s", compObjs[1].gc) + "     " + String.format("%25s", compObjs[2].gc));
        }
    }

    void ReadymadeSys(PCBS[] ReadyMade,PCBS[] compObjs,PCBS person) {
        System.out.println("THE RIGS READY TO BATTLE:");
        System.out.println("1.BLACKWOLF RIG");
        System.out.println("2.DESTRON'S RIG");
        System.out.println("3.DARKWOLF RIG");
        System.out.println("4.UNICORN RIG");
        System.out.println("5.ROYAL PRINCESS RIG");
        System.out.println("6.BAD BOY RIG");
        System.out.println("7.XPRO RIG");
        System.out.println("8.RIG PENGUIN");
        System.out.println("9.RIG FRAGGER");
        System.out.println("10.X1 FIVE-NINE RIG");
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                ReadyMade[0].Sname = "BLACKWOLF RIG";
                ReadyMade[0].gc = "RTX 3050 8 GB";
                ReadyMade[0].ram = "Kingston Fury Beast RGB 8GB DDR4";
                ReadyMade[0].st_h = null;
                ReadyMade[0].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[0].cab = "LIAN LI ALUMINIUM PC-011";
                ReadyMade[0].mb = "Asus TUF Gaming Z690-PLUS";
                ReadyMade[0].p = "intel i3 - 12600KF";
                ReadyMade[0].ps = "DEEPCOOL DO750-M";

                // m_cab=;
                // m_gc=;
                // m_p=;
                // m_mb=;
                // m_st_h=;
                // m_st_s=;
                // m_cab=;
                // m_ps=;


            } else if (i == 1) {
                ReadyMade[1].Sname = "DESTRON'S RIG";
                ReadyMade[1].gc = "RTX 4090 24 GB";
                ReadyMade[1].ram = "Corsair Vengeance 32GB (16GBx2) DDR5";
                ReadyMade[1].st_h = "SEAGATE FIRE CUBA - 2-TB";
                ReadyMade[1].st_s = "SAMSUNG 980 PRO - 2-TB";
                ReadyMade[1].cab = "Lian Li Aluminium PC-O11 Dynamic Razer Edition";
                ReadyMade[1].mb = "Asus Prime X299-A";
                ReadyMade[1].p = "intel i9 - 13900K";
                ReadyMade[1].ps = "ASUS ROG Thor 850P 850 Watts PSU";

                // m_cab=;
                // m_gc=;
                // m_p=;
                // m_mb=;
                // m_st_h=;
                // m_st_s=;
                // m_cab=;
                // m_ps=;

            } else if (i == 2) {
                System.out.println("NAME: DARKWOLF RIG");
                ReadyMade[2].Sname = "DARKWOLF RIG";
                ReadyMade[2].gc = "RTX 3080 ti 12 GB";
                ReadyMade[2].ram = "Corsair Vengeance LPX 8GB DDR4";
                ReadyMade[2].st_h = "";
                ReadyMade[2].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[2].cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                ReadyMade[2].mb = "MSI MPG Z690 Edge";
                ReadyMade[2].p = "Ryzen 5 - 7600";
                ReadyMade[2].ps = "GIGABYTE GP-P450B 80 Plus";

                // ReadyMade[2].m_cab=;
                // ReadyMade[2].m_gc=;
                // ReadyMade[2].m_p=;
                // ReadyMade[2].m_mb=;
                // ReadyMade[2].m_st_h=;
                // ReadyMade[2].m_st_s=;
                // ReadyMade[2].m_cab=;
                // ReadyMade[2].m_ps=;
            } else if (i == 3) {
                System.out.println("NAME: UNICORN RIG");
                ReadyMade[3].Sname = "UNICORN RIG";
                ReadyMade[3].gc = "RTX 3060 12 GB";
                ReadyMade[3].ram = "Corsair Vengeance LPX 8GB DDR4";
                ReadyMade[3].st_h = "";
                ReadyMade[3].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[3].cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                ReadyMade[3].mb = "MSI MPG Z690 Edge";
                ReadyMade[3].p = "intel i3 - 12000f";
                ReadyMade[3].ps = "GIGABYTE GP-P450B 80 Plus";

                // ReadyMade[3].m_cab=;
                // ReadyMade[3].m_gc=;
                // ReadyMade[3].m_p=;
                // ReadyMade[3].m_mb=;
                // ReadyMade[3].m_st_h=;
                // ReadyMade[3].m_st_s=;
                // ReadyMade[3].m_cab=;
                // ReadyMade[3].m_ps=;
            } else if (i == 4) {
                System.out.println("NAME: ROYAL PRINCESS RIG");
                ReadyMade[4].Sname = "ROYAL PRINCESS RIG";
                ReadyMade[4].gc = "RTX 3060 12 GB";
                ReadyMade[4].ram = "Kingston Fury Beast RGB 8GB DDR4";
                ReadyMade[4].st_h = "";
                ReadyMade[4].st_s = "SAMSUNG 970 EVO PLUS - 250-GB";
                ReadyMade[4].cab = "ANT ESPORTS ICE-511MT";
                ReadyMade[4].mb = "Asus TUF Gaming Z690-PLUS";
                ReadyMade[4].p = "intel i5 - 13600KF";
                ReadyMade[4].ps = "CORSAIR RMX RMI1000X";

                ReadyMade[4].m_gc=43000;
                ReadyMade[4].m_p=25200;
                ReadyMade[4].m_mb=26849;
                ReadyMade[4].m_st_h=0;
                ReadyMade[4].m_st_s=4099;
                ReadyMade[4].m_cab=4719;
                ReadyMade[4].m_ps=16999;
                ReadyMade[4].m_ram=2899;

            } else if (i == 5) {
                System.out.println("NAME: BAD BOY RIG");
                ReadyMade[5].Sname = "BAD BOY RIG";
                ReadyMade[5].gc = "RTX 3060 12 GB";
                ReadyMade[5].ram = "Corsair Vengeance LPX 8GB DDR4";
                ReadyMade[5].st_h = "";
                ReadyMade[5].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[5].cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                ReadyMade[5].mb = "GIGABYTE H610M-S2";
                ReadyMade[5].p = "intel i5 - 13600KF";
                ReadyMade[5].ps = "GIGABYTE GP-P450B 80 Plus";

                // m_cab=;
                // m_gc=;
                // m_p=;
                // m_mb=;
                // m_st_h=;
                // m_st_s=;
                // m_cab=;
                // m_ps=;
            } else if (i == 6) {
                System.out.println("NAME: XPRO RIG");
                ReadyMade[6].Sname = "XPRO RIG";
                ReadyMade[6].gc = "RTX 3060 12 GB";
                ReadyMade[6].ram = "Corsair Vengeance LPX 8GB DDR4";
                ReadyMade[6].st_h = "";
                ReadyMade[6].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[6].cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                ReadyMade[6].mb = "GIGABYTE H610M-S2";
                ReadyMade[6].p = "intel i5 - 13600KF";
                ReadyMade[6].ps = "GIGABYTE GP-P450B 80 Plus";

                // m_cab=;
                // m_gc=;
                // m_p=;
                // m_mb=;
                // m_st_h=;
                // m_st_s=;
                // m_cab=;
                // m_ps=;
            } else if (i == 7) {
                System.out.println("NAME: RIG PENGUIN");
                ReadyMade[7].Sname = "RIG PENGUIN";
                ReadyMade[7].gc = "RTX 3060 12 GB";
                ReadyMade[7].ram = "Corsair Vengeance LPX 8GB DDR4";
                ReadyMade[7].st_h = "";
                ReadyMade[7].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[7].cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                ReadyMade[7].mb = "GIGABYTE H610M-S2";
                ReadyMade[7].p = "intel i5 - 13600KF";
                ReadyMade[7].ps = "GIGABYTE GP-P450B 80 Plus";

                // m_cab=;
                // m_gc=;
                // m_p=;
                // m_mb=;
                // m_st_h=;
                // m_st_s=;
                // m_cab=;
                // m_ps=;
            } else if (i == 8) {
                System.out.println("NAME: RIG FRAGGER");
                ReadyMade[8].Sname = "RIG FRAGGER";
                ReadyMade[8].gc = "RTX 3060 12 GB";
                ReadyMade[8].ram = "Corsair Vengeance LPX 8GB DDR4";
                ReadyMade[8].st_h = "";
                ReadyMade[8].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[8].cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                ReadyMade[8].mb = "GIGABYTE H610M-S2";
                ReadyMade[8].p = "intel i5 - 13600KF";
                ReadyMade[8].ps = "GIGABYTE GP-P450B 80 Plus";

                // m_cab=;
                // m_gc=;
                // m_p=;
                // m_mb=;
                // m_st_h=;
                // m_st_s=;
                // m_cab=;
                // m_ps=;
            } else if (i == 9) {
                System.out.println("NAME: X1 FIVE-NINE RIG");
                ReadyMade[9].Sname = "X1 FIVE-NINE RIG";
                ReadyMade[9].gc = "RTX 3060 12 GB";
                ReadyMade[9].ram = "Corsair Vengeance LPX 8GB DDR4";
                ReadyMade[9].st_h = "";
                ReadyMade[9].st_s = "KINGSTON FURY RENEGADE - 500-GB";
                ReadyMade[9].cab = "Ant Esports 690 Air ARGB (E-ATX) Cabinet (White)";
                ReadyMade[9].mb = "GIGABYTE H610M-S2";
                ReadyMade[9].p = "intel i5 - 13600KF";
                ReadyMade[9].ps = "GIGABYTE GP-P450B 80 Plus";

                // m_cab=;
                // m_gc=;
                // m_p=;
                // m_mb=;
                // m_st_h=;
                // m_st_s=;
                // m_cab=;
                // m_ps=;
            }
        }
        System.out.println("DO YOU WANT TO CHECK ANY SYSTEM:");
        System.out.println("1.YES\n2.NO");
        int choice=sc.nextInt();
        switch(choice)
        {
        case 1:
                ReadyMadeCompare(ReadyMade); 
            break;
        case 2:
                System.out.println("DO YOU WANT TO BUY ANY 0F READYMADE SYSTEM: \n1.YES \n2. NO");
                int inchoice=sc.nextInt();
                switch(inchoice)
                {
                    case 1:
                        checkOut(compObjs, person, ReadyMade);
                        break;
                    case 2:
                        return;
                }
        }
    }

    void ReadyMadeCompare(PCBS[] ReadyMade) {
        System.out.print("HOW MANY SYSTEMS DO YOU WANT TO COMPARE: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("ENTER THE CHOICE YOU WANT TO SEE: ");
                int rm1 = sc.nextInt();
                System.out.println("NAME:        " + String.format("%25s", ReadyMade[rm1].Sname));
                System.out.println("PROCESSOR:   " + String.format("%25s", ReadyMade[rm1].p));
                System.out.println("MOTHERBOARD: " + String.format("%25s", ReadyMade[rm1].mb));
                System.out.println("RAM:         " + String.format("%25s", ReadyMade[rm1].ram));
                System.out.println("POWER SUPPLY:" + String.format("%25s", ReadyMade[rm1].ps));
                System.out.println("SSD:         " + String.format("%25s", ReadyMade[rm1].st_s));
                System.out.println("HHD:         " + String.format("%25s", ReadyMade[rm1].st_h));
                System.out.println("CABLE:       " + String.format("%25s", ReadyMade[rm1].cab));
                System.out.println("GRAPHIC CARD:" + String.format("%25s", ReadyMade[rm1].gc));
                break;
            case 2:
                System.out.print("ENTER THE TWO CHOICE YOU WANT TO SEE: ");
                int rm2 = sc.nextInt(), rm3=sc.nextInt();
                System.out.println("                      SYSTEM 1                                                SYSTEM 2");
                System.out.println("PROCESSOR:   " + String.format("%25s", ReadyMade[rm2].p) + "     "
                        + String.format("%25s", ReadyMade[rm3].p));
                System.out.println("MOTHERBOARD: " + String.format("%25s", ReadyMade[rm2].mb) + "     "
                        + String.format("%25s", ReadyMade[rm3].mb));
                System.out.println("RAM:         " + String.format("%25s", ReadyMade[rm2].ram) + "     "
                        + String.format("%25s", ReadyMade[rm3].ram));
                System.out.println("POWER SUPPLY:" + String.format("%25s", ReadyMade[rm2].ps) + "     "
                        + String.format("%25s", ReadyMade[rm3].ps));
                System.out.println("SSD:         " + String.format("%25s", ReadyMade[rm2].st_s) + "     "
                        + String.format("%25s", ReadyMade[rm3].st_s));
                System.out.println("HHD:         " + String.format("%25s", ReadyMade[rm2].st_h) + "     "
                        + String.format("%25s", ReadyMade[rm3].st_h));
                System.out.println("CABLE:       " + String.format("%25s", ReadyMade[rm2].cab) + "     "
                        + String.format("%25s", ReadyMade[rm3].cab));
                System.out.println("GARPHIC CARD:" + String.format("%25s", ReadyMade[rm2].gc) + "     "
                        + String.format("%25s", ReadyMade[rm3].gc));
                break;
            case 3:
                System.out.println("ENTER THE THREE CHOICES YOU WANT TO COMPARE: ");
                int rm4=sc.nextInt(), rm5=sc.nextInt(), rm6=sc.nextInt();
                System.out.println(
                    "                       SYSTEM 1                                                SYSTEM 2                                                SYSTEM 3");
            System.out.println("PROCESSOR:   " + String.format("%25s", ReadyMade[rm4].p) + "     "
                    + String.format("%25s", ReadyMade[rm5].p) + "     " + String.format("%25s", ReadyMade[rm6].p));
            System.out.println("MOTHERBOARD: " + String.format("%25s", ReadyMade[rm4].mb) + "     "
                    + String.format("%25s", ReadyMade[rm5].mb) + "     " + String.format("%25s", ReadyMade[rm6].mb));
            System.out.println("RAM:         " + String.format("%25s", ReadyMade[rm4].ram) + "     "
                    + String.format("%25s", ReadyMade[rm5].ram) + "     " + String.format("%25s", ReadyMade[rm6].ram));
            System.out.println("POWER SUPPLY:" + String.format("%25s", ReadyMade[rm4].ps) + "     "
                    + String.format("%25s", ReadyMade[rm5].ps) + "     " + String.format("%25s", ReadyMade[rm6].ps));
            System.out.println("SSD:         " + String.format("%25s", ReadyMade[rm4].st_s) + "     "
                    + String.format("%25s", ReadyMade[rm5].st_s) + "     " + String.format("%25s", ReadyMade[rm6].st_s));
            System.out.println("HHD:         " + String.format("%25s", ReadyMade[rm4].st_h) + "     "
                    + String.format("%25s", ReadyMade[rm5].st_h) + "     " + String.format("%25s", ReadyMade[rm6].st_h));
            System.out.println("CABLE:       " + String.format("%25s", ReadyMade[rm4].cab) + "     "
                    + String.format("%25s", ReadyMade[rm5].cab) + "     " + String.format("%25s", ReadyMade[rm6].cab));
            System.out.println("GARPHIC CARD:" + String.format("%25s", ReadyMade[rm4].gc) + "     "
                    + String.format("%25s", ReadyMade[rm5].gc) + "     " + String.format("%25s", ReadyMade[rm6].gc));

                break;
        }
    }

    void checkOut(PCBS[] compObjs, PCBS person, PCBS[] ReadyMade) {
        System.out.println("DO YOU WANT TO BUY THE SYSTEM YOU MADE");
        System.out.println("1. YES");
        System.out.println("2. NO");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("WHICH SYSTEM DO YOU WANT TO BUY:");
                System.out.print("ENTER THE SYSTEM NUMBER: ");
                int i = sc.nextInt();
                while (true) {
                    // if (/*status.equals("in")*/)
                    if (status == "in") {
                        System.out.println("PROCESSOR:   " + String.format("%25s", compObjs[i - 1].p) + "  "
                                + String.format("%8d", compObjs[i - 1].m_p));
                        System.out.println("MOTHERBOARD: " + String.format("%25s", compObjs[i - 1].mb) + "  "
                                + String.format("%8d", compObjs[i - 1].m_mb));
                        System.out.println("RAM:         " + String.format("%25s", compObjs[i - 1].ram) + "  "
                                + String.format("%8d", compObjs[i - 1].m_ram));
                        System.out.println("POWER SUPPLY:" + String.format("%25s", compObjs[i - 1].ps) + "  "
                                + String.format("%8d", compObjs[i - 1].m_ps));
                        System.out.println("SSD:         " + String.format("%25s", compObjs[i - 1].st_s) + "  "
                                + String.format("%8d", compObjs[i - 1].m_st_s));
                        System.out.println("HHD:         " + String.format("%25s", compObjs[i - 1].st_h) + "  "
                                + String.format("%8d", compObjs[i - 1].m_st_h));
                        System.out.println("CABLE:       " + String.format("%25s", compObjs[i - 1].cab) + "  "
                                + String.format("%8d", compObjs[i - 1].m_cab));
                        System.out.println("GRAPHIC CARD:" + String.format("%25s", compObjs[i - 1].gc) + "  "
                                + String.format("%8d", compObjs[i - 1].m_gc));
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("TOTAL:               " + compObjs[i - 1].bill);
                        System.out.println("GST(18%):            " + (double) (compObjs[i - 1].bill * 0.18));
                        gst_bill = compObjs[i - 1].bill * 1.18;
                        System.out.println("AMOUNT PAYABLE:      " + gst_bill);
                        break;
                    } else {
                        System.out.println("PLEASE LOGIN TO CHECKOUT:");
                        logOptions(person);
                    }
                }
                break;
            case 2:
                System.out.println("SELECT ANY OPTIONS GIVEN FROM BELOW IF YOU LIKE!!");
                ReadymadeSys(ReadyMade, compObjs, person);
                break;
        }
    }

    public static void main(String[] args) {
        PCBS person = new PCBS();
        PCBS obj = new PCBS();

        obj.options(person);
        obj.logOptions(person);

        PCBS ReadyMade[] = new PCBS[10];
        for(int i=0;i<ReadyMade.length;i++)
        {
            ReadyMade[i]=new PCBS();
        }

        obj.compOptions();
        PCBS[] compObjs = new PCBS[u];
        for (int t = 0; t < u; t++) {
            compObjs[t] = new PCBS();
            compObjs[t].sysSetup();
        }
        obj.compareSystem(compObjs);

        obj.checkOut(compObjs, person, ReadyMade);
    }
}

/*
 * FLOW:
 * 1. LOGIN IF CUSTOMER WANTS TO.
 * 2.
 * 
 * 
 * 
 * after diplaying configured system define system by purpose and suggest the
 * options.
 */

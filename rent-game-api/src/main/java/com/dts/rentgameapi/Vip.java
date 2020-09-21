package com.dts.rentgameapi;

/**
 * @author Rin-DTS
 */
public class Vip {
    public static final int VIP1 = 100000;
    public static final int VIP2 = VIP1 * 2;
    public static final int VIP3 = VIP1 * 3;
    public static final int VIP4 = VIP2 * 4;
    public static final int VIP5 = VIP2 * 5;
    public static final int VIP6 = VIP3 * 6;
    public static final int VIP7 = VIP3 * 7;
    public static final int VIP8 = VIP4 * 8;
    public static final int VIP9 = VIP4 * 9;
    public static final int VIP10 = VIP5 * 10;

    public static int getVip(Double amount) {
        if (amount <= VIP1)
            return 1;
        else if (amount >= VIP1 && amount < VIP2)
            return 2;
        else if (amount >= VIP2 && amount < VIP3)
            return 3;
        else if (amount >= VIP3 && amount < VIP4)
            return 4;
        else if (amount >= VIP4 && amount < VIP5)
            return 5;
        else if (amount >= VIP5 && amount < VIP6)
            return 6;
        else if (amount >= VIP6 && amount < VIP7)
            return 7;
        else if (amount >= VIP7 && amount < VIP8)
            return 8;
        else if (amount >= VIP8 && amount < VIP9)
            return 9;
        else
            return 10;
    }
}

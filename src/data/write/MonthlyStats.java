package data.write;

import java.util.ArrayList;

public class MonthlyStats {
    private  int month;
    private  ArrayList<Integer>  distributorsIds;

    public MonthlyStats(int month, ArrayList<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds;
    }

    public int getMonth() {
        return month;
    }

    public ArrayList<Integer> getDistributorsIds() {
        return distributorsIds;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDistributorsIds(ArrayList<Integer> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }
}

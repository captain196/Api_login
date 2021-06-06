package model;

public class frontobj {

    Data1 data;
    int page,per_page,total,total_page;

    public frontobj(Data1 data, int page, int per_page, int total, int total_page) {
        this.data = data;
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_page = total_page;
    }

    public void setData(Data1 data) {
        this.data = data;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public Data1 getData() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_page() {
        return total_page;
    }
}

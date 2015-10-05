package model;

public class NavDrawerItem {

    private boolean showNotify;
    private String title;
    private int icone;


    public NavDrawerItem() {

    }

    public NavDrawerItem(boolean showNotify, String title, int icone) {
        this.showNotify = showNotify;
        this.title = title;
        this.icone = icone;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }
}
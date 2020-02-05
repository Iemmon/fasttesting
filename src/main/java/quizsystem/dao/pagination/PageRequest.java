package quizsystem.dao.pagination;

public class PageRequest {
    private int pageNumber;
    private int itemsPerPage;

    public PageRequest(int pageNumber, int itemsPerPage) {
        this.pageNumber = pageNumber;
        this.itemsPerPage = itemsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

}

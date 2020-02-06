package quizsystem.dao.pagination;

public class PageRequest {
    private int pageNumber;
    private int itemsPerPage;
    private int maxPages;

    public PageRequest(int pageNumber, int itemsPerPage, int maxPages) {
        this.pageNumber = pageNumber;
        this.itemsPerPage = itemsPerPage;
        this.maxPages = maxPages;
    }

    public int getMaxPages() {
        return maxPages;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

}

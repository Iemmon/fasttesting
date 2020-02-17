package quizsystem.dao.pagination;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageRequest that = (PageRequest) o;
        return pageNumber == that.pageNumber &&
                itemsPerPage == that.itemsPerPage &&
                maxPages == that.maxPages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, itemsPerPage, maxPages);
    }
}

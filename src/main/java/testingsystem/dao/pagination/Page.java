package testingsystem.dao.pagination;

import java.util.List;

public class Page<T> {
    private final List<T> items;
    private final int pageNumber;
    private final int itemsPerPage;
    private final long maxPageNumber;

    public Page(List<T> items, int pageNumber, int itemsPerPage, long maxPageNumber) {
        this.items = items;
        this.pageNumber = pageNumber;
        this.itemsPerPage = itemsPerPage;
        this.maxPageNumber = maxPageNumber;
    }

    public List<T> getItems() {
        return items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public long getMaxPageNumber() {
        return maxPageNumber;
    }
}


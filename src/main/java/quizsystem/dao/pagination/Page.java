package quizsystem.dao.pagination;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page<?> page = (Page<?>) o;
        return pageNumber == page.pageNumber &&
                itemsPerPage == page.itemsPerPage &&
                maxPageNumber == page.maxPageNumber &&
                Objects.equals(items, page.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, pageNumber, itemsPerPage, maxPageNumber);
    }
}


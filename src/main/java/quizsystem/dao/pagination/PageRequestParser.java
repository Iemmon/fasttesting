package quizsystem.dao.pagination;

public class PageRequestParser {

    public static PageRequest parseIntoPageRequest(String page, int itemsPerPage, long maxUsers){
        int pageNumber = 1;
        if(!page.matches("[0-9]+")){
                pageNumber = Integer.parseInt(page);
            }

        int maxPage = (int) (maxUsers < itemsPerPage ? 1 : Math.ceil((double) maxUsers / itemsPerPage));
        pageNumber = Math.max(1, pageNumber);
        pageNumber = Math.min(maxPage, pageNumber);
        return new PageRequest(pageNumber, itemsPerPage, maxPage);
    }
}

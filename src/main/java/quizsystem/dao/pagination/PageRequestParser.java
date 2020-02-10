package quizsystem.dao.pagination;

import quizsystem.injector.ApplicationInjector;

import java.util.ResourceBundle;

public class PageRequestParser {

    private static final ResourceBundle RESOURCE_BUNDLE = ApplicationInjector.getInstance().getResourceBundle();

    public static PageRequest parseIntoPageRequest(String page, long maxUsers){
        int itemsPerPage = Integer.parseInt(RESOURCE_BUNDLE.getString("itemsPerPage"));
        int pageNumber = 1;
        if(page != null && page.matches("[0-9]+")){
                pageNumber = Integer.parseInt(page);
            }
        int maxPage = (int) (maxUsers < itemsPerPage ? Integer.parseInt(RESOURCE_BUNDLE.getString("defaultPageNumber")) : Math.ceil((double) maxUsers / itemsPerPage));
        pageNumber = Math.max(1, pageNumber);
        pageNumber = Math.min(maxPage, pageNumber);
        return new PageRequest(pageNumber, itemsPerPage, maxPage);
    }
}

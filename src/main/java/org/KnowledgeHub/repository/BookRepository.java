package org.KnowledgeHub.repository;

//public class BookRepository {

//    @Repository
//    public interface BookRepository extends JpaRepository<Book, Long> {
//
//        // Search by title (partial match)
//        List<Book> findByTitleContainingIgnoreCase(String title);
//
//        // Search by author (partial match)
//        List<Book> findByAuthorContainingIgnoreCase(String author);
//
//        // Filter by category
//        List<Book> findByCategory(String category);
//
//        // Filter by price range
//        List<Book> findByPriceBetween(double minPrice, double maxPrice);
//
//        // Filter by stock (availability)
//        List<Book> findByStockGreaterThan(int stock);
//
//        // Combination of multiple filters
//        @Query("SELECT b FROM Book b WHERE " +
//                "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
//                "(:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))) AND " +
//                "(:category IS NULL OR b.category = :category) AND " +
//                "(:minPrice IS NULL OR b.price >= :minPrice) AND " +
//                "(:maxPrice IS NULL OR b.price <= :maxPrice) AND " +
//                "(:inStock IS NULL OR b.stock > 0)")
//        List<Book> searchBooks(@Param("title") String title,
//                               @Param("author") String author,
//                               @Param("category") String category,
//                               @Param("minPrice") Double minPrice,
//                               @Param("maxPrice") Double maxPrice,
//                               @Param("inStock") Boolean inStock);
//    }
//
//}

package org.KnowledgeHub.entity;

import java.time.LocalDate;

public class Book {
        //@Id
       // @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String author;
        private String isbn;
        private double price;
        private String category;
        private LocalDate publicationDate;
        private int stock;
        private String description;
        private String coverImage;
        private String language;
        private String format;

        // Getters and Setters

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getIsbn() {
                return isbn;
        }

        public void setIsbn(String isbn) {
                this.isbn = isbn;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public LocalDate getPublicationDate() {
                return publicationDate;
        }

        public void setPublicationDate(LocalDate publicationDate) {
                this.publicationDate = publicationDate;
        }

        public int getStock() {
                return stock;
        }

        public void setStock(int stock) {
                this.stock = stock;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getCoverImage() {
                return coverImage;
        }

        public void setCoverImage(String coverImage) {
                this.coverImage = coverImage;
        }

        public String getLanguage() {
                return language;
        }

        public void setLanguage(String language) {
                this.language = language;
        }

        public String getFormat() {
                return format;
        }

        public void setFormat(String format) {
                this.format = format;
        }
}



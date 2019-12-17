package uk.co.techswitch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewComment {

    private String author;
    private String content;
    private String id;

    public ReviewComment() {
    }

    public ReviewComment(String author, String content, String id) {
        this.author = author;
        this.content = content;
        this.id = id;
    }


    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

}

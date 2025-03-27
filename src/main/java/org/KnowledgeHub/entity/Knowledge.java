package org.KnowledgeHub;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;
//import static org.KnowledgeHub.entity.Knowledge.author;

public class Knowledge {
    private int id;
    private String name;
    private String category;

    public Knowledge(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Knowledge() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "User [ID=" + id + ", Name=\"" + name + "\", category=\"" + category + "\"]";
    }
}


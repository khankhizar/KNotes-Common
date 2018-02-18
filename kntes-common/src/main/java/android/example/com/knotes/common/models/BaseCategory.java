package android.example.com.knotes.common.models;

import java.util.Calendar;

public class BaseCategory {

    private Long id;
    private String name;
    private String description;
    private String color;
    private int count;


    public BaseCategory() {
        this.id = Calendar.getInstance().getTimeInMillis();
    }


    public BaseCategory(BaseCategory baseCategory) {
        this(baseCategory.getId(), baseCategory.getName(), baseCategory.getDescription(), baseCategory.getColor());
    }


    public BaseCategory(Long id, String title, String description, String color) {
        this(id, title, description, color, 0);
    }


    public BaseCategory(Long id, String title, String description, String color, int count) {
        this.id = id;
        this.name = title;
        this.description = description;
        this.color = color;
        this.count = count;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String title) {
        this.name = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass().equals(this.getClass())) {
            try {
                BaseCategory c = (BaseCategory) obj;
                result = (getColor() == c.getColor() || getColor().equals(c.getColor()))
                        &&  (getDescription() == c.getDescription() || getDescription().equals(c.getDescription()))
                        &&  (getName() == c.getName() || getName().equals(c.getName()))
                        &&  (getId() == c.getId() || getId().equals(c.getId()));
            } catch (ClassCastException e) {
                result = false;
            }
        }
        return result;
    }
}
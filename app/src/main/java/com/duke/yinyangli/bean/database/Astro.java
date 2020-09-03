package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "astro", createInDb = false)
public class Astro {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "title")
    private String title;//血型+星座名：A型水瓶座

    @Property(nameInDb = "content")
    private String content;//星座运势

    @Generated(hash = 1223252336)
    public Astro() {
    }

    @Generated(hash = 479442558)
    public Astro(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

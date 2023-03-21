package ru.gb.iren.model;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import ru.gb.iren.adapter.LocalDateTimeGsonAdapter;

import java.time.LocalDateTime;

/**
 * Класс, описывающий запись в блокноте
 */
public class Note {
    @JsonAdapter(LocalDateTimeGsonAdapter.class)
    private final LocalDateTime createTime;
    private String title;
    private String body;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
        this.createTime = LocalDateTime.now();
    }

    public Note(String title, String body, LocalDateTime dateTime) {
        this.title = title;
        this.body = body;
        this.createTime = dateTime;
    }

    public LocalDateTime getCreateTime() {
//        return LocalDateTime.ofInstant(Instant.ofEpochSecond(createTime),
//                TimeZone.getDefault().toZoneId());
        return this.createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
